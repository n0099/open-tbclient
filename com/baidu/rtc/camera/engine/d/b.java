package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes6.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bCZ;
    private d bDa;
    private f bDb;
    private final Object bDc;

    private b() {
        this.bDc = new Object();
        this.bCZ = com.baidu.rtc.camera.engine.a.b.Pq();
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b bDd = new b();
    }

    public static b Pw() {
        return a.bDd;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aO(Context context) {
        synchronized (this.bDc) {
            this.bDb = new f(context, "RenderThread");
            this.bDb.start();
            this.bDa = new d(this.bDb);
            this.bDb.a(this.bDa);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bDa != null) {
            this.bDa.sendMessage(this.bDa.obtainMessage(1, surfaceTexture));
        }
    }

    public void P(int i, int i2) {
        if (this.bDa != null) {
            this.bDa.sendMessage(this.bDa.obtainMessage(2, i, i2));
        }
    }

    public void Px() {
        if (this.bDa != null) {
            this.bDa.sendMessage(this.bDa.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bDb != null) {
            this.bDb.requestRender();
        }
    }

    public void startRecording() {
        if (this.bDa != null) {
            synchronized (this.bDc) {
                this.bDa.sendMessage(this.bDa.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bDa != null) {
            synchronized (this.bDc) {
                this.bDa.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bDa != null) {
            synchronized (this.bDc) {
                this.bDa.sendEmptyMessage(16);
            }
        }
    }

    public void Pt() {
        if (this.bDa != null) {
            synchronized (this.bDc) {
                this.bDa.sendEmptyMessage(9);
            }
        }
    }
}
