package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Watermark;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DuMixOutput {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MirriorType bl;
    public Object bo;
    public boolean bp;
    public ScaleType bq;
    public boolean br;
    public int bs;
    public int bt;
    public Watermark bu;
    public int mOutputHeight;
    public int mOutputWidth;
    public RotationType mRotationType;

    public DuMixOutput() {
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
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
    }

    public DuMixOutput(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.mOutputWidth = i2;
        this.mOutputHeight = i3;
    }

    public DuMixOutput(SurfaceTexture surfaceTexture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.bo = surfaceTexture;
        this.mOutputWidth = i2;
        this.mOutputHeight = i3;
    }

    public DuMixOutput(Surface surface, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surface, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.bo = surface;
        this.mOutputWidth = i2;
        this.mOutputHeight = i3;
    }

    public DuMixOutput(SurfaceHolder surfaceHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {surfaceHolder, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65540, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65540, newInitContext);
                return;
            }
        }
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.bo = surfaceHolder;
        this.mOutputWidth = i2;
        this.mOutputHeight = i3;
    }

    public DuMixOutput(Texture texture, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {texture, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.bo = null;
        this.bp = false;
        this.bq = ScaleType.CENTER_CROP;
        this.br = true;
        this.bs = 1;
        this.mRotationType = RotationType.ROTATE_0;
        this.bl = MirriorType.NO_MIRRIOR;
        this.bt = 0;
        this.bo = texture;
        this.mOutputWidth = i2;
        this.mOutputHeight = i3;
    }

    public MirriorType getMirriorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.bl : (MirriorType) invokeV.objValue;
    }

    public int getOutputFPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bt : invokeV.intValue;
    }

    public int getOutputHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOutputHeight : invokeV.intValue;
    }

    public Object getOutputSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bo : invokeV.objValue;
    }

    public Texture getOutputTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object obj = this.bo;
            if (obj == null || !(obj instanceof Texture)) {
                return null;
            }
            return (Texture) obj;
        }
        return (Texture) invokeV.objValue;
    }

    public int getOutputWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mOutputWidth : invokeV.intValue;
    }

    public RotationType getRotationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRotationType : (RotationType) invokeV.objValue;
    }

    public ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.bq : (ScaleType) invokeV.objValue;
    }

    public int getScreenOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.bs : invokeV.intValue;
    }

    public Watermark getWatermark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.bu : (Watermark) invokeV.objValue;
    }

    public boolean isFitScreenAuto() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.br : invokeV.booleanValue;
    }

    public boolean isNeedDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.bp : invokeV.booleanValue;
    }

    public void setFitScreenAuto(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.br = z;
        }
    }

    public void setMirriorType(MirriorType mirriorType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mirriorType) == null) {
            this.bl = mirriorType;
        }
    }

    public void setNeedDetach(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.bp = z;
        }
    }

    public void setOutputFPS(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.bt = i2;
        }
    }

    public void setOutputHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mOutputHeight = i2;
        }
    }

    public void setOutputSurface(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, surfaceTexture) == null) {
            this.bo = surfaceTexture;
        }
    }

    public void setOutputSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, surface) == null) {
            this.bo = surface;
        }
    }

    public void setOutputSurface(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, surfaceHolder) == null) {
            this.bo = surfaceHolder;
        }
    }

    public void setOutputTexture(Texture texture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, texture) == null) {
            this.bo = texture;
        }
    }

    public void setOutputWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mOutputWidth = i2;
        }
    }

    public void setRotationType(RotationType rotationType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, rotationType) == null) {
            this.mRotationType = rotationType;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, scaleType) == null) {
            this.bq = scaleType;
        }
    }

    public void setScreenOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.bs = i2;
        }
    }

    public void setWatermark(Watermark watermark) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, watermark) == null) {
            this.bu = watermark;
        }
    }
}
