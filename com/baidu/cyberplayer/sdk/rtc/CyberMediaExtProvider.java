package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes4.dex */
public abstract class CyberMediaExtProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CyberMediaExtProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract CaptureManagerProvider createCaptureManagerProvider(Context context, int i2, int i3, int i4, int i5, int i6);

    public abstract RTCVideoViewProvider createRTCVideoView(Context context, AttributeSet attributeSet);

    public abstract RTCRoomProvider createRtcRoom();

    public abstract void enableRTCCaptureDebug(boolean z);

    public abstract void setRTCVerbose(boolean z);
}
