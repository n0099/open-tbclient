package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes11.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.aec().ef(z);
        com.baidu.rtc.camera.a.b.aea().cnd = aVar;
        com.baidu.rtc.camera.engine.d.b.aei().a(this).a(this).aZ(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.aei().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.aei().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.aei().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.aei().switchCamera();
    }

    public void V(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.aei().V(i, i2);
    }

    public void aee() {
        com.baidu.rtc.camera.engine.d.b.aei().aej();
    }

    public void aef() {
        com.baidu.rtc.camera.engine.d.b.aei().aef();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void aed() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void F(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.aei().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void H(float f) {
    }
}
