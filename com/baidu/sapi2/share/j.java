package com.baidu.sapi2.share;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class j implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ SapiShareClient a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SapiShareClient sapiShareClient) {
        this.a = sapiShareClient;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
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
        int i;
        boolean z;
        i = this.a.l;
        if (i == 0) {
            z = this.a.m;
            if (z) {
                this.a.m = false;
            } else {
                new m().a(true);
            }
        }
        SapiShareClient.b(this.a);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        SapiShareClient.c(this.a);
    }
}
