package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes14.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f2790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LivenessRecogActivity livenessRecogActivity) {
        this.f2790a = livenessRecogActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2790a.Z == 2) {
            this.f2790a.P.s = 5;
            Log.w("LivenessRecog", "timePointLivingEyeStart" + this.f2790a.da.ba);
            this.f2790a.J = 0;
        } else {
            this.f2790a.P.s = 7;
            Log.w("LivenessRecog", "timePointLivingMouthStart" + this.f2790a.da.da);
            this.f2790a.J = 5;
        }
        long currentTimeMillis = 20000 - (System.currentTimeMillis() - this.f2790a.P.v);
        if (currentTimeMillis < 5000) {
            this.f2790a.P.w = 25000 - currentTimeMillis;
        }
    }
}
