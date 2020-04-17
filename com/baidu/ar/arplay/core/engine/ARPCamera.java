package com.baidu.ar.arplay.core.engine;

import android.util.Log;
/* loaded from: classes3.dex */
public class ARPCamera extends ARPNode {
    private static ARPCamera eg = null;

    public static void aG() {
        if (eg != null) {
            eg.ev = -1L;
            eg = null;
        }
    }

    public void a(float f) {
        if (this.ev == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetFieldOfView(this.ev, f);
        }
    }

    public void a(float[] fArr) {
        if (this.ev == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return;
        }
        this.ex.lock();
        nativeSetViewMatrix(this.ev, fArr);
        this.ex.unlock();
    }

    public float[] aF() {
        if (this.ev == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.ex.lock();
        float[] nativeGetViewMatrix = nativeGetViewMatrix(this.ev);
        this.ex.unlock();
        return nativeGetViewMatrix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.arplay.core.engine.ARPNode
    public void finalize() {
        super.finalize();
        synchronized (this) {
            aG();
        }
    }

    native float[] nativeGetViewMatrix(long j);

    native void nativeSetFieldOfView(long j, float f);

    native void nativeSetViewMatrix(long j, float[] fArr);
}
