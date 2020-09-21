package com.baidu.searchbox.appframework;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class BdBoxActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = false;
    private static final String TAG = "BdBoxActivityLifecycle";
    private static boolean hasGlobalLifecycle = false;
    private int mActivityCount;
    private LinkedList<WeakReference<Activity>> mActivityStack = new LinkedList<>();
    private boolean mIsForeground = false;
    private CopyOnWriteArrayList<IActivityLifecycle> mCustomActivityLifeCycles = new CopyOnWriteArrayList<>();

    /* loaded from: classes10.dex */
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
        int size = this.mActivityStack.size();
        if (size < 2) {
            return getTopActivity();
        }
        for (int i = size - 1; i >= 0; i--) {
            WeakReference<Activity> weakReference = this.mActivityStack.get(i);
            if (weakReference != null && weakReference.get() != null) {
                Activity activity = weakReference.get();
                if (!activity.isFinishing()) {
                    return activity;
                }
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
        if (cls == null) {
            return null;
        }
        Iterator<WeakReference<Activity>> it = this.mActivityStack.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && next.get() != null) {
                Activity activity = next.get();
                if (cls.getSimpleName().equals(activity.getClass().getSimpleName())) {
                    return activity;
                }
            }
        }
        return null;
    }

    public void finishAllActivity() {
        if (!this.mActivityStack.isEmpty()) {
            Iterator<WeakReference<Activity>> it = this.mActivityStack.iterator();
            while (it.hasNext()) {
                WeakReference<Activity> next = it.next();
                if (next != null && next.get() != null) {
                    next.get().finish();
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

    /* loaded from: classes10.dex */
    public static class BackForegroundEvent {
        public boolean isForeground;

        public BackForegroundEvent(boolean z) {
            this.isForeground = z;
        }
    }
}
