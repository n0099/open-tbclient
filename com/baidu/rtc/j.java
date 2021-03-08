package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public abstract class j implements VideoSink {
    private BaiduRtcRoom.b cwG;
    protected long mUserId;
    public boolean cwF = false;
    private com.baidu.rtc.b.f stuckDataCalculator = new com.baidu.rtc.b.f(600);
    private boolean cwE = false;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.cwG = null;
        this.mUserId = j;
        this.cwG = bVar;
    }

    public boolean aeQ() {
        return this.cwF;
    }

    public void aeR() {
        this.stuckDataCalculator.reset();
    }

    public abstract void changeSurfaceSize(int i, int i2);

    public abstract void clearImage();

    public void ex(boolean z) {
        this.cwF = z;
    }

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cwE) {
            this.stuckDataCalculator.afx();
        }
        if (this.cwG != null) {
            this.cwG.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public void setEnableSLIDataReport(boolean z) {
        this.cwE = z;
    }

    public void setStuckEventListener(com.baidu.rtc.b.e eVar) {
        this.stuckDataCalculator.setStuckEventListener(eVar);
    }

    public abstract void setSurface(Surface surface);
}
