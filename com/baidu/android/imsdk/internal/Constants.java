package com.baidu.android.imsdk.internal;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.g;
import java.util.Random;
/* loaded from: classes.dex */
public final class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACK_MAX_SIZE = 20;
    public static final String ACTION_METHOD = "com.baidu.android.imsdk.action.METHOD";
    public static final String ACTION_SERVICE = "com.baidu.android.imsdk.action.IM_SERVICE";
    public static final String ACTION_START = "com.baidu.android.imsdk.action.SERVICE_START";
    public static final String ACTION_STOP = "com.baidu.android.imsdk.action.SERVICE_STOP";
    public static final long APPID_BAIDU = 405384;
    public static final long APPID_HAOKAN = 10660069;
    public static final long APPID_HAOKAN_JISU = 18406321;
    public static final long APPID_QUANMIN = 11564577;
    public static final long APPID_TIEBA = 10773430;
    public static final long APPID_YIMEI = 16595346;
    public static final String BIG_VERSION = "10";
    public static final int CLEAR_AFTER_LOGOUT = 1;
    public static final String CONNECT_STATE = "com.baidu.android.imsdk.connect_state";
    public static final long CRM_ZHIDAID_NOT_SET = -2;
    public static final int CUID_GET_TOKEN_MAX_TIMES = 3;
    public static final long DEFAULT_APPID = -1;
    public static final int DEFAULT_BDDNS_INIT_VALUE = 1;
    public static final int DEFAULT_CONN_TYPE_VALUE = 0;
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
    public static final String ERROR_MSG_NO_NET_HIT = "网络不给力，请稍后重试";
    public static final String ERROR_MSG_PARAMETER_ERROR = "Parameter error!";
    public static final String ERROR_MSG_SERVER_INTERNAL_ERROR = "Server error!";
    public static final String ERROR_MSG_SERVICE_ERROR = "service exception";
    public static final String ERROR_MSG_SUCCESS = "Sucess!";
    public static final String EVENT_LIST = "event_list";
    public static final Long EXPIRED_TIME;
    public static final String EXTRA_ALARM_ALERT = "AlarmAlert";
    public static final String EXTRA_BAIDU_UID = "buid";
    public static final String EXTRA_BAIDU_UIDS = "users_buid";
    public static final String EXTRA_BATCH_TYPE = "batch_type";
    public static final String EXTRA_BC_FETCH_TRIGGER_REASON = "fetch_msg_trigger_reason";
    public static final String EXTRA_BC_MEDIA = "media";
    public static final String EXTRA_BC_SET_SESSION_READ_TYPE = "type";
    public static final String EXTRA_BC_TO_SESSION = "to_session";
    public static final String EXTRA_BEGIN_MSGID = "msgid_begin";
    public static final String EXTRA_BUSINESS_FILTER_INFO = "filter_info";
    public static final String EXTRA_BUSINESS_MSG_EXT = "msg_ext";
    public static final String EXTRA_BUSINESS_NOTIFY_TYPE = "notify_type";
    public static final String EXTRA_BUSINESS_TYPE = "bussiness_type";
    public static final String EXTRA_CANCEL_ALARM = "cancel_alarm";
    public static final String EXTRA_CAST_ID = "mcast_id";
    public static final String EXTRA_CAST_IDS = "mcast_ids";
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_CHAT_ROOM_GROUP_ID = "chat_room_group_id";
    public static final String EXTRA_CHAT_TYPE = "chat_type";
    public static final String EXTRA_CLASS_TYPE = "extra_class_type";
    public static final String EXTRA_CLEAR_AFTER_LOGOUT = "clear_after_logout";
    public static final String EXTRA_CLIENT_MAX_MSGID = "client_max_msgid";
    public static final String EXTRA_CONFIG_CURSOR = "cursor";
    public static final String EXTRA_CONFIG_LIMIT = "limit";
    public static final String EXTRA_CONTACTER = "contacter";
    public static final String EXTRA_CONTACTER_IS_ZHIDA = "contacter_is_zhida";
    public static final String EXTRA_CONTACTER_PA_UID = "contacter_pa_uid";
    public static final String EXTRA_CONTACTER_UK = "contacter_uk";
    public static final String EXTRA_CONTACTER_USER_TYPE = "contacter_user_type";
    public static final String EXTRA_DEL_MSG_IDS = "del_msg_ids";
    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_DISCONNECT = "disconnect_initital";
    public static final String EXTRA_EMOJI_CONTENT = "emoji_content";
    public static final String EXTRA_EMOJI_OP_TYPE = "op_type";
    public static final String EXTRA_EMOJI_PACKAGE_ID = "emoji_package_id";
    public static final String EXTRA_EMOJI_TO_USER = "to_user";
    public static final String EXTRA_END_MSGID = "msgid_end";
    public static final String EXTRA_EVENT_LIST = "event_list";
    public static final String EXTRA_FETCH_SESSION_MODE = "fetch_session_mode";
    public static final String EXTRA_FETCH_SESSION_TOP = "fetch_session_top";
    public static final String EXTRA_FRIEND_GROUP_ID = "friend_group";
    public static final String EXTRA_FRIEND_GROUP_NAME = "friend_group_name";
    public static final String EXTRA_FROM_MEDIA = "from_media";
    public static final String EXTRA_GROUP_ID = "group_id";
    public static final String EXTRA_GROUP_MEMBERS = "group_members";
    public static final String EXTRA_HEART_BEAT_ROOM = "mcastids";
    public static final String EXTRA_INTERNAL_LOGIN = "internal_login";
    public static final String EXTRA_IS_STRANGER = "extra_is_stranger";
    public static final String EXTRA_JUMP_MSG = "jump_msg";
    public static final String EXTRA_LISTENER_ID = "listener_id";
    public static final String EXTRA_LOGIN_CFROM = "login_cfrom";
    public static final String EXTRA_LOGIN_FROM = "login_from";
    public static final String EXTRA_LOGIN_ID = "login_id";
    public static final String EXTRA_METHOD = "method";
    public static final String EXTRA_MSG_COUNT = "count";
    public static final String EXTRA_MSG_ID = "msgid";
    public static final String EXTRA_NOTIFY_ID = "notify_id";
    public static final String EXTRA_NOTIFY_MSGID = "notify_msgid";
    public static final String EXTRA_OPT_CODE = "opt_code";
    public static final String EXTRA_OPT_EXT = "opt_ext";
    public static final String EXTRA_PARAM = "param";
    public static final String EXTRA_PAUID_TYPE = "pa_uid";
    public static final String EXTRA_PA_ACCEPT_PUSH = "pa_accept_push";
    public static final String EXTRA_PA_ID = "pa_id";
    public static final String EXTRA_PA_INFO = "pa_info";
    public static final String EXTRA_PA_SEARCH_CONTENT = "pa_search_content";
    public static final String EXTRA_PA_TYPE = "pa_type";
    public static final String EXTRA_PUSH_APP_ID = "push_app_id";
    public static final String EXTRA_PUSH_CHANNEL_ID = "push_channel_id";
    public static final String EXTRA_PUSH_USER_ID = "push_user_id";
    public static final String EXTRA_REMAIN_EMPTY_SESSION = "remain_empty_session";
    public static final String EXTRA_RETRY_TIME = "retry_time";
    public static final String EXTRA_ROOM_ID = "room_id";
    public static final String EXTRA_ROOM_TYPE = "room_type";
    public static final String EXTRA_SAVE_TO_DB = "save_to_db";
    public static final String EXTRA_SCREEN_KEY = "screen_key";
    public static final String EXTRA_SEND_MSG = "send_msg";
    public static final String EXTRA_SERVICE = "service_id";
    public static final String EXTRA_SESSION_TYPE = "session_type";
    public static final String EXTRA_SOURCE = "source";
    public static final String EXTRA_SUB_PA_TYPE = "sub_pa_type";
    public static final String EXTRA_TARGET_USER = "target_user";
    public static final String EXTRA_TO_PAUID_TYPE = "to_pa_uid";
    public static final String EXTRA_TO_USER_TYPE = "to_user_type";
    public static final String EXTRA_TRIGGER_REASON = "trigger_reason";
    public static final String EXTRA_UID = "uid";
    public static final String EXTRA_UIDS = "users_id";
    public static final String EXTRA_USERS_SYNC = "users_info_sync";
    public static final String EXTRA_USER_TYPE = "user_type";
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 32;
    public static final String FRINEDGROUP_PREFIX = "FRIENDGROUP";
    public static final byte GZIP_CAST_TYPE = 11;
    public static final int IM_CAST_BUSY = 1316;
    public static int IM_ENV = 0;
    public static final String IM_INIT_TRACK_UPLOAD = "com.baidu.imsdk.init.track.upload";
    public static final int IM_IP_LOCATION_EXSIT = 0;
    public static final int IM_IP_LOCATION_NOT_EXSIT = 1;
    public static final int IM_SERVICE_ID = 2;
    public static final int IM_TRACK_DURATION_MS = 21600000;
    public static final String IM_TRACK_FAIL_COUNT = "com.baidu.imsdk.track.failcount";
    public static final String IM_TRACK_TIME = "com.baidu.imsdk.track";
    public static final String IM_TRACK_UPLOAD = "com.baidu.imsdk.track.upload";
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_ACCOUNT_MEDIA = "account_media";
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
    public static final String KEY_LOGIN_COOKIE = "login_cookie";
    public static final String KEY_LOGIN_CUID = "login_cuid";
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
    public static final String KEY_STOKEN = "tpl_stoken";
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
    public static final String LITTLE_VERSION = "0";
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
    public static final int METHOD_IM_BATCH_EXIT_CAST = 213;
    public static final int METHOD_IM_BATCH_JOIN_CAST = 212;
    public static final int METHOD_IM_BIND_PUSH_REMOTE = 90;
    public static final int METHOD_IM_CONFIRM_FRIEND = 68;
    public static final int METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG = 239;
    public static final int METHOD_IM_CONSULT_IM_NOTIFY_MSG = 238;
    public static final int METHOD_IM_CONSULT_IM_UPDATE_MSG = 237;
    public static final int METHOD_IM_CONSULT_NOTIFY_MSG = 236;
    public static final int METHOD_IM_DELIVER_CONFIG_MSG = 197;
    public static final int METHOD_IM_DELIVER_MSG = 196;
    public static final int METHOD_IM_DEL_BUSINESS_SESSION_MSG = 199;
    public static final int METHOD_IM_DEL_FRIEND = 58;
    public static final int METHOD_IM_DEL_MSG = 57;
    public static final int METHOD_IM_EMOJI = 214;
    public static final int METHOD_IM_FETCH_BUSINESS_SESSION_MSG = 198;
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
    public static final int METHOD_IM_MARK_BC_SESSION_READ_STATUS = 207;
    public static final int METHOD_IM_MARK_MSG_STATUS = 67;
    public static final int METHOD_IM_NOTIFY = 96;
    public static final int METHOD_IM_QUERY_PRESENCE = 21;
    public static final int METHOD_IM_QUIT_CAST = 202;
    public static final int METHOD_IM_RTC_NOTIFY_MSG = 231;
    public static final int METHOD_IM_RTC_SEND_MSG = 230;
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
    public static final int METHOD_MEDIA_GET_SESSION = 206;
    public static final int METHOD_MEDIA_NOTIFY = 226;
    public static final int METHOD_SEND_USER_MSG = 1048578;
    public static final int METHOD_SYNC_DIALOG = 94;
    public static final String MIDDLE_VERSION = "6";
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
    public static String RELIABLE_CASTID = null;
    public static final String RELIABLE_MAX_MSGINFO_KEY = "reliable_msg_info";
    public static String RELIABLE_MSGID = null;
    public static String RELIABLE_UPDATTIME = null;
    public static final int SAVE_TO_DB = 1;
    public static final String SETTING_DEBUG_MODE = "com.baidu.android.imsdk.Settings.debug_mode";
    public static final byte SHORT_PING_CMD_TYPE = 101;
    public static final int SOCKET_BACKUP_PORT_SSL = 8443;
    public static final int SOCKET_PORT_SSL = 443;
    public static final int SOCKET_PORT_TCP = 8100;
    public static final int SYNC_FOR_INTERNAL_LOGIN = 1;
    public static final int SYNC_FOR_SERVER_NOTIFY = 2;
    public static final int SYNC_FOR_TURN_PAGE = 3;
    public static final int SYNC_FOR_USER_LOGIN = 0;
    public static final long SYNC_MSG_DELAY_TIME = 10800000;
    public static final int SYNC_USERS_PROFILE_DURATION_MS = 3600000;
    public static long SYNC_USERS_PROFILE_RANDTIME = 0;
    public static final String THREAD_PREFIX = "IM-";
    public static final int TPL_ZHIDA_OL = 6376141;
    public static final int TPL_ZHIDA_RD = 6376141;
    public static final int TYPE_CONNECTION_LONG = 0;
    public static final int TYPE_GET_CHAT_OBJECT = 2;
    public static final String URL_HTTP_BOX = "http://180.97.36.95:8080/";
    public static final String URL_HTTP_ONLINE = "https://pim.baidu.com/";
    public static final String URL_HTTP_QA = "http://sz-shaheenv-odprestapi-b.bcc-szwg.baidu.com:8080/";
    public static final String URL_HTTP_RD = "http://rd-im-server.bcc-szth.baidu.com:8080/";
    public static final String URL_HTTP_RD_8111 = "http://rd-im-server.bcc-szth.baidu.com:8111/";
    public static int URL_SOCKET_PORT = 0;
    public static final int URL_SOCKET_PORT_OL_BOX = 8100;
    public static int URL_SOCKET_PORT_OL_SSL = 0;
    public static final int URL_SOCKET_PORT_QA = 8100;
    public static final int URL_SOCKET_PORT_RD = 8100;
    public static final int URL_SOCKET_PORT_TEST_BOX = 8100;
    public static String URL_SOCKET_SERVER = null;
    public static final int URL_SOCKET_SERVER_CONN_TIME_OUT = 10000;
    public static final String URL_SOCKET_SERVER_OL_BOX = "pimc.baidu.com";
    public static final String URL_SOCKET_SERVER_OL_HQ = "pimc2.baidu.com";
    public static final String URL_SOCKET_SERVER_OL_SSL = "pimc.baidu.com";
    public static final String URL_SOCKET_SERVER_QA = "10.64.132.59";
    public static final String URL_SOCKET_SERVER_RD = "rd-im-server.bcc-szth.baidu.com";
    public static final String URL_SOCKET_SERVER_TEST_BOX = "180.97.36.95";
    public static final String USERINFO_PREFIX = "USERINFO";
    public static final int USER_SETTING_UK_NOT_CONCERNED = -2;
    public static final String[] mSdkPermissions;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean dispatchToPimc2(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? j == APPID_HAOKAN || j == APPID_HAOKAN_JISU || j == APPID_QUANMIN || j == APPID_YIMEI || j == 10773430 : invokeJ.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(826624919, "Lcom/baidu/android/imsdk/internal/Constants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(826624919, "Lcom/baidu/android/imsdk/internal/Constants;");
                return;
            }
        }
        EXPIRED_TIME = 604800000L;
        RELIABLE_MSGID = "msgid";
        RELIABLE_CASTID = "castid";
        RELIABLE_UPDATTIME = "updatetime";
        SYNC_USERS_PROFILE_RANDTIME = new Random().nextInt(12) + 12;
        URL_SOCKET_PORT_OL_SSL = 443;
        URL_SOCKET_SERVER = "pimc.baidu.com";
        URL_SOCKET_PORT = 8100;
        IM_ENV = 0;
        mSdkPermissions = new String[]{g.a, g.c, "android.permission.ACCESS_NETWORK_STATE", "android.permission.RECEIVE_BOOT_COMPLETED", "android.permission.VIBRATE", g.h, g.d};
    }

    public Constants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return IMSettings.isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public static int getEnv(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                LogUtils.e("Constants", "context is null!!!");
                return 0;
            }
            try {
                return Utility.readIntData(context, KEY_ENV, 0);
            } catch (Exception unused) {
                return IM_ENV;
            }
        }
        return invokeL.intValue;
    }

    public static int getTplZhida(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            Utility.readIntData(context, KEY_ENV, -1);
            return 6376141;
        }
        return invokeL.intValue;
    }

    public static boolean setEnv(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, context, i)) == null) {
            long appid = AccountManager.getAppid(context);
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            if (dispatchToPimc2(appid)) {
                                URL_SOCKET_SERVER = URL_SOCKET_SERVER_OL_HQ;
                                URL_SOCKET_PORT = URL_SOCKET_PORT_OL_SSL;
                            } else {
                                URL_SOCKET_SERVER = URL_SOCKET_SERVER_TEST_BOX;
                                URL_SOCKET_PORT = 8100;
                            }
                        }
                    } else {
                        URL_SOCKET_SERVER = URL_SOCKET_SERVER_QA;
                        URL_SOCKET_PORT = 8100;
                    }
                } else {
                    URL_SOCKET_SERVER = URL_SOCKET_SERVER_RD;
                    URL_SOCKET_PORT = 8100;
                }
            } else if (dispatchToPimc2(appid)) {
                URL_SOCKET_SERVER = URL_SOCKET_SERVER_OL_HQ;
                URL_SOCKET_PORT = URL_SOCKET_PORT_OL_SSL;
            } else {
                URL_SOCKET_SERVER = "pimc.baidu.com";
                URL_SOCKET_PORT = URL_SOCKET_PORT_OL_SSL;
            }
            IM_ENV = i;
            if (i != getEnv(context)) {
                Utility.writeIntData(context, KEY_ENV, i);
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
