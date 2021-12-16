package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.rtc.logreport.StuckDataCalculator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes10.dex */
public abstract class RTCVideoExternalRender implements VideoSink {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RTCVideoExternalRender";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isEnableSLIDataReport;
    public boolean mIsRenderInited;
    public long mUserId;
    public BaiduRtcRoom.BaiduRtcRoomVideoObserver mVideoObserver;
    public StuckDataCalculator stuckDataCalculator;

    public RTCVideoExternalRender(BaiduRtcRoom.BaiduRtcRoomVideoObserver baiduRtcRoomVideoObserver, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduRtcRoomVideoObserver, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUserId = 0L;
        this.mVideoObserver = null;
        this.mIsRenderInited = false;
        this.stuckDataCalculator = new StuckDataCalculator(600);
        this.isEnableSLIDataReport = false;
        this.mUserId = j2;
        this.mVideoObserver = baiduRtcRoomVideoObserver;
    }

    public abstract void changeSurfaceSize(int i2, int i3);

    public abstract void clearImage();

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    public boolean isRenderInited() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIsRenderInited : invokeV.booleanValue;
    }

    public void leaving() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.stuckDataCalculator.reset();
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, videoFrame) == null) {
            if (this.isEnableSLIDataReport) {
                this.stuckDataCalculator.calculateStuck();
            }
            BaiduRtcRoom.BaiduRtcRoomVideoObserver baiduRtcRoomVideoObserver = this.mVideoObserver;
            if (baiduRtcRoomVideoObserver != null) {
                baiduRtcRoomVideoObserver.onVideoFrame(RTCVideoFrame.newfromVideoFrame(videoFrame), this.mUserId);
            }
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public void setEnableSLIDataReport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.isEnableSLIDataReport = z;
        }
    }

    public void setRenderInited(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mIsRenderInited = z;
        }
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sLIReportInterface) == null) {
            this.stuckDataCalculator.setStuckEventListener(sLIReportInterface);
        }
    }

    public abstract void setSurface(Surface surface);
}
