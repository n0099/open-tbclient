package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes4.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b aRq;
    private d aRr;
    private f aRs;
    private final Object aRt;

    private b() {
        this.aRt = new Object();
        this.aRq = com.baidu.rtc.camera.engine.a.b.Ct();
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static b aRu = new b();
    }

    public static b Cz() {
        return a.aRu;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aV(Context context) {
        synchronized (this.aRt) {
            this.aRs = new f(context, "RenderThread");
            this.aRs.start();
            this.aRr = new d(this.aRs);
            this.aRs.a(this.aRr);
        }
    }

    public void d(SurfaceTexture surfaceTexture) {
        if (this.aRr != null) {
            this.aRr.sendMessage(this.aRr.obtainMessage(1, surfaceTexture));
        }
    }

    public void F(int i, int i2) {
        if (this.aRr != null) {
            this.aRr.sendMessage(this.aRr.obtainMessage(2, i, i2));
        }
    }

    public void CA() {
        if (this.aRr != null) {
            this.aRr.sendMessage(this.aRr.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.aRs != null) {
            this.aRs.requestRender();
        }
    }

    public void Ap() {
        if (this.aRr != null) {
            synchronized (this.aRt) {
                this.aRr.sendMessage(this.aRr.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.aRr != null) {
            synchronized (this.aRt) {
                this.aRr.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.aRr != null) {
            synchronized (this.aRt) {
                this.aRr.sendEmptyMessage(16);
            }
        }
    }

    public void Cw() {
        if (this.aRr != null) {
            synchronized (this.aRt) {
                this.aRr.sendEmptyMessage(9);
            }
        }
    }
}
