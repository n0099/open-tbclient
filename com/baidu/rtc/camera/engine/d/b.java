package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes11.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b csR;
    private d csS;
    private f csT;
    private final Object csU;

    private b() {
        this.csU = new Object();
        this.csR = com.baidu.rtc.camera.engine.a.b.agC();
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static b csV = new b();
    }

    public static b agI() {
        return a.csV;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bF(Context context) {
        synchronized (this.csU) {
            this.csT = new f(context, "RenderThread");
            this.csT.start();
            this.csS = new d(this.csT);
            this.csT.a(this.csS);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.csS != null) {
            this.csS.sendMessage(this.csS.obtainMessage(1, surfaceTexture));
        }
    }

    public void X(int i, int i2) {
        if (this.csS != null) {
            this.csS.sendMessage(this.csS.obtainMessage(2, i, i2));
        }
    }

    public void agJ() {
        if (this.csS != null) {
            this.csS.sendMessage(this.csS.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.csT != null) {
            this.csT.requestRender();
        }
    }

    public void startRecording() {
        if (this.csS != null) {
            synchronized (this.csU) {
                this.csS.sendMessage(this.csS.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.csS != null) {
            synchronized (this.csU) {
                this.csS.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.csS != null) {
            synchronized (this.csU) {
                this.csS.sendEmptyMessage(16);
            }
        }
    }

    public void agF() {
        if (this.csS != null) {
            synchronized (this.csU) {
                this.csS.sendEmptyMessage(9);
            }
        }
    }
}
