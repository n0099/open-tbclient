package com.baidu.searchbox.appframework;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class BdBoxActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = false;
    private static final String TAG = "BdBoxActivityLifecycle";
    private static boolean hasGlobalLifecycle = false;
    private int mActivityCount;
    private LinkedList<WeakReference<Activity>> mActivityStack = new LinkedList<>();
    private boolean mIsForeground = false;
    private CopyOnWriteArrayList<IActivityLifecycle> mCustomActivityLifeCycles = new CopyOnWriteArrayList<>();

    /* loaded from: classes6.dex */
    public interface IActivityLifecycle {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);

        void onBackgroundToForeground(Activity activity);

        void onForegroundToBackground(Activity activity);
    }

    public void registerGlobalLifeCycle(IActivityLifecycle iActivityLifecycle) {
        if (iActivityLifecycle != null && !this.mCustomActivityLifeCycles.contains(iActivityLifecycle)) {
            hasGlobalLifecycle = true;
            this.mCustomActivityLifeCycles.add(iActivityLifecycle);
        }
    }

    public void registerLifeCycle(IActivityLifecycle iActivityLifecycle) {
        if (iActivityLifecycle != null && !this.mCustomActivityLifeCycles.contains(iActivityLifecycle)) {
            if (hasGlobalLifecycle && this.mCustomActivityLifeCycles.size() > 0) {
                this.mCustomActivityLifeCycles.add(this.mCustomActivityLifeCycles.size() - 1, iActivityLifecycle);
            } else {
                this.mCustomActivityLifeCycles.add(iActivityLifecycle);
            }
        }
    }

    public void unregisterLifeCycle(IActivityLifecycle iActivityLifecycle) {
        if (iActivityLifecycle != null) {
            this.mCustomActivityLifeCycles.remove(iActivityLifecycle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.mActivityStack.add(new WeakReference<>(activity));
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityStarted(activity);
            }
        }
        this.mActivityCount++;
        if (this.mActivityCount == 1) {
            onBackgroundToForeground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityStopped(activity);
            }
        }
        this.mActivityCount--;
        if (this.mActivityCount == 0) {
            onForegroundToBackground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        int i;
        if (!this.mActivityStack.isEmpty()) {
            int size = this.mActivityStack.size() - 1;
            while (true) {
                if (size >= 0) {
                    Activity activity2 = this.mActivityStack.get(size).get();
                    if (activity2 != null && activity2 == activity) {
                        i = size;
                        break;
                    }
                    size--;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i != -1) {
                this.mActivityStack.remove(i);
            }
        }
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }
    }

    public void onBackgroundToForeground(Activity activity) {
        this.mIsForeground = true;
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundToForeground(activity);
            }
        }
    }

    public void onForegroundToBackground(Activity activity) {
        this.mIsForeground = false;
        if (this.mCustomActivityLifeCycles != null && this.mCustomActivityLifeCycles.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onForegroundToBackground(activity);
            }
        }
    }

    public Activity getTopActivity() {
        WeakReference<Activity> last;
        if (this.mActivityStack.isEmpty() || (last = this.mActivityStack.getLast()) == null) {
            return null;
        }
        return last.get();
    }

    public Activity getPenultimateActivity() {
        if (this.mActivityStack.isEmpty() || this.mActivityStack.size() < 2) {
            return null;
        }
        return this.mActivityStack.get(this.mActivityStack.size() - 2).get();
    }

    public Activity getRealTopActivity() {
        Activity activity;
        int size = this.mActivityStack.size();
        if (size < 2) {
            return getTopActivity();
        }
        for (int i = size - 1; i >= 0; i--) {
            WeakReference<Activity> weakReference = this.mActivityStack.get(i);
            if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
                return activity;
            }
        }
        return null;
    }

    public LinkedList<WeakReference<Activity>> getActivityStack() {
        return this.mActivityStack;
    }

    public int getActivityCount() {
        if (this.mActivityStack == null || this.mActivityStack.isEmpty()) {
            return 0;
        }
        return this.mActivityStack.size();
    }

    public boolean isActivityInStack(Class cls) {
        return getSpecifiedActivity(cls) != null;
    }

    public Activity getSpecifiedActivity(Class cls) {
        Activity activity;
        if (cls == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList(this.mActivityStack);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= linkedList.size()) {
                return null;
            }
            WeakReference weakReference = (WeakReference) linkedList.get(i2);
            if (weakReference == null || (activity = (Activity) weakReference.get()) == null || !cls.getSimpleName().equals(activity.getClass().getSimpleName())) {
                i = i2 + 1;
            } else {
                return activity;
            }
        }
    }

    public void finishAllActivity() {
        Activity activity;
        if (!this.mActivityStack.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mActivityStack.size()) {
                    WeakReference<Activity> weakReference = this.mActivityStack.get(i2);
                    if (weakReference != null && (activity = weakReference.get()) != null) {
                        activity.finish();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    private String dump() {
        if (this.mActivityStack == null || this.mActivityStack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int size = this.mActivityStack.size() - 1; size >= 0; size--) {
            Activity activity = this.mActivityStack.get(size).get();
            if (activity != null) {
                sb.append(size + 1).append(": ").append(activity.getClass().getSimpleName()).append(" ");
            }
        }
        return sb.append("], this = ").append(this).toString();
    }

    /* loaded from: classes6.dex */
    public static class BackForegroundEvent {
        public boolean isForeground;

        public BackForegroundEvent(boolean z) {
            this.isForeground = z;
        }
    }
}
