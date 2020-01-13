package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes5.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.CP().bG(z);
        com.baidu.rtc.camera.a.b.CN().aRF = aVar;
        com.baidu.rtc.camera.engine.d.b.CV().a(this).a(this).aV(context);
    }

    public void AL() {
        com.baidu.rtc.camera.engine.d.b.CV().AL();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.CV().stopRecording();
    }

    public void d(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.CV().d(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.CV().switchCamera();
    }

    public void J(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.CV().J(i, i2);
    }

    public void CR() {
        com.baidu.rtc.camera.engine.d.b.CV().CW();
    }

    public void CS() {
        com.baidu.rtc.camera.engine.d.b.CV().CS();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void CQ() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void o(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.CV().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void O(float f) {
    }
}
