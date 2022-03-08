package com.baidu.ar.arplay.core.pixel;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ReadParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_CACHE_SIZE = 3;
    public static final MirrorType DEFAULT_MIRROR_TYPE;
    public static final int DEFAULT_ROTATE_DEGREE = 0;
    public static final PixelReadParams.ScaleType DEFAULT_SCALE_TYPE;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCacheSize;
    public MirrorType mMirrorType;
    public PixelType mPixelType;
    public Rect mReadRect;
    public int mRotateDegree;
    public PixelReadParams.ScaleType mScaleType;
    public FrameSize mTargetFrameSize;
    public boolean mUsePBO;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(280383616, "Lcom/baidu/ar/arplay/core/pixel/ReadParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(280383616, "Lcom/baidu/ar/arplay/core/pixel/ReadParams;");
                return;
            }
        }
        DEFAULT_SCALE_TYPE = PixelReadParams.ScaleType.FIT_XY;
        DEFAULT_MIRROR_TYPE = MirrorType.NO_MIRROR;
    }

    public ReadParams(PixelType pixelType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pixelType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mScaleType = DEFAULT_SCALE_TYPE;
        this.mMirrorType = DEFAULT_MIRROR_TYPE;
        this.mRotateDegree = 0;
        this.mUsePBO = true;
        this.mCacheSize = 3;
        this.mPixelType = pixelType;
    }

    public int getCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCacheSize : invokeV.intValue;
    }

    public MirrorType getMirrorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMirrorType : (MirrorType) invokeV.objValue;
    }

    public PixelType getPixelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPixelType : (PixelType) invokeV.objValue;
    }

    public Rect getReadRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mReadRect : (Rect) invokeV.objValue;
    }

    public int getRotateDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRotateDegree : invokeV.intValue;
    }

    public PixelReadParams.ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mScaleType : (PixelReadParams.ScaleType) invokeV.objValue;
    }

    public FrameSize getTargetFrameSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mTargetFrameSize : (FrameSize) invokeV.objValue;
    }

    public boolean isUsePBO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mUsePBO : invokeV.booleanValue;
    }

    public void setCacheSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mCacheSize = i2;
        }
    }

    public void setMirrorType(MirrorType mirrorType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mirrorType) == null) {
            this.mMirrorType = mirrorType;
        }
    }

    public void setPixelType(PixelType pixelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pixelType) == null) {
            this.mPixelType = pixelType;
        }
    }

    public void setReadRect(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            this.mReadRect = rect;
        }
    }

    public void setRotateDegree(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mRotateDegree = i2;
        }
    }

    public void setScaleType(PixelReadParams.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, scaleType) == null) {
            this.mScaleType = scaleType;
        }
    }

    public void setTargetFrameSize(FrameSize frameSize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameSize) == null) {
            this.mTargetFrameSize = frameSize;
        }
    }

    public void setUsePBO(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mUsePBO = z;
        }
    }
}
