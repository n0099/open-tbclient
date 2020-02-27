package com.baidu.rtc.camera.engine.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.rtc.camera.engine.b.b;
/* loaded from: classes6.dex */
public class a implements com.baidu.rtc.camera.engine.b.a, b {
    public a(Context context, boolean z, com.baidu.rtc.camera.b.a aVar) {
        com.baidu.rtc.camera.engine.a.b.Fl().bO(z);
        com.baidu.rtc.camera.a.b.Fj().aWe = aVar;
        com.baidu.rtc.camera.engine.d.b.Fr().a(this).a(this).aZ(context);
    }

    public void Db() {
        com.baidu.rtc.camera.engine.d.b.Fr().Db();
    }

    public void stopRecording() {
        com.baidu.rtc.camera.engine.d.b.Fr().stopRecording();
    }

    public void d(SurfaceTexture surfaceTexture) {
        com.baidu.rtc.camera.engine.d.b.Fr().d(surfaceTexture);
    }

    public void switchCamera() {
        com.baidu.rtc.camera.engine.d.b.Fr().switchCamera();
    }

    public void K(int i, int i2) {
        com.baidu.rtc.camera.engine.d.b.Fr().K(i, i2);
    }

    public void Fn() {
        com.baidu.rtc.camera.engine.d.b.Fr().Fs();
    }

    public void Fo() {
        com.baidu.rtc.camera.engine.d.b.Fr().Fo();
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void Fm() {
    }

    @Override // com.baidu.rtc.camera.engine.b.a
    public void t(byte[] bArr) {
        com.baidu.rtc.camera.engine.d.b.Fr().requestRender();
    }

    @Override // com.baidu.rtc.camera.engine.b.b
    public void O(float f) {
    }
}
