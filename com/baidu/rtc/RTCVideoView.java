package com.baidu.rtc;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.rtc.logreport.SLIReportInterface;
import com.baidu.rtc.logreport.StuckDataCalculator;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes2.dex */
public class RTCVideoView extends SurfaceViewRenderer {
    public boolean isEnableSLIDataReport;
    public volatile boolean mExtSinkNeedRender;
    public VideoSink mExtVideoSink;
    public Runnable mOnFirstFrameEvent;
    public StuckDataCalculator stuckDataCalculator;

    /* loaded from: classes2.dex */
    public interface ExtVideoSink extends VideoSink {
    }

    public RTCVideoView(Context context) {
        super(context);
        this.mExtSinkNeedRender = false;
        this.stuckDataCalculator = new StuckDataCalculator(600);
        this.isEnableSLIDataReport = false;
        this.mOnFirstFrameEvent = null;
        this.mExtVideoSink = null;
    }

    public RTCVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mExtSinkNeedRender = false;
        this.stuckDataCalculator = new StuckDataCalculator(600);
        this.isEnableSLIDataReport = false;
        this.mOnFirstFrameEvent = null;
        this.mExtVideoSink = null;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void clearImage() {
        this.stuckDataCalculator.reset();
        if (this.mExtVideoSink != null) {
            return;
        }
        super.clearImage();
    }

    @Override // org.webrtc.SurfaceViewRenderer, org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
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

    public void onRTCVideoFrame(RTCVideoFrame rTCVideoFrame) {
    }

    public boolean onlyforVideoCallbackdata() {
        return false;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setEnableHardwareScaler(boolean z) {
        if (this.mExtVideoSink != null) {
            return;
        }
        super.setEnableHardwareScaler(z);
    }

    public void setEnableSLIDataReport(boolean z) {
        this.isEnableSLIDataReport = z;
    }

    public void setExtVideoSink(ExtVideoSink extVideoSink) {
        this.mExtVideoSink = extVideoSink;
    }

    public void setExtVideoSink(VideoSink videoSink, boolean z) {
        this.mExtVideoSink = videoSink;
        this.mExtSinkNeedRender = z;
    }

    public void setFirstFrameEventListener(Runnable runnable) {
        this.mOnFirstFrameEvent = runnable;
    }

    @Override // org.webrtc.SurfaceViewRenderer
    public void setMirror(boolean z) {
        if (this.mExtVideoSink != null) {
            return;
        }
        super.setMirror(z);
    }

    public void setStuckEventListener(SLIReportInterface sLIReportInterface) {
        this.stuckDataCalculator.setStuckEventListener(sLIReportInterface);
    }
}
