package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes5.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b aSi;
    private d aSj;
    private f aSk;
    private final Object aSl;

    private b() {
        this.aSl = new Object();
        this.aSi = com.baidu.rtc.camera.engine.a.b.CP();
    }

    /* loaded from: classes5.dex */
    private static class a {
        private static b aSm = new b();
    }

    public static b CV() {
        return a.aSm;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aV(Context context) {
        synchronized (this.aSl) {
            this.aSk = new f(context, "RenderThread");
            this.aSk.start();
            this.aSj = new d(this.aSk);
            this.aSk.a(this.aSj);
        }
    }

    public void d(SurfaceTexture surfaceTexture) {
        if (this.aSj != null) {
            this.aSj.sendMessage(this.aSj.obtainMessage(1, surfaceTexture));
        }
    }

    public void J(int i, int i2) {
        if (this.aSj != null) {
            this.aSj.sendMessage(this.aSj.obtainMessage(2, i, i2));
        }
    }

    public void CW() {
        if (this.aSj != null) {
            this.aSj.sendMessage(this.aSj.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.aSk != null) {
            this.aSk.requestRender();
        }
    }

    public void AL() {
        if (this.aSj != null) {
            synchronized (this.aSl) {
                this.aSj.sendMessage(this.aSj.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.aSj != null) {
            synchronized (this.aSl) {
                this.aSj.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.aSj != null) {
            synchronized (this.aSl) {
                this.aSj.sendEmptyMessage(16);
            }
        }
    }

    public void CS() {
        if (this.aSj != null) {
            synchronized (this.aSl) {
                this.aSj.sendEmptyMessage(9);
            }
        }
    }
}
