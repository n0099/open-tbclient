package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.rtc.logreport.StuckDataCalculator;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes2.dex */
public abstract class RTCVideoExternalRender implements VideoSink {
    public static final String TAG = "RTCVideoExternalRender";
    public long mUserId;
    public BaiduRtcRoom.BaiduRtcRoomVideoObserver mVideoObserver;
    public boolean mIsRenderInited = false;
    public StuckDataCalculator stuckDataCalculator = new StuckDataCalculator(600);
    public boolean isEnableSLIDataReport = false;

    public RTCVideoExternalRender(BaiduRtcRoom.BaiduRtcRoomVideoObserver baiduRtcRoomVideoObserver, long j) {
        this.mUserId = 0L;
        this.mVideoObserver = null;
        this.mUserId = j;
        this.mVideoObserver = baiduRtcRoomVideoObserver;
    }

    public abstract void changeSurfaceSize(int i, int i2);

    public abstract void clearImage();

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    public boolean isRenderInited() {
        return this.mIsRenderInited;
    }

    public void leaving() {
        this.stuckDataCalculator.reset();
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.isEnableSLIDataReport) {
            this.stuckDataCalculator.calculateStuck();
        }
        BaiduRtcRoom.BaiduRtcRoomVideoObserver baiduRtcRoomVideoObserver = this.mVideoObserver;
        if (baiduRtcRoomVideoObserver != null) {
            baiduRtcRoomVideoObserver.onVideoFrame(RTCVideoFrame.newfromVideoFrame(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public void setEnableSLIDataReport(boolean z) {
        this.isEnableSLIDataReport = z;
    }

    public void setRenderInited(boolean z) {
        this.mIsRenderInited = z;
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        this.stuckDataCalculator.setStuckEventListener(sLIReportInterface);
    }

    public abstract void setSurface(Surface surface);
}
