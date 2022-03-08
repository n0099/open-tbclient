package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes4.dex */
public class DpStatConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_ACTIVATE_CORE_RESULT = 20737;
    public static final int ACTION_LIB_LOAD_RESULT = 20736;
    public static final String FILECACHE_CLOSE_TYPE = "filecache_close_type";
    public static final String FILECACHE_CLOSE_TYPE_FORBIDDEN = "1002";
    public static final String FILECACHE_CLOSE_TYPE_IS_BLACKURL = "1001";
    public static final String FILECACHE_CLOSE_TYPE_OPT_DISABLE = "1004";
    public static final String FILECACHE_CLOSE_TYPE_OPT_IS_LIVE = "1003";
    public static final String KEY_ABTEST_SID = "abtest_sid";
    public static final String KEY_APP_NAME = "app_name";
    public static final String KEY_APP_VERSION_NAME = "app_version";
    public static final String KEY_CORE_VERSION = "cyber_core_ver";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_CURRENT_POSITION = "current_position";
    public static final String KEY_DATA = "data";
    public static final String KEY_DECODE_MODE = "decode_mode";
    public static final String KEY_DETAIL = "detail";
    public static final String KEY_DOWNLOAD_SO_FAIL = "download_so";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_FILE_CACHE = "file_cache";
    public static final String KEY_FIRST_DISPLAY = "first_display";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_INIT_RTC_SDK = "init_sdk";
    public static final String KEY_IS_FEED_VIDEO = "is_feed_video";
    public static final String KEY_IS_USER_STARTED = "is_user_started";
    public static final String KEY_ITEMS = "items";
    public static final String KEY_KERNEL_SESSION_ID = "k_id";
    public static final String KEY_LOAD_SO_FAIL = "load_so";
    public static final String KEY_LOGIN_STATUS = "login_status";
    public static final String KEY_LOGIN_TIME = "login_time";
    public static final String KEY_LOGOUT_TIME = "logout_time";
    public static final String KEY_NETWORK = "network";
    public static final String KEY_NETWORK_STATUS = "network_status";
    public static final String KEY_NET_LEVEL = "net_level";
    public static final String KEY_PREPARED = "prepared";
    public static final String KEY_PROTO = "proto";
    public static final String KEY_P_ID = "p_id";
    public static final String KEY_REAL_PLAY_TIME = "real_played_time";
    public static final String KEY_ROOM_NAME = "room_name";
    public static final String KEY_SDK_VERSION = "cyber_sdk_ver";
    public static final String KEY_SERVER_TYPE = "server_type";
    public static final String KEY_SUB_CODE = "sub_code";
    public static final String KEY_TIME = "time";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";
    public static final String KEY_USER_ID = "userid";
    public static final String KEY_WIDTH = "width";
    public static final int MEDIA_ERROR_MEDIA_PLAYER = -10000;
    public static final String PCDN_CLOSE_TYPE = "pcdn_close_type";
    public static final String PCDN_CLOSE_TYPE_FORBIDDEN = "1001";
    public static final String PCDN_CLOSE_TYPE_LIBPATH_NULL = "1002";
    public static final String SERVER_TYPE_DUPLAYER_INIT = "dp_init";
    public static final String SERVER_TYPE_DUPLAYER_MONITOR = "duplayer_monitor";
    public static final String SERVER_TYPE_DUPLAYER_RTC = "duplayer_rtc";
    public static final int SESSION_TYPE_DP_INIT_COMMON = 24323;
    public static final int SESSION_TYPE_ERROR = 20481;
    public static final int SESSION_TYPE_FIRST_SCREEN = 20513;
    public static final int SESSION_TYPE_KERNEL = 24321;
    public static final int SESSION_TYPE_LIVE_STREAM_INFO = 20487;
    public static final int SESSION_TYPE_MEDIA_DATA_UTILIZATION_RATE = 20517;
    public static final int SESSION_TYPE_MEDIA_FORMAT_INFO = 20514;
    public static final int SESSION_TYPE_PLAY_COMMON = 24322;
    public static final int SESSION_TYPE_RTC_COMMON = 20488;
    public static final int SESSION_TYPE_STAGE_INFO = 20484;
    public transient /* synthetic */ FieldHolder $fh;

    public DpStatConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
