package com.baidu.ar.arplay.core.pixel;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.renderer.ARPRenderer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PixelReadParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_CACHE_SIZE = 3;
    public static final String DEFAULT_FILTER_ID = "camera";
    public static final int DEFAULT_ROTATE_DEGREE = 0;
    public static final ScaleType DEFAULT_SCALE_TYPE;
    public static final String TERMINAL_FILTER_ID = "target";
    public transient /* synthetic */ FieldHolder $fh;
    public int mCacheSize;
    public FrameType mFrameType;
    public boolean mIsPortrait;
    public int mOutputHeight;
    public int mOutputWidth;
    public PixelRotation mPixelRotation;
    public PixelType mPixelType;
    public String mPreFilterID;
    public Rect mReadRect;
    public ScaleType mScaleType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class FrameType {
        public static final /* synthetic */ FrameType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FrameType SINGLE_FRAME;
        public static final FrameType STREAM_FRAME;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1182154411, "Lcom/baidu/ar/arplay/core/pixel/PixelReadParams$FrameType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1182154411, "Lcom/baidu/ar/arplay/core/pixel/PixelReadParams$FrameType;");
                    return;
                }
            }
            STREAM_FRAME = new FrameType("STREAM_FRAME", 0, 0);
            FrameType frameType = new FrameType("SINGLE_FRAME", 1, 1);
            SINGLE_FRAME = frameType;
            $VALUES = new FrameType[]{STREAM_FRAME, frameType};
        }

        public FrameType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static FrameType valueOf(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != STREAM_FRAME.getValue() && i2 == SINGLE_FRAME.getValue()) {
                    return SINGLE_FRAME;
                }
                return STREAM_FRAME;
            }
            return (FrameType) invokeI.objValue;
        }

        public static FrameType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (FrameType) Enum.valueOf(FrameType.class, str) : (FrameType) invokeL.objValue;
        }

        public static FrameType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (FrameType[]) $VALUES.clone() : (FrameType[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class ScaleType {
        public static final /* synthetic */ ScaleType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType CENTER_CROP;
        public static final ScaleType EQUAL_SCALE;
        public static final ScaleType FIT_CENTER;
        public static final ScaleType FIT_XY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1012646808, "Lcom/baidu/ar/arplay/core/pixel/PixelReadParams$ScaleType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1012646808, "Lcom/baidu/ar/arplay/core/pixel/PixelReadParams$ScaleType;");
                    return;
                }
            }
            FIT_XY = new ScaleType("FIT_XY", 0);
            FIT_CENTER = new ScaleType("FIT_CENTER", 1);
            CENTER_CROP = new ScaleType("CENTER_CROP", 2);
            ScaleType scaleType = new ScaleType("EQUAL_SCALE", 3);
            EQUAL_SCALE = scaleType;
            $VALUES = new ScaleType[]{FIT_XY, FIT_CENTER, CENTER_CROP, scaleType};
        }

        public ScaleType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ScaleType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScaleType) Enum.valueOf(ScaleType.class, str) : (ScaleType) invokeL.objValue;
        }

        public static ScaleType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScaleType[]) $VALUES.clone() : (ScaleType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1209442232, "Lcom/baidu/ar/arplay/core/pixel/PixelReadParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1209442232, "Lcom/baidu/ar/arplay/core/pixel/PixelReadParams;");
                return;
            }
        }
        DEFAULT_SCALE_TYPE = ScaleType.FIT_XY;
    }

    public PixelReadParams(PixelType pixelType) {
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
        this.mPixelRotation = PixelRotation.NoRotation;
        this.mCacheSize = 3;
        this.mIsPortrait = false;
        this.mPreFilterID = "";
        this.mFrameType = FrameType.STREAM_FRAME;
        this.mPixelType = pixelType;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PixelReadParams.class == obj.getClass()) {
                PixelReadParams pixelReadParams = (PixelReadParams) obj;
                if (this.mPixelType == pixelReadParams.mPixelType && this.mOutputWidth == pixelReadParams.mOutputWidth && this.mOutputHeight == pixelReadParams.mOutputHeight && this.mPixelRotation == pixelReadParams.mPixelRotation && this.mScaleType == pixelReadParams.mScaleType && ((this.mReadRect == null && pixelReadParams.mReadRect == null) || ((rect = this.mReadRect) != null && rect.equals(pixelReadParams.mReadRect)))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getAlgoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ARPRenderer.needRotate(this.mPixelRotation.getValue()) ? this.mOutputWidth : this.mOutputHeight : invokeV.intValue;
    }

    public int getAlgoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ARPRenderer.needRotate(this.mPixelRotation.getValue()) ? this.mOutputHeight : this.mOutputWidth : invokeV.intValue;
    }

    public int getCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCacheSize : invokeV.intValue;
    }

    public FrameType getFrameType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFrameType : (FrameType) invokeV.objValue;
    }

    public boolean getIsPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIsPortrait : invokeV.booleanValue;
    }

    public int getOutputHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOutputHeight : invokeV.intValue;
    }

    public int getOutputWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mOutputWidth : invokeV.intValue;
    }

    public PixelRotation getPixelRotate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPixelRotation : (PixelRotation) invokeV.objValue;
    }

    public PixelType getPixelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPixelType : (PixelType) invokeV.objValue;
    }

    public String getPreFilterID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mPreFilterID : (String) invokeV.objValue;
    }

    public Rect getReadRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mReadRect : (Rect) invokeV.objValue;
    }

    public ScaleType getScaleType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mScaleType : (ScaleType) invokeV.objValue;
    }

    public void setCacheSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mCacheSize = i2;
        }
    }

    public void setFrameType(FrameType frameType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameType) == null) {
            this.mFrameType = frameType;
        }
    }

    public void setIsPortrait(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsPortrait = z;
        }
    }

    public void setOutputHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mOutputHeight = i2;
        }
    }

    public void setOutputWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mOutputWidth = i2;
        }
    }

    public void setPixelRotate(PixelRotation pixelRotation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, pixelRotation) == null) {
            this.mPixelRotation = pixelRotation;
        }
    }

    public void setPixelType(PixelType pixelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pixelType) == null) {
            this.mPixelType = pixelType;
        }
    }

    public void setPreFilterID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mPreFilterID = str;
        }
    }

    public void setReadRect(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rect) == null) {
            this.mReadRect = rect;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, scaleType) == null) {
            this.mScaleType = scaleType;
        }
    }
}
