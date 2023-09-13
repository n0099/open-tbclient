package com.baidu.cyberplayer.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.cyberplayer.sdk.CyberGlobalSetting;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.debug.DebugConfigManager;
import com.baidu.cyberplayer.sdk.downloader.Downloader;
import com.baidu.cyberplayer.sdk.statistics.DpNetworkUtils;
import com.baidu.cyberplayer.sdk.utils.MD5Utils;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.fun.ad.sdk.FunAdSdk;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CyberCfgManager {
    public static final String CLOUD_CFG_DATA_MD5 = "cloud_cfg_data_md5";
    public static final String CONFIG_FILE = "cybermedia.pro";
    public static final boolean DEBUG = false;
    public static final String DEFAULT_RC4_KEY = "SFIyRVI=";
    @Keep
    public static final String KEY_ACCURATE_SEEK_ENABLE = "accurate_seek_enable";
    public static final String KEY_APP_ID = "appid";
    public static final String KEY_APP_VER = "appversion";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_DEV_VER = "dev_ver";
    public static final String KEY_DISK_AUTO_CLEAN_ENABLE = "disk_auto_clean_enable";
    public static final String KEY_DISK_CRITICAL_CLEAN_MAX_SIZE = "disk_critical_clean_max_size";
    public static final String KEY_DISK_WARNING_CLEAN_MAX_SIZE = "disk_critical_clean_max_size";
    @Keep
    public static final String KEY_FILE_LRU_EXPIRED_DURATION = "file_lru_expired_duration";
    public static final String KEY_INT_CYBER_DOWN_INIT_SESSION_UBCID = "cyber_down_init_session_ubcid";
    @Keep
    public static final String KEY_INT_DECODE_MODE = "decode_mode";
    public static final String KEY_INT_ENABLE_AUTO_REQ_PS = "enable_auto_req_ps";
    @Keep
    public static final String KEY_INT_ENABLE_BSO = "enable_bso";
    @Keep
    public static final String KEY_INT_ENABLE_CRASHPAD = "enable_crashpad";
    @Keep
    public static final String KEY_INT_ENABLE_DLNA = "enable_dlna";
    public static final String KEY_INT_ENABLE_DOWNLOAD_ZIP_XCDN = "enable_download_zip_xcdn";
    @Keep
    public static final String KEY_INT_ENABLE_FILECACHE_CONFIG = "enable_filecache_config";
    @Keep
    public static final String KEY_INT_ENABLE_FILE_CACHE = "enable_file_cache";
    @Keep
    public static final String KEY_INT_ENABLE_FIRST_DISP_NOTIFY_OPT = "enable_first_disp_notify_opt";
    public static final String KEY_INT_ENABLE_GL_RENDER = "enable_gl_render";
    @Keep
    public static final String KEY_INT_ENABLE_HEARTBEAT_UPLOAD_STATISTICS = "enable_download_data_heartbeat_upload";
    public static final String KEY_INT_ENABLE_HLS_FORCE_MEDIAPLAYER = "enable_hls_force_mediaplayer";
    @Keep
    public static final String KEY_INT_ENABLE_HW_DECODE = "enable_hw_decode";
    @Keep
    public static final String KEY_INT_ENABLE_INTELLIGENT = "enable_intelligent";
    public static final String KEY_INT_ENABLE_LIVE_UPLOAD_DOUBLE = "enable_live_upload_double";
    @Keep
    public static final String KEY_INT_ENABLE_MEDIACODEC_REUSE = "enable_mediacodec_reuse";
    public static final String KEY_INT_ENABLE_MEDIAPLAYER_SUB_THREAD = "enable_mediaplayer_sub_thread";
    @Keep
    public static final String KEY_INT_ENABLE_MONITOR = "enable_monitor";
    public static final String KEY_INT_ENABLE_MPD = "enable_mpd";
    @Keep
    public static final String KEY_INT_ENABLE_MULTI_INSTANCE = "enable_multi_instance";
    public static final String KEY_INT_ENABLE_PAUSE_VV_STATISTIC_FIX = "enable_pause_vv_stat_fix";
    @Keep
    public static final String KEY_INT_ENABLE_PLAYER_SERVER = "enable_player_policy";
    @Keep
    public static final String KEY_INT_ENABLE_PLAY_SCORE_MONITOR = "enable_play_score_monitor";
    @Keep
    public static final String KEY_INT_ENABLE_PREFETCH = "enable_prefetch";
    public static final String KEY_INT_ENABLE_PS_CFG_PARSER_SINK = "enable_ps_cfg_parse_sink";
    @Keep
    public static final String KEY_INT_ENABLE_RTC = "enable_rtc";
    public static final String KEY_INT_ENABLE_SDK_APPEND_URL = "enable_sdk_append_url";
    public static final String KEY_INT_ENABLE_SESSION_GZIP = "enable_session_gzip";
    @Keep
    public static final String KEY_INT_ENABLE_SR = "enable_sr";
    public static final String KEY_INT_ENABLE_UPDATE_CORE = "enable_update_core";
    public static final String KEY_INT_ENABLE_UPLOAD_KERNEL_INIT_LOG = "enable_upload_kernel_init_log";
    public static final String KEY_INT_ENABLE_UPLOAD_SESSION_LOG = "enable_upload_session_log";
    public static final String KEY_INT_ENABLE_UPLOAD_UBC_LOG = "enable_upload_ubc_log";
    public static final String KEY_INT_ENABLE_VERSION_FOR_SHORT = "enable_version_for_short";
    public static final String KEY_INT_FILE_CACHE_DELETE_INTERVAL = "file_cache_delete_interval";
    public static final String KEY_INT_FILE_CACHE_MAX_SIZE = "file_cache_max_size";
    @Keep
    public static final String KEY_INT_FILE_CACHE_MIN_FREE_SIZE = "file_cache_min_free_size";
    public static final String KEY_INT_FST_STAGE_REQ_INTERVAL = "fst_stage_req_interval";
    public static final String KEY_INT_GRAY_RELEASE_SOLE_UBCID = "gray_release_sole_ubcid";
    @Keep
    public static final String KEY_INT_HEARTBEAT_UPLOAD_COUNT_MAX = "download_data_heartbeat_count_max";
    @Keep
    public static final String KEY_INT_HEARTBEAT_UPLOAD_STATISTICS_PERIOD = "download_data_heartbeat_upload_period";
    public static final String KEY_INT_INIT_SESSION_UBC = "init_session_ubc";
    public static final String KEY_INT_JAVA_ERROR_CODE_MAPPING = "java_error_code_mapping";
    public static final String KEY_INT_JUDGE_THREAD_ON_FIRST_FRAME = "judge_thread_on_first_frame";
    public static final String KEY_INT_LOG_LEVEL = "log_level";
    @Keep
    public static final String KEY_INT_MEDIA_INSTANCE_CAP = "instance_capacity";
    public static final String KEY_INT_MEDIA_PROCESS_UBC = "media_process_ubc";
    public static final String KEY_INT_NON_BD_VIDEO_DEAD_LINK_UBCID = "non_baidu_video_deadlink_ubcid";
    @Keep
    public static final String KEY_INT_PCDN_FORBIDDEN = "pcdn_forbidden";
    public static final String KEY_INT_REMOTE_FORBIDDEN = "remote_forbidden";
    @Keep
    public static final String KEY_INT_REMOTE_RESUME_FORBIDDEN = "remote_resume_forbidden";
    public static final String KEY_INT_SESSION_LOG_COLLECT_PERCENT = "session_log_collect_percent";
    public static final String KEY_INT_SR_LAST_RUN_TIME = "sr_last_run_time";
    public static final String KEY_INT_SR_REMAINING_NB = "sr_remaining_nb";
    public static final String KEY_INT_TEXTUREVIEW_ENABLE_TRANSLATE = "textureview_enable_translate";
    public static final String KEY_INT_TEXTUREVIEW_PLAYER_REUSE = "textureview_player_reuse";
    public static final String KEY_INT_TEXTUREVIEW_TEXTURE_AUTO_RELEASE = "textureview_texture_auto_release";
    public static final String KEY_INT_UPLOAD_PRELOG_THRES = "upload_prelog_thres";
    public static final String KEY_INT_VIDEOVIEW_AUTO_REQUEST_FOCUS = "videoview_auto_requestfocus";
    public static final String KEY_INT_YALOG_LEVEL = "yalog_level";
    public static final String KEY_INT_ZEUS_INIT_REFACTOR = "zeus_init_refactor";
    public static final String KEY_MODEL = "model";
    public static final String KEY_NET_TYPE = "net_type";
    public static final String KEY_PACKAGE_NAME = "package_name";
    public static final String KEY_SDK_VER = "sdk_ver";
    public static final String KEY_STR_BLACK_DEVICES_FOR_HDR = "blcak_devices_for_hdr";
    public static final String KEY_STR_BLACK_DEVICES_FOR_HW = "black_devices_for_hw";
    public static final String KEY_STR_BLACK_URLS_FOR_FILE_CACHE = "black_url_list_for_file_cache";
    public static final String KEY_STR_CORE_EXTERNAL_PATH = "core_external_path";
    public static final String KEY_STR_DECODE_MODE_FOR_ROM = "decode_mode_for_rom";
    public static final String KEY_STR_DOWNLOAD_ZIP_SID = "download_zip_sid";
    public static final String KEY_STR_FILE_CACHE_VER = "file_cache_ver";
    public static final String KEY_STR_FORCE_URL = "force_url";
    public static final String KEY_STR_PRE_DOWNLOAD_VER = "pre_download_ver";
    public static final String KEY_STR_RELEASE_KEY = "release_key";
    public static final String KEY_STR_REMOTE_BLACKLIST = "remote_blacklist";
    public static final String KEY_STR_REMOTE_FORBIDDEN_BY_ROM = "remote_forbidden_by_rom";
    public static final String KEY_STR_UPDATE_CLOUD_CFG_SERVER = "update_cloud_cfg_server";
    public static final String KEY_STR_UPDATE_CORE_EANBLE_DOWNGRADE = "update_core_enable_downgrade";
    public static final String KEY_STR_UPDATE_CORE_INFO = "update_core_info";
    public static final String KEY_STR_UPDATE_CORE_SDK_VER = "update_core_sdk_ver";
    public static final String KEY_STR_UPDATE_CORE_SERVER = "update_core_server";
    public static final String KEY_STR_UPLOAD_SESSION_LOG_VER = "upload_session_log_ver";
    public static final String KEY_STR_UPLOAD_SESSION_SERVER = "upload_session_server";
    public static final String KEY_STR_WHITE_DEVICES_FOR_HDR = "white_devices_for_hdr";
    public static final String KEY_STR_WHITE_DEVICES_FOR_SR = "white_devices_for_sr";
    public static final String KEY_USE_HTTPDNS_FIRST = "use_httpdns_first";
    @Keep
    public static final String LAST_CHECK_UNUSED_LIBS_TIME = "last_check_unused_libs_time";
    public static final String LAST_UPDATE_CLOUD_CFG_TIME = "last_update_cloud_cfg_time";
    public static final int NO_CONFIG_DEFAULT_INT_VALUE = -1;
    public static final String NO_CONFIG_DEFAULT_STR_VALUE = "";
    public static final String PREF_NAME = "video_cfg";
    public static final String SP_KEY_INSTALL_ERROR_COUNT = "install_error_count";
    @Keep
    public static final String SP_KEY_UPDATE_TYPE = "update_type";
    public static final String SP_KEY_UPDATE_TYPE_BLACK = "update_type_black";
    @Keep
    public static final String SP_KEY_UPDATE_VERSION = "update_version";
    public static final String SP_KEY_UPDATE_VERSION_BLACK = "update_version_black";
    @Keep
    public static final String SR_REMAINING_INFO = "sr_remaining_info";
    public static final String T7_PREF_NAME = "video_cfg_";
    public static final String TAG = "CyberCfgManager";
    @Keep
    public static final long TenMinute = 600;
    public static Context sContext;
    public String mCloudCfgFolder;
    public String mLocalCfgFolder;
    public static CyberCfgManager sInstance = new CyberCfgManager();
    public static volatile boolean sHasInit = false;
    public static volatile boolean sHasUpdated = false;
    public static int ONE_DAY_TIME_MILLIS = 86400000;
    public static ArrayList<String> sDeviceHwDecodeLocalBlackList = new ArrayList<>();
    public static ArrayList<String> sModelHwDecodeLocalBlackList = new ArrayList<>();
    public static ArrayList<String> sUrlFileCacheBlackList = new ArrayList<>();
    public static ArrayList<String> sDeviceRemotePlayBlackList = new ArrayList<>();
    public static ArrayList<String> sModelRemotePlayBlackList = new ArrayList<>();
    public static ArrayList<String> sDeviceVideoSRWhiteList = new ArrayList<>();
    public static ArrayList<String> sModelVideoSRWhiteList = new ArrayList<>();
    public static ArrayList<String> sDeviceHDRBlackList = new ArrayList<>();
    public static ArrayList<String> sModelHDRBlackList = new ArrayList<>();
    public static ArrayList<String> sDeviceHDRWhiteList = new ArrayList<>();
    public static ArrayList<String> sModelHDRWhiteList = new ArrayList<>();
    public static ArrayList<String> sDeviceCodecReuseBlackList = new ArrayList<>();
    public static ArrayList<String> sModelCodecReuseBlackList = new ArrayList<>();
    public Map<String, String> mCfgMap = new ConcurrentHashMap();
    public Map<String, String> mTempCfgMap = new ConcurrentHashMap();
    public String mCuid = null;
    public String mAppId = null;

    static {
        sDeviceHwDecodeLocalBlackList.add("hwH60");
        sDeviceHwDecodeLocalBlackList.add("hwp7");
        sDeviceHwDecodeLocalBlackList.add("sp8830ec");
        sDeviceHwDecodeLocalBlackList.add("Hisense M30T");
        sDeviceHwDecodeLocalBlackList.add("READBOY");
        sModelHwDecodeLocalBlackList.add("GT-I9500");
        sModelHwDecodeLocalBlackList.add("GT-I9268");
        sModelHwDecodeLocalBlackList.add("GT-I8268");
        sModelHwDecodeLocalBlackList.add("GT-I9260");
        sModelHwDecodeLocalBlackList.add("GT-I9508V");
        sModelHwDecodeLocalBlackList.add("SM-A7000");
        sModelHwDecodeLocalBlackList.add("SM-N9008V");
        sModelHwDecodeLocalBlackList.add("SM-N9006");
        sModelHwDecodeLocalBlackList.add("SM-G9280");
        sModelHwDecodeLocalBlackList.add("GT-I8552");
        sModelHwDecodeLocalBlackList.add("SM-N9009");
        sModelHwDecodeLocalBlackList.add("vivo X1");
        sModelHwDecodeLocalBlackList.add("X9077");
        sModelHwDecodeLocalBlackList.add("vivo X5Max+");
        sModelHwDecodeLocalBlackList.add("vivo X5M");
        sModelHwDecodeLocalBlackList.add("vivo Y37L");
        sModelHwDecodeLocalBlackList.add("vivo Y37");
        sModelHwDecodeLocalBlackList.add("vivo X5Pro V");
        sModelHwDecodeLocalBlackList.add("vivo X6D");
        sModelHwDecodeLocalBlackList.add("vivo X6Plus D");
        sModelHwDecodeLocalBlackList.add("vivo X6L");
        sModelHwDecodeLocalBlackList.add("vivo X7");
        sModelHwDecodeLocalBlackList.add("vivo Y23L");
        sModelHwDecodeLocalBlackList.add("OPPO A37m");
        sModelHwDecodeLocalBlackList.add("OPPO A59m");
        sModelHwDecodeLocalBlackList.add("OPPO A59s");
        sModelHwDecodeLocalBlackList.add("OPPO R9m");
        sModelHwDecodeLocalBlackList.add("OPPO R9tm");
        sModelHwDecodeLocalBlackList.add("OPPO R9km");
        sModelHwDecodeLocalBlackList.add("OPPO R7s");
        sModelHwDecodeLocalBlackList.add("OPPO R7");
        sModelHwDecodeLocalBlackList.add("R8205");
        sModelHwDecodeLocalBlackList.add("R8207");
        sModelHwDecodeLocalBlackList.add("A31");
        sModelHwDecodeLocalBlackList.add("A31c");
        sModelHwDecodeLocalBlackList.add("2013022");
        sModelHwDecodeLocalBlackList.add("HUAWEI VNS-AL00");
        sModelHwDecodeLocalBlackList.add("HUAWEI G629-UL00");
        sModelHwDecodeLocalBlackList.add("Lenovo A606");
        sModelHwDecodeLocalBlackList.add("Lenovo Z2");
        sModelHwDecodeLocalBlackList.add("ALE-TL00");
        sModelHwDecodeLocalBlackList.add("ALE-UL00");
        sModelHwDecodeLocalBlackList.add("BLN-AL10");
        sModelHwDecodeLocalBlackList.add("Che-UL00");
        sModelHwDecodeLocalBlackList.add("CHE_TL00");
        sModelHwDecodeLocalBlackList.add("Che2-TL00M");
        sModelHwDecodeLocalBlackList.add("CK2-01");
        sModelHwDecodeLocalBlackList.add("EVA-AL10");
        sModelHwDecodeLocalBlackList.add("NX506J");
        sModelHwDecodeLocalBlackList.add("NEM-AL10");
        sModelHwDecodeLocalBlackList.add("VIE-AL10");
        sModelHwDecodeLocalBlackList.add("m2 note");
        sModelHwDecodeLocalBlackList.add("HTC E9t");
        sModelHwDecodeLocalBlackList.add("MHA-AL00");
        sModelHwDecodeLocalBlackList.add("Redmi 3S");
        sModelHwDecodeLocalBlackList.add("Redmi 3X");
        sModelHwDecodeLocalBlackList.add("JLH-AN00");
        sModelHwDecodeLocalBlackList.add("NTN-AN20");
        if (Build.VERSION.SDK_INT == 31) {
            sModelHwDecodeLocalBlackList.add("M2012K11AC");
            sModelHwDecodeLocalBlackList.add("M2102J2SC");
            sModelHwDecodeLocalBlackList.add("V2141A");
            sModelHwDecodeLocalBlackList.add("V2148A");
            sModelHwDecodeLocalBlackList.add("V2154A");
            sModelHwDecodeLocalBlackList.add("V2136A");
        }
        sModelVideoSRWhiteList.add("HMA-AL00");
        sModelVideoSRWhiteList.add("ELE-AL00");
        sModelVideoSRWhiteList.add("ELE-TL00");
        sModelVideoSRWhiteList.add("VOG-AL10");
        sModelVideoSRWhiteList.add("VOG-AL00");
        sModelVideoSRWhiteList.add("PAFM00");
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                sModelHDRWhiteList.addAll(Arrays.asList("SEA-AL10", "ELE-AL00", "VOG-AL10", "VOG-AL00", "EML-AL00", "CLT-AL00", "HMA-TL00", "HMA-AL00", "LYA-AL00", "LYA-TL00", "LYA-AL10", "ELS-AN00", "ANA-AN00", "JAD-AL50", "NOH-AN50", "TAS-AN00", "TAS-AL00", "LIO-AN00", "JEF-AN20", "CDY-AN00", "JEF-AN00", "VCE-AL00", "WLZ-AL10", "NTH-AN00", "BMH-AN10", "BMH-AN20", "TNY-AL00", "PCAM00", "PCPM00", "PDYT20", "PCKM00", "PDYM20", "PBEM00", "PFFM10", "PFEM10", "PEQM00", "PFJM10", "PDEM10", "PEEM00", "PCLM10", "RMX2202", "RMX3161", "M2104K10AC", "M2101K9C", "Mi 10", "M2011K2C", "2201122C", "2201123C", "V2046A", "V2047A", "V2073A", "V1955A", "V2055A", "V1936AL", "V2031A", "SM-A8050", "SM-G9910", "SM-A5160"));
            }
        } catch (Exception unused) {
        }
    }

    @Keep
    public static CyberCfgManager getInstance() {
        if (sContext == null) {
            sContext = CyberPlayerManager.getApplicationContext();
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCfgs() {
        this.mTempCfgMap.clear();
        loadABTestCfgs();
        loadCloudCfgs();
        loadLocalCfgs();
        loadDebugCfgs();
        parserCfg();
        synchronized (this) {
            this.mCfgMap.clear();
            this.mCfgMap.putAll(this.mTempCfgMap);
        }
    }

    private void loadDebugCfgs() {
        try {
            Map<String, String> loadDebugConfig = DebugConfigManager.loadDebugConfig(sContext);
            if (loadDebugConfig != null) {
                loadLogLevel(loadDebugConfig);
                this.mTempCfgMap.putAll(loadDebugConfig);
            }
        } catch (Exception unused) {
        }
    }

    private void updateCloudCfgProFile() {
        if (CyberGlobalSetting.getInstance().isCloundSettingEnable() && Utils.isMainProcess()) {
            CyberTaskExcutor.getInstance().execute(new Runnable() { // from class: com.baidu.cyberplayer.sdk.config.CyberCfgManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CyberCfgManager.this.setPrefLong(CyberCfgManager.LAST_UPDATE_CLOUD_CFG_TIME, System.currentTimeMillis());
                        String cloundSettingServerUrl = CyberGlobalSetting.getInstance().getCloundSettingServerUrl();
                        Properties properties = new Properties();
                        Utils.makeSureFolderExists(CyberCfgManager.this.mCloudCfgFolder);
                        File file = new File(CyberCfgManager.this.mCloudCfgFolder, CyberCfgManager.CONFIG_FILE);
                        if (!file.exists() || !file.isFile()) {
                            file.createNewFile();
                        }
                        File file2 = new File(CyberCfgManager.this.mCloudCfgFolder, "cybermedia.pro.tmp");
                        if (!file2.exists() || !file2.isFile()) {
                            file2.createNewFile();
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", cloundSettingServerUrl);
                        byte[] startDownload = Downloader.startDownload(hashMap);
                        String computeMD5Hash = MD5Utils.computeMD5Hash(startDownload);
                        String RC4Decoder2String = Utils.RC4Decoder2String(startDownload, new String(Base64.decode("SFIyRVI=".getBytes(), 0)));
                        if (RC4Decoder2String != null) {
                            Map<String, String> JSONToMap = Utils.JSONToMap(RC4Decoder2String);
                            if (JSONToMap != null) {
                                FileWriter fileWriter = new FileWriter(file2.getAbsolutePath());
                                for (Map.Entry<String, String> entry : JSONToMap.entrySet()) {
                                    properties.setProperty(entry.getKey(), entry.getValue());
                                    CyberLog.d(CyberCfgManager.TAG, "update cloud cfg key:" + entry.getKey() + " value:" + entry.getValue());
                                }
                                properties.store(fileWriter, StickerDataChangeType.UPDATE);
                                fileWriter.close();
                            }
                            if (file2.renameTo(file) && !TextUtils.isEmpty(computeMD5Hash) && !computeMD5Hash.equals(CyberCfgManager.this.getPrefStr(CyberCfgManager.CLOUD_CFG_DATA_MD5, ""))) {
                                CyberCfgManager.this.setPrefStr(CyberCfgManager.CLOUD_CFG_DATA_MD5, computeMD5Hash);
                                CyberCfgManager.this.loadCfgs();
                                CyberPlayerCoreInvoker.updateCfg();
                                CyberLog.d(CyberCfgManager.TAG, "updateCloudCfgProFile success!");
                            }
                        }
                    } catch (Error e) {
                        CyberLog.e(CyberCfgManager.TAG, "update cloud error:" + e.toString());
                    } catch (Exception e2) {
                        CyberLog.e(CyberCfgManager.TAG, "update cloud exception:" + e2.toString());
                    }
                }
            });
        }
    }

    @Keep
    public synchronized Map<String, String> getCfgMap() {
        HashMap hashMap;
        HashMap hashMap2 = null;
        try {
            hashMap = new HashMap();
            try {
                hashMap.putAll(this.mCfgMap);
            } catch (Exception unused) {
                hashMap2 = hashMap;
                hashMap = hashMap2;
                return hashMap;
            }
        } catch (Exception unused2) {
        }
        return hashMap;
    }

    @Keep
    public synchronized void init() {
        if (!sHasInit) {
            this.mCuid = CyberPlayerManager.getClientID();
            this.mAppId = CyberPlayerManager.getAppID();
            loadCfgs();
            sHasInit = true;
        }
    }

    public synchronized void update() {
        if (sHasInit) {
            if (!sHasUpdated) {
                updateCloudCfgProFile();
                sHasUpdated = true;
            } else {
                if (System.currentTimeMillis() - getPrefLong(LAST_UPDATE_CLOUD_CFG_TIME, -1L) > ONE_DAY_TIME_MILLIS) {
                    updateCloudCfgProFile();
                }
            }
        }
    }

    private boolean loadAndCheckReleaseKey(Map<String, String> map) {
        String valueString = getValueString(map, KEY_STR_RELEASE_KEY, "");
        if (!TextUtils.isEmpty(valueString) && valueString.equalsIgnoreCase(this.mCuid)) {
            return true;
        }
        return false;
    }

    private void loadLogLevel(Map<String, String> map) {
        int valueInt = getValueInt(map, KEY_INT_LOG_LEVEL, -1);
        if (valueInt != -1) {
            CyberLog.setLogLevel(valueInt);
        }
    }

    @Keep
    public synchronized void removePref(String str) {
        if (sContext != null) {
            SharedPreferences.Editor edit = sContext.getSharedPreferences("video_cfg", 0).edit();
            edit.remove(str);
            edit.commit();
        }
    }

    public static boolean getValueBoolean(Map<String, String> map, String str, boolean z) {
        if (getValueInt(map, str, z ? 1 : 0) == 1) {
            return true;
        }
        return false;
    }

    public static int getValueInt(Map<String, String> map, String str, int i) {
        if (map != null) {
            String str2 = map.get(str);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return Integer.parseInt(str2);
                } catch (Exception unused) {
                }
            }
        }
        return i;
    }

    public static long getValueLong(Map<String, String> map, String str, long j) {
        if (map != null) {
            try {
                return Long.parseLong(map.get(str));
            } catch (Exception unused) {
            }
        }
        return j;
    }

    public static String getValueString(Map<String, String> map, String str, String str2) {
        if (map != null) {
            String str3 = map.get(str);
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
        }
        return str2;
    }

    private boolean isBlackDeviceForHW() {
        if (Build.VERSION.SDK_INT < 16 || CfgItemParser.doDeviceInfoCheck(sDeviceHwDecodeLocalBlackList, sModelHwDecodeLocalBlackList)) {
            return true;
        }
        String valueString = getValueString(this.mTempCfgMap, KEY_STR_BLACK_DEVICES_FOR_HW, "");
        if (TextUtils.isEmpty(valueString)) {
            return false;
        }
        String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(str);
        }
        return CfgItemParser.doDeviceInfoCheck(arrayList, arrayList);
    }

    private boolean isBlackDeviceForRemotePlay() {
        if (!CfgItemParser.doDeviceInfoCheck(sDeviceRemotePlayBlackList, sModelRemotePlayBlackList)) {
            String valueString = getValueString(this.mTempCfgMap, KEY_STR_REMOTE_BLACKLIST, "");
            if (TextUtils.isEmpty(valueString)) {
                return false;
            }
            String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                arrayList.add(str);
            }
            return CfgItemParser.doDeviceInfoCheck(arrayList, arrayList);
        }
        return true;
    }

    private void loadCloudCfgs() {
        this.mCloudCfgFolder = Utils.getCyberMediaPath() + File.separator + "config";
        Map<String, String> loadProperties = CfgProFileParser.loadProperties(this.mCloudCfgFolder + File.separator + CONFIG_FILE);
        if (loadProperties != null) {
            this.mTempCfgMap.putAll(loadProperties);
        }
    }

    private void loadLocalCfgs() {
        try {
            if (sContext != null) {
                this.mLocalCfgFolder = Utils.getExternalStorageCacheDirectory(sContext);
            }
            if (TextUtils.isEmpty(this.mLocalCfgFolder)) {
                return;
            }
            Map<String, String> loadProperties = CfgProFileParser.loadProperties(this.mLocalCfgFolder + File.separator + CONFIG_FILE);
            if (loadProperties != null) {
                loadLogLevel(loadProperties);
                if (loadAndCheckReleaseKey(loadProperties)) {
                    this.mTempCfgMap.putAll(loadProperties);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void parserCfg() {
        parserVersionMatch(KEY_INT_ENABLE_PREFETCH, KEY_STR_PRE_DOWNLOAD_VER);
        parserVersionMatch(KEY_INT_ENABLE_FILE_CACHE, KEY_STR_FILE_CACHE_VER);
        parserVersionMatch(KEY_INT_ENABLE_UPDATE_CORE, KEY_STR_UPDATE_CORE_SDK_VER);
        parserEnableUploadSessionLog();
        parserDecodeModeForRom();
        parserEnableRemote();
        parserSRInfo();
        this.mTempCfgMap.put(KEY_INT_ENABLE_HW_DECODE, Integer.toString(!isBlackDeviceForHW()));
    }

    private void parserDecodeModeForRom() {
        String valueString = getValueString(this.mTempCfgMap, KEY_STR_DECODE_MODE_FOR_ROM, "");
        if (!TextUtils.isEmpty(valueString)) {
            try {
                String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
                if (split != null && split.length == 2) {
                    for (String str : split[0].split(",")) {
                        if (Integer.parseInt(str) == Build.VERSION.SDK_INT) {
                            this.mTempCfgMap.put("decode_mode", split[1]);
                            return;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void parserSRInfo() {
        String prefStr = getPrefStr(SR_REMAINING_INFO, null);
        if (!TextUtils.isEmpty(prefStr)) {
            String[] split = prefStr.split(ParamableElem.DIVIDE_PARAM);
            if (split.length == 2) {
                this.mTempCfgMap.put(KEY_INT_SR_LAST_RUN_TIME, split[0]);
                this.mTempCfgMap.put(KEY_INT_SR_REMAINING_NB, split[1]);
            }
        }
        if (getValueBoolean(this.mTempCfgMap, KEY_INT_ENABLE_SR, false)) {
            this.mTempCfgMap.put(KEY_INT_ENABLE_SR, Integer.toString(isWhiteDevideForSR() ? 1 : 0));
        }
    }

    @Keep
    public boolean isBlackDeviceForCodecReuse() {
        if (!CfgItemParser.doDeviceInfoCheck(sDeviceCodecReuseBlackList, sModelCodecReuseBlackList)) {
            String valueString = getValueString(this.mTempCfgMap, "reuse_codec_blacklist", "");
            if (TextUtils.isEmpty(valueString)) {
                return false;
            }
            String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                arrayList.add(str);
            }
            return CfgItemParser.doDeviceInfoCheck(arrayList, arrayList);
        }
        return true;
    }

    @Keep
    public boolean isBlackDeviceForHDR() {
        if (Build.VERSION.SDK_INT < 24 || CfgItemParser.doDeviceInfoCheck(sDeviceHDRBlackList, sModelHDRBlackList)) {
            return true;
        }
        String valueString = getValueString(this.mTempCfgMap, KEY_STR_BLACK_DEVICES_FOR_HDR, "");
        if (TextUtils.isEmpty(valueString)) {
            return false;
        }
        String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(str);
        }
        return CfgItemParser.doDeviceInfoCheck(arrayList, arrayList);
    }

    private boolean isWhiteDevideForSR() {
        if (Build.VERSION.SDK_INT < 23 || Utils.getLoadLibsABI().equals("arm64-v8a")) {
            return false;
        }
        if (CfgItemParser.doDeviceInfoCheck(sDeviceVideoSRWhiteList, sModelVideoSRWhiteList)) {
            return true;
        }
        String valueString = getValueString(this.mTempCfgMap, KEY_STR_WHITE_DEVICES_FOR_SR, "");
        CyberLog.i(TAG, "value : " + valueString);
        if (TextUtils.isEmpty(valueString)) {
            return false;
        }
        String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(str);
        }
        return CfgItemParser.doDeviceInfoCheck(arrayList, arrayList);
    }

    private void loadABTestCfgs() {
        try {
            Map<String, String> installOpts = CyberPlayerManager.getInstallOpts();
            String valueString = getValueString(installOpts, "cybermedia_abtest_enable_config_abtest_merge", null);
            for (Map.Entry<String, String> entry : installOpts.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.startsWith(CyberPlayerManager.INSTALL_OPT_ABTEST_SWITCH_START_CODE)) {
                    CyberLog.d(TAG, "ABTest key:" + key + " value:" + value);
                    Map<String, String> JSONToMap = Utils.JSONToMap(value);
                    if (JSONToMap != null) {
                        if (valueString != null && valueString.length() != 0) {
                            this.mTempCfgMap.putAll(JSONToMap);
                        }
                        loadConfig(JSONToMap);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void loadConfig(Map<String, String> map) {
        JSONArray jSONArray = null;
        JSONObject jSONObject = null;
        for (String str : map.keySet()) {
            if (".rules".equals(str)) {
                if (jSONArray == null) {
                    try {
                        jSONArray = new JSONArray(getValueString(this.mTempCfgMap, ".rules", "[]"));
                    } catch (Exception unused) {
                        jSONArray = null;
                    }
                }
                JSONArray jSONArray2 = new JSONArray(map.get(str).toString());
                for (int i = 0; i < jSONArray2.length(); i++) {
                    jSONArray.put(jSONArray2.get(i));
                }
            } else if (".groups".equals(str)) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject(getValueString(this.mTempCfgMap, ".groups", "{}"));
                    } catch (Exception unused2) {
                        jSONObject = null;
                    }
                }
                JSONObject jSONObject2 = new JSONObject(map.get(str));
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            } else {
                this.mTempCfgMap.put(str, map.get(str));
            }
        }
        if (jSONArray != null) {
            String jSONArray3 = jSONArray.toString();
            this.mTempCfgMap.put(".rules", jSONArray3);
            CyberLog.d(TAG, "ABTEST-MERGE: [merge-rules] " + jSONArray3);
        }
        if (jSONObject != null) {
            String jSONObject3 = jSONObject.toString();
            this.mTempCfgMap.put(".groups", jSONObject3);
            CyberLog.d(TAG, "ABTEST-MERGE: [merge-groups] " + jSONObject3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        r8.mTempCfgMap.put(com.baidu.cyberplayer.sdk.config.CyberCfgManager.KEY_INT_REMOTE_FORBIDDEN, r0[1]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parserEnableRemote() {
        String valueString = getValueString(this.mTempCfgMap, KEY_STR_REMOTE_FORBIDDEN_BY_ROM, "16,17,18,19,20;1");
        if (!TextUtils.isEmpty(valueString)) {
            try {
                String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
                if (split != null && split.length == 2) {
                    String[] split2 = split[0].split(",");
                    int i = 0;
                    while (true) {
                        if (i >= split2.length) {
                            break;
                        } else if (Integer.parseInt(split2[i]) == Build.VERSION.SDK_INT) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (!getValueBoolean(this.mTempCfgMap, KEY_INT_REMOTE_FORBIDDEN, false) && isBlackDeviceForRemotePlay()) {
            this.mTempCfgMap.put(KEY_INT_REMOTE_FORBIDDEN, Integer.toString(1));
        }
    }

    private void parserEnableUploadSessionLog() {
        if (getValueInt(this.mTempCfgMap, KEY_INT_ENABLE_UPLOAD_SESSION_LOG, 0) == -1) {
            String valueString = getValueString(this.mTempCfgMap, KEY_STR_UPLOAD_SESSION_LOG_VER, "");
            if (!TextUtils.isEmpty(valueString) && !CfgItemParser.versionMatchCheck(valueString, SDKVersion.VERSION).booleanValue()) {
                this.mTempCfgMap.put(KEY_INT_ENABLE_UPLOAD_SESSION_LOG, Integer.toString(0));
                return;
            }
            if (new Random().nextInt(10000) + 1 <= getValueInt(this.mTempCfgMap, "session_log_collect_percent", 10000)) {
                this.mTempCfgMap.put(KEY_INT_ENABLE_UPLOAD_SESSION_LOG, Integer.toString(1));
            } else {
                this.mTempCfgMap.put(KEY_INT_ENABLE_UPLOAD_SESSION_LOG, Integer.toString(0));
            }
        }
    }

    @Keep
    public boolean isWhiteDevideForHDR() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        if (CfgItemParser.doDeviceInfoCheck(sDeviceHDRWhiteList, sModelHDRWhiteList)) {
            return true;
        }
        String valueString = getValueString(this.mTempCfgMap, KEY_STR_WHITE_DEVICES_FOR_HDR, "");
        CyberLog.i(TAG, "value : " + valueString);
        if (TextUtils.isEmpty(valueString)) {
            return false;
        }
        String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(str);
        }
        return CfgItemParser.doDeviceInfoCheck(arrayList, arrayList);
    }

    private void parserVersionMatch(String str, String str2) {
        if (getValueInt(this.mTempCfgMap, str, -1) == -1) {
            String valueString = getValueString(this.mTempCfgMap, str2, "");
            if (!TextUtils.isEmpty(valueString)) {
                this.mTempCfgMap.put(str, Integer.toString(CfgItemParser.versionMatchCheck(valueString, SDKVersion.VERSION).booleanValue() ? 1 : 0));
            }
        }
    }

    @Keep
    public synchronized boolean getCfgBoolValue(String str, boolean z) {
        boolean z2;
        int i;
        Map<String, String> map = this.mCfgMap;
        z2 = false;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        if (getValueInt(map, str, i) == 1) {
            z2 = true;
        }
        return z2;
    }

    public boolean getCfgBoolValueFast(String str, boolean z) {
        if (getValueInt(this.mCfgMap, str, z ? 1 : 0) == 1) {
            return true;
        }
        return false;
    }

    @Keep
    public synchronized int getCfgIntValue(String str, int i) {
        return getValueInt(this.mCfgMap, str, i);
    }

    @Keep
    public synchronized long getCfgLongValue(String str, long j) {
        return getValueLong(this.mCfgMap, str, j);
    }

    @Keep
    public synchronized String getCfgValue(String str, String str2) {
        return getValueString(this.mCfgMap, str, str2);
    }

    public String getCfgValueFast(String str, String str2) {
        return getValueString(this.mCfgMap, str, str2);
    }

    @Keep
    public synchronized int getPrefInt(String str, int i) {
        if (sContext != null) {
            i = sContext.getSharedPreferences("video_cfg", 0).getInt(str, i);
        }
        return i;
    }

    @Keep
    public synchronized long getPrefLong(String str, long j) {
        if (sContext != null) {
            j = sContext.getSharedPreferences("video_cfg", 0).getLong(str, j);
        }
        return j;
    }

    @Keep
    public synchronized String getPrefStr(String str, String str2) {
        if (sContext != null) {
            str2 = sContext.getSharedPreferences("video_cfg", 0).getString(str, str2);
        }
        return str2;
    }

    @Keep
    public synchronized void setPrefInt(String str, int i) {
        if (sContext != null) {
            SharedPreferences.Editor edit = sContext.getSharedPreferences("video_cfg", 0).edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    @Keep
    public synchronized void setPrefLong(String str, long j) {
        if (sContext != null) {
            SharedPreferences.Editor edit = sContext.getSharedPreferences("video_cfg", 0).edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    @Keep
    public synchronized void setPrefStr(String str, String str2) {
        if (sContext != null) {
            SharedPreferences.Editor edit = sContext.getSharedPreferences("video_cfg", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    @Keep
    public synchronized boolean isBlackUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (CfgItemParser.doBlackUrlLocalCheck(str, sUrlFileCacheBlackList)) {
            return true;
        }
        String valueString = getValueString(this.mCfgMap, KEY_STR_BLACK_URLS_FOR_FILE_CACHE, "");
        if (TextUtils.isEmpty(valueString)) {
            return false;
        }
        String[] split = valueString.split(ParamableElem.DIVIDE_PARAM);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            arrayList.add(str2);
        }
        return CfgItemParser.doBlackUrlLocalCheck(str, arrayList);
    }

    @Keep
    public boolean loadCodecReuseBlackList() {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                sDeviceCodecReuseBlackList.addAll(Arrays.asList("aquaman", "dangal", "dangalUHD", "dangalFHD", "magnolia", "machuca", MediaAEffect.AE_ANIM_ONCE, "oneday"));
            }
            if (Build.VERSION.SDK_INT <= 27) {
                sDeviceCodecReuseBlackList.add("HWEML");
            }
            if (Build.VERSION.SDK_INT <= 26) {
                sDeviceCodecReuseBlackList.addAll(Arrays.asList("Z80", "Z12_PRO", "XT1663", "XE2X", "X3_HK", "woods_fn", "woods_f", "whyred", "watson", "vernee_M5", "V5", "GiONEE_CBL7513", "V23GB", "tcl_eu", "TB3-850M", "TB3-850F", "TB3-730X", "TB3-730F", "taido_row", "s905x018", "SVP-DTV15", "Slate_Pro", "santoni", "RAIJIN", "QX1", "QM16XE_U", "Q5", "Q4310", "Q427", "Q4260", "Q350", "PRO7S", "PLE", "Pixi5-10_4G", "Pixi4-7_3G", "Phantom6", "PGN611", "PGN610", "PGN528", "PB2-670M", "panell_dt", "panell_ds", "panell_dl", "panell_d", "pacificrim", "P85", "P681", "p212", "OnePlus5T", "NX573J", "NX541J", "nicklaus_f", "namath", "MX6", "mido", FunAdSdk.PLATFORM_MH, "MEIZU_M5", "marino_f", "manning", "M5c", "M04", "LS-5017", "le_x6", "l5460", "kate", "K50a40", "JGZ", "j2xlteins", "itel_S41", "iris60", "Infinix-X572", "iball8735_9806", "i9031", "HWWAS-H", "HWVNS-H", "HWCAM-H", "HWBLN-H", "hwALE-H", "htc_e56ml_dtul", "griffin", "GIONEE_WBL7519", "GIONEE_WBL7365", "GIONEE_WBL5708", "GIONEE_SWW1631", "GIONEE_SWW1627", "GIONEE_SWW1609", "GIONEE_GBL7360", "GiONEE_GBL7319", "fugu", "flo", "F3311", "F3215", "F3213", "F3211", "F3116", "F3113", "F3111", "F04J", "F04H", "F03H", "F02H", "F01J", "F01H", "EverStar_S", "ELUGA_Ray_X", "ELUGA_Prim", "ELUGA_Note", "ELUGA_A3_Pro", "E5643", "DM-01K", "deb", "cv3", "cv1", "CPY83_I00", "CPH1715", "CPH1609", "CP8676_I02", "ComioS1", "C1", "BRAVIA_ATV3_4K", "BRAVIA_ATV2", "BLACK-1X", "b5", "Aura_Note_2", "ASUS_X00AD_2", "AquaPowerM", "A7020a48", "A7010a48", "A7000plus", "A7000-a", "A2016a40", "A1601", "A10-70L", "A10-70F", "602LV", "601LV", "1714", "1713", "1601"));
                sModelCodecReuseBlackList.addAll(Arrays.asList("AFTA", "AFTN", "JSN-L21"));
            }
            sModelCodecReuseBlackList.addAll(Arrays.asList("AFTA", "AFTN", "AFTR", "AFTEU011", "AFTEU014", "V2171A", "AFTEUFF014", "AFTJMST12", "AFTKMST12", "AFTSO001", "ALE-L21", "CAM-L21", "M2011K2C", "M2102K1AC", "M2102K1C", "ABR-AL00", "PBAM00", "PEMM20", "PECM30", "PDYM20", "PDVM00", "PBAT00", "RMX3121", "vivo X9", "vivo X9i", "OPPO R11s", "OPPO A83t", "V2068A", "V2057A"));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String makeCloundSettingRequestUrl(String str) {
        String packageName = sContext.getPackageName();
        String str2 = (str + File.separator + "videoconfig") + "?cmd=1&";
        StringBuilder sb = new StringBuilder();
        Utils.addRawLogItem(sb, "package_name", packageName);
        Utils.addRawLogItem(sb, "sdk_ver", SDKVersion.VERSION);
        if (!TextUtils.isEmpty(this.mAppId)) {
            Utils.addRawLogItem(sb, "appid", this.mAppId);
        }
        try {
            PackageManager packageManager = sContext.getPackageManager();
            if (packageManager != null) {
                Utils.addRawLogItem(sb, "appversion", packageManager.getPackageInfo(packageName, 0).versionName);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        Utils.addRawLogItem(sb, "dev_ver", Build.VERSION.SDK_INT);
        Utils.addRawLogItem(sb, "net_type", DpNetworkUtils.getNetworkStatisticsNoOperator(sContext));
        return str2 + sb.toString();
    }
}
