package com.baidu.ar.util;

import com.baidu.android.pushservice.PushConstants;
/* loaded from: classes3.dex */
public final class Constants {
    public static final String AC_ID = "ac_id";
    public static final String AR_APP_NAME = "AR";
    public static final String AR_CODED_KEY = "ar_coded_key";
    public static final String AR_CODE_URL = "ar_code_url";
    public static final String AR_HARDWARE_SATISFIED = "hardware_satisfied";
    public static final String AR_ID = "ar_id";
    public static final String AR_KEY = "ar_key";
    public static final String AR_LAUNCH_MODE = "ar_launch_mode";
    public static final String AR_NAME = "ar_name";
    public static final String AR_NEED_LAST_PREVIEW = "ar_last_preview";
    public static final String AR_PUBLISH_ID = "publish_id";
    public static final String AR_RESOURCE_CACHE_DIR = "/ARResource";
    public static final String AR_RESOURCE_CACHE_DIR_HIDE = "/.ARResource";
    public static final String AR_RESOURCE_CACHE_DIR_LOG = "/log";
    public static final String AR_RESOURCE_CACHE_DIR_NORMAL = "/normal";
    public static final String AR_RESOURCE_CACHE_DIR_NPC = "/npc";
    public static final String AR_RESOURCE_CACHE_DIR_SLAM = "/slam";
    public static final String AR_RESOURCE_CACHE_DIR_TRACK = "/track";
    public static final String AR_RESOURCE_CACHE_DIR_UDT = "/udt";
    public static final String AR_SALT_FIGURE = "ar_salt_figure";
    public static final String AR_SETTINGS = "ar_settings";
    public static final String AR_TYPE = "ar_type";
    public static final String AR_UNZIP_ROOT_DIR = "ar";
    public static final String AR_VALUE = "arValue";
    public static final int AUDIO_PERMISSION_REQUEST_CODE = 101;
    public static final int AUDIO_PERMISSION_REQUEST_CODE_SPEECH = 102;
    public static final int BDUSS_EXCEPRION = -10000;
    public static final String CHANNELID = "channel_id";
    public static final String COMMAND_FILE = "command.json";
    public static final String DOT = ".";
    public static final String DRAWURL = "draw_url";
    public static final String EXTRA_INFO = "extra_info";
    public static final String HTTP_APP_ID = "app_id";
    public static final String HTTP_AR_MD5 = "md5";
    public static final String HTTP_AR_MULTI_RESOURCE = "ar_resource_urls";
    public static final String HTTP_AR_REDIRECT_URL = "redirect_url";
    public static final String HTTP_AR_RENDER_DATA = "ar_render_data";
    public static final String HTTP_AR_RESOURCE = "ar_resource";
    public static final String HTTP_AR_VALUE = "ar_value";
    public static final int HTTP_CONNECT_TIMEOUT = 20000;
    public static final String HTTP_DEVICE_ID = "device_id";
    public static final String HTTP_ENGINE_VERSION = "engine_version";
    public static final int HTTP_ERRCODE_NOT_FIND = 1032;
    public static final int HTTP_ERRCODE_VERSION_HIGH = 1033;
    public static final int HTTP_ERRCODE_VERSION_LOW = 1044;
    public static final String HTTP_ERR_CODE = "err_code";
    public static final String HTTP_ERR_MSG = "err_msg";
    public static final String HTTP_GLES_VERSION = "gles_version";
    public static final String HTTP_OS_TYPE = "osType";
    public static final String HTTP_POWER = "power";
    public static final int HTTP_READ_TIMEOUT = 30000;
    public static final String HTTP_REFUSED = "refused";
    public static final int HTTP_RESULT_DOWNLOAD_ERROR = 1059;
    public static final int HTTP_RESULT_DOWNLOAD_IN_PROGRESS = 1056;
    public static final int HTTP_RESULT_FAILURE = 1057;
    public static final int HTTP_RESULT_NETWORK_ERROR = 1053;
    public static final int HTTP_RESULT_NOT_SUPPORT_AR = 1054;
    public static final int HTTP_RESULT_QUERY_ERROR = 1058;
    public static final int HTTP_RESULT_QUERY_IN_PROGRESS = 1055;
    public static final int HTTP_RESULT_SUCCESS = 0;
    public static final String HTTP_RET = "ret";
    public static final String HTTP_SYSTEM_VERSION = "system_version";
    public static final String HTTP_USER_ID = "user_id";
    public static final String HTTP_VERSION_CODE = "version_code";
    public static final String LUA_COMMAND_LIST = "commandList";
    public static final String LUA_COMMAND_NAME = "name";
    public static final String LUA_COMMAND_STRING = "luacommand";
    public static final String MARKETING = "marketing";
    public static final int MSG_LUA_SDK_BRIDGE_SET_SHAKE_ENABLE = 10004;
    public static final int MSG_LUA_SDK_BRIDGE_START_SHAKE = 10001;
    public static final int MSG_LUA_SDK_BRIDGE_STOP_SHAKE = 10002;
    public static final String MSG_SDK_LUA_BRIDGE_ACCELERATION_X = "x";
    public static final String MSG_SDK_LUA_BRIDGE_ACCELERATION_Y = "y";
    public static final String MSG_SDK_LUA_BRIDGE_ACCELERATION_Z = "z";
    public static final String MSG_SDK_LUA_BRIDGE_MAX_ACC = "max_acc";
    public static final int MSG_SDK_LUA_BRIDGE_ON_SHAKE = 10000;
    public static final String MSG_SDK_LUA_ID = "id";
    public static final int NETWORKTYPE_2G = 2;
    public static final int NETWORKTYPE_3G = 3;
    public static final int NETWORKTYPE_4G = 4;
    public static final int NETWORKTYPE_WIFI = 5;
    public static final String OLD_AR_KEY = "arKey";
    public static final String OLD_AR_TYPE = "arType";
    public static final String OS_TYPE_VALUE = "android";
    public static final String PRIZE_BDUSS = "bduss";
    public static final String PRIZE_CHANNEL = "channel";
    public static final String PRIZE_MODEL_TYPE = "model_type";
    public static final String PRIZE_TIMESTAMP = "timestamp";
    public static final String PUBLICKEY = "public_key";
    public static final String PUBLISH_BAIDUMAP = "6";
    public static final String PUBLISH_NUOMI = "5";
    public static final String PUBLISH_SHOUBAI = "2";
    public static final String SHOW_AUDIO_DIALOG = "show_audio_dialog";
    public static final String SIGN = "sign";
    public static final String TARGET_FILE = "targets.json";
    public static final String TIMESTAMP = "timestamp";
    public static final String URL_AR_QUERY_SERVICE = "/artrack-bos";
    public static final String URL_AR_STATISTIC = "/count_ar";
    public static final String URL_OFF_LINE = "http://cp01-rdqa-dev123-yangzuncheng.epc.baidu.com:8383";
    public static final String URL_TRACK_AR_ACTION_QUERY = "/queryarresource";
    public static final String URL_TRACK_AR_SHARE = "/share/shareupload";
    public static final String URL_TRACK_AR_STATISTIC = "/count_ar";
    public static final String VOICE_FILE = "voice.json";
    public static final String ZIP_SUFFIX = "zip";
    public static final String URL_ON_LINE = "https://dusee.baidu.com";
    public static String URL_TRACK_AR_PREFIX = URL_ON_LINE;
    public static String URL_STATISTIC_SERVICE = "/artrack";
    public static String PRIZE_ERRODCODE = "error_code";
    public static String PRIZE_ERRODMSG = PushConstants.EXTRA_ERROR_CODE;
    public static String PRIZE = "prize";
    public static String PRIZE_ID = "id";
    public static String PRIZE_TYPE = "type";
    public static String PRIZE_NAME = "name";
    public static String PRIZE_URL = "url";
    public static String PRIZE_SHOW_TYPE = "show_type";
    public static boolean RE_EXTRACT = true;
    public static boolean AR_IS_NEED_PRINT_FRAME_LOG = false;
    public static boolean DEBUG = false;
    public static boolean DEBUG_LOG = DEBUG & true;
    public static boolean DEBUG_TOAST = DEBUG & true;
    public static boolean DEBUG_TRACK_EDGE = DEBUG & true;
    public static boolean DEBUG_TRACK_JIT = DEBUG & true;
    public static boolean DEBUG_LOG2FILE = DEBUG_TRACK_JIT & true;
    public static boolean DEBUG_CAPTURE = DEBUG & false;
    public static boolean DEBUG_SERVER = DEBUG & false;
    public static boolean DEBUG_PREVIEW_FRAME = DEBUG & false;
    public static int PRINT_FPS_INTERVAL = 100;
    public static String SLAM_PLANE_LEVEL = "slam_plane_level";
    public static String SLAM_TRACK_QUALITY = "slam_track_quality";
    public static String SLAM_PROCESS_TIME = "slam_process_time";
    public static int SLAM_PLANE_ERROR = -1;
    public static int SLAM_PLANE_BAD = 0;
    public static int SLAM_PLANE_GOOD = 1;
    public static int SLAM_PLANE_PERFECT = 2;
    public static String SLAM_TRACK_STATUS = "slam_track_status";
    public static int OS_HAS_GYROSCOPE = 1;
    public static int OS_NOT_HAS_GYROSCOPE = 0;
    public static int UI_ORIENTATION_LANDSCAPE_RIGHT = 90;
    public static int UI_ORIENTATION_LANDSCAPE_LEFT = -90;
    public static int UI_ORIENTATION_PORTRAIT = 0;

    public static void setDebugEnable(boolean z) {
        DEBUG = z;
        DEBUG_LOG &= DEBUG;
        DEBUG_TOAST &= DEBUG;
        DEBUG_TRACK_EDGE &= DEBUG;
        DEBUG_TRACK_JIT &= DEBUG;
        DEBUG_LOG2FILE &= DEBUG_TRACK_JIT;
        DEBUG_CAPTURE &= DEBUG;
    }

    public static void setReExtract(boolean z) {
        if (DEBUG) {
            RE_EXTRACT = z;
        }
    }

    public static boolean setTrackDebugServer(String str) {
        if (DEBUG_SERVER) {
            URL_TRACK_AR_PREFIX = str;
            b.b("debug server is " + str);
            return true;
        }
        return false;
    }
}
