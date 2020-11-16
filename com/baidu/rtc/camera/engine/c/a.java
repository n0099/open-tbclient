package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes16.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.adu().eh(z);
        com.baidu.rtc.camera.a.b.ads().cls = aVar;
        com.baidu.rtc.camera.engine.d.b.adA().a(this).a(this).aZ(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.adA().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.adA().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.adA().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.adA().switchCamera();
    }

    public void V(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.adA().V(i, i2);
    }

    public void adw() {
        com.baidu.rtc.camera.engine.d.b.adA().adB();
    }

    public void adx() {
        com.baidu.rtc.camera.engine.d.b.adA().adx();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void adv() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void F(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.adA().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void G(float f) {
    }
}
