package com.baidu.livesdk.api.im.live;
/* loaded from: classes3.dex */
public class LiveMessageBean {
    public String at_character_name;
    public MessageBody at_message_body;
    public String at_name;
    public String at_portrait;
    public String at_uid;
    public String character_name;
    public String content;
    public Data data;
    public String expand;
    public MessageBody message_body;
    public long msgId;
    public String name;
    public String originMsgStr;
    public String portrait;
    public String room_id;
    public long time;
    public String to_uid;
    public String uid;
    public String type = "0";
    public String message_type = "0";
    public String character = "1005";
    public String vip = "0";
    public String at_message_type = "0";
    public String at_vip = "0";
    public String at_character = "1005";

    /* loaded from: classes3.dex */
    public interface Character {
        public static final int ANCHOR = 1001;
        public static final int BLACKLISTUSER = 1009;
        public static final int GAGUSER = 1;
        public static final int HONOREDGUEST = 1002;
        public static final int NOMALUSER = 1005;
        public static final int PRESENTER = 1000;
        public static final int ROBOT = 1008;
        public static final int SCENECON = 4;
        public static final int WHITELISTUSER = 3;
    }

    /* loaded from: classes3.dex */
    public static class Data {
        public String closeExt;
        public long[] delMsgIds;
        public int mcaseId;
        public int opreation;
        public String serviceInfo;
        public int serviceType;
        public LiveMessageBean stickMsg;
        public int feedback = 0;
        public String lasteruser = "";
        public int totaluser = 0;
        public String duration = "";
        public String totalUsers = "";
        public String noticeTitle = "";
        public String noticeContent = "";
        public String liveRTMPUrl = "";
        public String liveFLVUrl = "";
    }

    /* loaded from: classes3.dex */
    public static class Link {
        public String title;
        public String url;
    }

    /* loaded from: classes3.dex */
    public static class MessageBody {
        public Link link;
        public Pic pic;
        public Txt txt;
        public Voice voice;
    }

    /* loaded from: classes3.dex */
    public interface MessageType {
        public static final int PIC = 1;
        public static final int PIC_LINK = 4;
        public static final int PIC_TXT = 2;
        public static final int TXT = 0;
        public static final int TXT_LINK = 3;
        public static final int VOICE = 5;
    }

    /* loaded from: classes3.dex */
    public static class Pic {
        public ImageInfo origin;
        public ImageInfo thumbnail;

        /* loaded from: classes3.dex */
        public static class ImageInfo {
            public String format;
            public int height;
            public String url;
            public int width;
        }
    }

    /* loaded from: classes3.dex */
    public interface ServiceType {
        public static final int QUIZ_CONTINUE_INFO = 6;
        public static final int QUIZ_CONTINUE_RESULT = 7;
        public static final int QUIZ_LIVE_START = 2;
        public static final int QUIZ_QUESTION_ANSWER = 3;
        public static final int QUIZ_QUESTION_INFO = 1;
        public static final int QUIZ_QUESTION_START = 5;
        public static final int QUIZ_WINNER_RESULT = 4;
    }

    /* loaded from: classes3.dex */
    public interface StickOperation {
        public static final int CANCEL_STICK = 2;
        public static final int STICK = 1;
    }

    /* loaded from: classes3.dex */
    public static class Txt {
        public String word;
    }

    /* loaded from: classes3.dex */
    public interface Type {
        public static final int AT = 3;
        public static final int ENTER_LIVE = 1001;
        public static final int HINT = 1;
        public static final int LIVE_CLOSE = 102;
        public static final int LIVE_DELETE_MSG = 106;
        public static final int LIVE_ROOM_NOTICE = 103;
        public static final int LIVE_RTMP_CHANGE = 104;
        public static final int LIVE_SERVER = 107;
        public static final int LIVE_SERVER1 = 108;
        public static final int LIVE_STATE_INFO = 101;
        public static final int LIVE_STICK_MSG = 105;
        public static final int NORMAL = 0;
        public static final int NOTICE = 2;
        public static final int SYSTEM_TXT = 100;
    }

    /* loaded from: classes3.dex */
    public interface Vip {
        public static final int NOMALUSER = 0;
        public static final int VIP = 1;
    }

    /* loaded from: classes3.dex */
    public static class Voice {
        public String duration;
        public String format;
        public String url;
    }

    public String toString() {
        return "LiveMessageBean:{" + this.originMsgStr + "}";
    }
}
