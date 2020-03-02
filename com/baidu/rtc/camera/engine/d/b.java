package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes6.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b aWI;
    private d aWJ;
    private f aWK;
    private final Object aWL;

    private b() {
        this.aWL = new Object();
        this.aWI = com.baidu.rtc.camera.engine.a.b.Fn();
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b aWM = new b();
    }

    public static b Ft() {
        return a.aWM;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(Context context) {
        synchronized (this.aWL) {
            this.aWK = new f(context, "RenderThread");
            this.aWK.start();
            this.aWJ = new d(this.aWK);
            this.aWK.a(this.aWJ);
        }
    }

    public void d(SurfaceTexture surfaceTexture) {
        if (this.aWJ != null) {
            this.aWJ.sendMessage(this.aWJ.obtainMessage(1, surfaceTexture));
        }
    }

    public void K(int i, int i2) {
        if (this.aWJ != null) {
            this.aWJ.sendMessage(this.aWJ.obtainMessage(2, i, i2));
        }
    }

    public void Fu() {
        if (this.aWJ != null) {
            this.aWJ.sendMessage(this.aWJ.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.aWK != null) {
            this.aWK.requestRender();
        }
    }

    public void Dd() {
        if (this.aWJ != null) {
            synchronized (this.aWL) {
                this.aWJ.sendMessage(this.aWJ.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.aWJ != null) {
            synchronized (this.aWL) {
                this.aWJ.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.aWJ != null) {
            synchronized (this.aWL) {
                this.aWJ.sendEmptyMessage(16);
            }
        }
    }

    public void Fq() {
        if (this.aWJ != null) {
            synchronized (this.aWL) {
                this.aWJ.sendEmptyMessage(9);
            }
        }
    }
}
