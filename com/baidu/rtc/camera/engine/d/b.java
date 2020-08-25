package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes11.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b bNN;
    private d bNO;
    private f bNP;
    private final Object bNQ;

    private b() {
        this.bNQ = new Object();
        this.bNN = com.baidu.rtc.camera.engine.a.b.WH();
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static b bNR = new b();
    }

    public static b WN() {
        return a.bNR;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aV(Context context) {
        synchronized (this.bNQ) {
            this.bNP = new f(context, "RenderThread");
            this.bNP.start();
            this.bNO = new d(this.bNP);
            this.bNP.a(this.bNO);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.bNO != null) {
            this.bNO.sendMessage(this.bNO.obtainMessage(1, surfaceTexture));
        }
    }

    public void U(int i, int i2) {
        if (this.bNO != null) {
            this.bNO.sendMessage(this.bNO.obtainMessage(2, i, i2));
        }
    }

    public void WO() {
        if (this.bNO != null) {
            this.bNO.sendMessage(this.bNO.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.bNP != null) {
            this.bNP.requestRender();
        }
    }

    public void startRecording() {
        if (this.bNO != null) {
            synchronized (this.bNQ) {
                this.bNO.sendMessage(this.bNO.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.bNO != null) {
            synchronized (this.bNQ) {
                this.bNO.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.bNO != null) {
            synchronized (this.bNQ) {
                this.bNO.sendEmptyMessage(16);
            }
        }
    }

    public void WK() {
        if (this.bNO != null) {
            synchronized (this.bNQ) {
                this.bNO.sendEmptyMessage(9);
            }
        }
    }
}
