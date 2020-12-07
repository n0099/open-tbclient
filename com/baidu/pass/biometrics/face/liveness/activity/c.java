package com.baidu.pass.biometrics.face.liveness.activity;

import android.hardware.Camera;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity;
/* loaded from: classes12.dex */
class c implements Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f2734a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LivenessRecogActivity livenessRecogActivity) {
        this.f2734a = livenessRecogActivity;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int i;
        LivenessRecogActivity.b bVar;
        if (this.f2734a.P.s != 0 && this.f2734a.P.s != 10 && this.f2734a.P.s != 17 && this.f2734a.P.s != 19 && this.f2734a.P.s != 18) {
            try {
                i = this.f2734a.S;
                if (i <= 0) {
                    this.f2734a.ra = bArr;
                    this.f2734a.a(camera);
                    this.f2734a.T = new LivenessRecogActivity.b(this.f2734a, null);
                    bVar = this.f2734a.T;
                    bVar.execute(new Void[0]);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
