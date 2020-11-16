package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes16.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b clV;
    private d clW;
    private f clX;
    private final Object clY;

    private b() {
        this.clY = new Object();
        this.clV = com.baidu.rtc.camera.engine.a.b.adu();
    }

    /* loaded from: classes16.dex */
    private static class a {
        private static b clZ = new b();
    }

    public static b adA() {
        return a.clZ;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(Context context) {
        synchronized (this.clY) {
            this.clX = new f(context, "RenderThread");
            this.clX.start();
            this.clW = new d(this.clX);
            this.clX.a(this.clW);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.clW != null) {
            this.clW.sendMessage(this.clW.obtainMessage(1, surfaceTexture));
        }
    }

    public void V(int i, int i2) {
        if (this.clW != null) {
            this.clW.sendMessage(this.clW.obtainMessage(2, i, i2));
        }
    }

    public void adB() {
        if (this.clW != null) {
            this.clW.sendMessage(this.clW.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.clX != null) {
            this.clX.requestRender();
        }
    }

    public void startRecording() {
        if (this.clW != null) {
            synchronized (this.clY) {
                this.clW.sendMessage(this.clW.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.clW != null) {
            synchronized (this.clY) {
                this.clW.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.clW != null) {
            synchronized (this.clY) {
                this.clW.sendEmptyMessage(16);
            }
        }
    }

    public void adx() {
        if (this.clW != null) {
            synchronized (this.clY) {
                this.clW.sendEmptyMessage(9);
            }
        }
    }
}
