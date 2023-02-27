package com.baidu.sapi2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes2.dex */
public class ActivityStackManager implements Application.ActivityLifecycleCallbacks {
    public Stack<Activity> stack;

    /* loaded from: classes2.dex */
    public static class Instance {
        public static ActivityStackManager INSTANCE = new ActivityStackManager();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public ActivityStackManager() {
        this.stack = new Stack<>();
    }

    public static ActivityStackManager getInstance() {
        return Instance.INSTANCE;
    }

    public void finishAllActivity() {
        while (!this.stack.isEmpty()) {
            this.stack.pop().finish();
        }
    }

    public Activity getPenultimateActivity() {
        if (!this.stack.isEmpty() && this.stack.size() >= 2) {
            Stack<Activity> stack = this.stack;
            return stack.get(stack.size() - 2);
        }
        return null;
    }

    public Activity getRealTopActivity() {
        int size = this.stack.size();
        if (size < 2) {
            return getTopActivity();
        }
        for (int i = size - 1; i >= 0; i--) {
            Activity activity = this.stack.get(i);
            if (activity != null && !activity.isFinishing()) {
                return activity;
            }
        }
        return null;
    }

    public Activity getTopActivity() {
        if (!this.stack.isEmpty()) {
            return this.stack.lastElement();
        }
        return null;
    }

    public void addActivity(Activity activity) {
        this.stack.add(activity);
    }

    public void finishActivity(Activity activity) {
        this.stack.pop().finish();
    }

    public void finishActivityClass(Class<Activity> cls) {
        if (cls != null) {
            Iterator<Activity> it = this.stack.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next.getClass().equals(cls)) {
                    it.remove();
                    finishActivity(next);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        removeActivity(activity);
    }

    public void register(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean removeActivity(Activity activity) {
        return this.stack.remove(activity);
    }

    public int searchActivity(Activity activity) {
        return this.stack.search(activity);
    }

    public void unRegister(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        addActivity(activity);
    }
}
