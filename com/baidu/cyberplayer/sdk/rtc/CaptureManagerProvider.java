package com.baidu.cyberplayer.sdk.rtc;

import android.view.Surface;
import com.baidu.cyberplayer.sdk.rtc.CyberCaptureManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class CaptureManagerProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CaptureManagerProvider() {
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

    public abstract void destroySurface();

    public abstract void doAutoFocus();

    public abstract void doFocus(int i, int i2, int i3, int i4);

    public abstract void enableZoom(boolean z);

    public abstract boolean isFrontCamera();

    public abstract void muteCamera(boolean z);

    public abstract void pause();

    public abstract void release();

    public abstract void resume();

    public abstract void setBeautyBlure(float f);

    public abstract void setBeautyWhite(float f);

    public abstract void setCameraFace(boolean z);

    public abstract void setCaptureReadyCallback(CyberCaptureManager.OnCaptureReadyCallback onCaptureReadyCallback);

    public abstract void setCheekThin(float f);

    public abstract void setEnlargeEye(float f);

    public abstract void setFlip(boolean z);

    public abstract void setRtcExternalCapture(RTCRoomProvider rTCRoomProvider);

    public abstract void setRtcRemoteFlip(boolean z);

    public abstract void setSurface(Surface surface);

    public abstract void setSurfaceSize(int i, int i2);

    public abstract void switchCamera();

    public abstract void zoom(int i);
}
