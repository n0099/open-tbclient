package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public abstract class j implements VideoSink {
    public boolean ctf = false;
    private BaiduRtcRoom.b ctg;
    protected long mUserId;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.ctg = null;
        this.mUserId = j;
        this.ctg = bVar;
    }

    public boolean aev() {
        return this.ctf;
    }

    public abstract void changeSurfaceSize(int i, int i2);

    public abstract void clearImage();

    public void ev(boolean z) {
        this.ctf = z;
    }

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.ctg != null) {
            this.ctg.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public abstract void setSurface(Surface surface);
}
