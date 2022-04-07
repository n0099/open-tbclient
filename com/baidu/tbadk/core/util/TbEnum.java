package com.baidu.tbadk.core.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class TbEnum {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class BroadcastType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BROADCAST_CREATE_GROUP = "com.baidu.tieba.broadcast.create_group";
        public static final String BROADCAST_EDIT_GROUP = "com.baidu.tieba.broadcast.edit_group";
        public static final String BROADCAST_FORUM_CHANGED = "com.baidu.tieba.broadcast.forum_changed";
        public static final String BROADCAST_JOIN_GROUP = "com.baidu.tieba.broadcast.join_group";
        public static final String BROADCAST_LEAVE_MSGPAGE = "com.baidu.tieba.broadcast.leave_msgpage";
        public static final String BROADCAST_LOGINOUT = "com.baidu.tieba.broadcast.loginout";
        public static final String BROADCAST_LOGIN_SUCC = "com.baidu.tieba.broadcast.login_succ";
        public static final String BROADCAST_NEWVERSION = "com.baidu.tieba.broadcast.newversion";
        public static final String BROADCAST_QUIT_APP = "com.baidu.tieba.broadcast.quit_app";
        public static final String BROADCAST_QUIT_GROUP = "com.baidu.tieba.broadcast.quit_group";
        public static final String BROADCAST_REFRESHWEBVIEW = "com.baidu.tieba.broadcast.refresh_webview";
        public static final String BROADCAST_SET_TOP_GROUP = "com.baidu.tieba.broadcast.set_top_group";
        public static final String BROADCAST_START_APP = "com.baidu.tieba.broadcast.start_app";
        public static final String BROADCAST_SYNC = "com.baidu.tieba.broadcast.sync";
        public static final String BROADCAST_UN_SET_TOP_GROUP = "com.baidu.tieba.broadcast.un_set_top_group";
        public static final String BROADCAST_WEBSOCKET_CLOSE = "com.baidu.adp.socket.close";
        public static final String BROADCAST_WEBSOCKET_DATA = "com.baidu.adp.socket.data";
        public static final String BROADCAST_WEBSOCKET_OPDN = "com.baidu.adp.socket.open";
        public static final String BROADCAST_WEBSOCKET_SEND_DATA = "com.baidu.adp.socket.send_data";
        public transient /* synthetic */ FieldHolder $fh;

        public BroadcastType() {
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class CreateGroupSource {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FROM_BAR_GROUP = "bargp";
        public static final String FROM_MY_GROUP = "mygp";
        public static final String FROM_NEAR_GROUP = "neargp";
        public transient /* synthetic */ FieldHolder $fh;

        public CreateGroupSource() {
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static class CustomGroupType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int GROUP = 1;
        public static final int GROUP_UPDATE = -3;
        public static final int GROUP_VALIDATION = -4;
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

    /* loaded from: classes3.dex */
    public static class GroupInfoSource {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FROM_FORUM_GROUP_HOT = "forumgroup_hot";
        public static final String FROM_FORUM_GROUP_OFFICIAL = "forumgroup_official";
        public static final String FROM_FORUM_GROUP_RECOMMEND = "forumgroup_recommend";
        public static final String FROM_GROUP_TALK = "grouptalk";
        public static final String FROM_INVITE_TALK = "invitetalk";
        public static final String FROM_USER_GROUP = "usergroup";
        public transient /* synthetic */ FieldHolder $fh;

        public GroupInfoSource() {
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

    /* loaded from: classes3.dex */
    public static abstract class GroupType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FORUM_FRIEND_GROUP = 3;
        public static final int GROUP_TYPE_NOTIFY = 8;
        public static final int OFFICIAL_CHAT = 30;
        public static final int OFFICIAL_GROUP = 4;
        public static final int OPERATING = 5;
        public static final int PERSONAL_CHAT = 6;
        public static final int PRIVATE_GROUP = 2;
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static abstract class MsgContentType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final short MSG_CONTENT_TYPE_ACTIVITY = 6;
        public static final short MSG_CONTENT_TYPE_BIG_EMOTION = 4;
        public static final short MSG_CONTENT_TYPE_EXTRA = 9;
        public static final short MSG_CONTENT_TYPE_INVITE_2_GROUP = 5;
        public static final short MSG_CONTENT_TYPE_NOTIFY = 10;
        public static final short MSG_CONTENT_TYPE_PHOTOLIVE = 25;
        public static final short MSG_CONTENT_TYPE_PIC = 2;
        public static final short MSG_CONTENT_TYPE_PIC_TEXT = 7;
        public static final short MSG_CONTENT_TYPE_REPLY_CARD = 23;
        public static final short MSG_CONTENT_TYPE_TEXT = 1;
        public static final short MSG_CONTENT_TYPE_VOICE = 3;
        public static final short MSG_SYSTEM = 11;
        public static final short MSG_TOPIC_UPDATE = 12;
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

    /* loaded from: classes3.dex */
    public static abstract class MsgStatus {
        public static /* synthetic */ Interceptable $ic = null;
        public static final short MSG_STATUS_MY_SENDFAIL = 2;
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public static abstract class SystemMessage {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EVENT_ID_ADD_FRIEND = "406";
        public static final String EVENT_ID_APPLY_ADD_FRIEND = "410";
        public static final String EVENT_ID_APPLY_FRIEND = "401";
        public static final String EVENT_ID_APPLY_PASS_FRIEND = "411";
        public static final String EVENT_ID_APPLY_REPLY_MESSAGE = "412";
        public static final String EVENT_ID_APPLY_SUC = "002";
        public static final String EVENT_ID_APPLY_VERIFY = "001";
        public static final String EVENT_ID_COMMON = "110";
        public static final String EVENT_ID_DELETE_FRIEND = "405";
        public static final String EVENT_ID_DISMISS_GROUP = "107";
        public static final String EVENT_ID_FAKE = "-10001";
        public static final String EVENT_ID_GROUP_ACTIVITYS_IN_CHAT = "123";
        public static final String EVENT_ID_GROUP_JOIN = "105";
        public static final String EVENT_ID_GROUP_NAME_MODIFY = "101";
        public static final String EVENT_ID_GROUP_QUIT = "106";
        public static final String EVENT_ID_GROUP_UPGRADE = "104";
        public static final String EVENT_ID_HIDE_GROUP = "122";
        public static final String EVENT_ID_HIDE_GROUP_WARN = "121";
        public static final String EVENT_ID_INTRO_MODIFY = "103";
        public static final String EVENT_ID_INVITE_GROUP = "109";
        public static final String EVENT_ID_KICKED_OUT = "003";
        public static final String EVENT_ID_NOTICE_MODIFY = "102";
        public static final String EVENT_ID_OFFLINE_DEBUG = "503";
        public static final String EVENT_ID_PASSED_FRIEND = "402";
        public static final String EVENT_ID_PLUGIN_CONFIG_SYNC = "502";
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
