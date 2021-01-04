package com.baidu.pass.biometrics.face.liveness.activity;

import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes7.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LivenessRecogActivity livenessRecogActivity) {
        this.f4055a = livenessRecogActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4055a.Z == 2) {
            this.f4055a.P.s = 5;
            Log.w("LivenessRecog", "timePointLivingEyeStart" + this.f4055a.da.ba);
            this.f4055a.J = 0;
        } else {
            this.f4055a.P.s = 7;
            Log.w("LivenessRecog", "timePointLivingMouthStart" + this.f4055a.da.da);
            this.f4055a.J = 5;
        }
        long currentTimeMillis = 20000 - (System.currentTimeMillis() - this.f4055a.P.v);
        if (currentTimeMillis < 5000) {
            this.f4055a.P.w = 25000 - currentTimeMillis;
        }
    }
}
