package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes4.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Ct().bB(z);
        com.baidu.rtc.camera.a.b.Cr().aQN = aVar;
        com.baidu.rtc.camera.engine.d.b.Cz().a(this).a(this).aV(context);
    }

    public void Ap() {
        com.baidu.rtc.camera.engine.d.b.Cz().Ap();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.Cz().stopRecording();
    }

    public void d(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.Cz().d(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.Cz().switchCamera();
    }

    public void F(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.Cz().F(i, i2);
    }

    public void Cv() {
        com.baidu.rtc.camera.engine.d.b.Cz().CA();
    }

    public void Cw() {
        com.baidu.rtc.camera.engine.d.b.Cz().Cw();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Cu() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void o(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.Cz().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void P(float f) {
    }
}
