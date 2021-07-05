package com.baidu.rtc;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.RTCVideoCapture;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class myOuterRTCVideoCapture extends RTCVideoCapture {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RTCVideoCapture.RTCCapturerObserver capturerObserver;
    public final int frameHeight;
    public final int frameWidth;
    public final TimerTask tickTask;
    public final Timer timer;

    public myOuterRTCVideoCapture() {
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
        this.capturerObserver = null;
        this.frameWidth = 480;
        this.frameHeight = 640;
        this.timer = new Timer();
        this.tickTask = new TimerTask(this) { // from class: com.baidu.rtc.myOuterRTCVideoCapture.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ myOuterRTCVideoCapture this$0;

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

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.tick();
                }
            }
        };
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
        }
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public RTCVideoFrame getNextFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
            RTCI420Buffer allocate = RTCI420Buffer.allocate(480, 640);
            allocate.getDataY();
            allocate.getDataU();
            allocate.getDataV();
            allocate.getStrideY();
            allocate.getStrideU();
            allocate.getStrideV();
            return new RTCVideoFrame(allocate, 0, nanos);
        }
        return (RTCVideoFrame) invokeV.objValue;
    }

    @Override // com.baidu.rtc.RTCVideoCapture
    public void initialize(RTCVideoCapture.RTCCapturerObserver rTCCapturerObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rTCCapturerObserver) == null) {
            this.capturerObserver = rTCCapturerObserver;
        }
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public boolean isScreencast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public void startCapture(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            Log.e("selfVideoCapture", "startCapture.");
            this.timer.schedule(this.tickTask, 0L, 66L);
        }
    }

    @Override // com.baidu.rtc.RTCVideoCapture, org.webrtc.VideoCapturer
    public void stopCapture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.timer.cancel();
        }
    }

    public void tick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            RTCVideoFrame nextFrame = getNextFrame();
            this.capturerObserver.onFrameCaptured(nextFrame);
            nextFrame.release();
        }
    }
}
