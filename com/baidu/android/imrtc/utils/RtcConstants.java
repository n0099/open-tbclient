package com.baidu.android.imrtc.utils;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes18.dex */
public class RtcConstants {
    public static final int ACTION_IM_RTC_ACK = 102;
    public static final int ACTION_IM_RTC_ANSWER = 84;
    public static final int ACTION_IM_RTC_ANSWER_SYNC = 85;
    public static final int ACTION_IM_RTC_CANCEL_CALL = 94;
    public static final int ACTION_IM_RTC_CANCEL_CALL_SYNC = 95;
    public static final int ACTION_IM_RTC_CLOSE = 88;
    public static final int ACTION_IM_RTC_CLOSE_SYNC = 89;
    public static final int ACTION_IM_RTC_FETCH_ROOM_SIGNALING = 91;
    public static final int ACTION_IM_RTC_FETCH_ROOM_STATE = 90;
    public static final int ACTION_IM_RTC_HANGOUT = 86;
    public static final int ACTION_IM_RTC_HANGOUT_SYNC = 87;
    public static final int ACTION_IM_RTC_HEART_BEAT = 100;
    public static final int ACTION_IM_RTC_INVITE = 80;
    public static final int ACTION_IM_RTC_INVITE_SYNC = 81;
    public static final int ACTION_IM_RTC_JOIN = 92;
    public static final int ACTION_IM_RTC_JOIN_SYNC = 93;
    public static final int ACTION_IM_RTC_KICK_REQUEST = 104;
    public static final int ACTION_IM_RTC_KICK_REQUEST_SYNC = 105;
    public static final int ACTION_IM_RTC_KICK_RESPONSE = 106;
    public static final int ACTION_IM_RTC_KICK_RESPONSE_SYNC = 107;
    public static final int ACTION_IM_RTC_RING = 82;
    public static final int ACTION_IM_RTC_RING_SYNC = 83;
    public static final int ERROR_ACTION_ORDER = -2;
    public static final String EXTRA_RTC_ACTION_ID = "rtc_action_id";
    public static final String EXTRA_RTC_INFO = "rtc_info";
    public static final String EXTRA_RTC_ROOM_ID = "rtc_room_id";
    public static final int IM_RTC_1V1 = 1;
    public static final int IM_RTC_1VN = 2;
    public static final int IM_RTC_ANSWER_NO = 2;
    public static final int IM_RTC_ANSWER_OK = 1;
    public static final int IM_RTC_ANSWER_TIMEOUT = 3;
    public static final int IM_RTC_KICKED_NO = 2;
    public static final int IM_RTC_KICKED_NONE = 0;
    public static final int IM_RTC_KICKED_OK = 1;
    public static final int IM_RTC_MEDIA_AUDIO = 1;
    public static final int IM_RTC_MEDIA_VIDEO = 2;
    public static final int METHOD_IM_RTC_MSG = 230;
    public static final int METHOD_IM_RTC_NOTIFY_MSG = 231;
    public static final int RTC_HEART_BEAT_STATUS_IN_ROOM = 1;
    public static final int RTC_HEART_BEAT_STATUS_NOT_IN_ROOM = 0;
    public static final int RTC_SERVICE_ID = 5;
    public static final int SUCCESS = 0;
    public static boolean LOG_DEBUG = false;
    public static int RTC_VERSION = 102030;
    public static long RTC_HEART_BEAT_TIME = 10000;
    public static int RTC_HEART_BEAT_RETRY_TIME = 3;
    public static int RTC_HEART_BEAT_STATUS = 0;
    public static volatile long RTC_TRACK_UPLOAD_DURATION = 300000;
    public static volatile AtomicLong IM_RTC_SDK_SEQ_ID = new AtomicLong(-1);
    public static volatile long IM_RTC_SERVER_SEQ_ID = -1;

    /* loaded from: classes18.dex */
    public enum RoomEventType {
        JOIN_ROOM(93),
        EXIT_ROOM(87),
        CALLEE_RING(83);
        
        private final int value;

        RoomEventType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
