package com.baidu.searchbox.appframework;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class BdBoxActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    public static final boolean DEBUG = false;
    public static final String TAG = "BdBoxActivityLifecycle";
    public static boolean hasGlobalLifecycle;
    public int mActivityCount;
    public LinkedList<WeakReference<Activity>> mActivityStack = new LinkedList<>();
    public boolean mIsForeground = false;
    public CopyOnWriteArrayList<IActivityLifecycle> mCustomActivityLifeCycles = new CopyOnWriteArrayList<>();

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class BackForegroundEvent {
        public boolean isForeground;

        public BackForegroundEvent(boolean z) {
            this.isForeground = z;
        }
    }

    public void finishAllActivity() {
        Activity activity;
        if (!this.mActivityStack.isEmpty()) {
            for (int i = 0; i < this.mActivityStack.size(); i++) {
                WeakReference<Activity> weakReference = this.mActivityStack.get(i);
                if (weakReference != null && (activity = weakReference.get()) != null) {
                    activity.finish();
                }
            }
        }
    }

    public int getActivityCount() {
        LinkedList<WeakReference<Activity>> linkedList = this.mActivityStack;
        if (linkedList != null && !linkedList.isEmpty()) {
            return this.mActivityStack.size();
        }
        return 0;
    }

    public LinkedList<WeakReference<Activity>> getActivityStack() {
        return this.mActivityStack;
    }

    public Activity getPenultimateActivity() {
        if (!this.mActivityStack.isEmpty() && this.mActivityStack.size() >= 2) {
            LinkedList<WeakReference<Activity>> linkedList = this.mActivityStack;
            return linkedList.get(linkedList.size() - 2).get();
        }
        return null;
    }

    public Activity getRealTopActivity() {
        Activity activity;
        int size = this.mActivityStack.size();
        if (size < 2) {
            return getTopActivity();
        }
        for (int i = size - 1; i >= 0; i--) {
            try {
                WeakReference<Activity> weakReference = this.mActivityStack.get(i);
                if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
                    return activity;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> last;
        if (!this.mActivityStack.isEmpty() && (last = this.mActivityStack.getLast()) != null) {
            return last.get();
        }
        return null;
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    private String dump() {
        LinkedList<WeakReference<Activity>> linkedList = this.mActivityStack;
        if (linkedList != null && !linkedList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (int size = this.mActivityStack.size() - 1; size >= 0; size--) {
                Activity activity = this.mActivityStack.get(size).get();
                if (activity != null) {
                    String simpleName = activity.getClass().getSimpleName();
                    sb.append(size + 1);
                    sb.append(": ");
                    sb.append(simpleName);
                    sb.append(" ");
                }
            }
            sb.append("], this = ");
            sb.append(this);
            return sb.toString();
        }
        return "";
    }

    public Activity getSpecifiedActivity(Class cls) {
        Activity activity;
        if (cls == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList(this.mActivityStack);
        for (int i = 0; i < linkedList.size(); i++) {
            WeakReference weakReference = (WeakReference) linkedList.get(i);
            if (weakReference != null && (activity = (Activity) weakReference.get()) != null && cls.getSimpleName().equals(activity.getClass().getSimpleName())) {
                return activity;
            }
        }
        return null;
    }

    public boolean isActivityInStack(Class cls) {
        if (getSpecifiedActivity(cls) != null) {
            return true;
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityStarted(activity);
            }
        }
        int i = this.mActivityCount + 1;
        this.mActivityCount = i;
        if (i == 1) {
            onBackgroundToForeground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityStopped(activity);
            }
        }
        int i = this.mActivityCount - 1;
        this.mActivityCount = i;
        if (i == 0) {
            onForegroundToBackground(activity);
        }
    }

    public void onBackgroundToForeground(Activity activity) {
        this.mIsForeground = true;
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onBackgroundToForeground(activity);
            }
        }
    }

    public void onForegroundToBackground(Activity activity) {
        this.mIsForeground = false;
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onForegroundToBackground(activity);
            }
        }
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
                CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
                copyOnWriteArrayList.add(copyOnWriteArrayList.size() - 1, iActivityLifecycle);
                return;
            }
            this.mCustomActivityLifeCycles.add(iActivityLifecycle);
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
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (!this.mActivityStack.isEmpty()) {
            int size = this.mActivityStack.size();
            while (true) {
                size--;
                if (size >= 0) {
                    Activity activity2 = this.mActivityStack.get(size).get();
                    if (activity2 != null && activity2 == activity) {
                        break;
                    }
                } else {
                    size = -1;
                    break;
                }
            }
            if (size != -1) {
                this.mActivityStack.remove(size);
            }
        }
        CopyOnWriteArrayList<IActivityLifecycle> copyOnWriteArrayList = this.mCustomActivityLifeCycles;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<IActivityLifecycle> it = this.mCustomActivityLifeCycles.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }
    }
}
