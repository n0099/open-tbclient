package com.baidu.pass.biometrics.face.liveness.activity;

import android.hardware.Camera;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
/* loaded from: classes4.dex */
class c implements Camera.PreviewCallback {
    final /* synthetic */ LivenessRecogActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LivenessRecogActivity livenessRecogActivity) {
        this.a = livenessRecogActivity;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int i;
        LivenessRecogActivity.b bVar;
        if (this.a.P.s != 0 && this.a.P.s != 10 && this.a.P.s != 17 && this.a.P.s != 19 && this.a.P.s != 18) {
            try {
                i = this.a.S;
                if (i <= 0) {
                    this.a.ra = bArr;
                    this.a.a(camera);
                    this.a.T = new LivenessRecogActivity.b(this.a, null);
                    bVar = this.a.T;
                    bVar.execute(new Void[0]);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
