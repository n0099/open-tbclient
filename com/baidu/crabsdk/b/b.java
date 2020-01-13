package com.baidu.crabsdk.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        com.baidu.crabsdk.c.a.v("onActivityCreated:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        com.baidu.crabsdk.c.a.v("onActivityDestroyed:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        com.baidu.crabsdk.c.a.v("##onActivityPaused " + activity.getClass().getName());
        m.onPause(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.baidu.crabsdk.c.a.v("##onActivityResumed " + activity.getClass().getName());
        m.onResume(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        com.baidu.crabsdk.c.a.v("onActivitySaveInstanceState:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a.a(activity);
        com.baidu.crabsdk.c.a.v("onActivityStarted:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a.b(activity);
        com.baidu.crabsdk.c.a.v("onActivityStopped:" + activity.toString());
    }
}
