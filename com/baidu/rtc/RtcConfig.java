package com.baidu.rtc;
/* loaded from: classes15.dex */
public class RtcConfig {
    public String cuid;
    public String devicePosition;
    public int enableAudio;
    public int enableVideo;
    public String hostName;
    public int hostPort;
    public int identity;
    public int lineId;
    public String pushUrl;
    public int roomId;
    public int userId;
    public static int RTC_FAILED_INVALID_PUSHURL = 0;
    public static int RTC_FAILED_INVALID_VIDEO_CODEC = 1;
    public static int RTC_FAILED_INVALID_PARAMS = 2;
    public static int RTC_FAILED_INIT_FAILED = 3;

    /* loaded from: classes15.dex */
    public interface RtcHandler {
        void onConnectFailed(int i, int i2, String str, int i3);

        void onConnectSuccess(int i, int i2, String str, String str2);

        void onFailed(int i);

        boolean onLoadLibrary(String str);

        void onMuteStatusChanged(boolean z);

        void onRemoteUserOnLine(int i, int i2);

        void onStart(int i, int i2, String str, String str2);

        void onStop(int i, int i2);
    }

    public RtcConfig cloneObj() {
        RtcConfig rtcConfig = new RtcConfig();
        rtcConfig.roomId = this.roomId;
        rtcConfig.lineId = this.lineId;
        rtcConfig.hostName = this.hostName;
        rtcConfig.hostPort = this.hostPort;
        rtcConfig.userId = this.userId;
        rtcConfig.pushUrl = this.pushUrl;
        rtcConfig.identity = this.identity;
        rtcConfig.cuid = this.cuid;
        rtcConfig.enableAudio = this.enableAudio;
        rtcConfig.enableVideo = this.enableVideo;
        rtcConfig.devicePosition = this.devicePosition;
        return rtcConfig;
    }

    public boolean isCameraFront() {
        if (this.devicePosition == null || !this.devicePosition.equals("back")) {
            return true;
        }
        return false;
    }
}
