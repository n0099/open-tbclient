package com.baidu.ar.arplay.core.engine;

import android.util.Log;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes12.dex */
public class ARPNode {
    protected long eg = -1;
    private HashMap<String, ARPNode> eh;
    protected Lock ei;

    public ARPNode() {
        init();
    }

    public void a(Vector3f vector3f) {
        if (this.eg == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.ei.lock();
            nativeSetWorldPosition(this.eg, vector3f.toArray());
            this.ei.unlock();
        }
    }

    public void a(Vector4f vector4f) {
        if (this.eg == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector4f != null) {
            this.ei.lock();
            nativeSetRotation(this.eg, vector4f.toArray());
            this.ei.unlock();
        }
    }

    public void a(String str, Object obj) {
        if (!ARPEngine.getInstance().isEngineCanAccess() || ARPEngine.getInstance().isAppControllerInterrupt()) {
            return;
        }
        nativeUpdateUniform(this.eg, str, obj);
    }

    public Matrixf4x4 aT() {
        if (this.eg == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.ei.lock();
        float[] nativeInitialTransform = nativeInitialTransform(this.eg);
        this.ei.unlock();
        if (nativeInitialTransform == null || nativeInitialTransform.length < 16) {
            return new Matrixf4x4();
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrix(nativeInitialTransform);
        return matrixf4x4;
    }

    public Vector4f aU() {
        if (this.eg == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.ei.lock();
        float[] nativeGetRotation = nativeGetRotation(this.eg);
        this.ei.unlock();
        if (nativeGetRotation == null || nativeGetRotation.length < 4) {
            return new Vector4f();
        }
        Vector4f vector4f = new Vector4f();
        vector4f.setXYZW(nativeGetRotation[0], nativeGetRotation[1], nativeGetRotation[2], nativeGetRotation[3]);
        return vector4f;
    }

    public void b(Vector3f vector3f) {
        if (this.eg == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.ei.lock();
            nativeSetRotateWorldAxis(this.eg, vector3f.toArray());
            this.ei.unlock();
        }
    }

    public void e(long j) {
        this.eg = j;
    }

    public void init() {
        this.ei = new ReentrantLock();
        nativeInit();
        this.eh = new HashMap<>();
    }

    native float[] nativeGetRotation(long j);

    native void nativeInit();

    native float[] nativeInitialTransform(long j);

    native void nativeSetRotateWorldAxis(long j, float[] fArr);

    native void nativeSetRotation(long j, float[] fArr);

    native void nativeSetWorldPosition(long j, float[] fArr);

    native void nativeUpdateUniform(long j, String str, Object obj);
}
