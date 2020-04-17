package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Ne().cN(z);
        com.baidu.rtc.camera.a.b.Nc().buO = aVar;
        com.baidu.rtc.camera.engine.d.b.Nk().a(this).a(this).aQ(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.Nk().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.Nk().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.Nk().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.Nk().switchCamera();
    }

    public void M(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.Nk().M(i, i2);
    }

    public void Ng() {
        com.baidu.rtc.camera.engine.d.b.Nk().Nl();
    }

    public void Nh() {
        com.baidu.rtc.camera.engine.d.b.Nk().Nh();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Nf() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void v(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.Nk().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void u(float f) {
    }
}
