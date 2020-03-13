package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Fn().bO(z);
        com.baidu.rtc.camera.a.b.Fl().aWg = aVar;
        com.baidu.rtc.camera.engine.d.b.Ft().a(this).a(this).aZ(context);
    }

    public void Dd() {
        com.baidu.rtc.camera.engine.d.b.Ft().Dd();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.Ft().stopRecording();
    }

    public void d(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.Ft().d(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.Ft().switchCamera();
    }

    public void K(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.Ft().K(i, i2);
    }

    public void Fp() {
        com.baidu.rtc.camera.engine.d.b.Ft().Fu();
    }

    public void Fq() {
        com.baidu.rtc.camera.engine.d.b.Ft().Fq();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Fo() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void t(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.Ft().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void O(float f) {
    }
}
