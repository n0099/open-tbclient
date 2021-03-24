package com.baidu.rtc;

import org.webrtc.VideoFrame;
/* loaded from: classes2.dex */
public class RTCVideoFrame extends VideoFrame {
    public RTCVideoFrame(VideoFrame.Buffer buffer, int i, long j) {
        super(buffer, i, j);
    }

    public static RTCVideoFrame newfromVideoFrame(VideoFrame videoFrame) {
        return new RTCVideoFrame(videoFrame.getBuffer(), videoFrame.getRotation(), videoFrame.getTimestampNs());
    }
}
