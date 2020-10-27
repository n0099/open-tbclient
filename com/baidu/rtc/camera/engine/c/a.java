package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes11.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.abC().dW(z);
        com.baidu.rtc.camera.a.b.abA().chi = aVar;
        com.baidu.rtc.camera.engine.d.b.abI().a(this).a(this).aZ(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.abI().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.abI().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.abI().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.abI().switchCamera();
    }

    public void V(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.abI().V(i, i2);
    }

    public void abE() {
        com.baidu.rtc.camera.engine.d.b.abI().abJ();
    }

    public void abF() {
        com.baidu.rtc.camera.engine.d.b.abI().abF();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void abD() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void F(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.abI().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void F(float f) {
    }
}
