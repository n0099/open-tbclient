package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes10.dex */
public abstract class j implements VideoSink {
    public boolean cxW = false;
    private BaiduRtcRoom.b cxX;
    protected long mUserId;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.cxX = null;
        this.mUserId = j;
        this.cxX = bVar;
    }

    public boolean aip() {
        return this.cxW;
    }

    public abstract void changeSurfaceSize(int i, int i2);

    public abstract void clearImage();

    public void ez(boolean z) {
        this.cxW = z;
    }

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cxX != null) {
            this.cxX.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public abstract void setSurface(Surface surface);
}
