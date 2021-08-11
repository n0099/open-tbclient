package com.baidu.ar.arplay.core.pixel;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.renderer.ARPRenderer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class FramePixels {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCameraFrame;
    public int mDegree;
    public PixelReadParams.FrameType mFrameType;
    public boolean mFrontCamera;
    public int mHeight;
    public Orientation mOrientation;
    public int mPixelLength;
    public PixelType mPixelType;
    public ByteBuffer mPixelsAddress;
    public int mTextureID;
    public long mTimestamp;
    public int mWidth;

    /* renamed from: com.baidu.ar.arplay.core.pixel.FramePixels$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-809612941, "Lcom/baidu/ar/arplay/core/pixel/FramePixels$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-809612941, "Lcom/baidu/ar/arplay/core/pixel/FramePixels$1;");
                    return;
                }
            }
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation = iArr;
            try {
                iArr[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.PORTRAIT_REVERSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE_REVERSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FramePixels(PixelType pixelType, ByteBuffer byteBuffer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pixelType, byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCameraFrame = false;
        this.mFrontCamera = false;
        this.mDegree = 90;
        this.mPixelLength = 0;
        this.mTextureID = -1;
        this.mFrameType = PixelReadParams.FrameType.STREAM_FRAME;
        this.mPixelType = pixelType;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mPixelsAddress = byteBuffer;
    }

    public int getDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDegree : invokeV.intValue;
    }

    public PixelReadParams.FrameType getFrameType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFrameType : (PixelReadParams.FrameType) invokeV.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mHeight : invokeV.intValue;
    }

    public Orientation getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOrientation : (Orientation) invokeV.objValue;
    }

    public byte[] getPixelData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.mPixelLength;
            byte[] bArr = new byte[i2];
            ARPRenderer.copyNativeBytebuffer(this.mPixelsAddress, bArr, 0, i2);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public int getPixelLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPixelLength : invokeV.intValue;
    }

    public PixelType getPixelType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPixelType : (PixelType) invokeV.objValue;
    }

    public ByteBuffer getPixelsAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPixelsAddress : (ByteBuffer) invokeV.objValue;
    }

    public PixelRotation getSegOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            PixelRotation pixelRotation = PixelRotation.NoRotation;
            int i2 = AnonymousClass1.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[this.mOrientation.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return isFrontCamera() ? PixelRotation.FlipVertical : PixelRotation.Rotate180;
                } else if (i2 == 3) {
                    return isFrontCamera() ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft;
                } else if (i2 == 4) {
                    return isFrontCamera() ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
                }
            } else if (isFrontCamera()) {
                return PixelRotation.FlipHorizontal;
            }
            return PixelRotation.NoRotation;
        }
        return (PixelRotation) invokeV.objValue;
    }

    public int getTextureID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTextureID : invokeV.intValue;
    }

    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mTimestamp : invokeV.longValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mWidth : invokeV.intValue;
    }

    public boolean isCameraFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mCameraFrame : invokeV.booleanValue;
    }

    public boolean isFrontCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mFrontCamera : invokeV.booleanValue;
    }

    public void setCameraFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mCameraFrame = z;
        }
    }

    public void setDegree(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mDegree = i2;
        }
    }

    public void setFrameType(PixelReadParams.FrameType frameType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, frameType) == null) {
            this.mFrameType = frameType;
        }
    }

    public void setFrontCamera(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mFrontCamera = z;
        }
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mHeight = i2;
        }
    }

    public void setOrientation(Orientation orientation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, orientation) == null) {
            this.mOrientation = orientation;
        }
    }

    public void setPixelLength(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mPixelLength = i2;
        }
    }

    public void setPixelType(PixelType pixelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, pixelType) == null) {
            this.mPixelType = pixelType;
        }
    }

    public void setPixelsAddress(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, byteBuffer) == null) {
            this.mPixelsAddress = byteBuffer;
        }
    }

    public void setTextureID(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mTextureID = i2;
        }
    }

    public void setTimestamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            this.mTimestamp = j2;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mWidth = i2;
        }
    }
}
