package com.baidu.pass.biometrics.face.liveness.activity;

import android.hardware.Camera;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
/* loaded from: classes6.dex */
class c implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4007a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LivenessRecogActivity livenessRecogActivity) {
        this.f4007a = livenessRecogActivity;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int i;
        LivenessRecogActivity.b bVar;
        if (this.f4007a.P.s != 0 && this.f4007a.P.s != 10 && this.f4007a.P.s != 17 && this.f4007a.P.s != 19 && this.f4007a.P.s != 18) {
            try {
                i = this.f4007a.S;
                if (i <= 0) {
                    this.f4007a.ra = bArr;
                    this.f4007a.a(camera);
                    this.f4007a.T = new LivenessRecogActivity.b(this.f4007a, null);
                    bVar = this.f4007a.T;
                    bVar.execute(new Void[0]);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
