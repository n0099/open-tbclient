package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes7.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bIm;
    private d bIn;
    private f bIo;
    private final Object bIp;

    private b() {
        this.bIp = new Object();
        this.bIm = com.baidu.rtc.camera.engine.a.b.QL();
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static b bIq = new b();
    }

    public static b QR() {
        return a.bIq;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aQ(Context context) {
        synchronized (this.bIp) {
            this.bIo = new f(context, "RenderThread");
            this.bIo.start();
            this.bIn = new d(this.bIo);
            this.bIo.a(this.bIn);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bIn != null) {
            this.bIn.sendMessage(this.bIn.obtainMessage(1, surfaceTexture));
        }
    }

    public void R(int i, int i2) {
        if (this.bIn != null) {
            this.bIn.sendMessage(this.bIn.obtainMessage(2, i, i2));
        }
    }

    public void QS() {
        if (this.bIn != null) {
            this.bIn.sendMessage(this.bIn.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bIo != null) {
            this.bIo.requestRender();
        }
    }

    public void startRecording() {
        if (this.bIn != null) {
            synchronized (this.bIp) {
                this.bIn.sendMessage(this.bIn.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bIn != null) {
            synchronized (this.bIp) {
                this.bIn.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bIn != null) {
            synchronized (this.bIp) {
                this.bIn.sendEmptyMessage(16);
            }
        }
    }

    public void QO() {
        if (this.bIn != null) {
            synchronized (this.bIp) {
                this.bIn.sendEmptyMessage(9);
            }
        }
    }
}
