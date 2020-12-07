package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes12.dex */
public abstract class j implements VideoSink {
    public boolean cqR = false;
    private BaiduRtcRoom.b cqS;
    protected long mUserId;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.cqS = null;
        this.mUserId = j;
        this.cqS = bVar;
    }

    public boolean ags() {
        return this.cqR;
    }

    public abstract void changeSurfaceSize(int i, int i2);

    public abstract void clearImage();

    public void eq(boolean z) {
        this.cqR = z;
    }

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cqS != null) {
            this.cqS.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public abstract void setSurface(Surface surface);
}
