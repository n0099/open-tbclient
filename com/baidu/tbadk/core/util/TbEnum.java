package com.baidu.tbadk.core.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class TbEnum {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static abstract class ChatInputStatus {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String INPUT_DRAFT_KEY = "input_draft";
        public static final String INPUT_STATUS_KEY = "input_status";
        public static final String INPUT_STATUS_TEXT = "input_text";
        public static final String INPUT_STATUS_VOICE = "input_voice";
        public transient /* synthetic */ FieldHolder $fh;

        public ChatInputStatus() {
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

    /* loaded from: classes4.dex */
    public static abstract class ChatType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int GROUP_MODE = 0;
        public static final int PERSONAL_MODE = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public ChatType() {
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

    /* loaded from: classes4.dex */
    public static class CustomGroupId {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String GROUP_UPDATE = "-1002";
        public static final String GROUP_VALIDATION = "-1003";
        public static final String OFFICIAL_MERGE = "-1000";
        public static final String STRANGE_MERGE = "-1001";
        public transient /* synthetic */ FieldHolder $fh;

        public CustomGroupId() {
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

    /* loaded from: classes4.dex */
    public static class CustomGroupType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int GROUP_VALIDATION = -4;
        public static final int NEWGROUP = 9;
        public static final int NOTIFICATION = 5;
        public static final int OFFICIAL = 4;
        public static final int OFFICIAL_GROUP = -9;
        public static final int OFFICIAL_MERGE = -8;
        public static final int PERSONAL = 2;
        public static final int PERSONAL_GROUP = -1;
        public static final int STRANGE_MERGE = -7;
        public static final int SYSTEM = -2;
        public static final int YY_BROADCAST = 8;
        public static final int YY_IMEI = 7;
        public static final int YY_UID = 6;
        public transient /* synthetic */ FieldHolder $fh;

        public CustomGroupType() {
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

    /* loaded from: classes4.dex */
    public static abstract class GamePlayOrderMsgStatus {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LETTER_TYPE_ORDER_ACCEPT = 2;
        public static final int LETTER_TYPE_ORDER_CANCEL = 3;
        public static final int LETTER_TYPE_ORDER_CONFIRM = 6;
        public static final int LETTER_TYPE_ORDER_DOING = 9;
        public static final int LETTER_TYPE_ORDER_DONE = 10;
        public static final int LETTER_TYPE_ORDER_FINISH = 5;
        public static final int LETTER_TYPE_ORDER_NEW = 1;
        public static final int LETTER_TYPE_ORDER_REFUND_GOD = 8;
        public static final int LETTER_TYPE_ORDER_REFUND_USER = 7;
        public static final int LETTER_TYPE_ORDER_REJECT = 4;
        public transient /* synthetic */ FieldHolder $fh;

        public GamePlayOrderMsgStatus() {
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

    /* loaded from: classes4.dex */
    public static abstract class GroupType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int GROUP_TYPE_NOTIFY = 8;
        public static final int OFFICIAL_CHAT = 30;
        public static final int PERSONAL_CHAT = 6;
        public static final int SYSTEM_MSG = 1;
        public static final int YY_BROADCAST_NOTIFY = 12;
        public static final int YY_IMEI_NOTIFY = 11;
        public static final int YY_UID_NOTIFY = 10;
        public transient /* synthetic */ FieldHolder $fh;

        public GroupType() {
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

    /* loaded from: classes4.dex */
    public static abstract class MsgContentSubType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final short FRS_SUB_TYPE_EXTRA_SHARE = 4;
        public static final short MSG_SUB_TYPE_EXTRA_SHARE = 1;
        public static final short MSG_TOPIC_TYPE_EXTRA_SHARE = 5;
        public transient /* synthetic */ FieldHolder $fh;

        public MsgContentSubType() {
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

    /* loaded from: classes4.dex */
    public static abstract class MsgContentType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final short MSG_CONTENT_TYPE_ACTIVITY = 6;
        public static final short MSG_CONTENT_TYPE_BIG_EMOTION = 4;
        public static final short MSG_CONTENT_TYPE_BREAK_ICE = 30;
        public static final short MSG_CONTENT_TYPE_COMMON_SHARE_CARD = 38;
        public static final short MSG_CONTENT_TYPE_EXTRA = 9;
        public static final short MSG_CONTENT_TYPE_GAMEPLAY_ORDER = 34;
        public static final short MSG_CONTENT_TYPE_INVITE_2_GROUP = 5;
        public static final short MSG_CONTENT_TYPE_NOTIFY = 10;
        public static final int MSG_CONTENT_TYPE_ONE_KEY_CONVERSATION = 7019;
        public static final short MSG_CONTENT_TYPE_PHOTOLIVE = 25;
        public static final short MSG_CONTENT_TYPE_PIC = 2;
        public static final short MSG_CONTENT_TYPE_PIC_TEXT = 7;
        public static final short MSG_CONTENT_TYPE_QUESTION_THREAD = 35;
        public static final short MSG_CONTENT_TYPE_REPLY_CARD = 23;
        public static final short MSG_CONTENT_TYPE_SHARE_CHATROOM = 37;
        public static final short MSG_CONTENT_TYPE_SHARE_FORUM = 33;
        public static final short MSG_CONTENT_TYPE_SHARE_THREAD = 32;
        public static final short MSG_CONTENT_TYPE_SINGLE_TEXT_IMAGE = 102;
        public static final int MSG_CONTENT_TYPE_START_EGG_RAIN = 7016;
        public static final short MSG_CONTENT_TYPE_STRANGER_TIP = 8001;
        public static final int MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS = -7017;
        public static final int MSG_CONTENT_TYPE_SYSTEM_FROZEN = 7007;
        public static final int MSG_CONTENT_TYPE_SYSTEM_MANAGER_TIPS = -7014;
        public static final int MSG_CONTENT_TYPE_SYSTEM_MUZZLE = 7003;
        public static final int MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL = 7005;
        public static final short MSG_CONTENT_TYPE_SYSTEM_NOTICE_MODIFY = 7001;
        public static final int MSG_CONTENT_TYPE_SYSTEM_ONLY_MANAGER_CAN_TALK = 7013;
        public static final int MSG_CONTENT_TYPE_SYSTEM_RECALL_MSG = 7002;
        public static final int MSG_CONTENT_TYPE_SYSTEM_RECALL_MSG_PERSONAL = 7015;
        public static final int MSG_CONTENT_TYPE_SYSTEM_SHARE_CHAT_ROOM = 7020;
        public static final int MSG_CONTENT_TYPE_SYSTEM_SHARE_COMMON = 7021;
        public static final int MSG_CONTENT_TYPE_SYSTEM_SHARE_FORUM = 7009;
        public static final int MSG_CONTENT_TYPE_SYSTEM_SHARE_THREAD = 7010;
        public static final int MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_POST = 7011;
        public static final int MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW = 7012;
        public static final int MSG_CONTENT_TYPE_SYSTEM_TIMESTAMP = -7013;
        public static final int MSG_CONTENT_TYPE_SYSTEM_TIPS = 7017;
        public static final int MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN = 7008;
        public static final int MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE = 7004;
        public static final int MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL = 7006;
        public static final int MSG_CONTENT_TYPE_SYSTEM_UPDATE_TXT_GEN_IMAGE = 7014;
        public static final short MSG_CONTENT_TYPE_TEXT = 1;
        public static final short MSG_CONTENT_TYPE_TEXT_GEN_IMAGE = 101;
        public static final short MSG_CONTENT_TYPE_VOICE = 3;
        public static final int MSG_SUBSCRIBE_TIPS = -7015;
        public static final short MSG_SYSTEM = 11;
        public static final short MSG_TOPIC_UPDATE = 12;
        public static final int MSG_TYPE_SYSTEM_EXCELLENT = 7018;
        public static final short MSG_UEG_ILLEGAL = 31;
        public static final short MSG_UNSHOW_OPERATER_ACCOUNT = 99;
        public static final short MSG_UNSHOW_SYSTEM = 22;
        public transient /* synthetic */ FieldHolder $fh;

        public MsgContentType() {
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

    /* loaded from: classes4.dex */
    public static abstract class MsgStatus {
        public static /* synthetic */ Interceptable $ic = null;
        public static final short MSG_STATUS_MY_SENDFAIL = 2;
        public static final short MSG_STATUS_MY_SENDFAIL_ACCOUNT_CANCELLATION = 7;
        public static final short MSG_STATUS_MY_SENDFAIL_BZC_USER_BLOCK = 8;
        public static final short MSG_STATUS_MY_SENDFAIL_REFUSED_TO_ACCEPT_FRIEND_MSG = 4;
        public static final short MSG_STATUS_MY_SENDFAIL_REFUSED_TO_ACCEPT_STRANGER_MSG = 5;
        public static final short MSG_STATUS_MY_SENDFAIL_REFUSED_TO_ACCEPT_YOUR_MSG = 6;
        public static final short MSG_STATUS_MY_SENDFAIL_UNKNOW = 9;
        public static final short MSG_STATUS_MY_SENDING = 1;
        public static final short MSG_STATUS_MY_SENDSUCC = 3;
        public static final short MSG_STATUS_MY_UNKNOW = 0;
        public transient /* synthetic */ FieldHolder $fh;

        public MsgStatus() {
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

    /* loaded from: classes4.dex */
    public static abstract class MsgVoiceStatus {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int VOICE_STATUS_DOWNLOADING = 2;
        public static final int VOICE_STATUS_PLAYING = 3;
        public static final int VOICE_STATUS_WAITING = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public MsgVoiceStatus() {
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

    /* loaded from: classes4.dex */
    public static abstract class ParamKey {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String CHAT_MODE = "chat_mode";
        public static final String GID = "gid";
        public static final String GROUP = "group";
        public static final String USER = "user";
        public static final String USE_MOTU = "use_motu";
        public static final String VTAG = "vtag";
        public transient /* synthetic */ FieldHolder $fh;

        public ParamKey() {
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

    /* loaded from: classes4.dex */
    public static abstract class ResourceType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BIGIMAGE = 1;
        public static final int SMALLIMAGE = 0;
        public transient /* synthetic */ FieldHolder $fh;

        public ResourceType() {
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

    /* loaded from: classes4.dex */
    public static abstract class SystemMessage {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EVENT_ID_ADD_FRIEND = "406";
        public static final String EVENT_ID_APPLY_ADD_FRIEND = "410";
        public static final String EVENT_ID_APPLY_FRIEND = "401";
        public static final String EVENT_ID_APPLY_PASS_FRIEND = "411";
        public static final String EVENT_ID_APPLY_REPLY_MESSAGE = "412";
        public static final String EVENT_ID_COMMON = "110";
        public static final String EVENT_ID_CYBER_VIOLENCE = "416";
        public static final String EVENT_ID_DELETE_FRIEND = "405";
        public static final String EVENT_ID_FAKE = "-10001";
        public static final String EVENT_ID_OFFLINE_DEBUG = "503";
        public static final String EVENT_ID_PASSED_FRIEND = "402";
        public static final String EVENT_ID_PLUGIN_CONFIG_SYNC = "502";
        public static final String EVENT_ID_STRANGER_FIRST_MSG = "415";
        public static final String EVENT_ID_UPLOAD_STAT = "501";
        public static final String KEY_EVENT_ID = "eventId";
        public static final String KEY_EVENT_PARAM = "eventParam";
        public static final String KEY_GROUPTYPE = "groupType";
        public static final String KEY_GROUP_ID = "groupId";
        public static final String KEY_GROUP_IMAGE = "groupImage";
        public static final String KEY_GROUP_NAME = "groupName";
        public static final String KEY_LAST_MSG_ID = "lastMsgId";
        public static final String KEY_PORTRAIT = "portrait";
        public static final String KEY_TITLE = "title";
        public static final String KEY_USER_ID = "userId";
        public static final String KEY_USER_MSG = "userMsg";
        public static final String KEY_USER_MSG_CONTENT = "userMsgContent";
        public static final String KEY_USER_NAME = "userName";
        public transient /* synthetic */ FieldHolder $fh;

        public SystemMessage() {
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

    public TbEnum() {
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
