package com.baidu.sapi2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes12.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private Stack<Activity> a;

    /* loaded from: classes12.dex */
    private static class b {
        public static a a = new a();

        private b() {
        }
    }

    public static a e() {
        return b.a;
    }

    public void a(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void b(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public boolean c(Activity activity) {
        return this.a.remove(activity);
    }

    public int d(Activity activity) {
        return this.a.search(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        c(activity);
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

    private a() {
        this.a = new Stack<>();
    }

    public void a(Activity activity) {
        this.a.add(activity);
    }

    public Activity b() {
        if (this.a.isEmpty() || this.a.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.a;
        return stack.get(stack.size() - 2);
    }

    public Activity c() {
        int size = this.a.size();
        if (size < 2) {
            return d();
        }
        for (int i = size - 1; i >= 0; i--) {
            Activity activity = this.a.get(i);
            if (activity != null && !activity.isFinishing()) {
                return activity;
            }
        }
        return null;
    }

    public Activity d() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.lastElement();
    }

    public void a(Class<Activity> cls) {
        if (cls != null) {
            Iterator<Activity> it = this.a.iterator();
            while (it.hasNext()) {
                Activity next = it.next();
                if (next.getClass().equals(cls)) {
                    it.remove();
                    b(next);
                }
            }
        }
    }

    public void b(Activity activity) {
        this.a.pop().finish();
    }

    public void a() {
        while (!this.a.isEmpty()) {
            this.a.pop().finish();
        }
    }
}
