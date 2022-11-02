package com.baidu.livesdk.api.im.live;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LiveMessageBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String at_character;
    public String at_character_name;
    public MessageBody at_message_body;
    public String at_message_type;
    public String at_name;
    public String at_portrait;
    public String at_uid;
    public String at_vip;
    public String character;
    public String character_name;
    public String content;
    public Data data;
    public String expand;
    public MessageBody message_body;
    public String message_type;
    public long msgId;
    public String name;
    public String originMsgStr;
    public String portrait;
    public String room_id;
    public long time;
    public String to_uid;
    public String type;
    public String uid;
    public String vip;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface MessageType {
        public static final int PIC = 1;
        public static final int PIC_LINK = 4;
        public static final int PIC_TXT = 2;
        public static final int TXT = 0;
        public static final int TXT_LINK = 3;
        public static final int VOICE = 5;
    }

    /* loaded from: classes2.dex */
    public interface ServiceType {
        public static final int QUIZ_CONTINUE_INFO = 6;
        public static final int QUIZ_CONTINUE_RESULT = 7;
        public static final int QUIZ_LIVE_START = 2;
        public static final int QUIZ_QUESTION_ANSWER = 3;
        public static final int QUIZ_QUESTION_INFO = 1;
        public static final int QUIZ_QUESTION_START = 5;
        public static final int QUIZ_WINNER_RESULT = 4;
    }

    /* loaded from: classes2.dex */
    public interface StickOperation {
        public static final int CANCEL_STICK = 2;
        public static final int STICK = 1;
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface Vip {
        public static final int NOMALUSER = 0;
        public static final int VIP = 1;
    }

    /* loaded from: classes2.dex */
    public static class Pic {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageInfo origin;
        public ImageInfo thumbnail;

        /* loaded from: classes2.dex */
        public static class ImageInfo {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String format;
            public int height;
            public String url;
            public int width;

            public ImageInfo() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public Pic() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Data {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String closeExt;
        public long[] delMsgIds;
        public String duration;
        public int feedback;
        public String lasteruser;
        public String liveFLVUrl;
        public String liveRTMPUrl;
        public int mcaseId;
        public String noticeContent;
        public String noticeTitle;
        public int opreation;
        public String serviceInfo;
        public int serviceType;
        public LiveMessageBean stickMsg;
        public String totalUsers;
        public int totaluser;

        public Data() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.feedback = 0;
            this.lasteruser = "";
            this.totaluser = 0;
            this.duration = "";
            this.totalUsers = "";
            this.noticeTitle = "";
            this.noticeContent = "";
            this.liveRTMPUrl = "";
            this.liveFLVUrl = "";
        }
    }

    /* loaded from: classes2.dex */
    public static class Link {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String title;
        public String url;

        public Link() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class MessageBody {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Link link;
        public Pic pic;
        public Txt txt;
        public Voice voice;

        public MessageBody() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Txt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String word;

        public Txt() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Voice {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String duration;
        public String format;
        public String url;

        public Voice() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public LiveMessageBean() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = "0";
        this.message_type = "0";
        this.character = "1005";
        this.vip = "0";
        this.at_message_type = "0";
        this.at_vip = "0";
        this.at_character = "1005";
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "LiveMessageBean:{" + this.originMsgStr + "}";
        }
        return (String) invokeV.objValue;
    }
}
