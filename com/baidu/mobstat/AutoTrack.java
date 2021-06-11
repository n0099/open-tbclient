package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.mobstat.ActivityLifeObserver;
/* loaded from: classes2.dex */
public class AutoTrack {
    public static final int JOB_TYPE_BGSEND = 2;
    public static final int JOB_TYPE_SESSIONTIME = 1;

    /* loaded from: classes2.dex */
    public static class MyActivityLifeCallback implements ActivityLifeObserver.IActivityLifeCallback {

        /* renamed from: a  reason: collision with root package name */
        public int f8284a;

        public MyActivityLifeCallback(int i2) {
            this.f8284a = i2;
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            Context applicationContext = activity.getApplicationContext();
            int i2 = this.f8284a;
            if (i2 == 1) {
                BDStatCore.instance().autoTrackSessionEndTime(applicationContext);
            } else if (i2 == 2) {
                BDStatCore.instance().doSendLogCheck(applicationContext);
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            Context applicationContext = activity.getApplicationContext();
            int i2 = this.f8284a;
            if (i2 == 1) {
                BDStatCore.instance().autoTrackSessionStartTime(applicationContext);
            } else if (i2 == 2) {
                BDStatCore.instance().cancelSendLogCheck();
            }
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
        }

        @Override // com.baidu.mobstat.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStopped(Activity activity) {
        }
    }
}
