package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Qw().de(z);
        com.baidu.rtc.camera.a.b.Qu().bHk = aVar;
        com.baidu.rtc.camera.engine.d.b.QC().a(this).a(this).aP(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.QC().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.QC().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.QC().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.QC().switchCamera();
    }

    public void R(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.QC().R(i, i2);
    }

    public void Qy() {
        com.baidu.rtc.camera.engine.d.b.QC().QD();
    }

    public void Qz() {
        com.baidu.rtc.camera.engine.d.b.QC().Qz();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Qx() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void E(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.QC().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void A(float f) {
    }
}
