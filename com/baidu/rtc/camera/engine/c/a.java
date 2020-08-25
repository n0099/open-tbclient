package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes11.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.WH().m32do(z);
        com.baidu.rtc.camera.a.b.WF().bNk = aVar;
        com.baidu.rtc.camera.engine.d.b.WN().a(this).a(this).aV(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.WN().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.WN().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.WN().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.WN().switchCamera();
    }

    public void U(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.WN().U(i, i2);
    }

    public void WJ() {
        com.baidu.rtc.camera.engine.d.b.WN().WO();
    }

    public void WK() {
        com.baidu.rtc.camera.engine.d.b.WN().WK();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void WI() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void F(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.WN().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void B(float f) {
    }
}
