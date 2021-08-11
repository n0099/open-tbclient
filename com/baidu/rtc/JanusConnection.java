package com.baidu.rtc;

import com.baidu.rtc.PeerConnectionClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import org.webrtc.AudioTrack;
import org.webrtc.PeerConnection;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoTrack;
/* loaded from: classes5.dex */
public class JanusConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioTrack audioTrack;
    public PeerConnectionClient.PeerConnectionParameters connectionParam;
    public BigInteger handleId;
    public PeerConnection peerConnection;
    public PeerConnectionClient.SDPObserver sdpObserver;
    public boolean type;
    public SurfaceViewRenderer videoRender;
    public VideoTrack videoTrack;
    public int videoview_tag;

    public JanusConnection() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
