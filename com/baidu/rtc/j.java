package com.baidu.rtc;

import android.view.Surface;
import com.baidu.rtc.BaiduRtcRoom;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
/* loaded from: classes9.dex */
public abstract class j implements VideoSink {
    public boolean bXA = false;
    private BaiduRtcRoom.b bXB;
    protected long mUserId;

    public j(BaiduRtcRoom.b bVar, long j) {
        this.mUserId = 0L;
        this.bXB = null;
        this.mUserId = j;
        this.bXB = bVar;
    }

    public abstract void clearImage();

    public abstract Surface getSurface();

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        if (this.bXB != null) {
            this.bXB.a(l.a(videoFrame), this.mUserId);
        }
    }

    public abstract void release();

    public abstract void releaseSurface();
}
