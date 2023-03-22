package com.baidu.android.imsdk.db;

import android.provider.BaseColumns;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TableDefine {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_NAME_PREFIX = "bdimsdk_";
    public static final String DB_TABLE_BUSINESS_ADVISORY_AD_BTN_SHOW = "advisory_ad_btn_show";
    public static final String DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG = "advisory_custom_msg";
    public static final String DB_TABLE_BUSINESS_CHAT_MSG = "busisessmsg";
    public static final String DB_TABLE_BUSINESS_DIALOGUEID = "business_dialogueid";
    public static final String DB_TABLE_BUSINESS_SESSION = "busisession";
    public static final String DB_TABLE_CHAT_SESSION = "chatrecord";
    public static final String DB_TABLE_CRASH_LOG = "crash";
    public static final String DB_TABLE_DIALOG_RECORD = "dialog_record";
    public static final String DB_TABLE_ERROR_LOG = "errorlog";
    public static final String DB_TABLE_FRIEND_GROUP = "friendgroup";
    public static final String DB_TABLE_FRIEND_RELATION = "friendrelation";
    public static final String DB_TABLE_GROUPINFO = "groupinfo";
    public static final String DB_TABLE_GROUPMEMBER = "groupmember";
    public static final String DB_TABLE_MEDIA_DRAFT_MESSAGE = "media_draft_msg";
    public static final String DB_TABLE_MEDIA_MESSAGE = "media_message";
    public static final String DB_TABLE_MEDIA_SESSION = "media_session";
    public static final String DB_TABLE_MESSAGE = "message";
    public static final String DB_TABLE_MESSAGE_WITH_TAG = "message_tag";
    public static final String DB_TABLE_NO_DUPLICATE_MESSAGE = "duplicate_message";
    public static final String DB_TABLE_PA_CMD_QUEUE = "paCmdQueue";
    public static final String DB_TABLE_PA_SUBSCRIBE = "paSubscribe";
    public static final String DB_TABLE_RELIABLE_MESSAGE = "liveroom_message";
    public static final String DB_TABLE_STAT_LOG = "stat_log";
    public static final String DB_TABLE_STUDIO_USE_PA_MESSAGE = "studio_use_pa_message";
    public static final String DB_TABLE_USERINFO = "userinfo";
    public static final String DB_TABLE_ZHIDAINFO = "zhida_info";
    public static final int DB_VERSION = 79;
    public static final String SQL_COPY_TABLE_USERINFO = "INSERT INTO userinfo (uid, buid, username, sex, phone, user_detail, tiny_url, head_url, account_type, ip_exsit, ip, ip_isp, ip_country, ip_province, ip_city, ip_county, disturb, blacklist) SELECT uid, buid, username, sex, phone, user_detail, tiny_url, head_url, account_type, ip_exsit, ip, ip_isp, ip_country, ip_province, ip_city, ip_county, disturb, blacklist FROM userinfo_temp";
    public static final String SQL_CREATE_DUPLICATE_MESSAGE = "CREATE TABLE duplicate_message (_id INTEGER PRIMARY KEY AUTOINCREMENT , msgid LONG, category LONG, contacter LONG, msg_key TEXT, from_user LONG, input_time LONG, type LONG);";
    public static final String SQL_CREATE_MEDIA_MESSAGE_QUERY_MSGID_INDEX = "CREATE INDEX media_msgid_query ON media_message (category, contacter, msgid);";
    public static final String SQL_CREATE_MEDIA_SESSION_MODE_QUERY_INDEX = "CREATE INDEX media_fetch_session_query ON media_session (category, contacter, fetch_mode, sort_update_time, marktop);";
    public static final String SQL_CREATE_MEDIA_SESSION_QUERY_INDEX = "CREATE INDEX media_session_query ON media_session (category, contacter, paid, contacter_bduid);";
    public static final String SQL_CREATE_MESSAGE_INDEX = "CREATE INDEX msg_index ON message (expires_time, category, contacter, is_read);";
    public static final String SQL_CREATE_MESSAGE_QUERY_MSGID_ISEXIST_INDEX = "CREATE INDEX msgid_query ON message (msgid, status, contacter);";
    public static final String SQL_CREATE_MESSAGE_QUERY_MSGKEY_ISEXIST_INDEX = "CREATE INDEX msgkey_query ON message (msg_key, contacter);";
    public static final String SQL_CREATE_RELIABLE_MESSAGE = "CREATE TABLE liveroom_message (_id INTEGER PRIMARY KEY AUTOINCREMENT , msgid LONG, category LONG,content TEXT, contacter LONG, mcast_id LONG, msg_key TEXT, from_user LONG, create_time LONG, type LONG, priority LONG,is_read LONG);";
    public static final String SQL_CREATE_STUDIO_USE_PA_MESSAGE = "CREATE TABLE studio_use_pa_message (_id INTEGER PRIMARY KEY AUTOINCREMENT , msgid LONG, category INTEGER, contacter LONG, msg_key TEXT, from_user LONG, input_time LONG, type INTEGER, content TEXT, is_read INTEGER);";
    public static final String SQL_CREATE_TABLE_BUSINESS_ADV_AD_BTN_SHOW_INFO = "CREATE TABLE advisory_ad_btn_show (uk TEXT PRIMARY KEY , has_clicked_today INTEGER, last_show_time LONG, show_times_today INTEGER); ";
    public static final String SQL_CREATE_TABLE_BUSINESS_ADV_SESSION = "CREATE TABLE advisory_custom_msg (_id INTEGER PRIMARY KEY AUTOINCREMENT , role INTEGER, aid TEXT, uk TEXT, source INTEGER, order_type INTEGER, replyer_uid TEXT,eva_is_eva INTEGER, eva_star_num INTEGER, eva_star_desc TEXT,eva_msg TEXT, eva_tags TEXT,eva_amount INTEGER,eva_is_free INTEGER,eva_has_refund INTEGER,refund_status INTEGER,refund_title TEXT,refund_text TEXT, refund_url_text TEXT, allow_refund INTEGER DEFAULT -1, eva_type INTEGER, eva_title TEXT, eva_subtitle TEXT, eva_tag_list TEXT,cardTip TEXT,sopTitle TEXT,sopList TEXT,target_msgid LONG UNIQUE );";
    public static final String SQL_CREATE_TABLE_BUSINESS_DIALOGUEID = "CREATE TABLE business_dialogueid (_id INTEGER PRIMARY KEY AUTOINCREMENT , business_type INTEGER, resource_id TEXT, dialogue_id LONG UNIQUE );";
    public static final String SQL_CREATE_TABLE_BUSINESS_MESSAGE = "CREATE TABLE busisessmsg (_id INTEGER PRIMARY KEY AUTOINCREMENT , msgid LONG, from_user LONG, category INTEGER, contacter LONG, type INTEGER, content TEXT, time LONG, is_read INTEGER, status INTEGER, cmd INTEGER, from_buid TEXT, device_flag INTEGER,msg_key TEXT, tips_code INTEGER, tips TEXT, to_buid TEXT, contacter_is_read INTEGER,dialogue_id LONG, business_type INTEGER, sendid TEXT, session_type INTEGER,logic_del INTEGER,UNIQUE (msgid, contacter, session_type),UNIQUE (msg_key, contacter, session_type));";
    public static final String SQL_CREATE_TABLE_BUSINESS_SESSION = "CREATE TABLE busisession (_id INTEGER PRIMARY KEY AUTOINCREMENT , business INTEGER, category INTEGER, contacter LONG, bduid LONG, name TEXT, last_msg TEXT, last_msg_time LONG, new_msg_sum INTEGER, icon_url TEXT,last_msg_id LONG, session_type INTEGER,last_dialogue_id LONG, last_resource_id TEXT,last_aid_type INTEGER,last_dialogue_status INTEGER,chat_type INTEGER,extra TEXT,v_portrait TEXT,last_ask_uk LONG, last_answer_uk LONG, last_msg_desc TEXT, msg_draft TEXT, last_dialogue_status_show TEXT, classtype INTEGER DEFAULT 0, classtitle TEXT, classshow INTEGER DEFAULT 0, classavatar TEXT, subscribe_status INTEGER DEFAULT 0, collect_status INTEGER DEFAULT 0, UNIQUE (business, contacter, session_type));";
    public static final String SQL_CREATE_TABLE_CHAT_SESSION = "CREATE TABLE chatrecord (_id LONG PRIMARY KEY,category INTEGER, contacter LONG, name TEXT, last_msg TEXT, last_msg_time LONG, last_open_time LONG, new_msg_sum INTEGER, weight INTEGER, show INTEGER,collection_type INTEGER,chat_type INTEGER,icon_url TEXT,msg_state INTEGER,paid LONG,isclicked INTEGER, classtype INTEGER DEFAULT 0, classtitle TEXT, classshow INTEGER DEFAULT 0, marktop INTEGER DEFAULT 0, marktoptime LONG, classavatar TEXT, nickname TEXT, game_vs_history TEXT, extra TEXT, v_portrait TEXT, certification TEXT, vip_id TEXT, shield INTEGER, is_stranger INTEGER DEFAULT 0, disturb INTEGER DEFAULT 0, last_msg_bduid LONG DEFAULT 0, last_msg_name TEXT, shield_time LONG, remind_type INTEGER DEFAULT 0, remind_msgid LONG DEFAULT 0, remind_uid LONG DEFAULT 0, remind_role_display_name TEXT, highlight_desc TEXT, highlight_priority INTEGER DEFAULT 0, highlight_data_id INTEGER DEFAULT 0, last_msgid_from_me LONG DEFAULT 0, map_type INTEGER DEFAULT -1);";
    public static final String SQL_CREATE_TABLE_DAILOG_RECORD = "CREATE TABLE dialog_record ( category INTEGER ,contacter LONG, localmsgid LONG, dialogueMsgid INTEGER, state INTEGER,update_time LONG,jump INTEGER,  PRIMARY KEY (category,contacter));";
    public static final String SQL_CREATE_TABLE_FRIEND_GROUP = "CREATE TABLE friendgroup (_id INTEGER PRIMARY KEY AUTOINCREMENT , friend_group_id LONG, friend_group_name TEXT);";
    public static final String SQL_CREATE_TABLE_FRIEND_REALTION = "CREATE TABLE friendrelation (_id LONG PRIMARY KEY, friend_group_id LONG, uid LONG, friend_status INTEGER, friend_status_reverse INTEGER );";
    public static final String SQL_CREATE_TABLE_GROUPINFO = "CREATE TABLE groupinfo (group_id LONG PRIMARY KEY, group_name TEXT, description TEXT, group_type INTEGER);";
    public static final String SQL_CREATE_TABLE_GROUP_MEMBER = "CREATE TABLE groupmember (_id LONG PRIMARY KEY, group_id LONG, uid LONG, name TEXT, role INTEGER );";
    public static final String SQL_CREATE_TABLE_MEDIA_CHAT_SESSION = "CREATE TABLE media_session (_id LONG PRIMARY KEY,category INTEGER, contacter LONG, contacter_bduid LONG, name TEXT, last_msg TEXT, last_msg_time LONG, new_msg_sum INTEGER, chat_type INTEGER,icon_url TEXT,msg_state INTEGER,paid LONG,isclicked INTEGER, classtype INTEGER DEFAULT 0, classtitle TEXT, classshow INTEGER DEFAULT 0, marktop INTEGER DEFAULT 0, marktoptime LONG, classavatar TEXT, nickname TEXT, v_portrait TEXT, certification TEXT, vip_id TEXT, shield INTEGER, last_msg_bduid LONG DEFAULT 0, last_msg_name TEXT, shield_time LONG, sort_update_time LONG, fetch_mode INTEGER, is_stranger INTEGER, disturb INTEGER DEFAULT 0, last_msgid INTEGER, business INTEGER, imuk LONG, remind_type INTEGER DEFAULT 0, remind_msgid LONG DEFAULT 0, remind_uid LONG DEFAULT 0, remind_role_display_name TEXT, extra TEXT, highlight_desc TEXT, highlight_priority INTEGER DEFAULT 0, highlight_data_id INTEGER DEFAULT 0, last_msgid_from_me LONG DEFAULT 0, UNIQUE (category, contacter, classtype))";
    public static final String SQL_CREATE_TABLE_MEDIA_DRAFT_MESSAGE = "CREATE TABLE media_draft_msg (_id INTEGER PRIMARY KEY AUTOINCREMENT , category INTEGER, contacter LONG, type INTEGER, content TEXT, UNIQUE (category, contacter))";
    public static final String SQL_CREATE_TABLE_MEDIA_MESSAGE = "CREATE TABLE media_message (_id INTEGER PRIMARY KEY AUTOINCREMENT , msgid LONG, from_user LONG, category INTEGER, contacter LONG, type INTEGER, content TEXT, time LONG, is_read INTEGER, status INTEGER, local_url TEXT, isclicked INTEGER,sendid TEXT, buid TEXT, msg_key TEXT, tips_code INTEGER, tips TEXT, contacter_uk LONG, origin_pa TEXT, template_type INTEGER DEFAULT 0, auto_risk_control_status INTEGER DEFAULT 0, UNIQUE (msgid, contacter, category))";
    public static final String SQL_CREATE_TABLE_MESSAGE = "CREATE TABLE message (_id INTEGER PRIMARY KEY AUTOINCREMENT , msgid LONG, from_user LONG, category INTEGER, contacter LONG, type INTEGER, content TEXT, time LONG, is_read INTEGER, link TEXT, status INTEGER, cmd INTEGER, local_url TEXT, iszhida INTEGER,isclicked INTEGER,paid LONG,sendid TEXT, buid TEXT, device_flag INTEGER,msg_key TEXT, service_type TEXT, tips_code INTEGER, tips TEXT, template_type INTEGER DEFAULT 0, expires_time  LONG DEFAULT 0, send_type INTEGER DEFAULT -1, send_scene INTEGER DEFAULT -1, auto_risk_control_status INTEGER DEFAULT 0, origin_pa TEXT)";
    public static final String SQL_CREATE_TABLE_MESSAGE_TAG = "CREATE TABLE message_tag (_id INTEGER PRIMARY KEY AUTOINCREMENT , msgid LONG, from_user LONG, category INTEGER, contacter LONG, type INTEGER, content TEXT, time LONG, is_read INTEGER, link TEXT, status INTEGER, cmd INTEGER, local_url TEXT, iszhida INTEGER,isclicked INTEGER,paid LONG,sendid TEXT, buid TEXT, device_flag INTEGER,msg_key TEXT, service_type TEXT, tips_code INTEGER, tips TEXT, template_type INTEGER DEFAULT 0, expires_time  LONG DEFAULT 0, send_type INTEGER DEFAULT -1, send_scene INTEGER DEFAULT -1, origin_pa TEXT, auto_risk_control_status INTEGER DEFAULT 0, messsage_tag TEXT )";
    public static final String SQL_CREATE_TABLE_PA_CMD_QUEUE = "CREATE TABLE paCmdQueue(_id LONG PRIMARY KEY, uuid TEXT, methodId INTEGER, send_status INTEGER, extra String,priority INTEGER,msg_body TEXT ,type INTEGER);";
    public static final String SQL_CREATE_TABLE_PA_SUBSCRIBE = "CREATE TABLE paSubscribe(_id LONG PRIMARY KEY, paid LONG, nickname TEXT, avatar TEXT, description TEXT, url TEXT,acceptpush INTEGER, timestamp LONG, tpl LONG, detail TEXT, disturb INTEGER, pasubtype INTEGER, classtype INTEGER DEFAULT 0, classshow INTEGER DEFAULT 0, status INTEGER DEFAULT 0, classtitle TEXT, marktop INTEGER DEFAULT 0, marktoptime LONG, classavatar TEXT, replies TEXT, refreshtime LONG, subset_type INTEGER DEFAULT 0, pa_ext TEXT, v_portrait TEXT, vip_id TEXT, identity TEXT, has_identity INTEGER, shield INTEGER, shield_time LONG, subscribe INTEGER, has_reject_menu INTEGER DEFAULT 0, pa_imuk LONG, pa_bduid LONG, business_type INTEGER DEFAULT 0, shield_msg INTEGER DEFAULT 0, third_ext TEXT, map_type INTEGER DEFAULT -1, pa_blockinfo TEXT);";
    public static final String SQL_CREATE_TABLE_USERINFO = "CREATE TABLE userinfo (_id INTEGER PRIMARY KEY AUTOINCREMENT , uid LONG, buid LONG, username TEXT, sex INTEGER, phone INTEGER, user_detail TEXT, tiny_url TEXT, head_url TEXT, account_type INTEGER, ip_exsit INTEGER, ip TEXT, ip_isp TEXT, ip_country TEXT, ip_province TEXT, ip_city TEXT, ip_county TEXT, disturb INTEGER, blacklist INTEGER, v_portrait INTEGER, identity TEXT, last_update_time LONG, shield INTEGER, shield_time LONG, marktop INTEGER, marktop_time LONG, subscribe_status INTEGER, has_special_identity INTEGER, vip_id TEXT, special_identity TEXT, user_ext TEXT, phone_relation INTEGER);";
    public static final String SQL_CREATE_TABLE_ZHIDAINFO = "CREATE TABLE zhida_info ( zhidaid LONG PRIMARY KEY, apikey TEXT,description TEXT, entry_url TEXT,icon_url TEXT,is_subscribe INTEGER,paid LONG,name TEXT,acceptpush INTEGER, sfot_ttl LONG,status INTEGER);";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class BusiAdvAdBtnShowColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_HAS_CLICKED_TODAY = "has_clicked_today";
        public static final String COLUMN_LAST_SHOW_TIME = "last_show_time";
        public static final String COLUMN_SHOW_TIMES_TODAY = "show_times_today";
        public static final String COLUMN_UK = "uk";
        public transient /* synthetic */ FieldHolder $fh;

        public BusiAdvAdBtnShowColumns() {
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

    /* loaded from: classes.dex */
    public static final class BusiAdvCustomMsgColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_AID = "aid";
        public static final String COLUMN_ALLOW_REFUND_STATUS = "allow_refund";
        public static final String COLUMN_CARD_TIP = "cardTip";
        public static final String COLUMN_EVA_AMOUNT = "eva_amount";
        public static final String COLUMN_EVA_HAS_REFUND = "eva_has_refund";
        public static final String COLUMN_EVA_IS_EVA = "eva_is_eva";
        public static final String COLUMN_EVA_IS_FREE = "eva_is_free";
        public static final String COLUMN_EVA_MSG = "eva_msg";
        public static final String COLUMN_EVA_STAR_DESC = "eva_star_desc";
        public static final String COLUMN_EVA_STAR_NUM = "eva_star_num";
        public static final String COLUMN_EVA_SUBTITLE = "eva_subtitle";
        public static final String COLUMN_EVA_TAGS = "eva_tags";
        public static final String COLUMN_EVA_TAG_LIST = "eva_tag_list";
        public static final String COLUMN_EVA_TITLE = "eva_title";
        public static final String COLUMN_EVA_TYPE = "eva_type";
        public static final String COLUMN_ORDER_TYPE = "order_type";
        public static final String COLUMN_REFUND_STATUS = "refund_status";
        public static final String COLUMN_REFUND_TEXT = "refund_text";
        public static final String COLUMN_REFUND_TITLE = "refund_title";
        public static final String COLUMN_REFUND_URL_TEXT = "refund_url_text";
        public static final String COLUMN_REPLAYER_UID = "replyer_uid";
        public static final String COLUMN_ROLE = "role";
        public static final String COLUMN_SOP_LIST = "sopList";
        public static final String COLUMN_SOP_TITLE = "sopTitle";
        public static final String COLUMN_SOURCE = "source";
        public static final String COLUMN_TARGET_MSGID = "target_msgid";
        public static final String COLUMN_UK = "uk";
        public transient /* synthetic */ FieldHolder $fh;

        public BusiAdvCustomMsgColumns() {
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

    /* loaded from: classes.dex */
    public static final class BusiChatMsgColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUME_TIPS = "tips";
        public static final String COLUME_TIPS_CODE = "tips_code";
        public static final String COLUMN_BUSINESS_TYPE = "business_type";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CMD = "cmd";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_CONTACTER_IS_READ = "contacter_is_read";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_DEVICE_FLAG = "device_flag";
        public static final String COLUMN_DIALOGUE_ID = "dialogue_id";
        public static final String COLUMN_FROM_BUID = "from_buid";
        public static final String COLUMN_FROM_USER = "from_user";
        public static final String COLUMN_IS_READ = "is_read";
        public static final String COLUMN_LOGIC_DEL = "logic_del";
        public static final String COLUMN_MSGID = "msgid";
        public static final String COLUMN_MSGKEY = "msg_key";
        public static final String COLUMN_SEND_MSGID = "sendid";
        public static final String COLUMN_SESSION_TYPE = "session_type";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_TO_BDUID = "to_buid";
        public static final String COLUMN_TYPE = "type";
        public transient /* synthetic */ FieldHolder $fh;

        public BusiChatMsgColumns() {
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

    /* loaded from: classes.dex */
    public static final class BusiDialogueIdColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_BUSINESS_TYPE = "business_type";
        public static final String COLUMN_DIALOGUEID = "dialogue_id";
        public static final String COLUMN_RESOURCE_ID = "resource_id";
        public transient /* synthetic */ FieldHolder $fh;

        public BusiDialogueIdColumns() {
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

    /* loaded from: classes.dex */
    public static final class BusiSessionColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_AID_TYPE = "last_aid_type";
        public static final String COLUMN_BDUID = "bduid";
        public static final String COLUMN_BUSINESS_TYPE = "business";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CHAT_TYPE = "chat_type";
        public static final String COLUMN_CLASSAVATAR = "classavatar";
        public static final String COLUMN_CLASSSHOW = "classshow";
        public static final String COLUMN_CLASSTITLE = "classtitle";
        public static final String COLUMN_CLASSTYPE = "classtype";
        public static final String COLUMN_COLLECT_STATUS = "collect_status";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_DIALOGUE_STATUS = "last_dialogue_status";
        public static final String COLUMN_DRAFT = "msg_draft";
        public static final String COLUMN_EXTRA = "extra";
        public static final String COLUMN_ICON_URL = "icon_url";
        public static final String COLUMN_LAST_ANSWER_UK = "last_answer_uk";
        public static final String COLUMN_LAST_ASK_UK = "last_ask_uk";
        public static final String COLUMN_LAST_DIALOGUE_ID = "last_dialogue_id";
        public static final String COLUMN_LAST_MSG = "last_msg";
        public static final String COLUMN_LAST_MSG_DESC = "last_msg_desc";
        public static final String COLUMN_LAST_MSG_ID = "last_msg_id";
        public static final String COLUMN_LAST_MSG_TIME = "last_msg_time";
        public static final String COLUMN_LAST_RESOURCE_ID = "last_resource_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NEW_MSG_SUM = "new_msg_sum";
        public static final String COLUMN_SESSION_TYPE = "session_type";
        public static final String COLUMN_STATUS_SHOW = "last_dialogue_status_show";
        public static final String COLUMN_SUBSCRIBE_STATUS = "subscribe_status";
        public static final String COLUMN_V_PORTRAIT = "v_portrait";
        public transient /* synthetic */ FieldHolder $fh;

        public BusiSessionColumns() {
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

    /* loaded from: classes.dex */
    public static final class DRColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_DAILOGUE_MSGID = "dialogueMsgid";
        public static final String COLUMN_JUMP_TO_RECENT = "jump";
        public static final String COLUMN_MAXMSGID = "localmsgid";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_UPDATE_TIME = "update_time";
        public transient /* synthetic */ FieldHolder $fh;

        public DRColumns() {
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

    /* loaded from: classes.dex */
    public static final class FriendGroupColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_FRIEND_GROUP_ID = "friend_group_id";
        public static final String COLUMN_FRIEND_GROUP_NAME = "friend_group_name";
        public transient /* synthetic */ FieldHolder $fh;

        public FriendGroupColumns() {
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

    /* loaded from: classes.dex */
    public static final class FriendRelationColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_FRIEND_GROUP_ID = "friend_group_id";
        public static final String COLUMN_REVERSE_STATUS = "friend_status_reverse";
        public static final String COLUMN_STATUS = "friend_status";
        public static final String COLUMN_UID = "uid";
        public transient /* synthetic */ FieldHolder $fh;

        public FriendRelationColumns() {
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

    /* loaded from: classes.dex */
    public static final class GroupInfoColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_GROUP_ID = "group_id";
        public static final String COLUMN_GROUP_TYPE = "group_type";
        public static final String COLUMN_NAME = "group_name";
        public transient /* synthetic */ FieldHolder $fh;

        public GroupInfoColumns() {
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

    /* loaded from: classes.dex */
    public static final class GroupMemberColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_GROUP_ID = "group_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ROLE = "role";
        public static final String COLUMN_UID = "uid";
        public transient /* synthetic */ FieldHolder $fh;

        public GroupMemberColumns() {
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

    /* loaded from: classes.dex */
    public static final class MediaDraftMsg implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_TYPE = "type";
        public transient /* synthetic */ FieldHolder $fh;

        public MediaDraftMsg() {
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

    /* loaded from: classes.dex */
    public static final class MediaMessageColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUME_TIPS = "tips";
        public static final String COLUME_TIPS_CODE = "tips_code";
        public static final String COLUMN_AUTO_RISK_CONTROL_STATUS = "auto_risk_control_status";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_CONTACTER_UK = "contacter_uk";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_FROM_BUID = "buid";
        public static final String COLUMN_FROM_USER = "from_user";
        public static final String COLUMN_IS_CLICKED = "isclicked";
        public static final String COLUMN_IS_READ = "is_read";
        public static final String COLUMN_LOCAL_URL = "local_url";
        public static final String COLUMN_MSGID = "msgid";
        public static final String COLUMN_MSGKEY = "msg_key";
        public static final String COLUMN_ORIGIN_PA = "origin_pa";
        public static final String COLUMN_SEND_MSGID = "sendid";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TEMPLATE = "template_type";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_TYPE = "type";
        public transient /* synthetic */ FieldHolder $fh;

        public MediaMessageColumns() {
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

    /* loaded from: classes.dex */
    public static final class MediaSessionColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_BUSINESS_TYPE = "business";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CERTIFICATION = "certification";
        public static final String COLUMN_CHAT_TYPE = "chat_type";
        public static final String COLUMN_CLASSAVATAR = "classavatar";
        public static final String COLUMN_CLASSSHOW = "classshow";
        public static final String COLUMN_CLASSTITLE = "classtitle";
        public static final String COLUMN_CLASSTYPE = "classtype";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_CONTACTER_BAUID = "contacter_bduid";
        public static final String COLUMN_CONTACTER_IMUK = "imuk";
        public static final String COLUMN_DISTURB = "disturb";
        public static final String COLUMN_EXTRA = "extra";
        public static final String COLUMN_HIGHLIGHT_DATA_ID = "highlight_data_id";
        public static final String COLUMN_HIGHLIGHT_DESC = "highlight_desc";
        public static final String COLUMN_HIGHLIGHT_PRIORITY = "highlight_priority";
        public static final String COLUMN_ICON_URL = "icon_url";
        public static final String COLUMN_IS_CLICKED = "isclicked";
        public static final String COLUMN_LAST_MSG = "last_msg";
        public static final String COLUMN_LAST_MSGID = "last_msgid";
        public static final String COLUMN_LAST_MSGID_FROM_ME = "last_msgid_from_me";
        public static final String COLUMN_LAST_MSG_BDUID = "last_msg_bduid";
        public static final String COLUMN_LAST_MSG_NICKNAME = "last_msg_name";
        public static final String COLUMN_LAST_MSG_TIME = "last_msg_time";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NEW_MSG_SUM = "new_msg_sum";
        public static final String COLUMN_NICKNAME = "nickname";
        public static final String COLUMN_PAID = "paid";
        public static final String COLUMN_REMIND_MSGID = "remind_msgid";
        public static final String COLUMN_REMIND_ROLE_DISPLAY_NAME = "remind_role_display_name";
        public static final String COLUMN_REMIND_TYPE = "remind_type";
        public static final String COLUMN_REMIND_UID = "remind_uid";
        public static final String COLUMN_SESSION_MODE = "fetch_mode";
        public static final String COLUMN_SESSION_STRANGER = "is_stranger";
        public static final String COLUMN_SHIELD = "shield";
        public static final String COLUMN_SHIELD_TIME = "shield_time";
        public static final String COLUMN_SORT_UPDATE_TIME = "sort_update_time";
        public static final String COLUMN_STATE = "msg_state";
        public static final String COLUMN_TOP = "marktop";
        public static final String COLUMN_TOPTIME = "marktoptime";
        public static final String COLUMN_VIP_ID = "vip_id";
        public static final String COLUMN_V_PORTRAIT = "v_portrait";
        public transient /* synthetic */ FieldHolder $fh;

        public MediaSessionColumns() {
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

    /* loaded from: classes.dex */
    public static final class MessageColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUME_EXPIRES_TIME = "expires_time";
        public static final String COLUME_SERVICE_TYPE = "service_type";
        public static final String COLUME_TEMPLATE = "template_type";
        public static final String COLUME_TIPS = "tips";
        public static final String COLUME_TIPS_CODE = "tips_code";
        public static final String COLUMN_AUTO_RISK_CONTROL_STATUS = "auto_risk_control_status";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CMD = "cmd";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_DEVICE_FLAG = "device_flag";
        public static final String COLUMN_FROM_BUID = "buid";
        public static final String COLUMN_FROM_USER = "from_user";
        public static final String COLUMN_ISZHIDA = "iszhida";
        public static final String COLUMN_IS_CLICKED = "isclicked";
        public static final String COLUMN_IS_READ = "is_read";
        public static final String COLUMN_LINK = "link";
        public static final String COLUMN_LOCAL_URL = "local_url";
        public static final String COLUMN_LOGIC_DEL = "logic_del";
        public static final String COLUMN_MSGID = "msgid";
        public static final String COLUMN_MSGKEY = "msg_key";
        public static final String COLUMN_ORIGIN_PA = "origin_pa";
        public static final String COLUMN_PAID = "paid";
        public static final String COLUMN_SEND_MSGID = "sendid";
        public static final String COLUMN_SEND_SCENE = "send_scene";
        public static final String COLUMN_SEND_TYPE = "send_type";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_TYPE = "type";
        public transient /* synthetic */ FieldHolder $fh;

        public MessageColumns() {
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

    /* loaded from: classes.dex */
    public static final class MessageTagColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_MESSAGE_TAG = "messsage_tag";
        public transient /* synthetic */ FieldHolder $fh;

        public MessageTagColumns() {
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

    /* loaded from: classes.dex */
    public static final class NoDuplicateMessageColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_FROM_USER = "from_user";
        public static final String COLUMN_INPUT_TIME = "input_time";
        public static final String COLUMN_MSGID = "msgid";
        public static final String COLUMN_MSG_KEY = "msg_key";
        public static final String COLUMN_MSG_TYPE = "type";
        public transient /* synthetic */ FieldHolder $fh;

        public NoDuplicateMessageColumns() {
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

    /* loaded from: classes.dex */
    public static final class PaCmdQueueColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_EXTRA_DATA = "extra";
        public static final String COLUMN_METHOD_ID = "methodId";
        public static final String COLUMN_PARAM = "msg_body";
        public static final String COLUMN_PRIORITY = "priority";
        public static final String COLUMN_SEND_STATUS = "send_status";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_UUID = "uuid";
        public transient /* synthetic */ FieldHolder $fh;

        public PaCmdQueueColumns() {
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

    /* loaded from: classes.dex */
    public static final class PaSubscribeColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_ACCEPT_PUSH = "acceptpush";
        public static final String COLUMN_AVATAR = "avatar";
        public static final String COLUMN_BLOCK_INFO = "pa_blockinfo";
        public static final String COLUMN_BUSINESS_TYPE = "business_type";
        public static final String COLUMN_CLASSAVATAR = "classavatar";
        public static final String COLUMN_CLASSSHOW = "classshow";
        public static final String COLUMN_CLASSTITLE = "classtitle";
        public static final String COLUMN_CLASSTYPE = "classtype";
        public static final String COLUMN_DESPCRIPTION = "description";
        public static final String COLUMN_DETAIL = "detail";
        public static final String COLUMN_DISTURB = "disturb";
        public static final String COLUMN_HAS_IDENTITY = "has_identity";
        public static final String COLUMN_IDENTITY = "identity";
        public static final String COLUMN_MAP_TYPE = "map_type";
        public static final String COLUMN_NICKNAME = "nickname";
        public static final String COLUMN_PA_BDUID = "pa_bduid";
        public static final String COLUMN_PA_EXT = "pa_ext";
        public static final String COLUMN_PA_ID = "paid";
        public static final String COLUMN_PA_IMUK = "pa_imuk";
        public static final String COLUMN_REFRESH_TIME = "refreshtime";
        public static final String COLUMN_REJECT_MENU = "has_reject_menu";
        public static final String COLUMN_REPLIES = "replies";
        public static final String COLUMN_SHIELD = "shield";
        public static final String COLUMN_SHIELD_MSG = "shield_msg";
        public static final String COLUMN_SHIELD_TIME = "shield_time";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_SUBSCRIBE = "subscribe";
        public static final String COLUMN_SUBSET_TYPE = "subset_type";
        public static final String COLUMN_SUBTYPE = "pasubtype";
        public static final String COLUMN_SUB_TIME = "timestamp";
        public static final String COLUMN_THIRD_EXT = "third_ext";
        public static final String COLUMN_TOP = "marktop";
        public static final String COLUMN_TOPTIME = "marktoptime";
        public static final String COLUMN_TPL = "tpl";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_VIP_ID = "vip_id";
        public static final String COLUMN_V_PORTRAIT = "v_portrait";
        public transient /* synthetic */ FieldHolder $fh;

        public PaSubscribeColumns() {
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

    /* loaded from: classes.dex */
    public static final class ReliableMessageColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_CREATE_TIME = "create_time";
        public static final String COLUMN_FROM_USER = "from_user";
        public static final String COLUMN_IS_READ = "is_read";
        public static final String COLUMN_MCAST_ID = "mcast_id";
        public static final String COLUMN_MSGID = "msgid";
        public static final String COLUMN_MSG_KEY = "msg_key";
        public static final String COLUMN_PRIORITY = "priority";
        public static final String COLUMN_TYPE = "type";
        public transient /* synthetic */ FieldHolder $fh;

        public ReliableMessageColumns() {
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

    /* loaded from: classes.dex */
    public static final class SessionColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CERTIFICATION = "certification";
        public static final String COLUMN_CHAT_TYPE = "chat_type";
        public static final String COLUMN_CLASSAVATAR = "classavatar";
        public static final String COLUMN_CLASSSHOW = "classshow";
        public static final String COLUMN_CLASSTITLE = "classtitle";
        public static final String COLUMN_CLASSTYPE = "classtype";
        public static final String COLUMN_COLLECTION_TYPE = "collection_type";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_DISTURB = "disturb";
        public static final String COLUMN_EXTRA = "extra";
        public static final String COLUMN_GAMEHISTORY = "game_vs_history";
        public static final String COLUMN_HIGHLIGHT_DATA_ID = "highlight_data_id";
        public static final String COLUMN_HIGHLIGHT_DESC = "highlight_desc";
        public static final String COLUMN_HIGHLIGHT_PRIORITY = "highlight_priority";
        public static final String COLUMN_ICON_URL = "icon_url";
        public static final String COLUMN_IS_CLICKED = "isclicked";
        public static final String COLUMN_LAST_MSG = "last_msg";
        public static final String COLUMN_LAST_MSGID_FROM_ME = "last_msgid_from_me";
        public static final String COLUMN_LAST_MSG_BDUID = "last_msg_bduid";
        public static final String COLUMN_LAST_MSG_NICKNAME = "last_msg_name";
        public static final String COLUMN_LAST_MSG_TIME = "last_msg_time";
        public static final String COLUMN_LAST_OPEN_TIME = "last_open_time";
        public static final String COLUMN_MAP_TYPE = "map_type";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NEW_MSG_SUM = "new_msg_sum";
        public static final String COLUMN_NICKNAME = "nickname";
        public static final String COLUMN_PAID = "paid";
        public static final String COLUMN_REMIND_MSGID = "remind_msgid";
        public static final String COLUMN_REMIND_ROLE_DISPLAY_NAME = "remind_role_display_name";
        public static final String COLUMN_REMIND_TYPE = "remind_type";
        public static final String COLUMN_REMIND_UID = "remind_uid";
        public static final String COLUMN_SESSION_STRANGER = "is_stranger";
        public static final String COLUMN_SHIELD = "shield";
        public static final String COLUMN_SHIELD_TIME = "shield_time";
        public static final String COLUMN_SHOW = "show";
        public static final String COLUMN_STATE = "msg_state";
        public static final String COLUMN_TOP = "marktop";
        public static final String COLUMN_TOPTIME = "marktoptime";
        public static final String COLUMN_VIP_ID = "vip_id";
        public static final String COLUMN_V_PORTRAIT = "v_portrait";
        public static final String COLUMN_WEIGHT = "weight";
        public transient /* synthetic */ FieldHolder $fh;

        public SessionColumns() {
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

    /* loaded from: classes.dex */
    public static final class StudioUsePaMessageColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_CONTACTER = "contacter";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_FROM_USER = "from_user";
        public static final String COLUMN_INPUT_TIME = "input_time";
        public static final String COLUMN_IS_READ = "is_read";
        public static final String COLUMN_MSGID = "msgid";
        public static final String COLUMN_MSG_KEY = "msg_key";
        public static final String COLUMN_MSG_TYPE = "type";
        public transient /* synthetic */ FieldHolder $fh;

        public StudioUsePaMessageColumns() {
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

    /* loaded from: classes.dex */
    public static final class UserInfoColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_ACCOUNTTYPE = "account_type";
        public static final String COLUMN_BAIDU_UID = "buid";
        public static final String COLUMN_BLACKLIST = "blacklist";
        public static final String COLUMN_DISTURB = "disturb";
        public static final String COLUMN_HAS_SPECIAL_IDENTITY = "has_special_identity";
        public static final String COLUMN_HEAD_URL = "head_url";
        public static final String COLUMN_IDENTITY = "identity";
        public static final String COLUMN_IP = "ip";
        public static final String COLUMN_IP_CITY = "ip_city";
        public static final String COLUMN_IP_COUNTRY = "ip_country";
        public static final String COLUMN_IP_COUNTY = "ip_county";
        public static final String COLUMN_IP_EXSIT = "ip_exsit";
        public static final String COLUMN_IP_ISP = "ip_isp";
        public static final String COLUMN_IP_PROVINCE = "ip_province";
        public static final String COLUMN_MARKTOP = "marktop";
        public static final String COLUMN_MARKTOP_TIME = "marktop_time";
        public static final String COLUMN_NAME = "username";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_PHONE_RELATION = "phone_relation";
        public static final String COLUMN_SEX = "sex";
        public static final String COLUMN_SHIELD = "shield";
        public static final String COLUMN_SHIELD_TIME = "shield_time";
        public static final String COLUMN_SPECIAL_IDENTITY = "special_identity";
        public static final String COLUMN_SUBSCRIBE_STATUS = "subscribe_status";
        public static final String COLUMN_TINY_URL = "tiny_url";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_UPDATE_TIME = "last_update_time";
        public static final String COLUMN_USER_DETAIL = "user_detail";
        public static final String COLUMN_USER_EXT = "user_ext";
        public static final String COLUMN_VIP_ID = "vip_id";
        public static final String COLUMN_V_PORTRAIT = "v_portrait";
        public transient /* synthetic */ FieldHolder $fh;

        public UserInfoColumns() {
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

    /* loaded from: classes.dex */
    public static final class ZhiDaColumns implements BaseColumns {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String COLUMN_ACCEPT_PUSH = "acceptpush";
        public static final String COLUMN_APIKEY = "apikey";
        public static final String COLUMN_APPID = "zhidaid";
        public static final String COLUMN_DESC = "description";
        public static final String COLUMN_ENTRY = "entry_url";
        public static final String COLUMN_ICON_URL = "icon_url";
        public static final String COLUMN_IS_SUBSCRIBE = "is_subscribe";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PA_ID = "paid";
        public static final String COLUMN_SOFTTTL = "sfot_ttl";
        public static final String COLUMN_STATUS = "status";
        public transient /* synthetic */ FieldHolder $fh;

        public ZhiDaColumns() {
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

    public TableDefine() {
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
