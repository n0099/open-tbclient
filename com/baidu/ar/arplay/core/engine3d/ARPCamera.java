package com.baidu.ar.arplay.core.engine3d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ARPCamera extends ARPNode implements IARPCamera {
    public static /* synthetic */ Interceptable $ic;
    public static ARPCamera fJ;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1752181981, "Lcom/baidu/ar/arplay/core/engine3d/ARPCamera;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1752181981, "Lcom/baidu/ar/arplay/core/engine3d/ARPCamera;");
        }
    }

    public ARPCamera() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void be() {
        ARPCamera aRPCamera;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (aRPCamera = fJ) == null) {
            return;
        }
        aRPCamera.fK = -1L;
        fJ = null;
        nativeDestory();
    }

    public static native void nativeDestory();

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float getFieldOfView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j2 = this.fK;
            if (j2 == -1) {
                return 0.0f;
            }
            return nativeGetFieldOfView(j2);
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float[] getViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.fK == -1) {
                return null;
            }
            this.fM.lock();
            float[] nativeGetViewMatrix = nativeGetViewMatrix(this.fK);
            this.fM.unlock();
            return nativeGetViewMatrix;
        }
        return (float[]) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float getZFar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j2 = this.fK;
            if (j2 == -1) {
                return 0.0f;
            }
            return nativeGetZFar(j2);
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public float getZNear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j2 = this.fK;
            if (j2 == -1) {
                return 0.0f;
            }
            return nativeGetZNear(j2);
        }
        return invokeV.floatValue;
    }

    public native float nativeGetFieldOfView(long j2);

    public native float[] nativeGetViewMatrix(long j2);

    public native float nativeGetZFar(long j2);

    public native float nativeGetZNear(long j2);

    public native void nativeSetFieldOfView(long j2, float f2);

    public native void nativeSetViewMatrix(long j2, float[] fArr);

    public native void nativeSetZFar(long j2, float f2);

    public native void nativeSetZNear(long j2, float f2);

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setFieldOfView(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            long j2 = this.fK;
            if (j2 == -1) {
                return;
            }
            nativeSetFieldOfView(j2, f2);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setViewMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fArr) == null) || this.fK == -1) {
            return;
        }
        this.fM.lock();
        nativeSetViewMatrix(this.fK, fArr);
        this.fM.unlock();
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setZFar(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            long j2 = this.fK;
            if (j2 == -1) {
                return;
            }
            nativeSetZFar(j2, f2);
        }
    }

    @Override // com.baidu.ar.arplay.core.engine.engine3d.IARPCamera
    public void setZNear(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            long j2 = this.fK;
            if (j2 == -1) {
                return;
            }
            nativeSetZNear(j2, f2);
        }
    }
}
