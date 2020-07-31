package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes7.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.QL().dg(z);
        com.baidu.rtc.camera.a.b.QJ().bHJ = aVar;
        com.baidu.rtc.camera.engine.d.b.QR().a(this).a(this).aQ(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.QR().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.QR().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.QR().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.QR().switchCamera();
    }

    public void R(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.QR().R(i, i2);
    }

    public void QN() {
        com.baidu.rtc.camera.engine.d.b.QR().QS();
    }

    public void QO() {
        com.baidu.rtc.camera.engine.d.b.QR().QO();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void QM() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void E(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.QR().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void A(float f) {
    }
}
