package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes11.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.agC().ex(z);
        com.baidu.rtc.camera.a.b.agA().csq = aVar;
        com.baidu.rtc.camera.engine.d.b.agI().a(this).a(this).bF(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.agI().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.agI().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.agI().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.agI().switchCamera();
    }

    public void X(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.agI().X(i, i2);
    }

    public void agE() {
        com.baidu.rtc.camera.engine.d.b.agI().agJ();
    }

    public void agF() {
        com.baidu.rtc.camera.engine.d.b.agI().agF();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void agD() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void H(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.agI().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void G(float f) {
    }
}
