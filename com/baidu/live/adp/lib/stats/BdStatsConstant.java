package com.baidu.live.adp.lib.stats;
/* loaded from: classes7.dex */
public class BdStatsConstant {
    public static final String BD_STATISTICS_PERFORMANCE_UPLOADURL = "http://nlog.baidu.com/dplog/n";
    public static final String BROADCAST_ACCOUNT_CHANGED = "adp.bdstatisticsmanager.account_changed";
    public static final String BROADCAST_MULTIPROCESS_UPLOAD_ALLFILE = "adp.bdstatisticsmanager.multiproceess.uploadallfile";
    public static final String CONFIG_FILE_PATH = "statisticConfig";
    public static final String DEFAULT_LOG_DIR = "stat";
    public static final String FILE_MON = "mon";
    public static final String FILE_OMP = "omp";
    public static final String FILE_PF = "pf";
    public static final String FILE_STAT = "stat";
    public static final String INTENT_DATA_BDUSS = "intent_data_bduss";
    public static final String INTENT_DATA_USERID = "intent_data_userid";
    public static final String INTENT_DATA_USERNAME = "intent_data_username";
    public static final long MAX_DURATION_UPDATE_SWITCH_DATA = 86400000;
    public static final int MAX_STATISTICS_SIZE = 31457280;
    public static final long MAX_STORAGE_TIME = 604800000;
    public static final int MAX_WRITE_LOG_SIZE = 102400;
    public static final long MAX_WRITTING_FILE_SIZE_AFTER_RENAME_FAILED = 307200;
    public static final String MULTIPROCESS_TYPE_ALERT_LOG = "com.baidu.adp.stats.upload.alertlog";
    public static final String MULTIPROCESS_TYPE_BACKGROUND = "com.baidu.adp.stats.background";
    public static final String MULTIPROCESS_TYPE_UPDATE_CMD = "com.baidu.adp.stats.updatecmd";
    public static final String MULTIPROCESS_TYPE_UPDATE_SWITCH = "com.baidu.adp.stats.switch";
    public static final String MULTIPROCESS_TYPE_UPLOAD_ALLFILE = "com.baidu.adp.stats.uploadallfile";
    public static final String NOT_UPLOAD_LOG_DIR = "notUpload";
    public static final String SWITCHS_CMD_BRDMSG_NAME = "switchsCmdBrdMsg";
    public static final String SWITCHS_CONFIG_FILENAME = "switchsConfig";
    public static final int UPLOAD_RETRY_TIMES = 3;

    /* loaded from: classes7.dex */
    public static class AlertTypeKey {
        public static final String ALERT_CRASH = "alert_crash";
        public static final String ALERT_HTTP = "alert_http";
        public static final String ALERT_IM = "alert_im";
        public static final String ALERT_IMG = "alert_img";
        public static final String ALERT_PLUGIN = "alert_plugin";
        public static final String ALERT_PROTOBUF = "alert_protobuf";
    }

    /* loaded from: classes7.dex */
    public static class ErrorCode {
        public static final int ERR_LOG_BASE = -100000;
        public static final int ERR_LOG_FAST = 99999;
    }

    /* loaded from: classes7.dex */
    public static class NetSubType {
        public static final String DEFAULT = "d";
        public static final String IMG = "img";
        public static final String VOICE = "voice";
    }

    /* loaded from: classes7.dex */
    public static class OpSubType {
        public static final String ALADIN_PORT_ERROR = "aladin_port_error";
        public static final String DB = "db";
        public static final String DEFAULT = "d";
        public static final String FILE = "file";
        public static final String IMG_ERR = "img";
        public static final String LIVE_ERR = "live";
        public static final String RESOURCES_ERROR = "resources";
        public static final String VOICE_ERR = "voice";
    }

    /* loaded from: classes7.dex */
    public static class StatsFile {
        public static final String ALERT_LOG_FILE_PREFIX = "alert";
        public static final String DEBUG_LOG_DIR_NAME = "dbg";
        public static final String DEBUG_LOG_FILE_PREFIX = "dbg";
        public static final String ERROR_LOG_FILE_PREFIX = "err";
        public static final String LOG_FILE_SUFFIX = ".log";
        public static final String PF_LONG_FILE_PREFIX_STRING = "pf";
        public static final String STAT_LOG_FILE_PREFIX = "stat";
    }

    /* loaded from: classes7.dex */
    public static class StatsKey {
        public static final String ALERT_LOG = "alert_log";
        public static final String ALERT_TYPE = "alert_type";
        public static final String CHANNEL = "from";
        public static final String CLIENT_ID = "client_id";
        public static final String CLIENT_VERSION = "version";
        public static final String CON_COST = "con_cost";
        public static final String COST = "cost";
        public static final String COUNT = "co";
        public static final String CRASH_INFO = "ci";
        public static final String CRASH_TYPE = "crash_type";
        public static final String CUID = "cuid";
        public static final String CURRENT_CHANNEL = "cfrom";
        public static final String ERR_INTERVAL = "err_int";
        public static final String ERR_NO = "result";
        public static final String ERR_STRING = "es";
        public static final String FROM = "f";
        public static final String IMEI = "imei";
        public static final String IMG_INF = "img_inf";
        public static final String INTERFACE_NAME = "interface";
        public static final String IS_HOST = "is_host";
        public static final String IS_MAIN_PROC = "ismainproc";
        public static final String LIVE_INF = "live_inf";
        public static final String LOGID = "c_logid";
        public static final String MERGE_ITEM = "mi";
        public static final String METHOD = "m";
        public static final String NET = "net";
        public static final String OP_NAME = "op_key";
        public static final String OS = "os";
        public static final String OS_VERSION = "os_version";
        public static final String PARENT_TYPE = "pt";
        public static final String PHONE = "phone";
        public static final String PRODUCT = "product";
        public static final String RESPONSE_COST = "rsp_cost";
        public static final String RETRY_COUNT = "retry";
        public static final String SEQUENCEID = "seq_id";
        public static final String SIZE_DOWN = "size_d";
        public static final String SIZE_UP = "size_u";
        public static final String STREAM_ID = "stream_id";
        public static final String SUB_SYSTEM = "sub_sys";
        public static final String SUB_TYPE = "st";
        public static final String TIME = "t";
        public static final String TYPE = "module";
        public static final String UID = "uid";
        public static final String UNAME = "uname";
        public static final String VOICE_INF = "voice_inf";
    }

    /* loaded from: classes7.dex */
    public static class StatsType {
        public static final String ALERT = "alert";
        public static final String CRASH = "crash";
        public static final String DEBUG = "dbg";
        public static final String ERROR = "error";
        public static final String NET = "net";
        public static final String OPERATE = "op";
        public static final String PERFORMANCE = "pfmonitor";
        public static final String STAT = "stat";
    }

    /* loaded from: classes7.dex */
    public static class SubType {
        public static final String FRS = "frs";
        public static final String IM = "im";
        public static final String IMG = "img";
        public static final String PAY = "pay";
        public static final String PB = "pb";
        public static final String SEQID = "seqid";
        public static final String SOCKET = "socket";
        public static final String VOICE = "voice";
    }
}
