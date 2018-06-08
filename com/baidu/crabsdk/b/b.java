package com.baidu.crabsdk.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        com.baidu.crabsdk.c.a.cd("onActivityCreated:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        com.baidu.crabsdk.c.a.cd("onActivityDestroyed:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        com.baidu.crabsdk.c.a.cd("##onActivityPaused " + activity.getClass().getName());
        m.onPause(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.baidu.crabsdk.c.a.cd("##onActivityResumed " + activity.getClass().getName());
        m.onResume(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        com.baidu.crabsdk.c.a.cd("onActivitySaveInstanceState:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a.a(activity);
        com.baidu.crabsdk.c.a.cd("onActivityStarted:" + activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a.b(activity);
        com.baidu.crabsdk.c.a.cd("onActivityStopped:" + activity.toString());
    }
}
