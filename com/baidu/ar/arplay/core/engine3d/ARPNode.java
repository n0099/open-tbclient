package com.baidu.ar.arplay.core.engine3d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public class ARPNode implements IARPNode {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long fK;
    public HashMap<String, ARPNode> fL;
    public Lock fM;

    public ARPNode() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fK = -1L;
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.fM = new ReentrantLock();
            nativeInit();
            this.fL = new HashMap<>();
        }
    }

    private native void nativeInit();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    /* renamed from: H */
    public ARPNode getChildARPNode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.fK == -1) {
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
        return (ARPNode) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    /* renamed from: bg */
    public ARPNode getParentARPNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.fK;
            if (j2 == -1) {
                return null;
            }
            long nativeGetParentNodePtr = nativeGetParentNodePtr(j2);
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
        return (ARPNode) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void bindInternal(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.fK = j2;
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getEulerAnges() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.fK == -1) {
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
        return (Vector3f) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Matrixf4x4 getInitialTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.fK == -1) {
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
        return (Matrixf4x4) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? nativeGetName(this.fK) : (String) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.fK == -1) {
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
        return (Vector3f) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getRotateWorldAxis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.fK == -1) {
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
        return (Vector3f) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector4f getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.fK == -1) {
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
        return (Vector4f) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.fK == -1) {
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
        return (Vector3f) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Matrixf4x4 getTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.fK == -1) {
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
        return (Matrixf4x4) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public Vector3f getWorldPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.fK == -1) {
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
        return (Vector3f) invokeV.objValue;
    }

    public native long nativeGetChildNodeByName(long j2, String str);

    public native float[] nativeGetEulerAngles(long j2);

    public native String nativeGetName(long j2);

    public native long nativeGetParentNodePtr(long j2);

    public native float[] nativeGetPosition(long j2);

    public native float[] nativeGetRotateWorldAxis(long j2);

    public native float[] nativeGetRotation(long j2);

    public native float[] nativeGetScale(long j2);

    public native float[] nativeGetTransform(long j2);

    public native float[] nativeGetWorldPosition(long j2);

    public native float[] nativeInitialTransform(long j2);

    public native void nativeSetEulerAngles(long j2, float[] fArr);

    public native void nativeSetName(long j2, String str);

    public native void nativeSetPosition(long j2, float[] fArr);

    public native void nativeSetRotateWorldAxis(long j2, float[] fArr);

    public native void nativeSetRotation(long j2, float[] fArr);

    public native void nativeSetTransform(long j2, float[] fArr);

    public native void nativeSetWorldPosition(long j2, float[] fArr);

    public native void nativeUpdateUniform(long j2, String str, Object obj);

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setEulerAnges(Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, vector3f) == null) || this.fK == -1 || vector3f == null) {
            return;
        }
        this.fM.lock();
        nativeSetEulerAngles(this.fK, vector3f.toArray());
        this.fM.unlock();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            long j2 = this.fK;
            if (j2 == -1) {
                return;
            }
            nativeSetName(j2, str);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setPosition(Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, vector3f) == null) || this.fK == -1 || vector3f == null) {
            return;
        }
        this.fM.lock();
        nativeSetPosition(this.fK, vector3f.toArray());
        this.fM.unlock();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setRotateWorldAxis(Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, vector3f) == null) || this.fK == -1 || vector3f == null) {
            return;
        }
        this.fM.lock();
        nativeSetRotateWorldAxis(this.fK, vector3f.toArray());
        this.fM.unlock();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setRotation(Vector4f vector4f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, vector4f) == null) || this.fK == -1 || vector4f == null) {
            return;
        }
        this.fM.lock();
        nativeSetRotation(this.fK, vector4f.toArray());
        this.fM.unlock();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setTransform(Matrixf4x4 matrixf4x4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, matrixf4x4) == null) || this.fK == -1 || matrixf4x4 == null) {
            return;
        }
        this.fM.lock();
        nativeSetTransform(this.fK, matrixf4x4.getMatrix());
        this.fM.unlock();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void setWorldPosition(Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, vector3f) == null) || this.fK == -1 || vector3f == null) {
            return;
        }
        this.fM.lock();
        nativeSetWorldPosition(this.fK, vector3f.toArray());
        this.fM.unlock();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPNode
    public void updateUniform(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, obj) == null) {
            nativeUpdateUniform(this.fK, str, obj);
        }
    }
}
