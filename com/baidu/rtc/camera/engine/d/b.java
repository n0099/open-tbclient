package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes6.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bHN;
    private d bHO;
    private f bHP;
    private final Object bHQ;

    private b() {
        this.bHQ = new Object();
        this.bHN = com.baidu.rtc.camera.engine.a.b.Qw();
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b bHR = new b();
    }

    public static b QC() {
        return a.bHR;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aP(Context context) {
        synchronized (this.bHQ) {
            this.bHP = new f(context, "RenderThread");
            this.bHP.start();
            this.bHO = new d(this.bHP);
            this.bHP.a(this.bHO);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bHO != null) {
            this.bHO.sendMessage(this.bHO.obtainMessage(1, surfaceTexture));
        }
    }

    public void R(int i, int i2) {
        if (this.bHO != null) {
            this.bHO.sendMessage(this.bHO.obtainMessage(2, i, i2));
        }
    }

    public void QD() {
        if (this.bHO != null) {
            this.bHO.sendMessage(this.bHO.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bHP != null) {
            this.bHP.requestRender();
        }
    }

    public void startRecording() {
        if (this.bHO != null) {
            synchronized (this.bHQ) {
                this.bHO.sendMessage(this.bHO.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bHO != null) {
            synchronized (this.bHQ) {
                this.bHO.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bHO != null) {
            synchronized (this.bHQ) {
                this.bHO.sendEmptyMessage(16);
            }
        }
    }

    public void Qz() {
        if (this.bHO != null) {
            synchronized (this.bHQ) {
                this.bHO.sendEmptyMessage(9);
            }
        }
    }
}
