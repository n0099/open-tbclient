package com.baidu.ar;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DuMixInput {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceTexture bh;
    public Texture bi;
    public boolean bj;
    public boolean bk;
    public MirriorType bl;
    public boolean bm;
    public boolean bn;
    public boolean mFrontCamera;
    public int mInputHeight;
    public int mInputWidth;
    public RotationType mRotationType;

    public DuMixInput() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bj = true;
        this.mFrontCamera = true;
        this.bk = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bm = false;
        this.bn = false;
    }

    public DuMixInput(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bj = true;
        this.mFrontCamera = true;
        this.bk = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bm = false;
        this.bn = false;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }

    public DuMixInput(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bj = true;
        this.mFrontCamera = true;
        this.bk = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bm = false;
        this.bn = false;
        this.bh = surfaceTexture;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }

    public DuMixInput(Texture texture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mInputWidth = 0;
        this.mInputHeight = 0;
        this.bj = true;
        this.mFrontCamera = true;
        this.bk = true;
        this.mRotationType = RotationType.ROTATE_90;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bm = false;
        this.bn = false;
        this.bi = texture;
        this.mInputWidth = i;
        this.mInputHeight = i2;
    }

    public int getInputDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRotationType.getDegree() : invokeV.intValue;
    }

    public int getInputHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mInputHeight : invokeV.intValue;
    }

    public SurfaceTexture getInputSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bh : (SurfaceTexture) invokeV.objValue;
    }

    public Texture getInputTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bi : (Texture) invokeV.objValue;
    }

    public int getInputWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mInputWidth : invokeV.intValue;
    }

    public MirriorType getMirriorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.bl : (MirriorType) invokeV.objValue;
    }

    public RotationType getRotationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRotationType : (RotationType) invokeV.objValue;
    }

    public boolean isCameraInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.bj : invokeV.booleanValue;
    }

    public boolean isFitCameraAuto() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.bk : invokeV.booleanValue;
    }

    public boolean isFrontCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mFrontCamera : invokeV.booleanValue;
    }

    public boolean isSingleFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.bn : invokeV.booleanValue;
    }

    public boolean isSyncInputContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.bm : invokeV.booleanValue;
    }

    public void setCameraInput(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.bj = z;
        }
    }

    public void setFitCameraAuto(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.bk = z;
        }
    }

    public void setFrontCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mFrontCamera = z;
        }
    }

    public void setInputDegree(int i) {
        RotationType rotationType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            int i2 = ((i % 360) + 360) % 360;
            if (i == 0) {
                rotationType = RotationType.ROTATE_0;
            } else if (i == 90) {
                rotationType = RotationType.ROTATE_90;
            } else if (i == 180) {
                rotationType = RotationType.ROTATE_180;
            } else if (i != 270) {
                return;
            } else {
                rotationType = RotationType.ROTATE_270;
            }
            this.mRotationType = rotationType;
        }
    }

    public void setInputHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mInputHeight = i;
        }
    }

    public void setInputSurface(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, surfaceTexture) == null) {
            this.bh = surfaceTexture;
        }
    }

    public void setInputTexture(Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, texture) == null) {
            this.bi = texture;
        }
    }

    public void setInputWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.mInputWidth = i;
        }
    }

    public void setMirriorType(MirriorType mirriorType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, mirriorType) == null) {
            this.bl = mirriorType;
        }
    }

    public void setRotationType(RotationType rotationType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rotationType) == null) {
            this.mRotationType = rotationType;
        }
    }

    public void setSingleFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.bn = z;
            if (z) {
                this.bm = true;
                this.bj = false;
                this.mFrontCamera = false;
            }
        }
    }

    public void setSyncInputContent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.bm = z;
        }
    }
}
