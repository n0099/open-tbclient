package com.baidu.ar.arplay.core.engine3d;

import android.util.Log;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
/* loaded from: classes.dex */
public class ARPCamera extends ARPNode implements IARPCamera {
    public static ARPCamera fJ;

    public static void be() {
        ARPCamera aRPCamera = fJ;
        if (aRPCamera != null) {
            aRPCamera.fK = -1L;
            fJ = null;
            nativeDestory();
        }
    }

    public static native void nativeDestory();

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float getFieldOfView() {
        long j = this.fK;
        if (j == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return 0.0f;
        }
        return nativeGetFieldOfView(j);
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
        long j = this.fK;
        if (j == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return 0.0f;
        }
        return nativeGetZFar(j);
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float getZNear() {
        long j = this.fK;
        if (j == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
            return 0.0f;
        }
        return nativeGetZNear(j);
    }

    public native float nativeGetFieldOfView(long j);

    public native float[] nativeGetViewMatrix(long j);

    public native float nativeGetZFar(long j);

    public native float nativeGetZNear(long j);

    public native void nativeSetFieldOfView(long j, float f);

    public native void nativeSetViewMatrix(long j, float[] fArr);

    public native void nativeSetZFar(long j, float f);

    public native void nativeSetZNear(long j, float f);

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setFieldOfView(float f) {
        long j = this.fK;
        if (j == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetFieldOfView(j, f);
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
        long j = this.fK;
        if (j == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetZFar(j, f);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setZNear(float f) {
        long j = this.fK;
        if (j == -1) {
            Log.e(ARPCamera.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetZNear(j, f);
        }
    }
}
