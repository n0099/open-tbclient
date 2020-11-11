package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
/* loaded from: classes11.dex */
public final class b {
    private com.baidu.rtc.camera.engine.a.b cnH;
    private d cnI;
    private f cnJ;
    private final Object cnK;

    private b() {
        this.cnK = new Object();
        this.cnH = com.baidu.rtc.camera.engine.a.b.aec();
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static b cnL = new b();
    }

    public static b aei() {
        return a.cnL;
    }

    public c a(com.baidu.rtc.camera.engine.b.a aVar) {
        return new c(this, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aZ(Context context) {
        synchronized (this.cnK) {
            this.cnJ = new f(context, "RenderThread");
            this.cnJ.start();
            this.cnI = new d(this.cnJ);
            this.cnJ.a(this.cnI);
        }
    }

    public void c(SurfaceTexture surfaceTexture) {
        if (this.cnI != null) {
            this.cnI.sendMessage(this.cnI.obtainMessage(1, surfaceTexture));
        }
    }

    public void V(int i, int i2) {
        if (this.cnI != null) {
            this.cnI.sendMessage(this.cnI.obtainMessage(2, i, i2));
        }
    }

    public void aej() {
        if (this.cnI != null) {
            this.cnI.sendMessage(this.cnI.obtainMessage(3));
        }
    }

    public void requestRender() {
        if (this.cnJ != null) {
            this.cnJ.requestRender();
        }
    }

    public void startRecording() {
        if (this.cnI != null) {
            synchronized (this.cnK) {
                this.cnI.sendMessage(this.cnI.obtainMessage(6));
            }
        }
    }

    public void stopRecording() {
        if (this.cnI != null) {
            synchronized (this.cnK) {
                this.cnI.sendEmptyMessage(8);
            }
        }
    }

    public void switchCamera() {
        if (this.cnI != null) {
            synchronized (this.cnK) {
                this.cnI.sendEmptyMessage(16);
            }
        }
    }

    public void aef() {
        if (this.cnI != null) {
            synchronized (this.cnK) {
                this.cnI.sendEmptyMessage(9);
            }
        }
    }
}
