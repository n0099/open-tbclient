package com.baidu.ar.arplay.core.engine;

import android.util.Log;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class ARPNode {
    protected long ev = -1;
    private HashMap<String, ARPNode> ew;
    protected Lock ex;

    public ARPNode() {
        aH();
    }

    public void a(Vector3f vector3f) {
        if (this.ev == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.ex.lock();
            nativeSetWorldPosition(this.ev, vector3f.toArray());
            this.ex.unlock();
        }
    }

    public void a(Vector4f vector4f) {
        if (this.ev == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector4f != null) {
            this.ex.lock();
            nativeSetRotation(this.ev, vector4f.toArray());
            this.ex.unlock();
        }
    }

    public void a(String str, Object obj) {
        if (!ARPEngine.getInstance().isEngineCanAccess() || ARPEngine.getInstance().isAppControllerInterrupt()) {
            return;
        }
        nativeUpdateUniform(this.ev, str, obj);
    }

    public void aH() {
        this.ex = new ReentrantLock();
        nativeInit();
        this.ew = new HashMap<>();
    }

    public Matrixf4x4 aI() {
        if (this.ev == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.ex.lock();
        float[] nativeInitialTransform = nativeInitialTransform(this.ev);
        this.ex.unlock();
        if (nativeInitialTransform == null || nativeInitialTransform.length < 16) {
            return new Matrixf4x4();
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrix(nativeInitialTransform);
        return matrixf4x4;
    }

    public Vector4f aJ() {
        if (this.ev == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.ex.lock();
        float[] nativeGetRotation = nativeGetRotation(this.ev);
        this.ex.unlock();
        if (nativeGetRotation == null || nativeGetRotation.length < 4) {
            return new Vector4f();
        }
        Vector4f vector4f = new Vector4f();
        vector4f.setXYZW(nativeGetRotation[0], nativeGetRotation[1], nativeGetRotation[2], nativeGetRotation[3]);
        return vector4f;
    }

    public void b(Vector3f vector3f) {
        if (this.ev == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.ex.lock();
            nativeSetRotateWorldAxis(this.ev, vector3f.toArray());
            this.ex.unlock();
        }
    }

    public void e(long j) {
        this.ev = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() {
        this.ev = -1L;
        this.ew.clear();
        super.finalize();
    }

    native float[] nativeGetRotation(long j);

    native void nativeInit();

    native float[] nativeInitialTransform(long j);

    native void nativeSetRotateWorldAxis(long j, float[] fArr);

    native void nativeSetRotation(long j, float[] fArr);

    native void nativeSetWorldPosition(long j, float[] fArr);

    native void nativeUpdateUniform(long j, String str, Object obj);
}
