package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes6.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bvw;
    private d bvx;
    private f bvy;
    private final Object bvz;

    private b() {
        this.bvz = new Object();
        this.bvw = com.baidu.rtc.camera.engine.a.b.Nd();
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b bvA = new b();
    }

    public static b Nj() {
        return a.bvA;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aE(Context context) {
        synchronized (this.bvz) {
            this.bvy = new f(context, "RenderThread");
            this.bvy.start();
            this.bvx = new d(this.bvy);
            this.bvy.a(this.bvx);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bvx != null) {
            this.bvx.sendMessage(this.bvx.obtainMessage(1, surfaceTexture));
        }
    }

    public void M(int i, int i2) {
        if (this.bvx != null) {
            this.bvx.sendMessage(this.bvx.obtainMessage(2, i, i2));
        }
    }

    public void Nk() {
        if (this.bvx != null) {
            this.bvx.sendMessage(this.bvx.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bvy != null) {
            this.bvy.requestRender();
        }
    }

    public void startRecording() {
        if (this.bvx != null) {
            synchronized (this.bvz) {
                this.bvx.sendMessage(this.bvx.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bvx != null) {
            synchronized (this.bvz) {
                this.bvx.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bvx != null) {
            synchronized (this.bvz) {
                this.bvx.sendEmptyMessage(16);
            }
        }
    }

    public void Ng() {
        if (this.bvx != null) {
            synchronized (this.bvz) {
                this.bvx.sendEmptyMessage(9);
            }
        }
    }
}
