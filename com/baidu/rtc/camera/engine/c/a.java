package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Pq().cZ(z);
        com.baidu.rtc.camera.a.b.Po().bCw = aVar;
        com.baidu.rtc.camera.engine.d.b.Pw().a(this).a(this).aO(context);
    }

    public void startRecording() {
        com.baidu.rtc.camera.engine.d.b.Pw().startRecording();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.Pw().stopRecording();
    }

    public void c(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.Pw().c(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.Pw().switchCamera();
    }

    public void P(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.Pw().P(i, i2);
    }

    public void Ps() {
        com.baidu.rtc.camera.engine.d.b.Pw().Px();
    }

    public void Pt() {
        com.baidu.rtc.camera.engine.d.b.Pw().Pt();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Pr() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void C(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.Pw().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void u(float f) {
    }
}
