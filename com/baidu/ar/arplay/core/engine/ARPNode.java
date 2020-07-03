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
    protected long eH = -1;
    private HashMap<String, ARPNode> eI;
    protected Lock eJ;

    public ARPNode() {
        aV();
    }

    public void a(Vector3f vector3f) {
        if (this.eH == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.eJ.lock();
            nativeSetWorldPosition(this.eH, vector3f.toArray());
            this.eJ.unlock();
        }
    }

    public void a(Vector4f vector4f) {
        if (this.eH == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector4f != null) {
            this.eJ.lock();
            nativeSetRotation(this.eH, vector4f.toArray());
            this.eJ.unlock();
        }
    }

    public void a(String str, Object obj) {
        if (!ARPEngine.getInstance().isEngineCanAccess() || ARPEngine.getInstance().isAppControllerInterrupt()) {
            return;
        }
        nativeUpdateUniform(this.eH, str, obj);
    }

    public void aV() {
        this.eJ = new ReentrantLock();
        nativeInit();
        this.eI = new HashMap<>();
    }

    public Matrixf4x4 aW() {
        if (this.eH == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.eJ.lock();
        float[] nativeInitialTransform = nativeInitialTransform(this.eH);
        this.eJ.unlock();
        if (nativeInitialTransform == null || nativeInitialTransform.length < 16) {
            return new Matrixf4x4();
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrix(nativeInitialTransform);
        return matrixf4x4;
    }

    public Vector4f aX() {
        if (this.eH == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.eJ.lock();
        float[] nativeGetRotation = nativeGetRotation(this.eH);
        this.eJ.unlock();
        if (nativeGetRotation == null || nativeGetRotation.length < 4) {
            return new Vector4f();
        }
        Vector4f vector4f = new Vector4f();
        vector4f.setXYZW(nativeGetRotation[0], nativeGetRotation[1], nativeGetRotation[2], nativeGetRotation[3]);
        return vector4f;
    }

    public void b(Vector3f vector3f) {
        if (this.eH == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.eJ.lock();
            nativeSetRotateWorldAxis(this.eH, vector3f.toArray());
            this.eJ.unlock();
        }
    }

    public void e(long j) {
        this.eH = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() {
        this.eH = -1L;
        this.eI.clear();
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
