package com.baidu.rtc.player;

import com.baidu.rtc.player.BRTCPlayer;
import java.math.BigInteger;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public interface BRTCPlayerEvents {
    public static final int BRTC_PLAYER_ERROR_CONNECTION = 10003;
    public static final int BRTC_PLAYER_ERROR_ICE_CHANNEL = 10001;
    public static final int BRTC_PLAYER_ERROR_INVALID_STATE = 10008;
    public static final int BRTC_PLAYER_ERROR_INVALID_URL = 10000;
    public static final int BRTC_PLAYER_ERROR_LOAD_LIBRARIES = 10010;
    public static final int BRTC_PLAYER_ERROR_LOCAL_SDP_REQUEST = 10004;
    public static final int BRTC_PLAYER_ERROR_LOCAL_SDP_SET = 10005;
    public static final int BRTC_PLAYER_ERROR_REMOTE_SDP_REQUEST = 10006;
    public static final int BRTC_PLAYER_ERROR_REMOTE_SDP_SET = 10007;
    public static final int BRTC_PLAYER_ERROR_RESERVED = 10002;
    public static final int BRTC_PLAYER_ERROR_STREAMING_INTERRUPT = 10009;
    public static final int BRTC_PLAYER_EVENT_BUFFERING_END = 1005;
    public static final int BRTC_PLAYER_EVENT_BUFFERING_START = 1004;
    public static final int BRTC_PLAYER_EVENT_ICE_CONNECTED = 1001;
    public static final int BRTC_PLAYER_EVENT_ICE_DISCONNECTED = 1006;
    public static final int BRTC_PLAYER_EVENT_LOCAL_SDP_SET = 1009;
    public static final int BRTC_PLAYER_EVENT_NO_STREAMING_DETECTED = 1007;
    public static final int BRTC_PLAYER_EVENT_PEER_CONNECTION_CLOSED = 1002;
    public static final int BRTC_PLAYER_EVENT_PLAY_TIME_STATISTIC = 1008;
    public static final int BRTC_PLAYER_EVENT_REMOTE_RENDER = 1000;
    public static final int BRTC_PLAYER_EVENT_REMOTE_SDP_ACQUIRED = 1010;
    public static final int BRTC_PLAYER_EVENT_STATS_UPDATED = 1003;

    void onError(int i2, String str);

    void onFirstFrameRendered();

    void onInfoUpdated(int i2, Object obj);

    void onPlayerStateChanged(BRTCPlayer.PlayerState playerState);

    void onRemoteData(ByteBuffer byteBuffer);

    void onRemoteStreamStats(boolean z, boolean z2, BigInteger bigInteger);

    void onResolutionChanged(int i2, int i3);

    void onSEIRecv(ByteBuffer byteBuffer);
}
