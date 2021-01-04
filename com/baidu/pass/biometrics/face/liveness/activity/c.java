package com.baidu.pass.biometrics.face.liveness.activity;

import android.hardware.Camera;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
/* loaded from: classes7.dex */
class c implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4044a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LivenessRecogActivity livenessRecogActivity) {
        this.f4044a = livenessRecogActivity;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int i;
        LivenessRecogActivity.b bVar;
        if (this.f4044a.P.s != 0 && this.f4044a.P.s != 10 && this.f4044a.P.s != 17 && this.f4044a.P.s != 19 && this.f4044a.P.s != 18) {
            try {
                i = this.f4044a.S;
                if (i <= 0) {
                    this.f4044a.ra = bArr;
                    this.f4044a.a(camera);
                    this.f4044a.T = new LivenessRecogActivity.b(this.f4044a, null);
                    bVar = this.f4044a.T;
                    bVar.execute(new Void[0]);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
