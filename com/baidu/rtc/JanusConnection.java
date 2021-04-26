package com.baidu.rtc;

import com.baidu.rtc.PeerConnectionClient;
import java.math.BigInteger;
import org.webrtc.AudioTrack;
import org.webrtc.PeerConnection;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoTrack;
/* loaded from: classes2.dex */
public class JanusConnection {
    public AudioTrack audioTrack;
    public PeerConnectionClient.PeerConnectionParameters connectionParam;
    public BigInteger handleId;
    public PeerConnection peerConnection;
    public PeerConnectionClient.SDPObserver sdpObserver;
    public boolean type;
    public SurfaceViewRenderer videoRender;
    public VideoTrack videoTrack;
    public int videoview_tag;
}
