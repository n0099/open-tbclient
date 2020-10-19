package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes18.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f2737a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LivenessRecogActivity livenessRecogActivity) {
        this.f2737a = livenessRecogActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2737a.Z == 2) {
            this.f2737a.P.s = 5;
            Log.w("LivenessRecog", "timePointLivingEyeStart" + this.f2737a.da.ba);
            this.f2737a.J = 0;
        } else {
            this.f2737a.P.s = 7;
            Log.w("LivenessRecog", "timePointLivingMouthStart" + this.f2737a.da.da);
            this.f2737a.J = 5;
        }
        long currentTimeMillis = 20000 - (System.currentTimeMillis() - this.f2737a.P.v);
        if (currentTimeMillis < 5000) {
            this.f2737a.P.w = 25000 - currentTimeMillis;
        }
    }
}
