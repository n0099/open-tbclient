package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.rtc.logreport.StuckDataCalculator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes3.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isEnableSLIDataReport;
    public boolean isVideoTrackChanged;
    public volatile boolean mExtSinkNeedRender;
    public VideoSink mExtVideoSink;
    public Runnable mOnFirstFrameEvent;
    public StuckDataCalculator stuckDataCalculator;

    /* loaded from: classes3.dex */
    public interface ExtVideoSink extends VideoSink {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ScalingType {
        public static final /* synthetic */ ScalingType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ScalingType SCALE_ASPECT_BALANCED;
        public static final ScalingType SCALE_ASPECT_FILL;
        public static final ScalingType SCALE_ASPECT_FIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(185367203, "Lcom/baidu/rtc/RTCVideoView$ScalingType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(185367203, "Lcom/baidu/rtc/RTCVideoView$ScalingType;");
                    return;
                }
            }
            SCALE_ASPECT_FIT = new ScalingType("SCALE_ASPECT_FIT", 0);
            SCALE_ASPECT_FILL = new ScalingType("SCALE_ASPECT_FILL", 1);
            ScalingType scalingType = new ScalingType("SCALE_ASPECT_BALANCED", 2);
            SCALE_ASPECT_BALANCED = scalingType;
            $VALUES = new ScalingType[]{SCALE_ASPECT_FIT, SCALE_ASPECT_FILL, scalingType};
        }

        public ScalingType(String str, int i2) {
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

        public static ScalingType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ScalingType) Enum.valueOf(ScalingType.class, str) : (ScalingType) invokeL.objValue;
        }

        public static ScalingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ScalingType[]) $VALUES.clone() : (ScalingType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RTCVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExtSinkNeedRender = false;
        this.stuckDataCalculator = new StuckDataCalculator(600);
        this.isEnableSLIDataReport = false;
        this.isVideoTrackChanged = false;
        this.mOnFirstFrameEvent = null;
        this.mExtVideoSink = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExtSinkNeedRender = false;
        this.stuckDataCalculator = new StuckDataCalculator(600);
        this.isEnableSLIDataReport = false;
        this.isVideoTrackChanged = false;
        this.mOnFirstFrameEvent = null;
        this.mExtVideoSink = null;
    }

    private void updateReportEvents(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, videoFrame) == null) && this.isVideoTrackChanged) {
            this.isVideoTrackChanged = false;
            onFirstFrameRendered();
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.stuckDataCalculator.reset();
            if (this.mExtVideoSink != null) {
                return;
            }
            super.clearImage();
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFrame) == null) {
            updateReportEvents(videoFrame);
            if (this.isEnableSLIDataReport) {
                this.stuckDataCalculator.calculateStuck();
            }
            Runnable runnable = this.mOnFirstFrameEvent;
            if (runnable != null) {
                runnable.run();
                this.mOnFirstFrameEvent = null;
            }
            if (this.mExtVideoSink != null) {
                if (!this.mExtSinkNeedRender) {
                    this.mExtVideoSink.onFrame(videoFrame);
                    return;
                }
                this.mExtVideoSink.onFrame(RTCVideoFrame.newfromVideoFrame(videoFrame));
            }
            if (onlyforVideoCallbackdata()) {
                onRTCVideoFrame(RTCVideoFrame.newfromVideoFrame(videoFrame));
            } else {
                super.onFrame(videoFrame);
            }
        }
    }

    public void onRTCVideoFrame(RTCVideoFrame rTCVideoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rTCVideoFrame) == null) {
        }
    }

    public boolean onlyforVideoCallbackdata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.mExtVideoSink == null) {
            super.setEnableHardwareScaler(z);
        }
    }

    public void setEnableSLIDataReport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isEnableSLIDataReport = z;
        }
    }

    public void setExtVideoSink(ExtVideoSink extVideoSink) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, extVideoSink) == null) {
            this.mExtVideoSink = extVideoSink;
        }
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, videoSink, z) == null) {
            this.mExtVideoSink = videoSink;
            this.mExtSinkNeedRender = z;
        }
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) {
            this.mOnFirstFrameEvent = runnable;
        }
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && this.mExtVideoSink == null) {
            super.setMirror(z);
        }
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sLIReportInterface) == null) {
            this.stuckDataCalculator.setStuckEventListener(sLIReportInterface);
        }
    }

    public void setVideoTrackChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.isVideoTrackChanged = z;
        }
    }
}
