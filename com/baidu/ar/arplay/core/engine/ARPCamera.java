package com.baidu.ar.arplay.core.engine;

import android.util.Log;
/* loaded from: classes10.dex */
public class ARPCamera extends ARPNode {
    private static ARPCamera dU = null;

    public static void aS() {
        if (dU != null) {
            dU.eg = -1L;
            dU = null;
            nativeDestory();
        }
    }

    static native void nativeDestory();

    public void a(float f) {
        if (this.eg == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetFieldOfView(this.eg, f);
        }
    }

    public void a(float[] fArr) {
        if (this.eg == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return;
        }
        this.ei.lock();
        nativeSetViewMatrix(this.eg, fArr);
        this.ei.unlock();
    }

    public float[] aR() {
        if (this.eg == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.ei.lock();
        float[] nativeGetViewMatrix = nativeGetViewMatrix(this.eg);
        this.ei.unlock();
        return nativeGetViewMatrix;
    }

    native float[] nativeGetViewMatrix(long j);

    native void nativeSetFieldOfView(long j, float f);

    native void nativeSetViewMatrix(long j, float[] fArr);
}
