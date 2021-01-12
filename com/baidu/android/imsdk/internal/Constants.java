package com.baidu.android.imsdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.Random;
/* loaded from: classes3.dex */
public final class Constants {
    public static final int ACK_MAX_SIZE = 20;
    public static final String ACTION_METHOD = "com.baidu.android.imsdk.action.METHOD";
    public static final String ACTION_SERVICE = "com.baidu.android.imsdk.action.IM_SERVICE";
    public static final String ACTION_START = "com.baidu.android.imsdk.action.SERVICE_START";
    public static final String ACTION_STOP = "com.baidu.android.imsdk.action.SERVICE_STOP";
    public static final String API_KEY = "api_key";
    public static final long APPID_HAOKAN = 10660069;
    public static final long APPID_HAOKAN_JISU = 18406321;
    public static final long APPID_QUANMIN = 11564577;
    public static final long APPID_TIEBA = 10773430;
    public static final long APPID_YIMEI = 16595346;
    public static final String BIG_VERSION = "6";
    public static final int CHATSESSION_OPERATION_DELETE = 2;
    public static final int CHATSESSION_OPERATION_NONE = 3;
    public static final int CHATSESSION_OPERATION_UPDATE = 1;
    public static final int CLEAR_AFTER_LOGOUT = 1;
    public static final String CONNECT_STATE = "com.baidu.android.imsdk.connect_state";
    public static final long CRM_ZHIDAID_NOT_SET = -2;
    public static final int CUID_GET_TOKEN_MAX_TIMES = 3;
    public static final long DEFAULT_APPID = -1;
    public static final int DEFAULT_BDDNS_INIT_VALUE = 1;
    public static final int DEFAULT_CONN_TYPE_VALUE = 0;
    public static final int DEFAULT_PA = -1;
    public static final int DEFAULT_RESTAPI_DISABLE_VALUE = 0;
    public static final int DEFAULT_TRIGGER_ID = 0;
    public static final long DEFAULT_UK = 0;
    public static final int DEFAULT_UPLOAD_ENABLE_VALUE = 1;
    public static final int DEFAULT_UPLOAD_INIT_VALUE = 0;
    public static final int DEFAULT_USER_SETTING_NOT_CONCERNED = 0;
    public static final String DEVICE_TYPE = "6";
    public static final String ERROR_LOGIN_STATE_ERROR = "login state error!";
    public static final String ERROR_MSG_ACCOUNT_NOT_LOGIN = "Account not login! pls login first!";
    public static final String ERROR_MSG_CONNECT_SERVER_ERROR = "Connect server fail!";
    public static final String ERROR_MSG_HTTP_IOEXCEPTION_ERROR = "http ioexception!";
    public static final String ERROR_MSG_HTTP_RESPONSE_ERROR = "http response is error!";
    public static final String ERROR_MSG_INTERNAL_DB_ERROR = "db operation error!";
    public static final String ERROR_MSG_JSON_PARSE_EXCEPTION = "parse json exception!";
    public static final String ERROR_MSG_MD5_EMPTY = "byte empty";
    public static final String ERROR_MSG_MD5_NULL = "byte null";
    public static final String ERROR_MSG_NETWORK_ERROR = "Network error!";
    public static final String ERROR_MSG_NOT_MEDIA_ROLE_ERROR = "not amedia role";
    public static final String ERROR_MSG_PARAMETER_ERROR = "Parameter error!";
    public static final String ERROR_MSG_SERVER_INTERNAL_ERROR = "Server error!";
    public static final String ERROR_MSG_SERVICE_ERROR = "service exception";
    public static final String ERROR_MSG_SUCCESS = "Sucess!";
    public static final String EXTRA_ALARM_ALERT = "AlarmAlert";
    public static final String EXTRA_BAIDU_UID = "buid";
    public static final String EXTRA_BAIDU_UIDS = "users_buid";
    public static final String EXTRA_BEGIN_MSGID = "msgid_begin";
    public static final String EXTRA_CANCEL_ALARM = "cancel_alarm";
    public static final String EXTRA_CAST_ID = "mcast_id";
    public static final String EXTRA_CAST_IDS = "mcast_ids";
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_CLEAR_AFTER_LOGOUT = "clear_after_logout";
    public static final String EXTRA_CLIENT_MAX_MSGID = "client_max_msgid";
    public static final String EXTRA_CONFIG_CURSOR = "cursor";
    public static final String EXTRA_CONFIG_LIMIT = "limit";
    public static final String EXTRA_CONTACTER = "contacter";
    public static final String EXTRA_CONTACTER_IS_ZHIDA = "contacter_is_zhida";
    public static final String EXTRA_DEL_MSG_IDS = "del_msg_ids";
    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_DISCONNECT = "disconnect_initital";
    public static final String EXTRA_END_MSGID = "msgid_end";
    public static final String EXTRA_FRIEND_GROUP_ID = "friend_group";
    public static final String EXTRA_FRIEND_GROUP_NAME = "friend_group_name";
    public static final String EXTRA_GROUP_ID = "group_id";
    public static final String EXTRA_GROUP_MEMBERS = "group_members";
    public static final String EXTRA_HEART_BEAT_ROOM = "mcastids";
    public static final String EXTRA_INTERNAL_LOGIN = "internal_login";
    public static final String EXTRA_JUMP_MSG = "jump_msg";
    public static final String EXTRA_LISTENER_ID = "listener_id";
    public static final String EXTRA_LOGIN_CFROM = "login_cfrom";
    public static final String EXTRA_LOGIN_FROM = "login_from";
    public static final String EXTRA_LOGIN_ID = "login_id";
    public static final String EXTRA_METHOD = "method";
    public static final String EXTRA_MSG_COUNT = "count";
    public static final String EXTRA_MSG_ID = "msgid";
    public static final String EXTRA_OPT_CODE = "opt_code";
    public static final String EXTRA_OPT_EXT = "opt_ext";
    public static final String EXTRA_PA_ACCEPT_PUSH = "pa_accept_push";
    public static final String EXTRA_PA_ID = "pa_id";
    public static final String EXTRA_PA_INFO = "pa_info";
    public static final String EXTRA_PA_SEARCH_CONTENT = "pa_search_content";
    public static final String EXTRA_PUSH_APP_ID = "push_app_id";
    public static final String EXTRA_PUSH_CHANNEL_ID = "push_channel_id";
    public static final String EXTRA_PUSH_USER_ID = "push_user_id";
    public static final String EXTRA_RETRY_TIME = "retry_time";
    public static final String EXTRA_ROOM_ID = "room_id";
    public static final String EXTRA_SAVE_TO_DB = "save_to_db";
    public static final String EXTRA_SEND_MSG = "send_msg";
    public static final String EXTRA_SERVICE = "service_id";
    public static final String EXTRA_TARGET_USER = "target_user";
    public static final String EXTRA_TRIGGER_REASON = "trigger_reason";
    public static final String EXTRA_UID = "uid";
    public static final String EXTRA_UIDS = "users_id";
    public static final String EXTRA_USERS_SYNC = "users_info_sync";
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 32;
    public static final String FRINEDGROUP_PREFIX = "FRIENDGROUP";
    public static final byte GZIP_CAST_TYPE = 11;
    public static final int IM_CAST_BUSY = 1316;
    public static final String IM_INIT_TRACK_UPLOAD = "com.baidu.imsdk.init.track.upload";
    public static final int IM_IP_LOCATION_EXSIT = 0;
    public static final int IM_IP_LOCATION_NOT_EXSIT = 1;
    public static final int IM_SERVICE_ID = 2;
    public static final int IM_TRACK_DURATION_MS = 21600000;
    public static final String IM_TRACK_FAIL_COUNT = "com.baidu.imsdk.track.failcount";
    public static final String IM_TRACK_TIME = "com.baidu.imsdk.track";
    public static final String IM_TRACK_UPLOAD = "com.baidu.imsdk.track.upload";
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_ACCOUNT_PRIVATE = "account_private";
    public static final String KEY_APPID = "appid";
    public static final String KEY_BDDNS_TYPE = "bddns_enable_value";
    public static final String KEY_BUID = "buid";
    public static final String KEY_CONFIG_IDS = "push_config_msg_ids";
    public static final String KEY_CONFIG_MAXCURSOR = "config_maxcursor";
    public static final String KEY_CONN_TYPE = "socket_conn_type";
    public static final String KEY_CUID_AUTHORITY = "cuid_authority";
    public static final String KEY_CUID_GENERATE_TOKEN = "cuid_generate_token";
    public static final String KEY_CURRENT_PAID = "current_paid";
    public static final String KEY_CURRENT_ZHIDAID = "current_zhidaid";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_ENV = "key_env";
    public static final String KEY_ISINITIALTIVEDISCONNECT = "isinitial_disconnect";
    public static final String KEY_JUMP_TO_RECENT_MSG = "jump_to_recent_msg";
    public static final String KEY_LOGIN_CALL_TIME = "login_call_time";
    public static final String KEY_LOGIN_COOKIE = "login_cookie";
    public static final String KEY_LOGIN_CUID = "login_cuid";
    public static final String KEY_LOGIN_FLAG = "login_flag_state";
    public static final String KEY_LOGIN_FLAG_EXT = "login_flag_ext";
    public static final String KEY_LOGIN_OPEN_TYPE = "login_open_type";
    public static final String KEY_LOGIN_ROLE = "login_role";
    public static final String KEY_LOGIN_TYPE = "login_type";
    public static final String KEY_MEMBER_UPDATE = "member_update";
    public static final String KEY_NOTIFY_PAID = "notify_paid";
    public static final String KEY_PASSPORT_UID = "passport_uid";
    public static final String KEY_PA_SUBSCRIBE_SYNC_TIME = "sub_pa_sync_time";
    public static final String KEY_PRODUCT_LINE = "product_line";
    public static final String KEY_PRODUCT_VERSION = "product_version";
    public static final String KEY_PUSH_APP_ID = "push_appId";
    public static final String KEY_PUSH_BIND_STATUS = "push_bindCUID_status";
    public static final String KEY_PUSH_CHANNEL_ID = "push_channelId";
    public static final String KEY_PUSH_USER_ID = "push_userId";
    public static final String KEY_STUDIO_IS_HOST_SEND_MSG = "is_host_send_msg";
    public static final String KEY_SYNC_DAILOG_MAXMSGID = "sync_max_msgid";
    public static final String KEY_SYNC_FIRST_TIME = "sync first time";
    public static final String KEY_SYNC_MSG_TAB_TIME = "sync_msg_tab_time";
    public static final String KEY_SYNC_PUSH_TIME = "login_sync_push_time";
    public static final String KEY_TRIGGER_ID = "trigger_id";
    public static final String KEY_UK = "uk";
    public static final String KEY_UPDATE_SWITCH_PA = "update_switch_pa";
    public static final String KEY_UPDATE_SWITCH_USER = "update_switch_user";
    public static final String KEY_USER_SETTING_NOT_CONCERNED = "user_setting_not_concerned";
    public static final String KEY_VCODE = "imsdk_product_vcode";
    public static final String KEY_ZID = "imsdk_product_zid";
    public static final String LITTLE_VERSION = "5";
    public static final int LOGIN_STATE_LOGIN = 3;
    public static final int LOGIN_STATE_LOGINING = 1;
    public static final int LOGIN_STATE_LOGIN_FAILED = 2;
    public static final int LOGIN_STATE_LOGOUT = 6;
    public static final int LOGIN_STATE_LOGOUTING = 4;
    public static final int LOGIN_STATE_LOGOUT_FAILED = 5;
    public static final int LOGIN_STATE_NOT_LOGIN = 0;
    public static final int LOGIN_VERSION = 4;
    public static final int MAX_CONFIG_MSGID_CACHE_SIZE = 1000;
    public static final int MCAST_SERVICE_ID = 3;
    public static final int METHOD_ACK = 95;
    public static final int METHOD_GET_CONTACTER_INFO_FOR_SESSION = 1048577;
    public static final int METHOD_IM_ADD_FRIEND = 53;
    public static final int METHOD_IM_BIND_PUSH_REMOTE = 90;
    public static final int METHOD_IM_CONFIRM_FRIEND = 68;
    public static final int METHOD_IM_DELIVER_CONFIG_MSG = 197;
    public static final int METHOD_IM_DELIVER_MSG = 196;
    public static final int METHOD_IM_DEL_FRIEND = 58;
    public static final int METHOD_IM_DEL_MSG = 57;
    public static final int METHOD_IM_FETCH_CONFIG_MSG = 193;
    public static final int METHOD_IM_FETCH_MSG_BY_MSGID = 93;
    public static final int METHOD_IM_FRIEND_GROUP_ASSIGN = 125;
    public static final int METHOD_IM_FRIEND_GROUP_CREATE = 120;
    public static final int METHOD_IM_FRIEND_GROUP_DROP = 121;
    public static final int METHOD_IM_FRIEND_GROUP_MODIFY = 122;
    public static final int METHOD_IM_FRIEND_GROUP_QUERY = 123;
    public static final int METHOD_IM_FRIEND_GROUP_QUERY_MEMBER = 124;
    public static final int METHOD_IM_GET_FRIEND_LIST = 54;
    public static final int METHOD_IM_GET_GROUP_INFO = 61;
    public static final int METHOD_IM_GET_MY_PA_LIST = 104;
    public static final int METHOD_IM_GET_USERS_PROFILE_BATCH = 71;
    public static final int METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID = 171;
    public static final int METHOD_IM_GET_USER_IP_LOCATION = 91;
    public static final int METHOD_IM_GET_USER_PROFILE = 70;
    public static final int METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID = 170;
    public static final int METHOD_IM_JOIN_CAST = 201;
    public static final int METHOD_IM_MARK_MSG_STATUS = 67;
    public static final int METHOD_IM_NOTIFY = 96;
    public static final int METHOD_IM_QUERY_PRESENCE = 21;
    public static final int METHOD_IM_QUIT_CAST = 202;
    public static final int METHOD_IM_RTC_NOTIFY_MSG = 231;
    public static final int METHOD_IM_SCRIBE_PA = 100;
    public static final int METHOD_IM_SEARCH_PA = 103;
    public static final int METHOD_IM_SEND_GROUP_MSG = 65;
    public static final int METHOD_IM_SEND_MCAST_MSG = 185;
    public static final int METHOD_IM_SEND_MSG = 55;
    public static final int METHOD_IM_SEND_QUIZ_ANSWER_CAST = 210;
    public static final int METHOD_IM_SETTING_PA = 105;
    public static final int METHOD_IM_SUBSCRIBED_PA = 109;
    public static final int METHOD_IM_SYNC_DEVICE_TOKEN = 190;
    public static final int METHOD_IM_UNBIND_PUSH_REMOTE = 92;
    public static final int METHOD_IM_UNSCRIBE_PA = 101;
    public static final int METHOD_IM_USER_LOGIN_BY_TOKEN = 50;
    public static final int METHOD_IM_USER_LOGOUT = 52;
    public static final int METHOD_MEDIA_NOTIFY = 226;
    public static final int METHOD_SEND_USER_MSG = 1048578;
    public static final int METHOD_SYNC_DIALOG = 94;
    public static final String MIDDLE_VERSION = "8";
    public static final int MSG_NOTIFY = 1;
    public static final int MSG_NOT_NOTIFY = 0;
    public static final int NOT_CLEAR_AFTER_LOGOUT = 0;
    public static final int NOT_SAVE_TO_DB = 0;
    public static final long PAFLAG = 17592186044416L;
    public static final String PAGE_BAIJIAHAO_NAME = "baijiahao";
    public static final String PAGE_C2C_NAME = "C2C";
    public static final String PAGE_FUWUXIAOXI_NAME = "fuwuxiaoxi";
    public static final String PAGE_HUDONG_NAME = "hudongxiaoxi";
    public static final String PAGE_QUNXIAOXI_NAME = "qunxiaoxi";
    public static final String PAGE_SHANGXIONGHAO_NAME = "shangxionghao";
    public static final String PAGE_SHOWBAIFUWUHAO_NAME = "shoubaifuwuhao";
    public static final String PAGE_XIAOCHENGXUKEFU_NAME = "xiaochengxukefuxiaoxi";
    public static final int PA_ACCEPT_PUSH = 1;
    public static final int PA_CMD_MSG_SENDING = 2;
    public static final int PA_CMD_MSG_SEND_IDLE = 1;
    public static final int PA_NOT_ACCEPT_PUSH = 0;
    public static final String PREF_COMMON_DATA = "baidu_imsdk_common_data";
    public static final String PREF_RELIABLE_MSG_DATA = "imsdk_reliable_msg_data";
    public static final int RECORD_TO_TOP = 0;
    public static final int RECPRD_UPDATE_CONTENT = 1;
    public static final String RELIABLE_MAX_MSGINFO_KEY = "reliable_msg_info";
    public static final int SAVE_TO_DB = 1;
    public static final String SETTING_DEBUG_MODE = "com.baidu.android.imsdk.Settings.debug_mode";
    public static final byte SHORT_PING_CMD_TYPE = 101;
    public static final int SOCKET_BACKUP_PORT_SSL = 8443;
    public static final int SYNC_FOR_INTERNAL_LOGIN = 1;
    public static final int SYNC_FOR_SERVER_NOTIFY = 2;
    public static final int SYNC_FOR_USER_LOGIN = 0;
    public static final long SYNC_MSG_DELAY_TIME = 10800000;
    public static final int SYNC_USERS_PROFILE_DURATION_MS = 3600000;
    public static final String THREAD_PREFIX = "IM-";
    private static final int TPL_ZHIDA_OL = 6376141;
    private static final int TPL_ZHIDA_RD = 6376141;
    public static final int TYPE_CONNECTION_LONG = 0;
    public static final int TYPE_GET_CHAT_OBJECT = 2;
    public static final String URL_HTTP_BOX = "http://180.97.36.95:8080/";
    public static final String URL_HTTP_ONLINE = "https://pim.baidu.com/";
    public static final String URL_HTTP_QA = "http://10.64.132.67:8080/";
    public static final String URL_HTTP_RD = "http://rd-im-server.bcc-szth.baidu.com:8080/";
    private static final int URL_SOCKET_PORT_OL_BOX = 8100;
    private static final int URL_SOCKET_PORT_QA = 8100;
    private static final int URL_SOCKET_PORT_RD = 8100;
    private static final int URL_SOCKET_PORT_TEST_BOX = 8100;
    public static final int URL_SOCKET_SERVER_CONN_TIME_OUT = 10000;
    private static final String URL_SOCKET_SERVER_OL_BOX = "pimc.baidu.com";
    private static final String URL_SOCKET_SERVER_OL_HQ = "pimc2.baidu.com";
    private static final String URL_SOCKET_SERVER_OL_SSL = "pimc.baidu.com";
    private static final String URL_SOCKET_SERVER_QA = "10.64.132.59";
    private static final String URL_SOCKET_SERVER_RD = "rd-im-server.bcc-szth.baidu.com";
    private static final String URL_SOCKET_SERVER_TEST_BOX = "180.97.36.95";
    public static final String USERINFO_PREFIX = "USERINFO";
    public static final int USER_SETTING_UK_NOT_CONCERNED = -2;
    public static final String ZHIDA_SP_PRE = "prefix_crm_zhida_";
    public static final Long EXPIRED_TIME = 604800000L;
    public static String RELIABLE_MSGID = "msgid";
    public static String RELIABLE_CASTID = "castid";
    public static String RELIABLE_UPDATTIME = "updatetime";
    public static long SYNC_USERS_PROFILE_RANDTIME = new Random().nextInt(12) + 12;
    public static final int SOCKET_PORT_SSL = 443;
    public static int URL_SOCKET_PORT_OL_SSL = SOCKET_PORT_SSL;
    public static String URL_SOCKET_SERVER = "pimc.baidu.com";
    public static final int SOCKET_PORT_TCP = 8100;
    public static int URL_SOCKET_PORT = SOCKET_PORT_TCP;
    public static int IM_ENV = 0;
    public static final String[] mSdkPermissions = {"android.permission.INTERNET", "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_NETWORK_STATE", "android.permission.RECEIVE_BOOT_COMPLETED", "android.permission.VIBRATE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_WIFI_STATE"};

    public static boolean isDebugMode() {
        return IMSettings.isDebugMode();
    }

    public static int getEnv(Context context) {
        if (context == null) {
            LogUtils.e("Constants", "context is null!!!");
            return 0;
        }
        try {
            return Utility.readIntData(context, KEY_ENV, 0);
        } catch (Exception e) {
            return IM_ENV;
        }
    }

    public static boolean setEnv(Context context, int i) {
        long appid = AccountManager.getAppid(context);
        switch (i) {
            case 0:
                if (dispatchToPimc2(appid)) {
                    URL_SOCKET_SERVER = URL_SOCKET_SERVER_OL_HQ;
                    URL_SOCKET_PORT = URL_SOCKET_PORT_OL_SSL;
                    break;
                } else {
                    URL_SOCKET_SERVER = "pimc.baidu.com";
                    URL_SOCKET_PORT = URL_SOCKET_PORT_OL_SSL;
                    break;
                }
            case 1:
                URL_SOCKET_SERVER = URL_SOCKET_SERVER_RD;
                URL_SOCKET_PORT = SOCKET_PORT_TCP;
                break;
            case 2:
                URL_SOCKET_SERVER = URL_SOCKET_SERVER_QA;
                URL_SOCKET_PORT = SOCKET_PORT_TCP;
                break;
            case 3:
                if (dispatchToPimc2(appid)) {
                    URL_SOCKET_SERVER = URL_SOCKET_SERVER_OL_HQ;
                    URL_SOCKET_PORT = URL_SOCKET_PORT_OL_SSL;
                    break;
                } else {
                    URL_SOCKET_SERVER = URL_SOCKET_SERVER_TEST_BOX;
                    URL_SOCKET_PORT = SOCKET_PORT_TCP;
                    break;
                }
        }
        IM_ENV = i;
        if (IM_ENV != getEnv(context)) {
            Utility.writeIntData(context, KEY_ENV, i);
        }
        return true;
    }

    private static boolean dispatchToPimc2(long j) {
        if (j != APPID_HAOKAN && j != APPID_HAOKAN_JISU && j != APPID_QUANMIN && j != APPID_YIMEI && j != APPID_TIEBA) {
            return false;
        }
        return true;
    }

    public static int getTplZhida(Context context) {
        switch (Utility.readIntData(context, KEY_ENV, -1)) {
            case 1:
            case 2:
            default:
                return 6376141;
        }
    }
}
