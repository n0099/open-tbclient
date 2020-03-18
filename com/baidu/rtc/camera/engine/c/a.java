package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Fs().bP(z);
        com.baidu.rtc.camera.a.b.Fq().aWt = aVar;
        com.baidu.rtc.camera.engine.d.b.Fy().a(this).a(this).aY(context);
    }

    public void Dk() {
        com.baidu.rtc.camera.engine.d.b.Fy().Dk();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.Fy().stopRecording();
    }

    public void d(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.Fy().d(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.Fy().switchCamera();
    }

    public void K(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.Fy().K(i, i2);
    }

    public void Fu() {
        com.baidu.rtc.camera.engine.d.b.Fy().Fz();
    }

    public void Fv() {
        com.baidu.rtc.camera.engine.d.b.Fy().Fv();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Ft() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void t(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.Fy().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void O(float f) {
    }
}
