package com.baidu.ar.arplay.core.engine3d;

import android.util.Log;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
/* loaded from: classes6.dex */
public class ARPCamera extends ARPNode implements IARPCamera {
    private static ARPCamera fJ = null;

    public static void be() {
        if (fJ != null) {
            fJ.fK = -1L;
            fJ = null;
            nativeDestory();
        }
    }

    static native void nativeDestory();

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float getFieldOfView() {
        if (this.fK == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return 0.0f;
        }
        return nativeGetFieldOfView(this.fK);
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float[] getViewMatrix() {
        if (this.fK == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeGetViewMatrix = nativeGetViewMatrix(this.fK);
        this.fM.unlock();
        return nativeGetViewMatrix;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float getZFar() {
        if (this.fK == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return 0.0f;
        }
        return nativeGetZFar(this.fK);
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float getZNear() {
        if (this.fK == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return 0.0f;
        }
        return nativeGetZNear(this.fK);
    }

    native float nativeGetFieldOfView(long j);

    native float[] nativeGetViewMatrix(long j);

    native float nativeGetZFar(long j);

    native float nativeGetZNear(long j);

    native void nativeSetFieldOfView(long j, float f);

    native void nativeSetViewMatrix(long j, float[] fArr);

    native void nativeSetZFar(long j, float f);

    native void nativeSetZNear(long j, float f);

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setFieldOfView(float f) {
        if (this.fK == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetFieldOfView(this.fK, f);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setViewMatrix(float[] fArr) {
        if (this.fK == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return;
        }
        this.fM.lock();
        nativeSetViewMatrix(this.fK, fArr);
        this.fM.unlock();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setZFar(float f) {
        if (this.fK == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetZFar(this.fK, f);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setZNear(float f) {
        if (this.fK == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetZNear(this.fK, f);
        }
    }
}
