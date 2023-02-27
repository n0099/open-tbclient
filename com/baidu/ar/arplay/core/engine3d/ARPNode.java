package com.baidu.ar.arplay.core.engine3d;

import android.util.Log;
import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class ARPNode implements IARPNode {
    public long fK = -1;
    public HashMap<String, ARPNode> fL;
    public Lock fM;

    public ARPNode() {
        init();
    }

    private void init() {
        this.fM = new ReentrantLock();
        nativeInit();
        this.fL = new HashMap<>();
    }

    private native void nativeInit();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    /* renamed from: H */
    public ARPNode getChildARPNode(String str) {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        HashMap<String, ARPNode> hashMap = this.fL;
        ARPNode aRPNode = hashMap != null ? hashMap.get(str) : null;
        if (aRPNode == null) {
            long nativeGetChildNodeByName = nativeGetChildNodeByName(this.fK, str);
            if (nativeGetChildNodeByName != -1) {
                aRPNode = new ARPNode();
                aRPNode.bindInternal(nativeGetChildNodeByName);
                HashMap<String, ARPNode> hashMap2 = this.fL;
                if (hashMap2 != null) {
                    hashMap2.put(str, aRPNode);
                }
            }
        }
        return aRPNode;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    /* renamed from: bg */
    public ARPNode getParentARPNode() {
        long j = this.fK;
        if (j == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        long nativeGetParentNodePtr = nativeGetParentNodePtr(j);
        String nativeGetName = nativeGetName(nativeGetParentNodePtr);
        HashMap<String, ARPNode> hashMap = this.fL;
        ARPNode aRPNode = hashMap != null ? hashMap.get(nativeGetName) : null;
        if (aRPNode == null && nativeGetParentNodePtr != -1) {
            aRPNode = new ARPNode();
            aRPNode.bindInternal(nativeGetParentNodePtr);
            HashMap<String, ARPNode> hashMap2 = this.fL;
            if (hashMap2 != null) {
                hashMap2.put(nativeGetName, aRPNode);
            }
        }
        return aRPNode;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void bindInternal(long j) {
        this.fK = j;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getEulerAnges() {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeGetEulerAngles = nativeGetEulerAngles(this.fK);
        this.fM.unlock();
        if (nativeGetEulerAngles == null || nativeGetEulerAngles.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetEulerAngles[0], nativeGetEulerAngles[1], nativeGetEulerAngles[2]);
        return vector3f;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Matrixf4x4 getInitialTransform() {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeInitialTransform = nativeInitialTransform(this.fK);
        this.fM.unlock();
        if (nativeInitialTransform == null || nativeInitialTransform.length < 16) {
            return new Matrixf4x4();
        }
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrix(nativeInitialTransform);
        return matrixf4x4;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public String getName() {
        return nativeGetName(this.fK);
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getPosition() {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeGetPosition = nativeGetPosition(this.fK);
        this.fM.unlock();
        if (nativeGetPosition == null || nativeGetPosition.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetPosition[0], nativeGetPosition[1], nativeGetPosition[2]);
        return vector3f;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getRotateWorldAxis() {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeGetRotateWorldAxis = nativeGetRotateWorldAxis(this.fK);
        this.fM.unlock();
        if (nativeGetRotateWorldAxis == null || nativeGetRotateWorldAxis.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetRotateWorldAxis[0], nativeGetRotateWorldAxis[1], nativeGetRotateWorldAxis[2]);
        return vector3f;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector4f getRotation() {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeGetRotation = nativeGetRotation(this.fK);
        this.fM.unlock();
        if (nativeGetRotation == null || nativeGetRotation.length < 4) {
            return new Vector4f();
        }
        Vector4f vector4f = new Vector4f();
        vector4f.setXYZW(nativeGetRotation[0], nativeGetRotation[1], nativeGetRotation[2], nativeGetRotation[3]);
        return vector4f;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getScale() {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeGetScale = nativeGetScale(this.fK);
        this.fM.unlock();
        if (nativeGetScale == null || nativeGetScale.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetScale[0], nativeGetScale[1], nativeGetScale[2]);
        return vector3f;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Matrixf4x4 getTransform() {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeGetTransform = nativeGetTransform(this.fK);
        this.fM.unlock();
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        if (nativeGetTransform != null) {
            matrixf4x4.setMatrix(nativeGetTransform);
        }
        return matrixf4x4;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getWorldPosition() {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
            return null;
        }
        this.fM.lock();
        float[] nativeGetWorldPosition = nativeGetWorldPosition(this.fK);
        this.fM.unlock();
        if (nativeGetWorldPosition == null || nativeGetWorldPosition.length < 3) {
            return new Vector3f();
        }
        Vector3f vector3f = new Vector3f();
        vector3f.setXYZ(nativeGetWorldPosition[0], nativeGetWorldPosition[1], nativeGetWorldPosition[2]);
        return vector3f;
    }

    public native long nativeGetChildNodeByName(long j, String str);

    public native float[] nativeGetEulerAngles(long j);

    public native String nativeGetName(long j);

    public native long nativeGetParentNodePtr(long j);

    public native float[] nativeGetPosition(long j);

    public native float[] nativeGetRotateWorldAxis(long j);

    public native float[] nativeGetRotation(long j);

    public native float[] nativeGetScale(long j);

    public native float[] nativeGetTransform(long j);

    public native float[] nativeGetWorldPosition(long j);

    public native float[] nativeInitialTransform(long j);

    public native void nativeSetEulerAngles(long j, float[] fArr);

    public native void nativeSetName(long j, String str);

    public native void nativeSetPosition(long j, float[] fArr);

    public native void nativeSetRotateWorldAxis(long j, float[] fArr);

    public native void nativeSetRotation(long j, float[] fArr);

    public native void nativeSetTransform(long j, float[] fArr);

    public native void nativeSetWorldPosition(long j, float[] fArr);

    public native void nativeUpdateUniform(long j, String str, Object obj);

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setEulerAnges(Vector3f vector3f) {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.fM.lock();
            nativeSetEulerAngles(this.fK, vector3f.toArray());
            this.fM.unlock();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setName(String str) {
        long j = this.fK;
        if (j == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else {
            nativeSetName(j, str);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setPosition(Vector3f vector3f) {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.fM.lock();
            nativeSetPosition(this.fK, vector3f.toArray());
            this.fM.unlock();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setRotateWorldAxis(Vector3f vector3f) {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.fM.lock();
            nativeSetRotateWorldAxis(this.fK, vector3f.toArray());
            this.fM.unlock();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setRotation(Vector4f vector4f) {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector4f != null) {
            this.fM.lock();
            nativeSetRotation(this.fK, vector4f.toArray());
            this.fM.unlock();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setTransform(Matrixf4x4 matrixf4x4) {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (matrixf4x4 != null) {
            this.fM.lock();
            nativeSetTransform(this.fK, matrixf4x4.getMatrix());
            this.fM.unlock();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setWorldPosition(Vector3f vector3f) {
        if (this.fK == -1) {
            Log.e(ARPNode.class.getSimpleName(), "node addr is error");
        } else if (vector3f != null) {
            this.fM.lock();
            nativeSetWorldPosition(this.fK, vector3f.toArray());
            this.fM.unlock();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void updateUniform(String str, Object obj) {
        nativeUpdateUniform(this.fK, str, obj);
    }
}
