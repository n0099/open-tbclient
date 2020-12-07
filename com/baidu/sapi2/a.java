package com.baidu.sapi2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Stack;
/* loaded from: classes6.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Stack<Activity> f3293a;

    /* loaded from: classes6.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f3294a = new a();

        private b() {
        }
    }

    public static a e() {
        return b.f3294a;
    }

    public void a(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void b(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public boolean c(Activity activity) {
        return this.f3293a.remove(activity);
    }

    public int d(Activity activity) {
        return this.f3293a.search(activity);
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
        this.f3293a = new Stack<>();
    }

    public void a(Activity activity) {
        this.f3293a.add(activity);
    }

    public Activity b() {
        if (this.f3293a.isEmpty() || this.f3293a.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.f3293a;
        return stack.get(stack.size() - 2);
    }

    public Activity c() {
        int size = this.f3293a.size();
        if (size < 2) {
            return d();
        }
        for (int i = size - 1; i >= 0; i--) {
            Activity activity = this.f3293a.get(i);
            if (activity != null && !activity.isFinishing()) {
                return activity;
            }
        }
        return null;
    }

    public Activity d() {
        if (this.f3293a.isEmpty()) {
            return null;
        }
        return this.f3293a.lastElement();
    }

    public void a(Class<Activity> cls) {
        if (cls != null) {
            Iterator<Activity> it = this.f3293a.iterator();
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
        this.f3293a.pop().finish();
    }

    public void a() {
        while (!this.f3293a.isEmpty()) {
            this.f3293a.pop().finish();
        }
    }
}
