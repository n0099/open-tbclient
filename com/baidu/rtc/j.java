package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes16.dex */
public abstract class j implements VideoSink {
    public boolean cke = false;
    private BaiduRtcRoom.b ckf;
    protected long mUserId;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.ckf = null;
        this.mUserId = j;
        this.ckf = bVar;
    }

    public boolean adj() {
        return this.cke;
    }

    public abstract void changeSurfaceSize(int i, int i2);

    public abstract void clearImage();

    public void ea(boolean z) {
        this.cke = z;
    }

    public abstract Surface getSurface();

    public abstract boolean hasSurface();

    public abstract void init();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.ckf != null) {
            this.ckf.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();

    public abstract void setSurface(Surface surface);
}
