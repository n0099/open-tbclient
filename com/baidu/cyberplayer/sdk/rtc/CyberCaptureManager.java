package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes2.dex */
public class CyberCaptureManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CaptureManagerProvider f5020a;

    @Keep
    /* loaded from: classes2.dex */
    public interface OnCaptureReadyCallback {
        void onVideoCaptureReady(boolean z);
    }

    public CyberCaptureManager(Context context, int i2, int i3, int i4, int i5, int i6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5020a = a.a().a(context, i2, i3, i4, i5, i6, z);
    }

    public static void enableDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            d.b(z);
        }
    }

    public void destroySurface() {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.destroySurface();
    }

    public void doAutoFocus() {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.doAutoFocus();
    }

    public void doFocus(int i2, int i3, int i4, int i5) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.doFocus(i2, i3, i4, i5);
    }

    public void enableZoom(boolean z) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.enableZoom(z);
    }

    public boolean isFrontCamera() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CaptureManagerProvider captureManagerProvider = this.f5020a;
            if (captureManagerProvider != null) {
                return captureManagerProvider.isFrontCamera();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void muteCamera(boolean z) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.muteCamera(z);
    }

    public void pause() {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.pause();
    }

    public void release() {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.release();
    }

    public void resume() {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.resume();
    }

    public void setBeautyBlure(float f2) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048585, this, f2) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setBeautyBlure(f2);
    }

    public void setBeautyWhite(float f2) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048586, this, f2) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setBeautyWhite(f2);
    }

    public void setCameraFace(boolean z) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setCameraFace(z);
    }

    public void setCaptureReadyCallback(OnCaptureReadyCallback onCaptureReadyCallback) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, onCaptureReadyCallback) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setCaptureReadyCallback(onCaptureReadyCallback);
    }

    public void setCheekThin(float f2) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f2) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setCheekThin(f2);
    }

    public void setEnlargeEye(float f2) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048590, this, f2) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setEnlargeEye(f2);
    }

    public void setFlip(boolean z) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setFlip(z);
    }

    public void setRtcExternalCapture(CyberRTCRoom cyberRTCRoom) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, cyberRTCRoom) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setRtcExternalCapture(cyberRTCRoom.getProvider());
    }

    public void setRtcRemoteFlip(boolean z) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setRtcRemoteFlip(z);
    }

    public void setSurface(Surface surface) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, surface) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setSurface(surface);
    }

    public void setSurfaceSize(int i2, int i3) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.setSurfaceSize(i2, i3);
    }

    public void switchCamera() {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.switchCamera();
    }

    public void zoom(int i2) {
        CaptureManagerProvider captureManagerProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (captureManagerProvider = this.f5020a) == null) {
            return;
        }
        captureManagerProvider.zoom(i2);
    }
}
