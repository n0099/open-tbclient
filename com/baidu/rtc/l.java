package com.baidu.rtc;

import org.webrtc.VideoFrame;
/* loaded from: classes12.dex */
public class l extends VideoFrame {
    public l(VideoFrame.Buffer buffer, int i, long j) {
        super(buffer, i, j);
    }

    public static l a(VideoFrame videoFrame) {
        return new l(videoFrame.getBuffer(), videoFrame.getRotation(), videoFrame.getTimestampNs());
    }
}
