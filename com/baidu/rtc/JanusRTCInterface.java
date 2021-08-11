package com.baidu.rtc;

import com.baidu.rtc.BaiduRtcRoom;
import java.math.BigInteger;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface JanusRTCInterface {
    void onAttribute(BigInteger bigInteger, String str);

    void onComing(BigInteger bigInteger, String str);

    void onConnectError();

    void onCreatedHandle(BigInteger bigInteger, long j2);

    void onHangUp(BigInteger bigInteger);

    void onLeaving(BigInteger bigInteger, BigInteger bigInteger2);

    void onLivePublishFailed(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str);

    void onLivePublishInterrupted(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str);

    void onLivePublishSucceed(BaiduRtcRoom.RtcLiveTransferMode rtcLiveTransferMode, String str);

    void onLoginError();

    void onLoginTimeout();

    void onMediaStreamingEvent(BigInteger bigInteger, int i2, boolean z);

    void onMessage(BigInteger bigInteger, String str);

    void onPublisherJoined(BigInteger bigInteger);

    void onPublisherRemoteJsep(BigInteger bigInteger, JSONObject jSONObject);

    void onRemoteGone(BigInteger bigInteger);

    void onRoomDisbanded();

    void onServerAckTimeout();

    void onSignalErrorInfo(int i2);

    void onSlowLink(boolean z, int i2);

    void onUserDisShutUp(long j2);

    void onUserJoinedRoom(BigInteger bigInteger, String str, String str2);

    void onUserKickOff(long j2);

    void onUserLeavingRoom(BigInteger bigInteger);

    void onUserShutUp(long j2);

    void onWebrtcUp(BigInteger bigInteger);

    void subscriberHandleRemoteJsep(BigInteger bigInteger, JSONObject jSONObject);
}
