package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes11.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b chL;
    private d chM;
    private f chN;
    private final Object chO;

    private b() {
        this.chO = new Object();
        this.chL = com.baidu.rtc.camera.engine.a.b.abC();
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static b chP = new b();
    }

    public static b abI() {
        return a.chP;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(Context context) {
        synchronized (this.chO) {
            this.chN = new f(context, "RenderThread");
            this.chN.start();
            this.chM = new d(this.chN);
            this.chN.a(this.chM);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.chM != null) {
            this.chM.sendMessage(this.chM.obtainMessage(1, surfaceTexture));
        }
    }

    public void V(int i, int i2) {
        if (this.chM != null) {
            this.chM.sendMessage(this.chM.obtainMessage(2, i, i2));
        }
    }

    public void abJ() {
        if (this.chM != null) {
            this.chM.sendMessage(this.chM.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.chN != null) {
            this.chN.requestRender();
        }
    }

    public void startRecording() {
        if (this.chM != null) {
            synchronized (this.chO) {
                this.chM.sendMessage(this.chM.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.chM != null) {
            synchronized (this.chO) {
                this.chM.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.chM != null) {
            synchronized (this.chO) {
                this.chM.sendEmptyMessage(16);
            }
        }
    }

    public void abF() {
        if (this.chM != null) {
            synchronized (this.chO) {
                this.chM.sendEmptyMessage(9);
            }
        }
    }
}
