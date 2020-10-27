package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public abstract class j implements VideoSink {
    public boolean cfZ = false;
    private BaiduRtcRoom.b cga;
    protected long mUserId;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.cga = null;
        this.mUserId = j;
        this.cga = bVar;
    }

    public abstract void clearImage();

    public abstract Surface getSurface();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.cga != null) {
            this.cga.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();
}
