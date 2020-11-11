package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public abstract class j implements VideoSink {
    public boolean clO = false;
    private BaiduRtcRoom.b clP;
    protected long mUserId;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.clP = null;
        this.mUserId = j;
        this.clP = bVar;
    }

    public boolean adR() {
        return this.clO;
    }

    public abstract void changeSurfaceSize(int i, int i2);

    public abstract void clearImage();

    public void dY(boolean z) {
        this.clO = z;
    }

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.clP != null) {
            this.clP.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public abstract void setSurface(Surface surface);
}
