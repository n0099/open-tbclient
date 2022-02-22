package com.baidu.rtc;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.CapturerObserver;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
/* loaded from: classes11.dex */
public abstract class RTCVideoCapture implements VideoCapturer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CapturerObserver innnerCapturerObserver;
    public RTCCapturerObserver outterCapturerObserver;

    /* loaded from: classes11.dex */
    public interface RTCCapturerObserver {
        void onCapturerStarted(boolean z);

        void onCapturerStopped();

        void onFrameCaptured(RTCVideoFrame rTCVideoFrame);
    }

    public RTCVideoCapture() {
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
        this.innnerCapturerObserver = null;
        this.outterCapturerObserver = new RTCCapturerObserver(this) { // from class: com.baidu.rtc.RTCVideoCapture.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RTCVideoCapture this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.rtc.RTCVideoCapture.RTCCapturerObserver
            public void onCapturerStarted(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    this.this$0.innnerCapturerObserver.onCapturerStarted(z);
                }
            }

            @Override // com.baidu.rtc.RTCVideoCapture.RTCCapturerObserver
            public void onCapturerStopped() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.this$0.innnerCapturerObserver.onCapturerStopped();
                }
            }

            @Override // com.baidu.rtc.RTCVideoCapture.RTCCapturerObserver
            public void onFrameCaptured(RTCVideoFrame rTCVideoFrame) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, rTCVideoFrame) == null) {
                    this.this$0.innnerCapturerObserver.onFrameCaptured(rTCVideoFrame);
                }
            }
        };
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public abstract void initialize(RTCCapturerObserver rTCCapturerObserver);

    @Override // org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, surfaceTextureHelper, context, capturerObserver) == null) {
            this.innnerCapturerObserver = capturerObserver;
            initialize(this.outterCapturerObserver);
        }
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
