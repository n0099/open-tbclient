package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes6.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bvr;
    private d bvs;
    private f bvt;
    private final Object bvu;

    private b() {
        this.bvu = new Object();
        this.bvr = com.baidu.rtc.camera.engine.a.b.Ne();
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static b bvv = new b();
    }

    public static b Nk() {
        return a.bvv;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aQ(Context context) {
        synchronized (this.bvu) {
            this.bvt = new f(context, "RenderThread");
            this.bvt.start();
            this.bvs = new d(this.bvt);
            this.bvt.a(this.bvs);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bvs != null) {
            this.bvs.sendMessage(this.bvs.obtainMessage(1, surfaceTexture));
        }
    }

    public void M(int i, int i2) {
        if (this.bvs != null) {
            this.bvs.sendMessage(this.bvs.obtainMessage(2, i, i2));
        }
    }

    public void Nl() {
        if (this.bvs != null) {
            this.bvs.sendMessage(this.bvs.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bvt != null) {
            this.bvt.requestRender();
        }
    }

    public void startRecording() {
        if (this.bvs != null) {
            synchronized (this.bvu) {
                this.bvs.sendMessage(this.bvs.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bvs != null) {
            synchronized (this.bvu) {
                this.bvs.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bvs != null) {
            synchronized (this.bvu) {
                this.bvs.sendEmptyMessage(16);
            }
        }
    }

    public void Nh() {
        if (this.bvs != null) {
            synchronized (this.bvu) {
                this.bvs.sendEmptyMessage(9);
            }
        }
    }
}
