package com.baidu.ar.arplay.core.engine;

import android.util.Log;
/* loaded from: classes11.dex */
public class ARPCamera extends ARPNode {
    private static ARPCamera es = null;

    public static void aU() {
        if (es != null) {
            es.eH = -1L;
            es = null;
        }
    }

    public void a(float f) {
        if (this.eH == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetFieldOfView(this.eH, f);
        }
    }

    public void a(float[] fArr) {
        if (this.eH == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return;
        }
        this.eJ.lock();
        nativeSetViewMatrix(this.eH, fArr);
        this.eJ.unlock();
    }

    public float[] aT() {
        if (this.eH == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.eJ.lock();
        float[] nativeGetViewMatrix = nativeGetViewMatrix(this.eH);
        this.eJ.unlock();
        return nativeGetViewMatrix;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.arplay.core.engine.ARPNode
    public void finalize() {
        super.finalize();
        synchronized (this) {
            aU();
        }
    }

    native float[] nativeGetViewMatrix(long j);

    native void nativeSetFieldOfView(long j, float f);

    native void nativeSetViewMatrix(long j, float[] fArr);
}
