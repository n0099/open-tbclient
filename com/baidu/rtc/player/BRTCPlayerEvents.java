package com.baidu.rtc.player;

import com.baidu.rtc.player.BRTCPlayer;
import java.math.BigInteger;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public interface BRTCPlayerEvents {
    public static final int BRTC_PLAYER_ERROR_CONNECTION = 10003;
    public static final int BRTC_PLAYER_ERROR_ICE_CHANNEL = 10001;
    public static final int BRTC_PLAYER_ERROR_ICE_DISCONNECTED = 10002;
    public static final int BRTC_PLAYER_ERROR_INVALID_STATE = 10008;
    public static final int BRTC_PLAYER_ERROR_INVALID_URL = 10000;
    public static final int BRTC_PLAYER_ERROR_LOAD_LIBRARIES = 10010;
    public static final int BRTC_PLAYER_ERROR_LOCAL_SDP_REQUEST = 10004;
    public static final int BRTC_PLAYER_ERROR_LOCAL_SDP_SET = 10005;
    public static final int BRTC_PLAYER_ERROR_REMOTE_SDP_REQUEST = 10006;
    public static final int BRTC_PLAYER_ERROR_REMOTE_SDP_SET = 10007;
    public static final int BRTC_PLAYER_ERROR_STREAMING_INTERRUPT = 10009;
    public static final int BRTC_PLAYER_EVENT_ICE_CONNECTED = 1001;
    public static final int BRTC_PLAYER_EVENT_PEER_CONNECTION_CLOSED = 1002;
    public static final int BRTC_PLAYER_EVENT_REMOTE_RENDER = 1000;
    public static final int BRTC_PLAYER_EVENT_STREAMING_INFO_UPDATED = 1003;

    void onError(int i2, String str);

    void onFirstFrameRendered();

    void onInfoUpdated(int i2, String str);

    void onPlayerStateChanged(BRTCPlayer.PlayerState playerState);

    void onRemoteData(ByteBuffer byteBuffer);

    void onRemoteStreamStats(Boolean bool, Boolean bool2, BigInteger bigInteger);

    void onResolutionChanged(int i2, int i3);

    void onSEIRecv(ByteBuffer byteBuffer);
}
