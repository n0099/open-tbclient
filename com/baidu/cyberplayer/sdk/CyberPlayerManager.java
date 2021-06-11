package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.remote.PrefetchOptions;
import com.baidu.searchbox.playerserver.PlayerPolicyManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class CyberPlayerManager {
    public static final int ABR_MODE = -1;
    public static final int COMMAND_ADD_STAGE_INFO = 1001;
    public static final int COMMAND_ON_FIRST_FRAME_DRAWED = 1002;
    public static final int COMMAND_SET_STATISTIC_INFO = 1003;
    public static final int COMMAND_USER_CLICK_START = 1000;
    public static final int CYBER_RENDER_TYPE_GLSURFACEVIEW = 0;
    public static final int CYBER_RENDER_TYPE_SURFACEVIEW = 2;
    public static final int CYBER_RENDER_TYPE_TEXTUREVIEW = 1;
    public static final int DECODE_MODE_AUTO = 0;
    public static final int DECODE_MODE_HW = 2;
    public static final int DECODE_MODE_SW = 1;
    public static final int DECODE_MODE_SYS = 4;
    public static final int DELETING = -2;
    public static final int DIR_NOT_EXIST = -1;
    public static final int DP_MSG_INFO_CACHE_DURATION = 953;
    public static final int DiskLevelCritical = 2;
    public static final int DiskLevelNormal = 0;
    public static final int DiskLevelWarning = 1;
    public static final String INSTALL_OPT_ABTEST_SID = "abtest_sid";
    public static final String INSTALL_OPT_ABTEST_SWITCH_START_CODE = "cybermedia_abtest_";
    public static final String INSTALL_OPT_APP_VERSION_NAME = "app_version_name";
    public static final String INSTALL_OPT_CRASHPAD_INSTALL_TYPE = "crashpad_install_type";
    public static final String INSTALL_OPT_ENABLE_SF_SWITCH = "enable_spring_festival";
    public static final String INSTALL_OPT_PIPELINE_NUM = "pipeline_count";
    public static final String INSTALL_OPT_PROCESS_TYPE = "process_type";
    @Deprecated
    public static final int INSTALL_TYPE_ALL = 7;
    public static final int INSTALL_TYPE_CYBER_MEDIA = 1;
    public static final int LIB_TYPE_CRASHPAD = 16;
    public static final int LIB_TYPE_FFMPEG_EXTEND = 4;
    public static final int LIB_TYPE_PCDN = 2;
    @Deprecated
    public static final int LIB_TYPE_RTC = 32;
    public static final int LIB_TYPE_STRATEGY_OPTIMIZE = 64;
    public static final int LIB_TYPE_VIDEO_SR = 8;
    public static final int MEDIA_ERROR_FOMAT_DEMUXER_NOT_FOUND = -2006;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_OPEN_VIDEO_FAIL = -111;
    public static final int MEDIA_ERROR_REMOTE_DIED = -30001;
    public static final int MEDIA_ERROR_REMOTE_EXCEPTION = -30000;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_SETDATASOURCE_EXCEPTION = -10001;
    public static final int MEDIA_ERROR_STATE_EXCEPTION = -10002;
    public static final int MEDIA_ERROR_SURFACE_EXCEPTION = -10000;
    public static final int MEDIA_ERROR_TIMED_OUT = -110;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = -1010;
    public static final int MEDIA_INFO_AUDIO_BITRATE = 938;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_CONNECTED_SERVER = 10015;
    public static final int MEDIA_INFO_CONNECT_BEGIN = 919;
    public static final int MEDIA_INFO_CONNECT_END = 920;
    public static final int MEDIA_INFO_DECODE_FAIL = 10008;
    public static final int MEDIA_INFO_DECODE_MODE_CHANGED = 10102;
    public static final int MEDIA_INFO_DNS_BEGIN = 917;
    public static final int MEDIA_INFO_DNS_END = 918;
    public static final int MEDIA_INFO_DNS_EXCEPTION = 10014;
    public static final int MEDIA_INFO_EXTEND_CARLTON_FOUND = 925;
    public static final int MEDIA_INFO_EXTEND_SERVER_CHANGE = 5000;
    public static final int MEDIA_INFO_EXTEND_VIDEO_CACHE_PROGRESS = 946;
    public static final int MEDIA_INFO_EXTEND_VIDEO_DOWNLOAD_SPEED = 924;
    public static final int MEDIA_INFO_EXTENT_DOWNLOAD_PERCENT = 262144;
    public static final int MEDIA_INFO_FIRST_DISP_INTERVAL = 904;
    public static final int MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE = 10011;
    public static final int MEDIA_INFO_HARDWARE_START_FAIL_CHANGE_MODE = 10010;
    public static final int MEDIA_INFO_KERNEL_NET_TRAFFIC = 11002;
    public static final int MEDIA_INFO_LOOP_REPLAYED = 955;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NET_RECONNECTING = 923;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_ON_SEI_DATA_CHANGED = 10103;
    public static final int MEDIA_INFO_PCDN_TRAFFIC = 11000;
    public static final int MEDIA_INFO_PLAY_COMPLETE = 10004;
    public static final int MEDIA_INFO_PRERENDER_COMPLETE = 12006;
    public static final int MEDIA_INFO_PROCESS = 910;
    public static final int MEDIA_INFO_RESPONSE_BEGIN = 921;
    public static final int MEDIA_INFO_RESPONSE_END = 922;
    public static final int MEDIA_INFO_RESTART_PLAYED = 956;
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
    public static final int NETWORK_STATUS_GOOD = 2;
    public static final int NETWORK_STATUS_NORMAL = 1;
    public static final int NETWORK_STATUS_POOR = 0;
    public static final String OPT_BUFFER_SIZE = "max-buffer-size";
    public static final String OPT_CHCHE_PATH = "cache-path";
    public static final String OPT_CLIENT_SET_URL_TIME = "client-set-url-time";
    public static final String OPT_CLIENT_USER_CLICK_TIME = "client-user-click-time";
    public static final String OPT_ENABLE_FILECACHE = "enable_filecache";
    public static final String OPT_ENABLE_FIRSTSCREEN_ACCURATE_SEEK = "enable-firstscreen-accurate-seek";
    public static final String OPT_ENABLE_HLS_VOD_FILECACHE = "hls-vod-filecache-enable";
    public static final String OPT_ENABLE_KERNEL_NET = "kernel-net-enable";
    public static final String OPT_ENABLE_P2P = "p2p-enable";
    public static final String OPT_ENABLE_PCDN = "pcdn-enable";
    public static final String OPT_ENABLE_PREBUFFER = "prebuffer-enable";
    public static final String OPT_ENABLE_PRE_RENDER_ON_PREPARE = "pre-render-on-prepared-enable";
    public static final String OPT_ENABLE_SEI_DATA_NOTIFICATION = "enable-sei-data-notification";
    public static final String OPT_FEED_VIDEO = "is-feed-video";
    public static final String OPT_FILE_MAX_SIZE = "file-max-size";
    public static final String OPT_FILE_MIN_SIZE = "file-min-size";
    public static final String OPT_FILE_SIZE = "file-size";
    public static final String OPT_HTTP_PROXY = "http_proxy";
    public static final String OPT_IS_LIVE_VIDEO = "is_live_video";
    public static final String OPT_KERNEL_NET_NETHANDLE = "kernel-net-nethandle";
    public static final String OPT_MAX_FRAMES = "max-frames";
    public static final String OPT_NEED_HTTP_REFERER = "need-http-referer";
    public static final String OPT_NEED_T5_AUTH = "need-t5-auth";
    public static final String OPT_PCDN_NETHANDLE = "pcdn-nethandle";
    public static final String OPT_PCDN_TYPE = "pcdn-type";
    public static final String OPT_PREPARSE_IP = "preparse_ip";
    public static final String OPT_SR_OPTION = "sr_option";
    public static final String OPT_STAGE_TYPE = "stage-type";
    public static final String OPT_SUPPORT_PROCESS = "support-process";
    public static final String OPT_VIDEO_BPS = "video-bps";
    public static final String OPT_VIDEO_MOOV_SIZE = "video-moov-size";
    public static final String OPT_VIDEO_ROTATE = "video-rorate";
    public static final int PRECONNECT_SERVER = 1;
    public static final int PREFETCH_DATA = 0;
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

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4727a = false;
    public static int appID = -1;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4728b = false;

    /* renamed from: c  reason: collision with root package name */
    public static OnDeleteListener f4729c;

    /* renamed from: d  reason: collision with root package name */
    public static OnUpdateDiskQuotaComplete f4730d;

    /* renamed from: e  reason: collision with root package name */
    public static OnVideoFlowListener f4731e;

    /* renamed from: f  reason: collision with root package name */
    public static HttpDNS2 f4732f;

    /* renamed from: g  reason: collision with root package name */
    public static GetNetHandleListener f4733g;
    public static Context j;
    public static String k;
    public static int l;
    public static String m;
    public static String n;
    public static Class<?> o;

    /* renamed from: h  reason: collision with root package name */
    public static final Object f4734h = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static final Object f4735i = new Object();
    public static Map<String, String> p = new HashMap();

    @Keep
    /* loaded from: classes2.dex */
    public interface GetNetHandleListener {
        Long getKerNetHandle();

        Long getPcdnNetHandle();
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface HttpDNS {
        List<String> getIpList(String str);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface HttpDNS2 {
        List<String> getIpList2(String str, boolean z);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface InstallListener {
        void onInstallError(int i2, int i3, String str);

        void onInstallProgress(int i2, int i3);

        void onInstallSuccess(int i2, String str);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i2);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnDeleteListener {
        void onDeleteComplete(int i2, long j);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnErrorListener {
        boolean onError(int i2, int i3, Object obj);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnInfoListener {
        boolean onInfo(int i2, int i3, Object obj);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnMediaSourceChangedListener {
        boolean onMediaSourceChanged(int i2, int i3, Object obj);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnUpdateDiskQuotaComplete {
        void notifyCompletion();
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnVideoFlowListener {
        void onRecordFlow(HashMap<String, String> hashMap);
    }

    @Keep
    /* loaded from: classes2.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i2, int i3, int i4, int i5);
    }

    static {
        PlayerPolicyManager.getInstance().register(new CyberPlayerConfig());
    }

    public static void a(Map<String, String> map) {
        if (map != null) {
            String str = map.get(INSTALL_OPT_ENABLE_SF_SWITCH);
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (Integer.parseInt(str) == 1) {
                        CyberLog.i("CyberPlayerManager", "parserGlobalInstallOptions isSpringFestivalEnable TRUE !! ");
                        c.a().a(true);
                    }
                } catch (Exception unused) {
                }
            }
            String str2 = map.get(INSTALL_OPT_APP_VERSION_NAME);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            CyberLog.i("CyberPlayerManager", "parserGlobalInstallOptions app version name:" + str2);
            n = str2;
        }
    }

    public static long b(int i2) {
        CyberCfgManager cyberCfgManager;
        long j2 = 314572800;
        String str = STORAGE_QUOTA_NORMAL;
        if (i2 != 0) {
            if (i2 == 1) {
                cyberCfgManager = CyberCfgManager.getInstance();
                j2 = 209715200;
                str = STORAGE_QUOTA_WARNING;
            } else if (i2 == 2) {
                cyberCfgManager = CyberCfgManager.getInstance();
                j2 = 104857600;
                str = STORAGE_QUOTA_CRITICAL;
            }
            return cyberCfgManager.getCfgLongValue(str, j2);
        }
        cyberCfgManager = CyberCfgManager.getInstance();
        return cyberCfgManager.getCfgLongValue(str, j2);
    }

    public static CyberAudioRecorder createCyberAudioRecorder() {
        CyberLog.d("CyberPlayerManager", "DuplayerCore Version:" + getCoreVersion() + " CyberSdk Version:" + getSDKVersion());
        return d.d();
    }

    public static PlayerProvider createCyberPlayer(int i2, HttpDNS httpDNS) {
        CyberLog.d("CyberPlayerManager", "DuplayerCore Version:" + getCoreVersion() + " CyberSdk Version:" + getSDKVersion());
        return m.a().a(i2, httpDNS, false);
    }

    public static CyberVRRenderProvider createCyberVRRender(Context context) {
        return d.a(context);
    }

    public static void deleteVideoCache(OnDeleteListener onDeleteListener) {
        if (f4727a) {
            if (onDeleteListener != null) {
                onDeleteListener.onDeleteComplete(-2, 0L);
                return;
            }
            return;
        }
        f4727a = true;
        f4729c = onDeleteListener;
        CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberPlayerManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CyberPlayerManager.f4734h) {
                    long a2 = o.a(Boolean.TRUE);
                    if (CyberPlayerManager.f4729c != null) {
                        if (a2 < 0) {
                            CyberPlayerManager.f4729c.onDeleteComplete((int) a2, 0L);
                        } else {
                            CyberPlayerManager.f4729c.onDeleteComplete(0, a2);
                        }
                    }
                    boolean unused = CyberPlayerManager.f4727a = false;
                    OnDeleteListener unused2 = CyberPlayerManager.f4729c = null;
                }
            }
        });
    }

    public static boolean duplayerEncrypt(byte[] bArr, int i2, byte[] bArr2) {
        return d.a(bArr, i2, bArr2);
    }

    public static String getAppID() {
        return m;
    }

    public static String getAppVerionName() {
        return n;
    }

    public static Context getApplicationContext() {
        return j;
    }

    public static String getClientID() {
        return k;
    }

    public static String getCoreVersion() {
        String a2 = d.a();
        return TextUtils.isEmpty(a2) ? "0.0.0.0" : a2;
    }

    public static int getDevicePlayQualityScore(String str, int i2, int i3, int i4, Map<String, String> map) {
        return d.a(str, i2, i3, i4, map);
    }

    public static List<String> getIPListWithHost(String str) {
        HttpDNS2 httpDNS2 = f4732f;
        if (httpDNS2 == null) {
            return null;
        }
        return httpDNS2.getIpList2(str, false);
    }

    public static Map<String, String> getInstallOpts() {
        return p;
    }

    public static int getInstallType() {
        return l;
    }

    public static GetNetHandleListener getNetHandleListener() {
        return f4733g;
    }

    public static int getNetworkStatus() {
        return 2;
    }

    public static int getPrefetchUploadThres() {
        return CyberCfgManager.getInstance().getCfgIntValue("upload_prelog_thres", -1);
    }

    public static Class<?> getRemoteServiceClass() {
        return o;
    }

    public static String getSDKVersion() {
        return SDKVersion.VERSION;
    }

    public static HashMap<Integer, Long> getSystemInfraInfo() {
        return d.j();
    }

    public static long getVideoCacheSize() {
        long k2 = o.k();
        CyberLog.d("CyberPlayerManager", "getVideoCacheSize:" + k2);
        return k2;
    }

    public static boolean hasCacheFile(String str) {
        return d.c(str);
    }

    @Deprecated
    public static synchronized void install(Context context, String str, String str2) throws Exception {
        synchronized (CyberPlayerManager.class) {
            install(context, str, str2, 7, null, null, null);
        }
    }

    public static synchronized void install(Context context, String str, String str2, int i2, Class<?> cls, Map<String, String> map, InstallListener installListener) throws Exception {
        synchronized (CyberPlayerManager.class) {
            try {
                if (context == null) {
                    throw new NullPointerException("context is null");
                }
                if (TextUtils.isEmpty(str)) {
                    throw new NullPointerException("clienID is null");
                }
                j = context.getApplicationContext();
                k = str;
                l |= i2;
                o = cls;
                m = context.getPackageName();
                if (map != null) {
                    p.putAll(map);
                    a(map);
                }
                CyberCoreLoaderManager.a().a(str2, i2 | 64, map, installListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isCoreLoaded() {
        return isCoreLoaded(l);
    }

    public static boolean isCoreLoaded(int i2) {
        return d.a(i2);
    }

    public static void onDiskUsageLevelChangedCallback(int i2, final int i3, OnUpdateDiskQuotaComplete onUpdateDiskQuotaComplete) {
        if (f4728b) {
            if (onUpdateDiskQuotaComplete != null) {
                onUpdateDiskQuotaComplete.notifyCompletion();
                return;
            }
            return;
        }
        f4728b = true;
        f4730d = onUpdateDiskQuotaComplete;
        CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberPlayerManager.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CyberPlayerManager.f4735i) {
                    o.a(CyberPlayerManager.b(i3));
                    if (CyberPlayerManager.f4730d != null) {
                        CyberPlayerManager.f4730d.notifyCompletion();
                    }
                    boolean unused = CyberPlayerManager.f4728b = false;
                    OnUpdateDiskQuotaComplete unused2 = CyberPlayerManager.f4730d = null;
                }
            }
        });
    }

    public static void onExit() {
        CyberLog.i("CyberPlayerManager", "onExit call by app");
    }

    public static void preResolveHosts(List<String> list) {
        CyberLog.d("CyberPlayer", "preResolveHosts hosts: " + list);
        if (f4732f != null) {
            for (String str : list) {
                f4732f.getIpList2(str, false);
            }
        }
    }

    @Deprecated
    public static void preconnect(String str, String str2, String str3, int i2, HttpDNS httpDNS) {
        d.a(str, str2, str3, 1, 0, i2, httpDNS, "", -1, -1, -1, -1, null);
    }

    @Deprecated
    public static void preconnect(String str, String str2, String str3, int i2, HttpDNS httpDNS, String str4) {
        d.a(str, str2, str3, 1, 0, i2, httpDNS, str4 == null ? "" : str4, -1, -1, -1, -1, null);
    }

    public static void preconnect(String str, String str2, String str3, int i2, HttpDNS httpDNS, String str4, int i3, int i4, int i5, int i6) {
        d.a(str, str2, str3, 1, 0, i2, httpDNS, str4 == null ? "" : str4, i3, i4, i5, i6, null);
    }

    @Deprecated
    public static void prefetch(String str, String str2, String str3, int i2, int i3, HttpDNS httpDNS) {
        PlayerPolicyManager.getInstance().update();
        d.a(str, str2, str3, 0, i2, i3, httpDNS, "", -1, -1, -1, -1, null);
    }

    @Deprecated
    public static void prefetch(String str, String str2, String str3, int i2, int i3, HttpDNS httpDNS, String str4) {
        String str5 = str4 == null ? "" : str4;
        PlayerPolicyManager.getInstance().update();
        d.a(str, str2, str3, 0, i2, i3, httpDNS, str5, -1, -1, -1, -1, null);
    }

    public static void prefetch(String str, String str2, String str3, int i2, int i3, HttpDNS httpDNS, String str4, int i4, int i5, int i6, int i7, PrefetchOptions prefetchOptions) {
        String str5 = str4 == null ? "" : str4;
        PlayerPolicyManager.getInstance().update();
        d.a(str, str2, str3, 0, i2, i3, httpDNS, str5, i4, i5, i6, i7, prefetchOptions);
    }

    @Deprecated
    public static void prefetch(String str, String str2, String str3, int i2, HttpDNS httpDNS) {
        PlayerPolicyManager.getInstance().update();
        d.a(str, str2, str3, 0, 0, i2, httpDNS, "", -1, -1, -1, -1, null);
    }

    @Deprecated
    public static void prefetch(String str, String str2, String str3, int i2, HttpDNS httpDNS, String str4) {
        String str5 = str4 == null ? "" : str4;
        PlayerPolicyManager.getInstance().update();
        d.a(str, str2, str3, 0, 0, i2, httpDNS, str5, -1, -1, -1, -1, null);
    }

    public static void setCollectVideoFlow(OnVideoFlowListener onVideoFlowListener) {
        f4731e = onVideoFlowListener;
    }

    public static void setHttpDNS2(HttpDNS2 httpDNS2) {
        f4732f = httpDNS2;
    }

    public static void setNetHandleListener(GetNetHandleListener getNetHandleListener) {
        f4733g = getNetHandleListener;
    }

    public static void stopPrefetch(String str) {
        d.b(str);
    }

    public static void videoFlowCallback(HashMap<String, String> hashMap) {
        OnVideoFlowListener onVideoFlowListener = f4731e;
        if (onVideoFlowListener != null) {
            onVideoFlowListener.onRecordFlow(hashMap);
        }
    }
}
