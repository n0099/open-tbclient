package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes15.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4021a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LivenessRecogActivity livenessRecogActivity) {
        this.f4021a = livenessRecogActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4021a.Z == 2) {
            this.f4021a.P.s = 5;
            Log.w("LivenessRecog", "timePointLivingEyeStart" + this.f4021a.da.ba);
            this.f4021a.J = 0;
        } else {
            this.f4021a.P.s = 7;
            Log.w("LivenessRecog", "timePointLivingMouthStart" + this.f4021a.da.da);
            this.f4021a.J = 5;
        }
        long currentTimeMillis = 20000 - (System.currentTimeMillis() - this.f4021a.P.v);
        if (currentTimeMillis < 5000) {
            this.f4021a.P.w = 25000 - currentTimeMillis;
        }
    }
}
