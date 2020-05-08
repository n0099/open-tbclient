package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Nd().cN(z);
        com.baidu.rtc.camera.a.b.Nb().buT = aVar;
        com.baidu.rtc.camera.engine.d.b.Nj().a(this).a(this).aE(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.Nj().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.Nj().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.Nj().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.Nj().switchCamera();
    }

    public void M(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.Nj().M(i, i2);
    }

    public void Nf() {
        com.baidu.rtc.camera.engine.d.b.Nj().Nk();
    }

    public void Ng() {
        com.baidu.rtc.camera.engine.d.b.Nj().Ng();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Ne() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void v(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.Nj().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void u(float f) {
    }
}
