package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes6.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b aWJ;
    private d aWK;
    private f aWL;
    private final Object aWM;

    private b() {
        this.aWM = new Object();
        this.aWJ = com.baidu.rtc.camera.engine.a.b.Fn();
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b aWN = new b();
    }

    public static b Ft() {
        return a.aWN;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(Context context) {
        synchronized (this.aWM) {
            this.aWL = new f(context, "RenderThread");
            this.aWL.start();
            this.aWK = new d(this.aWL);
            this.aWL.a(this.aWK);
        }
    }

    public void d(SurfaceTexture surfaceTexture) {
        if (this.aWK != null) {
            this.aWK.sendMessage(this.aWK.obtainMessage(1, surfaceTexture));
        }
    }

    public void K(int i, int i2) {
        if (this.aWK != null) {
            this.aWK.sendMessage(this.aWK.obtainMessage(2, i, i2));
        }
    }

    public void Fu() {
        if (this.aWK != null) {
            this.aWK.sendMessage(this.aWK.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.aWL != null) {
            this.aWL.requestRender();
        }
    }

    public void Dd() {
        if (this.aWK != null) {
            synchronized (this.aWM) {
                this.aWK.sendMessage(this.aWK.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.aWK != null) {
            synchronized (this.aWM) {
                this.aWK.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.aWK != null) {
            synchronized (this.aWM) {
                this.aWK.sendEmptyMessage(16);
            }
        }
    }

    public void Fq() {
        if (this.aWK != null) {
            synchronized (this.aWM) {
                this.aWK.sendEmptyMessage(9);
            }
        }
    }
}
