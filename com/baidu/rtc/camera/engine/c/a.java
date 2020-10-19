package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes11.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.ZI().dI(z);
        com.baidu.rtc.camera.a.b.ZG().bYK = aVar;
        com.baidu.rtc.camera.engine.d.b.ZO().a(this).a(this).aZ(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.ZO().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.ZO().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.ZO().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.ZO().switchCamera();
    }

    public void U(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.ZO().U(i, i2);
    }

    public void ZK() {
        com.baidu.rtc.camera.engine.d.b.ZO().ZP();
    }

    public void ZL() {
        com.baidu.rtc.camera.engine.d.b.ZO().ZL();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void ZJ() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void F(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.ZO().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void D(float f) {
    }
}
