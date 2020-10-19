package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes11.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bZn;
    private d bZo;
    private f bZp;
    private final Object bZq;

    private b() {
        this.bZq = new Object();
        this.bZn = com.baidu.rtc.camera.engine.a.b.ZI();
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static b bZr = new b();
    }

    public static b ZO() {
        return a.bZr;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(Context context) {
        synchronized (this.bZq) {
            this.bZp = new f(context, "RenderThread");
            this.bZp.start();
            this.bZo = new d(this.bZp);
            this.bZp.a(this.bZo);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bZo != null) {
            this.bZo.sendMessage(this.bZo.obtainMessage(1, surfaceTexture));
        }
    }

    public void U(int i, int i2) {
        if (this.bZo != null) {
            this.bZo.sendMessage(this.bZo.obtainMessage(2, i, i2));
        }
    }

    public void ZP() {
        if (this.bZo != null) {
            this.bZo.sendMessage(this.bZo.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bZp != null) {
            this.bZp.requestRender();
        }
    }

    public void startRecording() {
        if (this.bZo != null) {
            synchronized (this.bZq) {
                this.bZo.sendMessage(this.bZo.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bZo != null) {
            synchronized (this.bZq) {
                this.bZo.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bZo != null) {
            synchronized (this.bZq) {
                this.bZo.sendEmptyMessage(16);
            }
        }
    }

    public void ZL() {
        if (this.bZo != null) {
            synchronized (this.bZq) {
                this.bZo.sendEmptyMessage(9);
            }
        }
    }
}
