package com.baidu.ar.arplay.core.engine3d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ARPScene implements IARPScene {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ARPNode> fL;
    public long fN;

    public ARPScene() {
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
        this.fN = -1L;
        init();
    }

    private IARPNode e(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j2)) == null) {
            String nativeGetNodeName = nativeGetNodeName(j2);
            ARPNode aRPNode = this.fL.get(nativeGetNodeName);
            if (aRPNode == null) {
                ARPNode aRPNode2 = new ARPNode();
                aRPNode2.bindInternal(j2);
                this.fL.put(nativeGetNodeName, aRPNode2);
                return aRPNode2;
            }
            return aRPNode;
        }
        return (IARPNode) invokeJ.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.fL = new HashMap<>();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPCamera getActiveCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long nativeGetActiveCamera = nativeGetActiveCamera(this.fN);
            ARPCamera aRPCamera = new ARPCamera();
            aRPCamera.bindInternal(nativeGetActiveCamera);
            return aRPCamera;
        }
        return (IARPCamera) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public String getName(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? nativeGetName(j2) : (String) invokeJ.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPNode getNodeByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            long j2 = this.fN;
            if (j2 == -1) {
                return null;
            }
            return e(nativeGetNodeByName(j2, str));
        }
        return (IARPNode) invokeL.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public IARPNode getRootNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j2 = this.fN;
            if (j2 == -1) {
                return null;
            }
            return e(nativeGetRootNode(j2));
        }
        return (IARPNode) invokeV.objValue;
    }

    public native long nativeGetActiveCamera(long j2);

    public native String nativeGetName(long j2);

    public native long nativeGetNodeByName(long j2, String str);

    public native String nativeGetNodeName(long j2);

    public native long nativeGetRootNode(long j2);

    public native void nativeRelocate(long j2);

    public native float[] nativeSceneProject(long j2, float[] fArr);

    public native void nativeSetOffScreenGuideWork(long j2, boolean z);

    public native void nativeSetVisible(long j2, boolean z);

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void relocate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long j2 = this.fN;
            if (j2 == -1) {
                return;
            }
            nativeRelocate(j2);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public float[] sceneProject(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fArr)) == null) {
            long j2 = this.fN;
            if (j2 == -1) {
                return null;
            }
            return nativeSceneProject(j2, fArr);
        }
        return (float[]) invokeL.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void setInternal(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.fN = j2;
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public void setOffScreenGuideWork(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            long j2 = this.fN;
            if (j2 == -1) {
                return;
            }
            nativeSetOffScreenGuideWork(j2, z);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPScene
    public boolean setVisible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            long j2 = this.fN;
            if (j2 == -1) {
                return false;
            }
            nativeSetVisible(j2, z);
            return true;
        }
        return invokeZ.booleanValue;
    }
}
