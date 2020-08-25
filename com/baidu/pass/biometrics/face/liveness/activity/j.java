package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes4.dex */
class j implements Runnable {
    final /* synthetic */ LivenessRecogActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LivenessRecogActivity livenessRecogActivity) {
        this.a = livenessRecogActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.Z == 2) {
            this.a.P.s = 5;
            Log.w("LivenessRecog", "timePointLivingEyeStart" + this.a.da.ba);
            this.a.J = 0;
        } else {
            this.a.P.s = 7;
            Log.w("LivenessRecog", "timePointLivingMouthStart" + this.a.da.da);
            this.a.J = 5;
        }
        long currentTimeMillis = 20000 - (System.currentTimeMillis() - this.a.P.v);
        if (currentTimeMillis < 5000) {
            this.a.P.w = 25000 - currentTimeMillis;
        }
    }
}
