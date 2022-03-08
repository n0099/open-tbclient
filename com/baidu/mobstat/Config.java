package com.baidu.mobstat;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Config {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APPKEY_META_NAME = "BaiduMobAd_STAT_ID";
    public static final String APP_KEY = "k";
    public static final String APP_VERSION_CODE = "a";
    public static final String APP_VERSION_NAME = "n";
    public static final int APP_VERSION_NOT_INI_VALUE = -1;
    public static final long BPLUS_DELAY_TIME = 5000;
    public static final String CAR_UUID = "uu";
    public static final String CELL_LOCATION = "cl";
    public static final String CHANNEL = "c";
    public static final String CHANNEL_META_NAME = "BaiduMobAd_CHANNEL";
    public static final int COMMON_DATA_LENGTH_LIMIT_LARGE = 1024;
    public static final int CRASH_EXT_LIMIT_BYTES = 256;
    public static final int CRASH_TYPE_JAVA = 0;
    public static final int CRASH_TYPE_NATIE = 1;
    public static final String CUID = "i";
    public static final String CUID_SEC = "ii";
    public static final String CUSTOM_USER_ID = "uid";
    public static final String DEF_MAC_ID = "02:00:00:00:00:00";
    public static final String DEVICE_BLUETOOTH_MAC = "bm";
    public static final String DEVICE_BOARD = "bo";
    public static final String DEVICE_BRAND = "bd";
    public static final String DEVICE_EXT_SIZE = "ext_stat";
    public static final String DEVICE_HEIGHT = "h";
    public static final String DEVICE_ID = "d";
    public static final String DEVICE_ID_SEC = "dd";
    public static final String DEVICE_LOCAL_IP = "in_ip";
    public static final String DEVICE_MAC_ID = "mc";
    public static final String DEVICE_MEM_SIZE = "mem";
    public static final String DEVICE_NAME = "dn";
    public static final String DEVICE_PART = "device";
    public static final String DEVICE_ROM_SIZE = "in_stat";
    public static final String DEVICE_UPTIME = "uptime";
    public static final String DEVICE_WIDTH = "w";
    public static final String EVENT_AAC = "c";
    public static final String EVENT_ATTR = "attribute";
    public static final String EVENT_AUTOTRACE = "at";
    public static final String EVENT_DURATION = "d";
    public static final String EVENT_EXT = "ext";
    public static final String EVENT_FEED_IDENTIFIER_SIGN = "sign";
    public static final String EVENT_H5_EVENT = "h5";
    public static final String EVENT_H5_PAGE = "p2";
    public static final String EVENT_H5_VIEW_HIERARCHY = "h3";
    public static final String EVENT_HEAT_POINT = "point";
    public static final String EVENT_HEAT_X = "x";
    public static final String EVENT_HEAT_XP = "xp";
    public static final String EVENT_HEAT_Y = "y";
    public static final String EVENT_HEAT_YP = "yp";
    public static final String EVENT_HIERARCHY = "h";
    public static final String EVENT_ID = "i";
    public static final String EVENT_LABEL = "l";
    public static final int EVENT_LIDU = 3600000;
    public static final String EVENT_NATIVE_VIEW_HIERARCHY = "h2";
    public static final String EVENT_PAGE = "p";
    public static final String EVENT_PAGE_MAPPING = "pd";
    public static final String EVENT_PART = "ev";
    public static final String EVENT_PATH_MAPPING = "ed";
    public static final String EVENT_SESSION_START_TIME = "ss";
    public static final String EVENT_TIME = "t";
    public static final String EVENT_TIME_SEQUENCE = "s";
    public static final String EVENT_VIEW_RES_NAME = "rn";
    public static final String EVENT_VIEW_TYPE = "v";
    public static final String EXCEPTION_CONTENT = "c";
    public static final String EXCEPTION_CRASH_CHANNEL = "ty";
    public static final String EXCEPTION_CRASH_TYPE = "ct";
    public static final String EXCEPTION_LOG_META_NAME = "BaiduMobAd_EXCEPTION_LOG";
    public static final String EXCEPTION_MEMORY = "mem";
    public static final String EXCEPTION_MEMORY_FREE = "free";
    public static final String EXCEPTION_MEMORY_LOW = "low";
    public static final String EXCEPTION_MEMORY_TOTAL = "total";
    public static final String EXCEPTION_PART = "ex";
    public static final String EXCEPTION_TIME = "t";
    public static final String EXCEPTION_TYPE = "y";
    public static final String EXCEPTION_VERSION = "v";
    public static final String EXCEPT_FILE_NAME;
    public static final String EXT = "ext";
    public static final int EXT_ITEM_LIMIT_BYTES = 1024;
    public static final String FEED_LIST_END_TIME = "e";
    public static final String FEED_LIST_ITEM_CUSTOM_ID = "id";
    public static final String FEED_LIST_ITEM_DURATION = "d";
    public static final String FEED_LIST_ITEM_IDENTIFIER_DATA_SIGN = "sign";
    public static final String FEED_LIST_ITEM_INDEX = "index";
    public static final String FEED_LIST_ITEM_LIST_NAME = "n";
    public static final String FEED_LIST_ITEM_PAGE = "p";
    public static final String FEED_LIST_ITEM_PART = "sv";
    public static final String FEED_LIST_ITEM_PATH = "path";
    public static final String FEED_LIST_ITEM_SHOW_COUNT = "c";
    public static final String FEED_LIST_ITEM_SHOW_TIME = "t";
    public static final String FEED_LIST_ITEM_SHOW_TIME_OFFSET = "ps";
    public static final String FEED_LIST_ITEM_TITLE = "title";
    public static final String FEED_LIST_ITEM_USER_SET = "user";
    public static final String FEED_LIST_MAPPING = "sd";
    public static final String FEED_LIST_NAME = "name";
    public static final String FEED_LIST_PART = "ti";
    public static final String FEED_LIST_START_TIME = "s";
    public static final String FEED_LIST_USER_SET = "user";
    public static final long FULL_TRACE_LOG_LIMIT = 10485760;
    public static final String GET_CELL_LOCATION = "BaiduMobAd_CELL_LOCATION";
    public static final String GET_GPS_LOCATION = "BaiduMobAd_GPS_LOCATION";
    public static final String GET_WIFI_LOCATION = "BaiduMobAd_WIFI_LOCATION";
    public static final String GPS_LOCATION = "gl";
    public static final String HEADER_EXT = "ext";
    public static final String HEADER_FULL_TRACE = "at";
    public static final String HEADER_PART = "he";
    public static final String INPUT_DEF_PKG = "pkg";
    public static final String INPUT_DEF_PKG_SYS = "sys";
    public static final String INPUT_DEF_VERSION = "version";
    public static final int INPUT_INFO_LIMIT_BYTES = 1024;
    public static final String INPUT_INSTALLED_PKG = "install";
    public static final String INPUT_PART = "input";
    public static final String LAST_AP_INFO_FILE_NAME;
    public static final String LAST_SESSION_FILE_NAME;
    public static final String LAUNCH = "launch";
    public static final String LAUNCH_CONTENT = "content";
    public static final String LAUNCH_INFO = "info";
    public static final String LAUNCH_REFERER = "referer";
    public static final String LAUNCH_TYPE = "type";
    public static final String LINKED_WAY = "l";
    public static final String LOG_FULL_SEND_URL = "https://hmma.baidu.com/auto.gif";
    public static final String LOG_SEND_URL;
    public static final String LOG_SEND_URL_NOSSL = "http://hmma.baidu.com/app.gif";
    public static final String LOG_SEND_URL_SSL = "https://hmma.baidu.com/app.gif";
    public static final String MANUFACTURER = "ma";
    public static final int MAX_CACHE_JSON_CAPACITY = 184320;
    public static final int MAX_CACHE_JSON_CAPACIT_EXCEPTION = 5120;
    public static final int MAX_CUSTOM_USER_ID_LENGTH = 256;
    public static final int MAX_CUSTOM_VERSION_NAME_LENGTH = 256;
    public static final int MAX_FEED_COMMON_DATA_LENGTH = 256;
    public static final int MAX_HEAT_COUNT_PER_EVENT = 10;
    public static final long MAX_LOG_DATA_EXSIT_TIME = 604800000;
    public static final boolean MERGE_EVENT = true;
    public static final String MODEL = "m";
    public static final String NULL_DEVICE_ID = "000000000000000";
    public static final String ONLY_WIFI_META_NAME = "BaiduMobAd_ONLY_WIFI";
    public static final String OPERATOR = "op";
    public static final String OS = "o";
    public static final String OS_SYSVERSION = "sv";
    public static final String OS_VERSION = "s";
    public static final String PACKAGE_NAME = "pn";
    public static final String PAGE_EXT = "ext";
    public static final String PAGE_H5_PAGE = "h5";
    public static final String PLATFORM_TYPE = "pt";
    public static String PREFIX_SEND_DATA = null;
    public static final String PREFIX_SEND_DATA_FULL = "__track_send_data_";
    public static final String PRINCIPAL_PART = "pr";
    public static final String PROCESS_CLASS = "scl";
    public static final String PROCESS_LABEL = "pl";
    public static final String PUSH = "push";
    public static final int PUSH_ID_LIMIT_BYTES = 1024;
    public static final long RAVEN_LOG_LIMIT = 52428800;
    public static final String RES_PREFIX;
    public static final String ROM = "rom";
    public static final boolean SDK_ENABLE_DEVICE = false;
    public static final boolean SDK_ENABLE_FEED = true;
    public static final boolean SDK_ENABLE_INPUT = false;
    public static final boolean SDK_ENABLE_MAC = true;
    public static final boolean SDK_FOR_CAR = false;
    public static final boolean SDK_FOR_DUEROS = false;
    public static final boolean SDK_FOR_HUAWEI = false;
    public static final boolean SDK_FOR_MAP = false;
    public static final boolean SDK_FOR_MB_DEV = false;
    public static final boolean SDK_FOR_RAVEN = false;
    public static final boolean SDK_FOR_SDK = false;
    public static final boolean SDK_INTERNAL = false;
    public static final boolean SDK_LOG_FILTER = false;
    public static final boolean SDK_RELEASE = true;
    public static final String SDK_TAG = "tg";
    public static final int SDK_TAG_VALUE = 1;
    public static final boolean SDK_TRACE_ALL = true;
    public static final boolean SDK_WITH_AUTOTRACE = true;
    public static final int SDK_WITH_BPLUS = 2;
    public static final int SENDING_LOG_TIMER_PERIOD = 3600000;
    public static final String SEND_STRATEGY_META_NAME = "BaiduMobAd_SEND_STRATEGY";
    public static final String SEQUENCE_INDEX = "sq";
    public static final String SESSION_COUNTED = "c";
    public static final int SESSION_PERIOD = 30000;
    public static final String SESSION_STARTTIME = "ss";
    public static final String SESSTION_ACTIVITY_AUTOTRACE = "at";
    public static final String SESSTION_ACTIVITY_DURATION = "d";
    public static final String SESSTION_ACTIVITY_NAME = "n";
    public static final String SESSTION_ACTIVITY_REFERER_SRC_IDENTIFIER_SIGN = "sign";
    public static final String SESSTION_ACTIVITY_START = "ps";
    public static final String SESSTION_ACTIVITY_TITLE = "t";
    public static final String SESSTION_ACTIVITY_X_TOTAL_HEIGHT = "xt";
    public static final String SESSTION_ACTIVITY_X_VIEW_HEIGHT = "xc";
    public static final String SESSTION_ACTIVITY_Y_TOTAL_HEIGHT = "yt";
    public static final String SESSTION_ACTIVITY_Y_VIEW_HEIGHT = "yc";
    public static final String SESSTION_END_TIME = "e";
    public static final String SESSTION_ID = "i";
    public static final String SESSTION_PAGE_VIEW = "p";
    public static final String SESSTION_START_TIME = "s";
    public static final String SESSTION_TRACK_END_TIME = "e2";
    public static final String SESSTION_TRACK_START_TIME = "s2";
    public static final String SESSTION_TRIGGER_CATEGORY = "pc";
    public static final String SIGN = "sign";
    public static final String STAMP = "t";
    public static final String START_TYPE = "startType";
    public static final String STAT_CACHE_FILE_NAME;
    public static final String STAT_FULL_CACHE_FILE_NAME;
    public static final String STAT_SDK_CHANNEL = "sc";
    public static final int STAT_SDK_CHANNEL_VALUE = 14;
    public static final String STAT_SDK_TYPE = "st";
    public static final String STAT_SDK_VERSION = "v";
    public static final String STAT_SDK_VERSION_NUM = "3.9.5.1";
    public static final String TARGET_SDK_VERSION = "tv";
    public static final String TEST_DEVICE_ID = "td";
    public static final String TIME_INTERVAL_META_NAME = "BaiduMobAd_TIME_INTERVAL";
    public static final String TRACE_APPLICATION_SESSION = "app_session";
    public static final String TRACE_CIRCLE = "circle";
    public static final String TRACE_FAILED_CNT = "failed_cnt";
    public static final String TRACE_PART = "trace";
    public static final int TRACE_RECENT_DAY_VISIT = 5;
    public static final String TRACE_TODAY_VISIT_SPLIT = ":";
    public static final String TRACE_VISIT = "visit";
    public static final String TRACE_VISIT_FIRST = "first";
    public static final String TRACE_VISIT_RECENT = "recent";
    public static final String TRACE_VISIT_RECENT_COUNT = "count";
    public static final String TRACE_VISIT_RECENT_DAY = "day";
    public static final String TRACE_VISIT_SESSION_LAST_INTERVAL = "session_last_interval";
    public static final String TRACE_VISIT_SESSION_TODAY_COUNT = "session_today_cnt";
    public static final String WIFI_LOCATION = "wl2";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class AppLaunchType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int AppCall = 1;
        public static final int DirectCall = 0;
        public static final int PushCall = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public AppLaunchType() {
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

    /* loaded from: classes4.dex */
    public static class CrashChannel {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int SYS_TRACK = 0;
        public static final int USER_UPLOAD_ERROR = 12;
        public static final int USER_UPLOAD_EXCEPTION = 11;
        public static final int USER_UPLOAD_OTHER = 13;
        public transient /* synthetic */ FieldHolder $fh;

        public CrashChannel() {
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class EventViewType {
        public static /* synthetic */ Interceptable $ic;
        public static final EventViewType BUTTON;
        public static final EventViewType EDIT;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ EventViewType[] f34919b;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2012504581, "Lcom/baidu/mobstat/Config$EventViewType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2012504581, "Lcom/baidu/mobstat/Config$EventViewType;");
                    return;
                }
            }
            EDIT = new EventViewType("EDIT", 0, 0);
            EventViewType eventViewType = new EventViewType("BUTTON", 1, 1);
            BUTTON = eventViewType;
            f34919b = new EventViewType[]{EDIT, eventViewType};
        }

        public EventViewType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i3;
        }

        public static EventViewType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EventViewType) Enum.valueOf(EventViewType.class, str) : (EventViewType) invokeL.objValue;
        }

        public static EventViewType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EventViewType[]) f34919b.clone() : (EventViewType[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? String.valueOf(this.a) : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class SessionInvokeCategory {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ActivityInvoke = 1;
        public static final int ApiInvoke = 0;
        public static final int CustomInvoke = 3;
        public static final int FragmentInvoke = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public SessionInvokeCategory() {
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

    /* loaded from: classes4.dex */
    public static class StartType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int NORMAL_START = 0;
        public static final int QUICK_START = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public StartType() {
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

    /* loaded from: classes4.dex */
    public static class TraceType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int AUTO_TRACE = 1;
        public static final int CODE_TRACE = 0;
        public static final int EDIT_TRACE = 2;
        public static final int FULL_TRACE = 3;
        public transient /* synthetic */ FieldHolder $fh;

        public TraceType() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(351802000, "Lcom/baidu/mobstat/Config;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(351802000, "Lcom/baidu/mobstat/Config;");
                return;
            }
        }
        LOG_SEND_URL = Build.VERSION.SDK_INT < 9 ? "http://hmma.baidu.com/app.gif" : "https://hmma.baidu.com/app.gif";
        PREFIX_SEND_DATA = "";
        RES_PREFIX = "__local_";
        PREFIX_SEND_DATA = "__send_data_";
        LAST_SESSION_FILE_NAME = RES_PREFIX + "last_session.json";
        EXCEPT_FILE_NAME = RES_PREFIX + "except_cache.json";
        LAST_AP_INFO_FILE_NAME = RES_PREFIX + "ap_info_cache.json";
        STAT_CACHE_FILE_NAME = RES_PREFIX + "stat_cache.json";
        STAT_FULL_CACHE_FILE_NAME = RES_PREFIX + "stat_full_cache.json";
    }

    public Config() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
