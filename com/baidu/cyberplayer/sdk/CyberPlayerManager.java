package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.recorder.CyberAudioRecorder;
import com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes12.dex */
public class CyberPlayerManager {
    public static final int CLARITY_MODE_AUTO = -1;
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
    public static final String INSTALL_OPT_ABTEST_SID = "abtest_sid";
    public static final String INSTALL_OPT_ABTEST_SWITCH_START_CODE = "cybermedia_abtest_";
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
    public static final int LIB_TYPE_RTC = 32;
    public static final int LIB_TYPE_VIDEO_SR = 8;
    public static final int MEDIA_ERROR_FOMAT_DEMUXER_NOT_FOUND = -2006;
    public static final int MEDIA_ERROR_IO = -1004;
    public static final int MEDIA_ERROR_MALFORMED = -1007;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_OPEN_VIDEO_FAIL = -111;
    public static final int MEDIA_ERROR_REMOTE_DIED = -30001;
    public static final int MEDIA_ERROR_REMOTE_EXCEPTION = -30000;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
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
    public static final int MEDIA_INFO_LOOP_REPLAYED = 955;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NET_RECONNECTING = 923;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_PCDN_TRAFFIC = 11000;
    public static final int MEDIA_INFO_PLAY_COMPLETE = 10004;
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
    public static final int NETWORK_STATUS_GOOD = 2;
    public static final int NETWORK_STATUS_NORMAL = 1;
    public static final int NETWORK_STATUS_POOR = 0;
    public static final String OPT_BUFFER_SIZE = "max-buffer-size";
    public static final String OPT_CHCHE_PATH = "cache-path";
    public static final String OPT_CLIENT_SET_URL_TIME = "client-set-url-time";
    public static final String OPT_CLIENT_USER_CLICK_TIME = "client-user-click-time";
    public static final String OPT_ENABLE_FILECACHE = "enable_filecache";
    public static final String OPT_ENABLE_KERNEL_NET = "kernel-net-enable";
    public static final String OPT_ENABLE_P2P = "p2p-enable";
    public static final String OPT_ENABLE_PCDN = "pcdn-enable";
    public static final String OPT_ENABLE_PREBUFFER = "prebuffer-enable";
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
    public static final String OPT_SR_OPTION = "sr_option";
    public static final String OPT_STAGE_TYPE = "stage-type";
    public static final String OPT_SUPPORT_PROCESS = "support-process";
    public static final String OPT_VIDEO_ROTATE = "video-rorate";
    public static final int PRECONNECT_SERVER = 1;
    public static final int PREFETCH_DATA = 0;
    public static final String STAGE_INFO_SOURCE = "stage_source";
    public static final String STAGE_INFO_TITLE = "stage_title";
    public static final String STAGE_INFO_TYPE = "stage_type";
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
    public static final int VIDEO_SCALING_MODE_NOT_SCALE = 6;
    public static final int VIDEO_SCALING_MODE_SCALE_16_TO_9 = 5;
    public static final int VIDEO_SCALING_MODE_SCALE_4_TO_3 = 4;
    public static final int VIDEO_SCALING_MODE_SCALE_5_TO_4 = 3;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING = 0;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    private static Context e;
    private static String f;
    private static int g;
    private static String h;
    private static Class<?> i;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1341a = false;
    private static OnDeleteListener b = null;
    private static OnVideoFlowListener c = null;
    private static final Object d = new Object();
    public static String VIDEO_FLOW_URL = "video_flow_url";
    public static String VIDEO_FLOW_STAGE = "video_flow_stage";
    public static String VIDEO_FLOW_VALUE = "video_flow_value";
    public static String VIDEO_FLOW_IS_PREFETCH = "video_flow_is_prefetch";
    private static Map<String, String> j = new HashMap();

    @Keep
    /* loaded from: classes12.dex */
    public interface HttpDNS {
        List<String> getIpList(String str);
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface InstallListener {
        void onInstallError(int i, int i2, String str);

        void onInstallProgress(int i, int i2);

        void onInstallSuccess(int i, String str);
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(int i);
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnDeleteListener {
        void onDeleteComplete(int i, long j);
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnErrorListener {
        boolean onError(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnInfoListener {
        boolean onInfo(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnMediaSourceChangedListener {
        boolean onMediaSourceChanged(int i, int i2, Object obj);
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnSeekCompleteListener {
        void onSeekComplete();
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnVideoFlowListener {
        void onRecordFlow(HashMap<String, String> hashMap);
    }

    @Keep
    /* loaded from: classes12.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(int i, int i2, int i3, int i4);
    }

    private static void a(Map<String, String> map) {
        if (map != null) {
            String str = map.get(INSTALL_OPT_ENABLE_SF_SWITCH);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (Integer.parseInt(str) == 1) {
                    CyberLog.i("CyberPlayerManager", "parserGlobalInstallOptions isSpringFestivalEnable TRUE !! ");
                    c.a().a(true);
                }
            } catch (Exception e2) {
            }
        }
    }

    public static CyberAudioRecorder createCyberAudioRecorder() {
        CyberLog.d("CyberPlayerManager", "DuplayerCore Version:" + getCoreVersion() + " CyberSdk Version:" + getSDKVersion());
        return d.d();
    }

    public static PlayerProvider createCyberPlayer(int i2, HttpDNS httpDNS) {
        CyberLog.d("CyberPlayerManager", "DuplayerCore Version:" + getCoreVersion() + " CyberSdk Version:" + getSDKVersion());
        return l.a().a(i2, httpDNS, false);
    }

    public static CyberVRRenderProvider createCyberVRRender(Context context) {
        return d.a(context);
    }

    public static void deleteVideoCache(OnDeleteListener onDeleteListener) {
        if (f1341a) {
            if (onDeleteListener != null) {
                onDeleteListener.onDeleteComplete(-2, 0L);
                return;
            }
            return;
        }
        f1341a = true;
        b = onDeleteListener;
        CyberTaskExcutor.getInstance().executeSingleThread(new Runnable() { // from class: com.baidu.cyberplayer.sdk.CyberPlayerManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CyberPlayerManager.d) {
                    long a2 = n.a((Boolean) true);
                    if (CyberPlayerManager.b != null) {
                        if (a2 < 0) {
                            CyberPlayerManager.b.onDeleteComplete((int) a2, 0L);
                        } else {
                            CyberPlayerManager.b.onDeleteComplete(0, a2);
                        }
                    }
                    boolean unused = CyberPlayerManager.f1341a = false;
                    OnDeleteListener unused2 = CyberPlayerManager.b = null;
                }
            }
        });
    }

    public static boolean duplayerEncrypt(byte[] bArr, int i2, byte[] bArr2) {
        return d.a(bArr, i2, bArr2);
    }

    public static String getAppID() {
        return h;
    }

    public static Context getApplicationContext() {
        return e;
    }

    public static String getClientID() {
        return f;
    }

    public static String getCoreVersion() {
        String a2 = d.a();
        return TextUtils.isEmpty(a2) ? "0.0.0.0" : a2;
    }

    public static int getDevicePlayQualityScore(String str, int i2, int i3, int i4, Map<String, String> map) {
        return d.a(str, i2, i3, i4, map);
    }

    public static Map<String, String> getInstallOpts() {
        return j;
    }

    public static int getInstallType() {
        return g;
    }

    public static int getNetworkStatus() {
        return 2;
    }

    public static int getPrefetchUploadThres() {
        return CyberCfgManager.getInstance().getCfgIntValue("upload_prelog_thres", -1);
    }

    public static Class<?> getRemoteServiceClass() {
        return i;
    }

    public static String getSDKVersion() {
        return SDKVersion.VERSION;
    }

    public static HashMap<Integer, Long> getSystemInfraInfo() {
        return d.j();
    }

    public static long getVideoCacheSize() {
        long k = n.k();
        CyberLog.d("CyberPlayerManager", "getVideoCacheSize:" + k);
        return k;
    }

    public static boolean hasCacheFile(String str) {
        return d.b(str);
    }

    @Deprecated
    public static synchronized void install(Context context, String str, String str2) throws Exception {
        synchronized (CyberPlayerManager.class) {
            install(context, str, str2, 7, null, null, null);
        }
    }

    public static synchronized void install(Context context, String str, String str2, int i2, Class<?> cls, Map<String, String> map, InstallListener installListener) throws Exception {
        synchronized (CyberPlayerManager.class) {
            if (context == null) {
                throw new NullPointerException("context is null");
            }
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException("clienID is null");
            }
            e = context.getApplicationContext();
            f = str;
            g |= i2;
            i = cls;
            h = context.getPackageName();
            DpSessionDatasUploader.getInstance().a(e);
            if (map != null) {
                j.putAll(map);
                a(map);
            }
            com.baidu.cyberplayer.sdk.loader.b.a().a(str2, i2, map, installListener);
        }
    }

    public static boolean isCoreLoaded() {
        return isCoreLoaded(g);
    }

    public static boolean isCoreLoaded(int i2) {
        return d.a(i2);
    }

    public static void onExit() {
        CyberLog.i("CyberPlayerManager", "onExit call by app");
    }

    public static void preconnect(String str, String str2, String str3, int i2, HttpDNS httpDNS) {
        d.a(str, str2, str3, 1, 0, i2, httpDNS, "");
    }

    public static void preconnect(String str, String str2, String str3, int i2, HttpDNS httpDNS, String str4) {
        d.a(str, str2, str3, 1, 0, i2, httpDNS, str4 == null ? "" : str4);
    }

    public static void prefetch(String str, String str2, String str3, int i2, int i3, HttpDNS httpDNS) {
        d.a(str, str2, str3, 0, i2, i3, httpDNS, "");
    }

    public static void prefetch(String str, String str2, String str3, int i2, int i3, HttpDNS httpDNS, String str4) {
        d.a(str, str2, str3, 0, i2, i3, httpDNS, str4 == null ? "" : str4);
    }

    public static void prefetch(String str, String str2, String str3, int i2, HttpDNS httpDNS) {
        d.a(str, str2, str3, 0, 0, i2, httpDNS, "");
    }

    public static void prefetch(String str, String str2, String str3, int i2, HttpDNS httpDNS, String str4) {
        d.a(str, str2, str3, 0, 0, i2, httpDNS, str4 == null ? "" : str4);
    }

    public static void setCollectVideoFlow(OnVideoFlowListener onVideoFlowListener) {
        c = onVideoFlowListener;
    }

    public static void stopPrefetch(String str) {
        d.a(str);
    }

    public static void videoFlowCallback(HashMap<String, String> hashMap) {
        if (c != null) {
            c.onRecordFlow(hashMap);
        }
    }
}
