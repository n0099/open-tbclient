package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes10.dex */
public abstract class j implements VideoSink {
    private BaiduRtcRoom.b cvg;
    protected long mUserId;
    public boolean cvf = false;
    private com.baidu.rtc.b.f stuckDataCalculator = new com.baidu.rtc.b.f(600);
    private boolean cve = false;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.cvg = null;
        this.mUserId = j;
        this.cvg = bVar;
    }

    public boolean aeN() {
        return this.cvf;
    }

    public void aeO() {
        this.stuckDataCalculator.reset();
    }

    public abstract void changeSurfaceSize(int i, int i2);

    public abstract void clearImage();

    public void ex(boolean z) {
        this.cvf = z;
    }

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cve) {
            this.stuckDataCalculator.afu();
        }
        if (this.cvg != null) {
            this.cvg.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public void setEnableSLIDataReport(boolean z) {
        this.cve = z;
    }

    public void setStuckEventListener(com.baidu.rtc.b.e eVar) {
        this.stuckDataCalculator.setStuckEventListener(eVar);
    }

    public abstract void setSurface(Surface surface);
}
