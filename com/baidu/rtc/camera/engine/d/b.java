package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes6.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b aWH;
    private d aWI;
    private f aWJ;
    private final Object aWK;

    private b() {
        this.aWK = new Object();
        this.aWH = com.baidu.rtc.camera.engine.a.b.Fl();
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b aWL = new b();
    }

    public static b Fr() {
        return a.aWL;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(Context context) {
        synchronized (this.aWK) {
            this.aWJ = new f(context, "RenderThread");
            this.aWJ.start();
            this.aWI = new d(this.aWJ);
            this.aWJ.a(this.aWI);
        }
    }

    public void d(SurfaceTexture surfaceTexture) {
        if (this.aWI != null) {
            this.aWI.sendMessage(this.aWI.obtainMessage(1, surfaceTexture));
        }
    }

    public void K(int i, int i2) {
        if (this.aWI != null) {
            this.aWI.sendMessage(this.aWI.obtainMessage(2, i, i2));
        }
    }

    public void Fs() {
        if (this.aWI != null) {
            this.aWI.sendMessage(this.aWI.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.aWJ != null) {
            this.aWJ.requestRender();
        }
    }

    public void Db() {
        if (this.aWI != null) {
            synchronized (this.aWK) {
                this.aWI.sendMessage(this.aWI.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.aWI != null) {
            synchronized (this.aWK) {
                this.aWI.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.aWI != null) {
            synchronized (this.aWK) {
                this.aWI.sendEmptyMessage(16);
            }
        }
    }

    public void Fo() {
        if (this.aWI != null) {
            synchronized (this.aWK) {
                this.aWI.sendEmptyMessage(9);
            }
        }
    }
}
