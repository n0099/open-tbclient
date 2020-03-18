package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes6.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b aWW;
    private d aWX;
    private f aWY;
    private final Object aWZ;

    private b() {
        this.aWZ = new Object();
        this.aWW = com.baidu.rtc.camera.engine.a.b.Fs();
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b aXa = new b();
    }

    public static b Fy() {
        return a.aXa;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aY(Context context) {
        synchronized (this.aWZ) {
            this.aWY = new f(context, "RenderThread");
            this.aWY.start();
            this.aWX = new d(this.aWY);
            this.aWY.a(this.aWX);
        }
    }

    public void d(SurfaceTexture surfaceTexture) {
        if (this.aWX != null) {
            this.aWX.sendMessage(this.aWX.obtainMessage(1, surfaceTexture));
        }
    }

    public void K(int i, int i2) {
        if (this.aWX != null) {
            this.aWX.sendMessage(this.aWX.obtainMessage(2, i, i2));
        }
    }

    public void Fz() {
        if (this.aWX != null) {
            this.aWX.sendMessage(this.aWX.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.aWY != null) {
            this.aWY.requestRender();
        }
    }

    public void Dk() {
        if (this.aWX != null) {
            synchronized (this.aWZ) {
                this.aWX.sendMessage(this.aWX.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.aWX != null) {
            synchronized (this.aWZ) {
                this.aWX.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.aWX != null) {
            synchronized (this.aWZ) {
                this.aWX.sendEmptyMessage(16);
            }
        }
    }

    public void Fv() {
        if (this.aWX != null) {
            synchronized (this.aWZ) {
                this.aWX.sendEmptyMessage(9);
            }
        }
    }
}
