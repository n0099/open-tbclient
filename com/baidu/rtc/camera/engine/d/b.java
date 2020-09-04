package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes11.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bNR;
    private d bNS;
    private f bNT;
    private final Object bNU;

    private b() {
        this.bNU = new Object();
        this.bNR = com.baidu.rtc.camera.engine.a.b.WH();
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static b bNV = new b();
    }

    public static b WN() {
        return a.bNV;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aV(Context context) {
        synchronized (this.bNU) {
            this.bNT = new f(context, "RenderThread");
            this.bNT.start();
            this.bNS = new d(this.bNT);
            this.bNT.a(this.bNS);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bNS != null) {
            this.bNS.sendMessage(this.bNS.obtainMessage(1, surfaceTexture));
        }
    }

    public void U(int i, int i2) {
        if (this.bNS != null) {
            this.bNS.sendMessage(this.bNS.obtainMessage(2, i, i2));
        }
    }

    public void WO() {
        if (this.bNS != null) {
            this.bNS.sendMessage(this.bNS.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bNT != null) {
            this.bNT.requestRender();
        }
    }

    public void startRecording() {
        if (this.bNS != null) {
            synchronized (this.bNU) {
                this.bNS.sendMessage(this.bNS.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bNS != null) {
            synchronized (this.bNU) {
                this.bNS.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bNS != null) {
            synchronized (this.bNU) {
                this.bNS.sendEmptyMessage(16);
            }
        }
    }

    public void WK() {
        if (this.bNS != null) {
            synchronized (this.bNU) {
                this.bNS.sendEmptyMessage(9);
            }
        }
    }
}
