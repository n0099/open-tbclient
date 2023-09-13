package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.ab.CyberAbTestManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.context.ICyberGlobalOptions;
import com.baidu.cyberplayer.sdk.context.ICyberMediaContext;
import com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager;
import com.baidu.cyberplayer.sdk.playconfig.PlayConfigABTest;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory;
import com.baidu.searchbox.playerserver.PlayerPolicyCfgManager;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
import com.baidu.searchbox.playerserver.PlayerPolicyRuntime;
import com.baidu.searchbox.playerserver.ab.PlayConfigABContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes3.dex */
public class CyberPlayerManager {
    @Deprecated
    public static final int ABR_MODE = -1;
    public static final int COMMAND_ADD_STAGE_INFO = 1001;
    public static final int COMMAND_ON_FIRST_FRAME_DRAWED = 1002;
    public static final int COMMAND_SET_STATISTIC_INFO = 1003;
    public static final int COMMAND_USER_CLICK_START = 1000;
    public static final int CYBER_FILTER_TYPE_GAUSSFILTER = 256;
    public static final int CYBER_FILTER_TYPE_NORMAL = 0;
    public static final int CYBER_RENDER_TYPE_GLSURFACEVIEW = 0;
    public static final int CYBER_RENDER_TYPE_GLTEXTUREVIEW = 4;
    public static final int CYBER_RENDER_TYPE_HDRVIEW = 3;
    public static final int CYBER_RENDER_TYPE_SURFACEVIEW = 2;
    public static final int CYBER_RENDER_TYPE_TEXTUREVIEW = 1;
    public static final boolean DEBUG = false;
    public static final int DECODE_MODE_AUTO = 0;
    public static final int DECODE_MODE_HW = 2;
    public static final int DECODE_MODE_SW = 1;
    public static final int DECODE_MODE_SYS = 4;
    public static final int DELETING = -2;
    public static final int DIR_NOT_EXIST = -1;
    public static final int DOLBY_YPTE = 2;
    public static final int DP_MSG_INFO_CACHE_DURATION = 953;
    public static final int DiskLevelCritical = 2;
    public static final int DiskLevelNormal = 0;
    public static final int DiskLevelWarning = 1;
    public static final int HDR10P_TYPE = 16;
    public static final int HDR10_TYPE = 4;
    public static final int HEVC_HLG_TYPE = 1;
    public static final int INSTALL_ERROR_CODE_INVALID_PARAM = -7;
    @Keep
    public static final int INSTALL_INFO_CRYPTO_SO_PATH_CHANGED = 102;
    @Keep
    public static final int INSTALL_INFO_FFMPEG_SO_PATH_CHANGED = 100;
    @Keep
    public static final int INSTALL_INFO_PROGRESS_UPDATE = 103;
    @Keep
    public static final int INSTALL_INFO_SSL_SO_PATH_CHANGED = 101;
    public static final String INSTALL_OPT_ABTEST_SID = "abtest_sid";
    public static final String INSTALL_OPT_ABTEST_SWITCH_START_CODE = "cybermedia_abtest_";
    public static final String INSTALL_OPT_APP_VERSION_NAME = "app_version_name";
    public static final String INSTALL_OPT_CRASHPAD_INSTALL_TYPE = "crashpad_install_type";
    public static final String INSTALL_OPT_CRASHPAD_MAIN_PROCESS_WORK_DIR = "crashpad_main_process_work_dir";
    public static final String INSTALL_OPT_CRASHPAD_MEDIA_PROCESS_WORK_DIR = "crashpad_media_process_work_dir";
    public static final String INSTALL_OPT_ENABLE_SF_SWITCH = "enable_spring_festival";
    public static final String INSTALL_OPT_PIPELINE_NUM = "pipeline_count";
    public static final String INSTALL_OPT_PROCESS_TYPE = "process_type";
    @Deprecated
    public static final int INSTALL_TYPE_ALL = 7;
    public static final int INSTALL_TYPE_CYBER_MEDIA = 1;
    public static final int LIB_ID_CRYPTO = 102;
    public static final int LIB_ID_FFMPEG = 100;
    public static final int LIB_ID_OPENSSL = 101;
    public static final int LIB_TYPE_CRASHPAD = 16;
    public static final int LIB_TYPE_FFMPEG_EXTEND = 4;
    public static final int LIB_TYPE_PCDN = 2;
    @Deprecated
    public static final int LIB_TYPE_RTC = 32;
    public static final int LIB_TYPE_STRATEGY_INTELLIGENT = 128;
    public static final int LIB_TYPE_STRATEGY_OPTIMIZE = 64;
    public static final int LIB_TYPE_VIDEO_SR = 8;
    public static final int MEDIA_COLLECT_RUNTIME_INFO = 100;
    public static final int MEDIA_COLLECT_RUNTIME_INFO_WITHOUT_DISK = 101;
    public static final int MEDIA_ERROR_CREATE_ASYNC_PLAYER_FAIL = -112;
    public static final int MEDIA_ERROR_FOMAT_DEMUXER_NOT_FOUND = -2006;
    public static final int MEDIA_ERROR_INVALID_OPERATION = -38;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NA_HTTP_FORBIDDEN = -2403;
    public static final int MEDIA_ERROR_NA_NETWORK_HTTP_FORBIDDEN = -33403;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_OPEN_VIDEO_FAIL = -111;
    public static final int MEDIA_ERROR_REMOTE_DIED = -30001;
    public static final int MEDIA_ERROR_REMOTE_EXCEPTION = -30000;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_SETDATASOURCE_EXCEPTION = -10001;
    public static final int MEDIA_ERROR_STATE_EXCEPTION = -10002;
    public static final int MEDIA_ERROR_SURFACE_EXCEPTION = -10000;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNDEFINE_AUDIO_NOT_PLAY = 804;
    public static final int MEDIA_ERROR_UNDEFINE_LOWLEVEL_SYSTEM_ERROR = Integer.MIN_VALUE;
    public static final int MEDIA_ERROR_UNDEFINE_VIDEO_NOT_PLAY = 805;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_AUDIO_BITRATE = 938;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BIND_4G_SUCCESS = 12009;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_CONNECTED_SERVER = 10015;
    public static final int MEDIA_INFO_CONNECT_BEGIN = 919;
    public static final int MEDIA_INFO_CONNECT_END = 920;
    public static final int MEDIA_INFO_DECODE_FAIL = 10008;
    public static final int MEDIA_INFO_DECODE_MODE_CHANGED = 10102;
    public static final int MEDIA_INFO_DISABLE_FILECACHE = 11001;
    public static final int MEDIA_INFO_DNS_BEGIN = 917;
    public static final int MEDIA_INFO_DNS_END = 918;
    public static final int MEDIA_INFO_DNS_EXCEPTION = 10014;
    public static final int MEDIA_INFO_EXTEND_CARLTON_FOUND = 925;
    public static final int MEDIA_INFO_EXTEND_SERVER_CHANGE = 5000;
    public static final int MEDIA_INFO_EXTEND_VIDEO_CACHE_PROGRESS = 946;
    public static final int MEDIA_INFO_EXTEND_VIDEO_DOWNLOAD_SPEED = 924;
    public static final int MEDIA_INFO_EXTENT_DOWNLOAD_PERCENT = 262144;
    public static final int MEDIA_INFO_FIRST_DISP_INTERVAL = 904;
    public static final int MEDIA_INFO_FIRST_DISP_INTERVAL_SUB_T = 905;
    public static final int MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE = 10011;
    public static final int MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE = 10010;
    public static final int MEDIA_INFO_HDR_VIDEO = 11011;
    public static final int MEDIA_INFO_HTTP_REDIECT = 12011;
    public static final int MEDIA_INFO_KERNEL_NET_TRAFFIC = 11002;
    public static final int MEDIA_INFO_KLOGID_CHANGE = 11008;
    public static final int MEDIA_INFO_LOOP_REPLAYED = 955;
    public static final int MEDIA_INFO_MEDIA_FILE_PATH = 12012;
    public static final int MEDIA_INFO_META = 20500;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NET_RECONNECTING = 923;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_ON_SEI_DATA_CHANGED = 10103;
    public static final int MEDIA_INFO_PCDN_DOWNGRADE = 11006;
    public static final int MEDIA_INFO_PCDN_TRAFFIC = 11000;
    public static final int MEDIA_INFO_PLAY_COMPLETE = 10004;
    public static final int MEDIA_INFO_PLAY_FROM_LOCAL_CACHE = 12010;
    public static final int MEDIA_INFO_PRERENDER_COMPLETE = 12006;
    public static final int MEDIA_INFO_PROCESS = 910;
    public static final int MEDIA_INFO_QUIC_INFO = 12007;
    public static final int MEDIA_INFO_RESPONSE_BEGIN = 921;
    public static final int MEDIA_INFO_RESPONSE_END = 922;
    public static final int MEDIA_INFO_RESTART_PLAYED = 956;
    public static final int MEDIA_INFO_RETRY_BEGIN = 11004;
    public static final int MEDIA_INFO_RETRY_END = 11005;
    public static final int MEDIA_INFO_RETRY_FAIL = 10007;
    public static final int MEDIA_INFO_RTMP_CONNECT_SERVER_FAIL = 3002;
    public static final int MEDIA_INFO_RTMP_HANDSHAKE_FAIL = 3003;
    public static final int MEDIA_INFO_RTMP_IO_FAIL = 3004;
    public static final int MEDIA_INFO_SERVER_CHANGE = 931;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_START_PLAY = 10012;
    public static final int MEDIA_INFO_START_PULL_STREAM = 10013;
    public static final int MEDIA_INFO_STREAM_RECONNECED = 937;
    public static final int MEDIA_INFO_STREAM_RECONNECTING = 936;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_VIDEO_BITRATE = 939;
    public static final int MEDIA_INFO_VIDEO_CARLTON = 10009;
    public static final int MEDIA_INFO_VIDEO_DROP_FRAME = 10003;
    public static final int MEDIA_INFO_VIDEO_FRAMERATE = 940;
    public static final int MEDIA_INFO_VIDEO_NETWORK_DOWNLOAD_FIRST_PERIOD_SPEED = 909;
    public static final int MEDIA_INFO_VIDEO_NETWORK_DOWNLOAD_SPEED_SLOW = 908;
    public static final int MEDIA_INFO_VIDEO_PREPARED = 10005;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_SIZE_CHANGE = 10006;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int MEDIA_INFO_WEAK_NETWORK_BEST_RANK = 12005;
    public static final int MEDIA_WARNING_HDR_PLAY_EXCTION = 11012;
    public static final int MEDIA_WARNING_HDR_TYPE_UNSUPORT = 11014;
    public static final int MEDIA_WARNING_HDR_VIEW_UNSUPORT = 11016;
    public static final int MEDIA_WARNING_NOT_HDR_VIDEO = 11013;
    public static final int NETWORK_STATUS_GOOD = 2;
    public static final int NETWORK_STATUS_NORMAL = 1;
    public static final int NETWORK_STATUS_POOR = 0;
    public static final String OPT_BIND_4G = "video_bind_4g";
    public static final String OPT_BUFFER_CONFIG_JSON = "buffer_config_json";
    @Deprecated
    public static final String OPT_BUFFER_SIZE = "max-buffer-size";
    public static final String OPT_CHCHE_PATH = "cache-path";
    public static final String OPT_CLIENT_SET_URL_TIME = "client-set-url-time";
    public static final String OPT_CLIENT_USER_CLICK_TIME = "client-user-click-time";
    public static final String OPT_CUSTOM_CACHE_DIR = "custom-cache-directory";
    public static final String OPT_ENABLE_DISPLAY_FIRST_SCREEN_ON_PAUSED = "opt-paused-display-first-screen";
    public static final String OPT_ENABLE_FILECACHE = "enable_filecache";
    public static final String OPT_ENABLE_FIRSTSCREEN_ACCURATE_SEEK = "enable-firstscreen-accurate-seek";
    public static final String OPT_ENABLE_FLV_LIVE_QUIC = "opt-flv-live-quic";
    public static final String OPT_ENABLE_HLS_VOD_FILECACHE = "hls-vod-filecache-enable";
    public static final String OPT_ENABLE_KERNEL_NET = "kernel-net-enable";
    public static final String OPT_ENABLE_P2P = "p2p-enable";
    public static final String OPT_ENABLE_PCDN = "pcdn-enable";
    public static final String OPT_ENABLE_PREBUFFER = "prebuffer-enable";
    public static final String OPT_ENABLE_PRE_DECODE_ON_PREPARE = "opt-pre-decode-on-prepared";
    public static final String OPT_ENABLE_PRE_PREPARE = "opt-pre-prepared";
    public static final String OPT_ENABLE_PRE_RENDER_ON_PREPARE = "opt-pre-render-on-prepared";
    public static final String OPT_ENABLE_SEI_DATA_NOTIFICATION = "enable-sei-data-notification";
    public static final String OPT_ENABLE_START_ON_PREPARE = "start-on-prepared";
    public static final String OPT_FEED_VIDEO = "is-feed-video";
    public static final String OPT_FILECACHE_RESERVE_URL = "enable-filecache-reserve-url";
    @Deprecated
    public static final String OPT_FILE_MAX_SIZE = "file-max-size";
    @Deprecated
    public static final String OPT_FILE_MIN_SIZE = "file-min-size";
    public static final String OPT_FILE_SIZE = "file-size";
    public static final String OPT_FIRST_DISP_NOTIFY_SUB_T = "first_disp_notify_sub_thread";
    public static final String OPT_HTTP_PROXY = "http_proxy";
    public static final String OPT_IS_LIVE_VIDEO = "is_live_video";
    public static final String OPT_KERNEL_NET_NETHANDLE = "kernel-net-nethandle";
    public static final String OPT_MAX_FRAMES = "max-frames";
    public static final String OPT_MAX_MEMORY_BUFFER_SIZE = "max-buffer-size";
    public static final String OPT_MPD_AUTO = "mpd-auto";
    public static final String OPT_MPD_CLARITY = "mpd-clarity";
    public static final String OPT_MPD_CONTENT = "mpd-content";
    public static final String OPT_NEED_HTTP_REFERER = "need-http-referer";
    public static final String OPT_NEED_T5_AUTH = "need-t5-auth";
    public static final String OPT_NQE_SCORE = "nqe-score";
    public static final String OPT_PCDN_NETHANDLE = "pcdn-nethandle";
    public static final String OPT_PCDN_TYPE = "pcdn-type";
    public static final String OPT_PREPARSE_IP = "preparse_ip";
    public static final String OPT_SR_OPTION = "sr_option";
    public static final String OPT_STAGE_TYPE = "stage-type";
    public static final String OPT_SUPPORT_PROCESS = "support-process";
    public static final String OPT_SURFACE_UPDATE_MODE = "mediacodec-surface-update-mode";
    public static final String OPT_UPDATE_POS_INTERVAL = "update-current-position-interval";
    public static final String OPT_URL_REPLACE_HOST = "opt-url-replace-host";
    public static final String OPT_URL_REPLACE_HOST_ENABLE = "opt-url-enable-replace-host";
    public static final String OPT_USER_AGENT = "user_agent";
    public static final String OPT_VIDEO_BPS = "video-bps";
    public static final String OPT_VIDEO_MOOV_SIZE = "video-moov-size";
    public static final String OPT_VIDEO_ROTATE = "video-rorate";
    public static final int PRECONNECT_SERVER = 2;
    public static final int PREFETCH_DATA = 1;
    public static final int PREFETCH_DEFAULT = -1;
    public static final int PREFETCH_DISABLE = 0;
    public static final int PREFETCH_ENABLE = 1;
    public static final int SEEK_CLOSEST = 3;
    public static final int SEEK_PREVIOUS_SYNC = 0;
    public static final String STAGE_INFO_SOURCE = "stage_source";
    public static final String STAGE_INFO_TITLE = "stage_title";
    public static final String STAGE_INFO_TYPE = "stage_type";
    public static final String STORAGE_QUOTA_CRITICAL = "storage_quota_critical";
    public static final String STORAGE_QUOTA_NORMAL = "storage_quota_normal";
    public static final String STORAGE_QUOTA_WARNING = "storage_quota_warning";
    public static final String STR_IS_FEED_VIDEO = "is_feed_video";
    public static final String STR_STAGE_INFO = "stage_info";
    public static final String STR_STATISTICS_INFO = "statistics_info";
    public static final int SUCCESS = 0;
    public static final int SYSTEM_INFRA_KEY_BUILD_DATE_UTC = 8;
    public static final int SYSTEM_INFRA_KEY_MAX_CPU_FREQ = 7;
    public static final int SYSTEM_INFRA_KEY_NUM_PROCESSORS = 6;
    public static final int SYSTEM_INFRA_KEY_PM_SIZE_AVAILABLE = 9;
    public static final int SYSTEM_INFRA_KEY_VMPEEK = 1;
    public static final int SYSTEM_INFRA_KEY_VMSIZE = 0;
    public static final int SYSTEM_INFRA_KEY_VMSIZE_AVAILABLE = 4;
    public static final int SYSTEM_INFRA_KEY_VMSIZE_IN_SMAPS = 3;
    public static final int SYSTEM_INFRA_KEY_VMSIZE_SLICE = 5;
    public static final int StorageQuotaCritical = 104857600;
    public static final int StorageQuotaNormal = 314572800;
    public static final int StorageQuotaWarning = 209715200;
    public static final String TAG = "CyberPlayerManager";
    public static String VIDEO_FLOW_IS_PREFETCH = "video_flow_is_prefetch";
    public static String VIDEO_FLOW_STAGE = "video_flow_stage";
    public static String VIDEO_FLOW_URL = "video_flow_url";
    public static String VIDEO_FLOW_VALUE = "video_flow_value";
    public static final int VIDEO_SCALING_MODE_NOT_SCALE = 6;
    public static final int VIDEO_SCALING_MODE_SCALE_16_TO_9 = 5;
    public static final int VIDEO_SCALING_MODE_SCALE_4_TO_3 = 4;
    public static final int VIDEO_SCALING_MODE_SCALE_5_TO_4 = 3;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING = 0;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROP_BOTTOM = 10;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROP_LEFT = 7;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROP_RIGHT = 8;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROP_TOP = 9;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static final int VP9_HLG_TYPE = 8;
    public static int appID = -1;
    public static OnDeleteListener mDeleteListener;
    public static boolean mDeleting;
    public static GetNetHandleListener mGetNetHandleListener;
    public static HttpDNS2 mHttpDNS2;
    public static OnVideoFlowListener mOnVideoFlowListerer;
    public static boolean mUpdatingDiskQuota;
    public static OnUpdateDiskQuotaComplete mUpdatingListener;
    public static String sAppID;
    public static String sAppVersionName;
    public static Context sApplicationContext;
    public static String sClientID;
    public static ICyberMediaContext sCyberMeidaContext;
    public static int sInstallType;
    public static boolean sIsAutoDeleting;
    public static Class<?> sRemoteServiceClass;
    public static final Object deleteLock = new Object();
    public static final Object updateQuotaLock = new Object();
    public static Map<String, String> sInstallOpts = new HashMap();
    public static int sPcdnType = 0;

    @Keep
    /* loaded from: classes3.dex */
    public interface GetNetHandleListener {
        Long getKerNetHandle();

        Long getPcdnNetHandle();
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface HttpDNS {
        List<String> getIpList(String str);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface HttpDNS2 {
        List<String> getIpList2(String str, boolean z);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface InstallListener {
        void onInstallError(int i, int i2, String str);

        @Deprecated
        void onInstallProgress(int i, int i2);

        void onInstallSuccess(int i, String str);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface InstallListener2 extends InstallListener {
        void onInstallInfo(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes3.dex */
    public enum MediaSourceSwitchMode {
        MEDIASOURCE_SWITCH_ABR_MODE,
        MEDIASOURCE_SWITCH_FORCE_MODE
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnDeleteListener {
        void onDeleteComplete(int i, long j);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnErrorListener {
        boolean onError(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnInfoListener {
        boolean onInfo(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnMediaRuntimeInfoListener {
        void onRuntimeInfo(String str);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnMediaSourceChangedListener {
        boolean onMediaSourceChanged(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnPrefetchListener {
        void onPrefetchStatusChanged(String str, boolean z, int i, String str2);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnUpdateDiskQuotaComplete {
        void notifyCompletion();
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnVideoFlowListener {
        void onRecordFlow(HashMap<String, String> hashMap);
    }

    @Keep
    /* loaded from: classes3.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2, int i3, int i4);
    }

    public static int getNetworkStatus() {
        return 2;
    }

    public static boolean isBuildDebugMode() {
        return false;
    }

    @Keep
    public static boolean isRequestForbiddenError(int i) {
        return i == -2403 || i == -33403;
    }

    static {
        PlayerPolicyManager.getInstance().register(new CyberPlayerConfig());
        PlayerPolicyManager.getInstance().register(PlayerPolicyCfgManager.getInstance());
    }

    public static CyberAudioRecorder createCyberAudioRecorder() {
        CyberLog.d(TAG, "DuplayerCore Version:" + getCoreVersion() + " CyberSdk Version:" + getSDKVersion());
        return CyberPlayerCoreInvoker.createCyberAudioRecorder();
    }

    public static String getAppID() {
        return sAppID;
    }

    public static String getAppVerionName() {
        return sAppVersionName;
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static String getClientID() {
        return sClientID;
    }

    public static String getCoreVersion() {
        return CyberVersion.getCoreVersion();
    }

    public static ICyberMediaContext getCyberMediaContext() {
        return sCyberMeidaContext;
    }

    public static Map<String, String> getInstallOpts() {
        return sInstallOpts;
    }

    public static int getInstallType() {
        return sInstallType;
    }

    public static GetNetHandleListener getNetHandleListener() {
        return mGetNetHandleListener;
    }

    public static int getPcdnType() {
        return sPcdnType;
    }

    public static int getPrefetchUploadThres() {
        return CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_UPLOAD_PRELOG_THRES, -1);
    }

    public static Class<?> getRemoteServiceClass() {
        return sRemoteServiceClass;
    }

    public static String getSDKVersion() {
        return CyberVersion.getSDKVersion();
    }

    public static HashMap<Integer, Long> getSystemInfraInfo() {
        return CyberPlayerCoreInvoker.getSystemInfraInfo();
    }

    public static long getVideoCacheSize() {
        long videoCacheSize = Utils.getVideoCacheSize();
        CyberLog.d(TAG, "getVideoCacheSize:" + videoCacheSize);
        return videoCacheSize;
    }

    public static long getVideoCacheSizeCanBeCleared() {
        if (CyberAbTestManager.getAbSwitchInt("video_can_be_cleared_cache_size", 1) == 0) {
            return getVideoCacheSize();
        }
        long videoCacheSizeCanBeCleared = CyberPlayerCoreInvoker.getVideoCacheSizeCanBeCleared();
        CyberLog.d(TAG, "getVideoCacheSizeExcludeIgnore:" + videoCacheSizeCanBeCleared);
        return videoCacheSizeCanBeCleared;
    }

    public static boolean isAppInDebugMode() {
        Context context = sApplicationContext;
        if (context == null) {
            return false;
        }
        try {
            if ((context.getApplicationInfo().flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isCoreLoaded() {
        return isCoreLoaded(sInstallType);
    }

    public static boolean isMPDSupported() {
        return CyberCfgManager.getInstance().getCfgBoolValueFast(CyberCfgManager.KEY_INT_ENABLE_MPD, true);
    }

    public static void kernelNetInit() {
        CyberPlayerCoreInvoker.kernelNetInit();
    }

    public static void onExit() {
        CyberLog.i(TAG, "onExit call by app");
    }

    public static void pcdnNetInit() {
        CyberPlayerCoreInvoker.pcdnNetInit();
    }

    public static void saveFilecacheConfig() {
        sendGlobalCommondToRemote("saveFilecacheConfig", 0, 0L, null, null);
    }

    public static CyberVRRenderProvider createCyberVRRender(Context context) {
        return CyberPlayerCoreInvoker.createCyberVRRender(context);
    }

    public static void deleteVideoCache(OnDeleteListener onDeleteListener) {
        if (!mDeleting) {
            mDeleting = true;
            mDeleteListener = onDeleteListener;
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberPlayerManager.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CyberPlayerManager.deleteLock) {
                        CyberPlayerManager.sendGlobalCommondToRemote("deleteVideoCache", 0, 0L, null, null);
                        long cleanFilecache = Utils.cleanFilecache(Boolean.TRUE);
                        if (CyberPlayerManager.mDeleteListener != null) {
                            if (cleanFilecache < 0) {
                                CyberPlayerManager.mDeleteListener.onDeleteComplete((int) cleanFilecache, 0L);
                            } else {
                                CyberPlayerManager.mDeleteListener.onDeleteComplete(0, cleanFilecache);
                            }
                        }
                        boolean unused = CyberPlayerManager.mDeleting = false;
                        OnDeleteListener unused2 = CyberPlayerManager.mDeleteListener = null;
                    }
                }
            });
        } else if (onDeleteListener != null) {
            onDeleteListener.onDeleteComplete(-2, 0L);
        }
    }

    public static List<String> getIPListWithHost(String str) {
        HttpDNS2 httpDNS2 = mHttpDNS2;
        if (httpDNS2 == null) {
            return null;
        }
        return httpDNS2.getIpList2(str, false);
    }

    public static Object getLibPath(int i) {
        CyberCoreLoaderManager.getInstance();
        return CyberCoreLoaderManager.getLibPath(i);
    }

    public static boolean hasCacheFile(String str) {
        return CyberPlayerCoreInvoker.hasCacheFile(str);
    }

    public static boolean isCoreLoaded(int i) {
        return CyberPlayerCoreInvoker.isLoaded(i);
    }

    public static void preResolveHosts(List<String> list) {
        CyberLog.d(CyberPlayer.TAG, "preResolveHosts hosts: " + list);
        if (mHttpDNS2 != null) {
            for (String str : list) {
                mHttpDNS2.getIpList2(str, false);
            }
        }
    }

    public static void setCollectVideoFlow(OnVideoFlowListener onVideoFlowListener) {
        mOnVideoFlowListerer = onVideoFlowListener;
    }

    public static void setCyberMediaContext(ICyberMediaContext iCyberMediaContext) {
        sCyberMeidaContext = iCyberMediaContext;
        PlayConfigABContext.setPlayConfigABTest(new PlayConfigABTest());
    }

    public static void setHttpDNS2(HttpDNS2 httpDNS2) {
        mHttpDNS2 = httpDNS2;
    }

    public static void setNetHandleListener(GetNetHandleListener getNetHandleListener) {
        mGetNetHandleListener = getNetHandleListener;
    }

    public static void setPrefetchListener(OnPrefetchListener onPrefetchListener) {
        CyberPlayerCoreInvoker.setPrefetchListener(onPrefetchListener);
    }

    public static void stopPrefetch(String str) {
        CyberPlayerCoreInvoker.stopPrefetch(str);
    }

    public static void videoFlowCallback(HashMap<String, String> hashMap) {
        OnVideoFlowListener onVideoFlowListener = mOnVideoFlowListerer;
        if (onVideoFlowListener != null) {
            onVideoFlowListener.onRecordFlow(hashMap);
        }
    }

    public static PlayerProvider createCyberPlayer(int i, HttpDNS httpDNS) {
        CyberLog.d(TAG, "DuplayerCore Version:" + getCoreVersion() + " CyberSdk Version:" + getSDKVersion());
        return PlayerProviderFactory.getInstance().create(i, httpDNS, false);
    }

    public static void doDiskAutoClean(int i, final int i2) {
        if (!sIsAutoDeleting) {
            sIsAutoDeleting = true;
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberPlayerManager.3
                @Override // java.lang.Runnable
                public void run() {
                    int i3 = i2;
                    if (i3 == 2) {
                        long cfgLongValue = CyberCfgManager.getInstance().getCfgLongValue("disk_critical_clean_max_size", Utils.DEFAULT_CRITICAL_THRESHOLD);
                        CyberPlayerCoreInvoker.cleanFileCacheWithThreshold(cfgLongValue);
                        CyberPlayerManager.sendGlobalCommondToRemote("diskAutoClean", 0, cfgLongValue, null, null);
                    } else if (i3 == 1) {
                        long cfgLongValue2 = CyberCfgManager.getInstance().getCfgLongValue("disk_critical_clean_max_size", Utils.DEFAULT_WARING_THRESHOLD);
                        CyberPlayerCoreInvoker.cleanFileCacheWithThreshold(cfgLongValue2);
                        CyberPlayerManager.sendGlobalCommondToRemote("diskAutoClean", 0, cfgLongValue2, null, null);
                    }
                    boolean unused = CyberPlayerManager.sIsAutoDeleting = false;
                }
            });
        }
    }

    public static void removeVideoReserveUrl(String str, boolean z) {
        sendGlobalCommondToRemote("removeFilecacheReserveUrl", z ? 1 : 0, 0L, str, null);
    }

    public static boolean duplayerEncrypt(byte[] bArr, int i, byte[] bArr2) {
        return CyberPlayerCoreInvoker.duplayerEncrypt(bArr, i, bArr2);
    }

    public static void onDiskUsageLevelChangedCallback(int i, final int i2, OnUpdateDiskQuotaComplete onUpdateDiskQuotaComplete) {
        if (!mUpdatingDiskQuota) {
            mUpdatingDiskQuota = true;
            mUpdatingListener = onUpdateDiskQuotaComplete;
            CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberPlayerManager.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CyberPlayerManager.updateQuotaLock) {
                        Utils.updateStorageQuota(CyberPlayerManager.quotaWithLevel(i2));
                        if (CyberPlayerManager.mUpdatingListener != null) {
                            CyberPlayerManager.mUpdatingListener.notifyCompletion();
                        }
                        boolean unused = CyberPlayerManager.mUpdatingDiskQuota = false;
                        OnUpdateDiskQuotaComplete unused2 = CyberPlayerManager.mUpdatingListener = null;
                    }
                }
            });
        } else if (onUpdateDiskQuotaComplete != null) {
            onUpdateDiskQuotaComplete.notifyCompletion();
        }
    }

    public static int getDeviceHDRSupported(int i, int i2, int i3) {
        boolean z;
        if (sApplicationContext == null) {
            return -1;
        }
        if (CyberCfgManager.getInstance().isWhiteDevideForHDR() && !CyberCfgManager.getInstance().isBlackDeviceForHDR()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            CyberLog.i(TAG, "getDeviceHDRSupported not support:not in whiteList or in blackList");
            return 0;
        } else if (!isCoreLoaded(1)) {
            return -1;
        } else {
            return CyberPlayerCoreInvoker.getDeviceHDRSupported(i, i2, i3);
        }
    }

    public static int getDevicePlayQualityScore(String str, int i, int i2, int i3, Map<String, String> map) {
        return CyberPlayerCoreInvoker.getDevicePlayQualityScore(str, i, i2, i3, map);
    }

    @Deprecated
    public static void preconnect(String str, String str2, String str3, int i, HttpDNS httpDNS) {
        CyberPlayerCoreInvoker.prefetch(str, str2, str3, 2, 0, i, httpDNS, "", -1, -1, -1, -1, null);
    }

    @Deprecated
    public static void prefetch(String str, String str2, String str3, int i, HttpDNS httpDNS) {
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_PREFETCH);
        PlayerConfigManager.startRequestPlayerServerCfg();
        CyberPlayerCoreInvoker.prefetch(str, str2, str3, 1, 0, i, httpDNS, "", -1, -1, -1, -1, null);
    }

    public static void sendGlobalCommondToRemote(String str, int i, long j, String str2, PrefetchOptions prefetchOptions) {
        RemotePlayerFactory.getInstance().sendGlobalCommondToRemote(str, i, j, str2, prefetchOptions);
    }

    public static synchronized void install(Context context, int i, Class<?> cls, InstallListener2 installListener2) throws Exception {
        synchronized (CyberPlayerManager.class) {
            ICyberMediaContext cyberMediaContext = getCyberMediaContext();
            if (cyberMediaContext != null) {
                ICyberGlobalOptions cyberGlobalOptions = cyberMediaContext.getCyberGlobalOptions();
                if (cyberGlobalOptions != null) {
                    HashMap hashMap = new HashMap();
                    CyberAbTestManager.parseCyberMediaAllAbs();
                    CyberAbTestManager.collectOriginAbs(hashMap);
                    int pcdnType = cyberGlobalOptions.getPcdnType();
                    int crashPadInstallType = cyberGlobalOptions.getCrashPadInstallType();
                    hashMap.put(INSTALL_OPT_CRASHPAD_INSTALL_TYPE, crashPadInstallType + "");
                    hashMap.put("abtest_sid", cyberGlobalOptions.getAllSid());
                    install(context, cyberGlobalOptions.getClientId(), cyberGlobalOptions.getDownloadCoreServer(), i, cls, (Map<String, String>) hashMap, installListener2, pcdnType);
                } else {
                    throw new IllegalArgumentException("ICyberGlobalOptions is null");
                }
            } else {
                throw new IllegalArgumentException("ICyberMediaContext is null");
            }
        }
    }

    public static synchronized void install(Context context, int i, Class<?> cls, InstallListener installListener) throws Exception {
        synchronized (CyberPlayerManager.class) {
            ICyberMediaContext cyberMediaContext = getCyberMediaContext();
            if (cyberMediaContext != null) {
                ICyberGlobalOptions cyberGlobalOptions = cyberMediaContext.getCyberGlobalOptions();
                if (cyberGlobalOptions != null) {
                    HashMap hashMap = new HashMap();
                    CyberAbTestManager.parseCyberMediaAllAbs();
                    CyberAbTestManager.collectOriginAbs(hashMap);
                    int pcdnType = cyberGlobalOptions.getPcdnType();
                    int crashPadInstallType = cyberGlobalOptions.getCrashPadInstallType();
                    hashMap.put(INSTALL_OPT_CRASHPAD_INSTALL_TYPE, crashPadInstallType + "");
                    hashMap.put("abtest_sid", cyberGlobalOptions.getAllSid());
                    install(context, cyberGlobalOptions.getClientId(), cyberGlobalOptions.getDownloadCoreServer(), i, cls, hashMap, installListener, pcdnType);
                } else {
                    throw new IllegalArgumentException("ICyberGlobalOptions is null");
                }
            } else {
                throw new IllegalArgumentException("ICyberMediaContext is null");
            }
        }
    }

    @Deprecated
    public static synchronized void install(Context context, String str, String str2, int i) throws Exception {
        synchronized (CyberPlayerManager.class) {
            install(context, str, str2, 7, (Class<?>) null, (Map<String, String>) null, (InstallListener2) null, i);
        }
    }

    public static synchronized void install(Context context, String str, String str2, int i, Class<?> cls, Map<String, String> map, InstallListener2 installListener2) throws Exception {
        int i2;
        ICyberGlobalOptions cyberGlobalOptions;
        synchronized (CyberPlayerManager.class) {
            if (sPcdnType > 0) {
                install(context, str, str2, i, cls, map, installListener2, sPcdnType);
            } else {
                ICyberMediaContext cyberMediaContext = getCyberMediaContext();
                if (cyberMediaContext != null && (cyberGlobalOptions = cyberMediaContext.getCyberGlobalOptions()) != null) {
                    i2 = cyberGlobalOptions.getPcdnType();
                } else {
                    i2 = 0;
                }
                install(context, str, str2, i, cls, map, installListener2, i2);
            }
        }
    }

    public static synchronized void install(Context context, String str, String str2, int i, Class<?> cls, Map<String, String> map, InstallListener2 installListener2, int i2) throws Exception {
        synchronized (CyberPlayerManager.class) {
            try {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        Context applicationContext = context.getApplicationContext();
                        sApplicationContext = applicationContext;
                        PlayerPolicyRuntime.init(applicationContext);
                        sClientID = str;
                        sInstallType |= i;
                        sRemoteServiceClass = cls;
                        sAppID = context.getPackageName();
                        sPcdnType = i2;
                        if (map != null) {
                            sInstallOpts.putAll(map);
                            parserGlobalInstallOptions(map);
                        }
                        int i3 = i | 64;
                        if (Build.VERSION.SDK_INT > 23) {
                            i3 |= 128;
                        }
                        CyberCoreLoaderManager.getInstance().load(str2, i3, map, installListener2);
                    } else {
                        throw new NullPointerException("clienID is null");
                    }
                } else {
                    throw new NullPointerException("context is null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static synchronized void install(Context context, String str, String str2, int i, Class<?> cls, Map<String, String> map, InstallListener installListener) throws Exception {
        int i2;
        ICyberGlobalOptions cyberGlobalOptions;
        synchronized (CyberPlayerManager.class) {
            ICyberMediaContext cyberMediaContext = getCyberMediaContext();
            if (cyberMediaContext != null && (cyberGlobalOptions = cyberMediaContext.getCyberGlobalOptions()) != null) {
                i2 = cyberGlobalOptions.getPcdnType();
            } else {
                i2 = 0;
            }
            install(context, str, str2, i, cls, map, installListener, i2);
        }
    }

    @Deprecated
    public static void prefetch(String str, String str2, String str3, int i, int i2, HttpDNS httpDNS, String str4) {
        String str5;
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_PREFETCH);
        PlayerConfigManager.startRequestPlayerServerCfg();
        CyberPlayerCoreInvoker.prefetch(str, str2, str3, 1, i, i2, httpDNS, str5, -1, -1, -1, -1, null);
    }

    @Deprecated
    public static synchronized void install(Context context, String str, String str2, int i, Class<?> cls, Map<String, String> map, InstallListener installListener, int i2) throws Exception {
        synchronized (CyberPlayerManager.class) {
            try {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        Context applicationContext = context.getApplicationContext();
                        sApplicationContext = applicationContext;
                        PlayerPolicyRuntime.init(applicationContext);
                        sClientID = str;
                        sInstallType |= i;
                        sRemoteServiceClass = cls;
                        sAppID = context.getPackageName();
                        if (map != null) {
                            sInstallOpts.putAll(map);
                            parserGlobalInstallOptions(map);
                        }
                        sPcdnType = i2;
                        int i3 = i | 64;
                        if (Build.VERSION.SDK_INT > 23) {
                            i3 |= 128;
                        }
                        CyberCoreLoaderManager.getInstance().load(str2, i3, map, installListener);
                    } else {
                        throw new NullPointerException("clienID is null");
                    }
                } else {
                    throw new NullPointerException("context is null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void onAppDiskCacheChanged(int i, int i2) {
        boolean z = true;
        if (CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_DISK_AUTO_CLEAN_ENABLE, 1) == 1) {
            long prefLong = CyberCfgManager.getInstance().getPrefLong(Utils.LAST_DISK_AUTO_CLEAN_TIME, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (prefLong > 0) {
                if (currentTimeMillis - prefLong <= Utils.getCacheInterval()) {
                    z = false;
                }
                if (z) {
                    doDiskAutoClean(i, i2);
                    CyberCfgManager.getInstance().setPrefLong(Utils.LAST_DISK_AUTO_CLEAN_TIME, currentTimeMillis);
                    return;
                }
                return;
            }
            doDiskAutoClean(i, i2);
            CyberCfgManager.getInstance().setPrefLong(Utils.LAST_DISK_AUTO_CLEAN_TIME, currentTimeMillis);
        }
    }

    public static void parserGlobalInstallOptions(Map<String, String> map) {
        boolean z;
        PackageManager packageManager;
        String str;
        if (map != null) {
            String str2 = map.get(INSTALL_OPT_ENABLE_SF_SWITCH);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (Integer.parseInt(str2) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        CyberLog.i(TAG, "parserGlobalInstallOptions isSpringFestivalEnable TRUE !! ");
                        CyberGlobalSetting.getInstance().setSFSwitchEnable(true);
                    }
                } catch (Exception unused) {
                }
            }
            String str3 = map.get(INSTALL_OPT_APP_VERSION_NAME);
            if (!TextUtils.isEmpty(str3)) {
                CyberLog.i(TAG, "parserGlobalInstallOptions app version name:" + str3);
                sAppVersionName = str3;
                return;
            }
            Context context = sApplicationContext;
            if (context != null && (packageManager = context.getPackageManager()) != null && (str = sAppID) != null) {
                try {
                    sAppVersionName = packageManager.getPackageInfo(str, 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    CyberLog.e(TAG, e.getMessage());
                }
            }
        }
    }

    @Deprecated
    public static void preconnect(String str, String str2, String str3, int i, HttpDNS httpDNS, String str4) {
        String str5;
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        CyberPlayerCoreInvoker.prefetch(str, str2, str3, 2, 0, i, httpDNS, str5, -1, -1, -1, -1, null);
    }

    @Deprecated
    public static void prefetch(String str, String str2, String str3, int i, int i2, HttpDNS httpDNS) {
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_PREFETCH);
        PlayerConfigManager.startRequestPlayerServerCfg();
        CyberPlayerCoreInvoker.prefetch(str, str2, str3, 1, i, i2, httpDNS, "", -1, -1, -1, -1, null);
    }

    public static void preconnect(String str, String str2, String str3, int i, HttpDNS httpDNS, String str4, int i2, int i3, int i4, int i5) {
        String str5;
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        CyberPlayerCoreInvoker.prefetch(str, str2, str3, 2, 0, i, httpDNS, str5, i2, i3, i4, i5, null);
    }

    public static void prefetch(String str, String str2, String str3, int i, int i2, HttpDNS httpDNS, String str4, int i3, int i4, int i5, int i6, PrefetchOptions prefetchOptions) {
        String str5;
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_PREFETCH);
        PlayerConfigManager.startRequestPlayerServerCfg();
        CyberPlayerCoreInvoker.prefetch(str, str2, str3, 1, i, i2, httpDNS, str5, i3, i4, i5, i6, prefetchOptions);
    }

    @Deprecated
    public static void prefetch(String str, String str2, String str3, int i, HttpDNS httpDNS, String str4) {
        String str5;
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        PlayerConfigManager.setRequestSource(PlayerPolicyManager.REQ_SOURCE_PREFETCH);
        PlayerConfigManager.startRequestPlayerServerCfg();
        CyberPlayerCoreInvoker.prefetch(str, str2, str3, 1, 0, i, httpDNS, str5, -1, -1, -1, -1, null);
    }

    public static long quotaWithLevel(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return CyberCfgManager.getInstance().getCfgLongValue(STORAGE_QUOTA_NORMAL, 314572800L);
                }
                return CyberCfgManager.getInstance().getCfgLongValue(STORAGE_QUOTA_CRITICAL, 104857600L);
            }
            return CyberCfgManager.getInstance().getCfgLongValue(STORAGE_QUOTA_WARNING, 209715200L);
        }
        return CyberCfgManager.getInstance().getCfgLongValue(STORAGE_QUOTA_NORMAL, 314572800L);
    }
}
