package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes15.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bPR;
    private d bPS;
    private f bPT;
    private final Object bPU;

    private b() {
        this.bPU = new Object();
        this.bPR = com.baidu.rtc.camera.engine.a.b.Xq();
    }

    /* loaded from: classes15.dex */
    private static class a {
        private static b bPV = new b();
    }

    public static b Xw() {
        return a.bPV;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aU(Context context) {
        synchronized (this.bPU) {
            this.bPT = new f(context, "RenderThread");
            this.bPT.start();
            this.bPS = new d(this.bPT);
            this.bPT.a(this.bPS);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bPS != null) {
            this.bPS.sendMessage(this.bPS.obtainMessage(1, surfaceTexture));
        }
    }

    public void U(int i, int i2) {
        if (this.bPS != null) {
            this.bPS.sendMessage(this.bPS.obtainMessage(2, i, i2));
        }
    }

    public void Xx() {
        if (this.bPS != null) {
            this.bPS.sendMessage(this.bPS.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bPT != null) {
            this.bPT.requestRender();
        }
    }

    public void startRecording() {
        if (this.bPS != null) {
            synchronized (this.bPU) {
                this.bPS.sendMessage(this.bPS.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bPS != null) {
            synchronized (this.bPU) {
                this.bPS.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bPS != null) {
            synchronized (this.bPU) {
                this.bPS.sendEmptyMessage(16);
            }
        }
    }

    public void Xt() {
        if (this.bPS != null) {
            synchronized (this.bPU) {
                this.bPS.sendEmptyMessage(9);
            }
        }
    }
}
