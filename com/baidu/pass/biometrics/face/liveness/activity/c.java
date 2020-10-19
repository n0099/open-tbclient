package com.baidu.pass.biometrics.face.liveness.activity;

import android.hardware.Camera;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
/* loaded from: classes18.dex */
class c implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f2730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LivenessRecogActivity livenessRecogActivity) {
        this.f2730a = livenessRecogActivity;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int i;
        LivenessRecogActivity.b bVar;
        if (this.f2730a.P.s != 0 && this.f2730a.P.s != 10 && this.f2730a.P.s != 17 && this.f2730a.P.s != 19 && this.f2730a.P.s != 18) {
            try {
                i = this.f2730a.S;
                if (i <= 0) {
                    this.f2730a.ra = bArr;
                    this.f2730a.a(camera);
                    this.f2730a.T = new LivenessRecogActivity.b(this.f2730a, null);
                    bVar = this.f2730a.T;
                    bVar.execute(new Void[0]);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
