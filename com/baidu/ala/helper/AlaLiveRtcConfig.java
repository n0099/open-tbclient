package com.baidu.ala.helper;
/* loaded from: classes6.dex */
public class AlaLiveRtcConfig {
    public int mCloseTimeout;
    public int mHandshakeTimeout;
    public int mHeartInterval;
    public int mHeartTimeout;
    public boolean mIsSupportFaceStyle;
    public long mLineIndex;
    public int mPkID;
    public int mReduceDelay;
    public long mRoomId;
    public String mRtcServerHost;
    public int mRtcServerPort;
    public long mUId;

    /* loaded from: classes6.dex */
    public static class NativeErroCode {
        public static final int ERROR_CLOSE_TIMEOUT = 1030;
        public static final int ERROR_CLOSE_UNKNOW = 1031;
        public static final int ERROR_CODE_BASE = 1000;
        public static final int ERROR_CONNECT_TOO_MANY_TIMES = 1100;
        public static final int ERROR_HANDS_SHAKE_INTERNAL_SERVER_ERROR = 1013;
        public static final int ERROR_HANDS_SHAKE_NETWORK_INVALIDATE = 1014;
        public static final int ERROR_HANDS_SHAKE_NO_AUTH = 1012;
        public static final int ERROR_HANDS_SHAKE_PARAM_ERROR = 1011;
        public static final int ERROR_HANDS_SHAKE_TIMEOUT = 1010;
        public static final int ERROR_HANDS_SHAKE_UNKNOW = 1015;
        public static final int ERROR_HEART_BEAT_TIMEOUT = 1020;
        public static final int ERROR_HEART_BEAT_UNKNOW = 1021;
        public static final int ERROR_NETWORK_CHANGED = 1002;
        public static final int ERROR_PROTOCAL_SESSION_ID = 1040;
        public static final int ERROR_SOCKET_UNKNOW = 1003;
        public static final int ERROR_SOCKET_WRITE = 1001;
        public static final int ERROR_SUCCESS = 0;
    }

    public AlaLiveRtcConfig(AlaLiveRtcConfig alaLiveRtcConfig) {
        this.mUId = 0L;
        this.mRoomId = 0L;
        this.mLineIndex = 0L;
        this.mRtcServerHost = null;
        this.mRtcServerPort = 0;
        this.mPkID = 0;
        this.mHandshakeTimeout = 0;
        this.mHeartInterval = 0;
        this.mHeartTimeout = 0;
        this.mCloseTimeout = 0;
        this.mReduceDelay = 0;
        this.mIsSupportFaceStyle = true;
        if (alaLiveRtcConfig != null) {
            this.mUId = alaLiveRtcConfig.mUId;
            this.mRoomId = alaLiveRtcConfig.mRoomId;
            this.mLineIndex = alaLiveRtcConfig.mLineIndex;
            this.mRtcServerHost = alaLiveRtcConfig.mRtcServerHost;
            this.mRtcServerPort = alaLiveRtcConfig.mRtcServerPort;
            this.mIsSupportFaceStyle = alaLiveRtcConfig.mIsSupportFaceStyle;
            this.mPkID = alaLiveRtcConfig.mPkID;
            this.mHandshakeTimeout = alaLiveRtcConfig.mHandshakeTimeout;
            this.mHeartInterval = alaLiveRtcConfig.mHeartInterval;
            this.mHeartTimeout = alaLiveRtcConfig.mHeartTimeout;
            this.mCloseTimeout = alaLiveRtcConfig.mCloseTimeout;
            this.mReduceDelay = alaLiveRtcConfig.mReduceDelay;
        }
    }

    public AlaLiveRtcConfig() {
        this.mUId = 0L;
        this.mRoomId = 0L;
        this.mLineIndex = 0L;
        this.mRtcServerHost = null;
        this.mRtcServerPort = 0;
        this.mPkID = 0;
        this.mHandshakeTimeout = 0;
        this.mHeartInterval = 0;
        this.mHeartTimeout = 0;
        this.mCloseTimeout = 0;
        this.mReduceDelay = 0;
        this.mIsSupportFaceStyle = true;
    }
}
