package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes15.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Xq().dn(z);
        com.baidu.rtc.camera.a.b.Xo().bPo = aVar;
        com.baidu.rtc.camera.engine.d.b.Xw().a(this).a(this).aU(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.Xw().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.Xw().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.Xw().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.Xw().switchCamera();
    }

    public void U(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.Xw().U(i, i2);
    }

    public void Xs() {
        com.baidu.rtc.camera.engine.d.b.Xw().Xx();
    }

    public void Xt() {
        com.baidu.rtc.camera.engine.d.b.Xw().Xt();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Xr() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void F(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.Xw().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void B(float f) {
    }
}
