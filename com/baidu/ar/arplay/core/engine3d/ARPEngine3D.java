package com.baidu.ar.arplay.core.engine3d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.engine3d.AbstractARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.ar.arplay.representation.Matrix;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ARPEngine3D extends AbstractARPEngine3D {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ARPEngine3D() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Vector3f vector3f, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65537, null, vector3f, f) == null) {
            nativeSetMovePlane(vector3f.getX(), vector3f.getY(), vector3f.getZ(), f);
        }
    }

    private IARPScene bf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            long nativeGetCurrentScene = nativeGetCurrentScene();
            if (nativeGetCurrentScene == -1) {
                return null;
            }
            ARPScene aRPScene = new ARPScene();
            aRPScene.setInternal(nativeGetCurrentScene);
            return aRPScene;
        }
        return (IARPScene) invokeV.objValue;
    }

    public static native void nativeSetMovePlane(float f, float f2, float f3, float f4);

    @Override // com.baidu.ar.arplay.core.engine.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ARPCamera.be();
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D
    public IARPScene getCurrentScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? bf() : (IARPScene) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D
    public void initWorldAxis() {
        IARPScene bf;
        Vector3f vector3f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bf = bf()) == null) {
            return;
        }
        IARPNode rootNode = bf.getRootNode();
        if (this.mIsActiveByARPlayVersionCase) {
            vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
            if (rootNode == null) {
                return;
            }
        } else {
            a(new Vector3f(0.0f, 0.0f, 1.0f), 0.0f);
            vector3f = new Vector3f(0.0f, 0.0f, 1.0f);
            if (rootNode == null) {
                return;
            }
        }
        rootNode.setRotateWorldAxis(vector3f);
    }

    public native long nativeGetCurrentScene();

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D
    public void sceneRotateToCamera() {
        IARPScene currentScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (currentScene = getCurrentScene()) == null) {
            return;
        }
        IARPCamera activeCamera = currentScene.getActiveCamera();
        Matrixf4x4 matrixf4x4 = new Matrixf4x4();
        matrixf4x4.setMatrixValues(activeCamera.getViewMatrix());
        Matrixf4x4 matrixf4x42 = new Matrixf4x4();
        Matrix.invertM(matrixf4x42.getMatrix(), 0, matrixf4x4.getMatrix(), 0);
        IARPNode rootNode = currentScene.getRootNode();
        if (rootNode == null) {
            Log.e("sceneRotateToCamera", "current scene root node is null!");
            return;
        }
        Vector3f vector3f = new Vector3f(0.0f, -1.0f, 0.0f);
        if (this.mIsActiveByARPlayVersionCase) {
            vector3f.setXYZ(0.0f, 0.0f, 1.0f);
        }
        Vector4f rotation = rootNode.getRotation();
        Quaternion quaternion = new Quaternion();
        quaternion.setAxisAngleRad(new Vector3f(rotation.x(), rotation.y(), rotation.z()), rotation.getW());
        Matrixf4x4 matrixf4x43 = new Matrixf4x4();
        matrixf4x43.setMatrixValues(quaternion.getMatrix4x4().getMatrix());
        Vector3f vector3f2 = new Vector3f();
        Matrix.multiplyMV3(vector3f2.toArray(), matrixf4x43.getMatrix(), vector3f.toArray(), 1.0f);
        Vector3f vector3f3 = new Vector3f();
        Vector3f vector3f4 = new Vector3f(0.0f, 0.0f, -1.0f);
        matrixf4x42.setW0(0.0f);
        matrixf4x42.setW1(0.0f);
        matrixf4x42.setW2(0.0f);
        matrixf4x42.setW3(1.0f);
        Matrix.multiplyMV3(vector3f3.toArray(), matrixf4x42.getMatrix(), vector3f4.toArray(), 1.0f);
        Vector3f vector3f5 = new Vector3f();
        if (this.mIsActiveByARPlayVersionCase) {
            vector3f3.setY(0.0f);
            vector3f5.setXYZ(0.0f, 1.0f, 0.0f);
        } else {
            vector3f3.setZ(0.0f);
            vector3f5.setXYZ(0.0f, 0.0f, 1.0f);
        }
        vector3f3.normalize();
        vector3f3.multiplyByScalar(-1.0f);
        Quaternion a = ARPNumber.a(vector3f2, vector3f3);
        a.multiplyByQuat(quaternion);
        Vector4f vector4f = new Vector4f();
        a.toAxisAngle(vector4f);
        vector4f.setW((float) Math.toRadians(vector4f.w()));
        rootNode.setRotation(vector4f);
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D
    public void sceneWorldPositionToOrigin() {
        IARPScene currentScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (currentScene = getCurrentScene()) == null) {
            return;
        }
        IARPNode rootNode = currentScene.getRootNode();
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, 0.0f);
        if (rootNode != null) {
            rootNode.setWorldPosition(vector3f);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D
    public void updateNodeUniform(String str, HashMap<String, Object> hashMap) {
        IARPScene currentScene;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, hashMap) == null) || (currentScene = getCurrentScene()) == null || TextUtils.isEmpty(str) || hashMap == null) {
            return;
        }
        IARPNode nodeByName = currentScene.getNodeByName(str);
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            nodeByName.updateUniform(entry.getKey(), entry.getValue());
        }
    }
}
