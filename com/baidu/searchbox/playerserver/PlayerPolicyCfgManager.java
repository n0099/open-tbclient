package com.baidu.searchbox.playerserver;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.playerserver.PlayerPolicyDetailConfig;
import com.baidu.searchbox.playerserver.ab.PlayConfigABManager;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayerPolicyCfgManager implements IPlayerConfig {
    public static final int FEED_AD = 2;
    public static final String GROUP_DEFAULT = "default";
    public static final String GROUP_FEED_AD = "feed_ad";
    public static final String GROUP_MINI_VIDEO = "mini_video";
    public static final String GROUP_NOVEL_AD = "novel_ad";
    public static final String GROUP_SEARCH_CACHE = "search_cache";
    public static final int MINI_VIDEO = 0;
    public static final int NOVEL_AD = 3;
    public static final String PP_CFG_KEY_CLARITY = "clarity_config";
    public static final String PP_CFG_KEY_KEY = "key";
    public static final String PP_CFG_KEY_LEVEL = "level";
    public static final String PP_CFG_KEY_LIMIT_RATE = "limit_rate";
    public static final String PP_CFG_KEY_P2P_ENABLE = "p2p_enable";
    public static final String PP_CFG_KEY_PCDN_ENABLE = "pcdn_enable";
    public static final String PP_CFG_KEY_PREBOOT = "preboot_config";
    public static final String PP_CFG_KEY_QUIC_ENABLE = "quic_enable";
    public static final String PP_CFG_KEY_SLE = "sle";
    public static final String PP_CFG_KEY_SL_RATE = "sl_rate";
    public static final String PP_CFG_KEY_SPLIT_RATE = "split_rate";
    public static final String PP_CFG_KEY_XCDN_ENABLE = "xcdn_enable";
    public static final int SEARCH_CACHE = 4;
    public static final int SHORT_VIDEO = 1;
    public static final PlayerPolicyCfgManager S_INSTANCE = new PlayerPolicyCfgManager();
    public static final String TAG = "PlayerPolicy-CfgParser";
    public static final int UNKNOWN = -1;
    public boolean isPlayConfigLoadedFromFile = false;
    @Keep
    public PlayerPolicyBandwidthConfig mBandwidthConfig = null;
    public HandlerThread mHandlerThread;
    public String mHashTag;
    public JSONObject mPlayConfigMerged;
    public Handler mWorkHandler;

    /* loaded from: classes4.dex */
    public static class AdjustInfo {
        public int adjustSize;
        public String adjustUrl;

        public AdjustInfo(String str, int i) {
            this.adjustSize = i;
            this.adjustUrl = str;
        }
    }

    public PlayerPolicyCfgManager() {
        this.mHandlerThread = null;
        this.mWorkHandler = null;
        HandlerThread handlerThread = new HandlerThread("player_config_thread");
        this.mHandlerThread = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
            this.mWorkHandler = new Handler(this.mHandlerThread.getLooper());
        }
    }

    public static PlayerPolicyCfgManager getInstance() {
        return S_INSTANCE;
    }

    public synchronized String getHashTag() {
        loadPlayConfigFromFileIfNeeded();
        return this.mHashTag;
    }

    public synchronized String getPlayConfigMerged() {
        loadPlayConfigFromFileIfNeeded();
        if (this.mPlayConfigMerged == null) {
            return null;
        }
        return this.mPlayConfigMerged.toString();
    }

    public PlayerPolicyBandwidthConfig getPlayerConfig() {
        PlayerPolicyBandwidthConfig playerPolicyBandwidthConfig;
        synchronized (PlayerPolicyCfgManager.class) {
            playerPolicyBandwidthConfig = this.mBandwidthConfig;
        }
        return playerPolicyBandwidthConfig;
    }

    @Keep
    /* loaded from: classes4.dex */
    public static class PlayerPolicyBandwidthConfig {
        public long mUpdateInterval = 300;
        public long mLastConfigUpdateTimeStamp = 0;
        public int level = 0;
        public int bandwidthWatermark = 5;
        public int cdnBandWidthLevel = 9;
        @Keep
        public PlayerPolicyDetailConfig mPlayerConfig = null;
        @Keep
        public PlayerPolicyDetailConfig mMiniVideoConfig = null;
        @Keep
        public PlayerPolicyDetailConfig mFeedAdConfig = null;
        @Keep
        public PlayerPolicyDetailConfig mNovelAdConfig = null;
        @Keep
        public PlayerPolicyDetailConfig mSearchCacheConfig = null;
        public JSONObject mBindWidthConfig = null;

        public PlayerPolicyDetailConfig getConfig(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return this.mPlayerConfig;
                            }
                            return this.mSearchCacheConfig;
                        }
                        return this.mNovelAdConfig;
                    }
                    return this.mFeedAdConfig;
                }
                return this.mPlayerConfig;
            }
            return this.mMiniVideoConfig;
        }

        public String getGroupFromUrl(Uri uri) {
            int queryVideoType = PlayerPolicyCfgManager.getInstance().queryVideoType(uri);
            if (queryVideoType != 0) {
                if (queryVideoType != 2) {
                    if (queryVideoType != 3) {
                        if (queryVideoType != 4) {
                            return "default";
                        }
                        return PlayerPolicyCfgManager.GROUP_SEARCH_CACHE;
                    }
                    return "novel_ad";
                }
                return PlayerPolicyCfgManager.GROUP_FEED_AD;
            }
            return PlayerPolicyCfgManager.GROUP_MINI_VIDEO;
        }

        public JSONObject getObject(String str) {
            return getObject(str, "default");
        }

        public PlayerPolicyDetailConfig getPPConfigFromUri(Uri uri) {
            return getConfig(PlayerPolicyCfgManager.getInstance().queryVideoType(uri));
        }

        public String getString(String str) {
            return getString(str, "default");
        }

        public JSONObject getObject(String str, String str2) {
            JSONObject optJSONObject;
            JSONObject jSONObject = this.mBindWidthConfig;
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str2)) == null) {
                return null;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
            if (optJSONObject2 == null) {
                return this.mBindWidthConfig.optJSONObject(str);
            }
            return optJSONObject2;
        }

        public String getString(String str, String str2) {
            JSONObject optJSONObject;
            JSONObject jSONObject = this.mBindWidthConfig;
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(str2)) == null) {
                return null;
            }
            Object opt = optJSONObject.opt(str);
            if (opt == null) {
                opt = this.mBindWidthConfig.opt(str);
            }
            if (opt == null) {
                return null;
            }
            return opt.toString();
        }
    }

    private boolean isMatchHost(String str, String[] strArr) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; strArr != null && i < strArr.length; i++) {
                if (str.equals(strArr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6 A[Catch: Exception -> 0x00cb, TryCatch #3 {Exception -> 0x00cb, blocks: (B:20:0x0090, B:22:0x00a6, B:23:0x00ae, B:25:0x00b4, B:26:0x00bc, B:28:0x00c2), top: B:81:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4 A[Catch: Exception -> 0x00cb, TryCatch #3 {Exception -> 0x00cb, blocks: (B:20:0x0090, B:22:0x00a6, B:23:0x00ae, B:25:0x00b4, B:26:0x00bc, B:28:0x00c2), top: B:81:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2 A[Catch: Exception -> 0x00cb, TRY_LEAVE, TryCatch #3 {Exception -> 0x00cb, blocks: (B:20:0x0090, B:22:0x00a6, B:23:0x00ae, B:25:0x00b4, B:26:0x00bc, B:28:0x00c2), top: B:81:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010f A[Catch: Exception -> 0x0146, TryCatch #6 {Exception -> 0x0146, blocks: (B:37:0x00de, B:39:0x010f, B:40:0x0117, B:42:0x011d, B:43:0x0125), top: B:87:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d A[Catch: Exception -> 0x0146, TryCatch #6 {Exception -> 0x0146, blocks: (B:37:0x00de, B:39:0x010f, B:40:0x0117, B:42:0x011d, B:43:0x0125), top: B:87:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0155 A[Catch: Exception -> 0x0197, TryCatch #5 {Exception -> 0x0197, blocks: (B:48:0x014f, B:50:0x0155, B:52:0x0180, B:53:0x0188, B:55:0x018e), top: B:85:0x014f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01a6 A[Catch: Exception -> 0x01d1, TryCatch #8 {Exception -> 0x01d1, blocks: (B:60:0x01a0, B:62:0x01a6, B:64:0x01ba, B:65:0x01c2, B:67:0x01c8), top: B:91:0x01a0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PlayerPolicyDetailConfig getDetailConfig(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        PlayerPolicyDetailConfig.PCDNConfig pCDNConfig;
        try {
            String string = jSONObject.getString("host");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            PlayerPolicyDetailConfig playerPolicyDetailConfig = new PlayerPolicyDetailConfig(str);
            playerPolicyDetailConfig.hosts = string.split(ParamableElem.DIVIDE_PARAM);
            playerPolicyDetailConfig.cntlId = jSONObject.getString("cntl_id");
            try {
                jSONObject4 = jSONObject.getJSONObject("pcdn_config");
                pCDNConfig = playerPolicyDetailConfig.pcdnConfig;
                str2 = PP_CFG_KEY_CLARITY;
            } catch (Exception e) {
                e = e;
                str2 = PP_CFG_KEY_CLARITY;
            }
            try {
                pCDNConfig.pcdnEnable = jSONObject4.getInt(PP_CFG_KEY_PCDN_ENABLE);
                playerPolicyDetailConfig.pcdnConfig.p2pEnable = jSONObject4.getInt(PP_CFG_KEY_P2P_ENABLE);
                playerPolicyDetailConfig.pcdnConfig.xcdnEnable = jSONObject4.getInt(PP_CFG_KEY_XCDN_ENABLE);
            } catch (Exception e2) {
                e = e2;
                Log.e(TAG, "update pcdn_config fail", e);
                jSONObject3 = jSONObject.getJSONObject("cdn_config");
                JSONObject jSONObject5 = jSONObject3.getJSONObject(PP_CFG_KEY_LIMIT_RATE);
                PlayerPolicyDetailConfig.CdnConfig cdnConfig = playerPolicyDetailConfig.cdnConfig;
                str4 = PP_CFG_KEY_LIMIT_RATE;
                try {
                    cdnConfig.sle = jSONObject5.getInt(PP_CFG_KEY_SLE);
                    PlayerPolicyDetailConfig.CdnConfig cdnConfig2 = playerPolicyDetailConfig.cdnConfig;
                    str5 = PP_CFG_KEY_SLE;
                    str3 = PP_CFG_KEY_P2P_ENABLE;
                } catch (Exception e3) {
                    e = e3;
                    str5 = PP_CFG_KEY_SLE;
                    str3 = PP_CFG_KEY_P2P_ENABLE;
                }
                try {
                    cdnConfig2.slRate = (float) jSONObject5.getDouble(PP_CFG_KEY_SL_RATE);
                    playerPolicyDetailConfig.cdnConfig.splitRate = (float) jSONObject5.getDouble(PP_CFG_KEY_SPLIT_RATE);
                    if (jSONObject3.has("level")) {
                    }
                    if (jSONObject3.has("key")) {
                    }
                    if (jSONObject3.has(PP_CFG_KEY_QUIC_ENABLE)) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.e(TAG, "update cdn config fail", e);
                    jSONObject2 = jSONObject.getJSONObject("prefetch_config");
                    playerPolicyDetailConfig.prefetchConfig.duration = jSONObject2.getInt("duration");
                    playerPolicyDetailConfig.prefetchConfig.pcdnEnable = jSONObject2.getInt(PP_CFG_KEY_PCDN_ENABLE);
                    playerPolicyDetailConfig.prefetchConfig.p2pEnable = jSONObject2.getInt(str3);
                    playerPolicyDetailConfig.prefetchConfig.xcdnEnable = jSONObject2.getInt(PP_CFG_KEY_XCDN_ENABLE);
                    if (jSONObject2.has("level")) {
                    }
                    if (jSONObject2.has("key")) {
                    }
                    JSONObject jSONObject6 = jSONObject2.getJSONObject(str4);
                    playerPolicyDetailConfig.prefetchConfig.sle = jSONObject6.getInt(str5);
                    playerPolicyDetailConfig.prefetchConfig.slRate = (float) jSONObject6.getDouble(PP_CFG_KEY_SL_RATE);
                    playerPolicyDetailConfig.prefetchConfig.splitRate = (float) jSONObject6.getDouble(PP_CFG_KEY_SPLIT_RATE);
                    str6 = str2;
                    if (jSONObject.has(str6)) {
                    }
                    if (jSONObject.has(PP_CFG_KEY_PREBOOT)) {
                    }
                    return playerPolicyDetailConfig;
                }
                jSONObject2 = jSONObject.getJSONObject("prefetch_config");
                playerPolicyDetailConfig.prefetchConfig.duration = jSONObject2.getInt("duration");
                playerPolicyDetailConfig.prefetchConfig.pcdnEnable = jSONObject2.getInt(PP_CFG_KEY_PCDN_ENABLE);
                playerPolicyDetailConfig.prefetchConfig.p2pEnable = jSONObject2.getInt(str3);
                playerPolicyDetailConfig.prefetchConfig.xcdnEnable = jSONObject2.getInt(PP_CFG_KEY_XCDN_ENABLE);
                if (jSONObject2.has("level")) {
                }
                if (jSONObject2.has("key")) {
                }
                JSONObject jSONObject62 = jSONObject2.getJSONObject(str4);
                playerPolicyDetailConfig.prefetchConfig.sle = jSONObject62.getInt(str5);
                playerPolicyDetailConfig.prefetchConfig.slRate = (float) jSONObject62.getDouble(PP_CFG_KEY_SL_RATE);
                playerPolicyDetailConfig.prefetchConfig.splitRate = (float) jSONObject62.getDouble(PP_CFG_KEY_SPLIT_RATE);
                str6 = str2;
                if (jSONObject.has(str6)) {
                }
                if (jSONObject.has(PP_CFG_KEY_PREBOOT)) {
                }
                return playerPolicyDetailConfig;
            }
            try {
                jSONObject3 = jSONObject.getJSONObject("cdn_config");
                JSONObject jSONObject52 = jSONObject3.getJSONObject(PP_CFG_KEY_LIMIT_RATE);
                PlayerPolicyDetailConfig.CdnConfig cdnConfig3 = playerPolicyDetailConfig.cdnConfig;
                str4 = PP_CFG_KEY_LIMIT_RATE;
                cdnConfig3.sle = jSONObject52.getInt(PP_CFG_KEY_SLE);
                PlayerPolicyDetailConfig.CdnConfig cdnConfig22 = playerPolicyDetailConfig.cdnConfig;
                str5 = PP_CFG_KEY_SLE;
                str3 = PP_CFG_KEY_P2P_ENABLE;
                cdnConfig22.slRate = (float) jSONObject52.getDouble(PP_CFG_KEY_SL_RATE);
                playerPolicyDetailConfig.cdnConfig.splitRate = (float) jSONObject52.getDouble(PP_CFG_KEY_SPLIT_RATE);
                if (jSONObject3.has("level")) {
                    playerPolicyDetailConfig.cdnConfig.level = jSONObject3.getInt("level");
                }
                if (jSONObject3.has("key")) {
                    playerPolicyDetailConfig.cdnConfig.key = jSONObject3.getString("key");
                }
                if (jSONObject3.has(PP_CFG_KEY_QUIC_ENABLE)) {
                    playerPolicyDetailConfig.cdnConfig.quicEnable = jSONObject3.getInt(PP_CFG_KEY_QUIC_ENABLE);
                }
            } catch (Exception e5) {
                e = e5;
                str3 = PP_CFG_KEY_P2P_ENABLE;
                str4 = PP_CFG_KEY_LIMIT_RATE;
                str5 = PP_CFG_KEY_SLE;
            }
            try {
                jSONObject2 = jSONObject.getJSONObject("prefetch_config");
                playerPolicyDetailConfig.prefetchConfig.duration = jSONObject2.getInt("duration");
                playerPolicyDetailConfig.prefetchConfig.pcdnEnable = jSONObject2.getInt(PP_CFG_KEY_PCDN_ENABLE);
                playerPolicyDetailConfig.prefetchConfig.p2pEnable = jSONObject2.getInt(str3);
                playerPolicyDetailConfig.prefetchConfig.xcdnEnable = jSONObject2.getInt(PP_CFG_KEY_XCDN_ENABLE);
                if (jSONObject2.has("level")) {
                    playerPolicyDetailConfig.prefetchConfig.level = jSONObject2.getInt("level");
                }
                if (jSONObject2.has("key")) {
                    playerPolicyDetailConfig.prefetchConfig.key = jSONObject2.getString("key");
                }
                JSONObject jSONObject622 = jSONObject2.getJSONObject(str4);
                playerPolicyDetailConfig.prefetchConfig.sle = jSONObject622.getInt(str5);
                playerPolicyDetailConfig.prefetchConfig.slRate = (float) jSONObject622.getDouble(PP_CFG_KEY_SL_RATE);
                playerPolicyDetailConfig.prefetchConfig.splitRate = (float) jSONObject622.getDouble(PP_CFG_KEY_SPLIT_RATE);
            } catch (Exception e6) {
                Log.e(TAG, "update prefetch config fail", e6);
            }
            str6 = str2;
            try {
                if (jSONObject.has(str6)) {
                    JSONObject jSONObject7 = jSONObject.getJSONObject(str6);
                    playerPolicyDetailConfig.clarityConfig.cs480p = (float) jSONObject7.getDouble("cs_480p");
                    playerPolicyDetailConfig.clarityConfig.cs720p = (float) jSONObject7.getDouble("cs_720p");
                    playerPolicyDetailConfig.clarityConfig.cs1080p = (float) jSONObject7.getDouble("cs_1080p");
                    if (jSONObject7.has("level")) {
                        playerPolicyDetailConfig.clarityConfig.level = jSONObject7.getInt("level");
                    }
                    if (jSONObject7.has("key")) {
                        playerPolicyDetailConfig.clarityConfig.key = jSONObject7.getString("key");
                    }
                }
            } catch (Exception e7) {
                Log.e(TAG, "update clarityConfig fail", e7);
            }
            try {
                if (jSONObject.has(PP_CFG_KEY_PREBOOT)) {
                    JSONObject jSONObject8 = jSONObject.getJSONObject(PP_CFG_KEY_PREBOOT);
                    playerPolicyDetailConfig.prebootConfig.b = jSONObject8.getInt("b");
                    if (jSONObject8.has("level")) {
                        playerPolicyDetailConfig.prebootConfig.level = jSONObject8.getInt("level");
                    }
                    if (jSONObject8.has("key")) {
                        playerPolicyDetailConfig.prebootConfig.key = jSONObject8.getString("key");
                    }
                }
            } catch (Exception e8) {
                Log.e(TAG, "update prebootConfig fail", e8);
            }
            return playerPolicyDetailConfig;
        } catch (Exception e9) {
            Log.e(TAG, "NO HOST fail : ", e9);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlayerPolicyBandwidthConfig getPPBandwidthConfig(@NonNull String str) {
        try {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                PlayerPolicyBandwidthConfig playerPolicyBandwidthConfig = new PlayerPolicyBandwidthConfig();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("errno") == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("bandwidth_config");
                    playerPolicyBandwidthConfig.mBindWidthConfig = jSONObject2;
                    try {
                        playerPolicyBandwidthConfig.mLastConfigUpdateTimeStamp = jSONObject2.getLong("now_time");
                        playerPolicyBandwidthConfig.mUpdateInterval = jSONObject2.getLong("update_interval");
                        if (jSONObject2.has("level")) {
                            playerPolicyBandwidthConfig.level = jSONObject2.getInt("level");
                        }
                        if (jSONObject2.has("bandwidth_watermark")) {
                            playerPolicyBandwidthConfig.bandwidthWatermark = jSONObject2.getInt("bandwidth_watermark");
                        }
                        if (jSONObject2.has("cdn_bandwidth_level")) {
                            playerPolicyBandwidthConfig.cdnBandWidthLevel = jSONObject2.getInt("cdn_bandwidth_level");
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "get now time fail!", e);
                    }
                    PPLog.i(TAG, "configContainer level:" + playerPolicyBandwidthConfig.level);
                    playerPolicyBandwidthConfig.mPlayerConfig = getDetailConfig(jSONObject2.getJSONObject("default"), "Short Video");
                    PPLog.i(TAG, "" + playerPolicyBandwidthConfig.mPlayerConfig);
                    playerPolicyBandwidthConfig.mMiniVideoConfig = getDetailConfig(jSONObject2.getJSONObject(GROUP_MINI_VIDEO), "Mini Video");
                    PPLog.i(TAG, "" + playerPolicyBandwidthConfig.mMiniVideoConfig);
                    try {
                        playerPolicyBandwidthConfig.mFeedAdConfig = getDetailConfig(jSONObject2.getJSONObject(GROUP_FEED_AD), "feed ad");
                        Log.i(TAG, "" + playerPolicyBandwidthConfig.mFeedAdConfig);
                        playerPolicyBandwidthConfig.mNovelAdConfig = getDetailConfig(jSONObject2.getJSONObject("novel_ad"), "novel ad");
                        Log.i(TAG, "" + playerPolicyBandwidthConfig.mNovelAdConfig);
                        playerPolicyBandwidthConfig.mSearchCacheConfig = getDetailConfig(jSONObject2.getJSONObject(GROUP_SEARCH_CACHE), GROUP_SEARCH_CACHE);
                    } catch (Exception e2) {
                        Log.e(TAG, "update ad config fail : ", e2);
                    }
                }
                return playerPolicyBandwidthConfig;
            } catch (Error e3) {
                Log.e(TAG, "update config fail : ", e3);
                return null;
            }
        } catch (Exception e4) {
            Log.e(TAG, "update config fail : ", e4);
            return null;
        }
    }

    private File makePlayConfigFile(Context context) {
        String str = Utils.getExternalStorageCacheDirectory(context) + File.separator + "baidu" + File.separator + "flyflow" + File.separator + "playserver" + File.separator;
        PPLog.d(TAG, "mergeCfgToSdCard dir=" + str);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file, "play-config.json");
    }

    private JSONObject mergeCfg(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            JSONObject jSONObject2 = new JSONObject(str2);
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("config");
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = optJSONObject2.opt(next);
                if (optJSONObject2.isNull(next)) {
                    optJSONObject.remove(next);
                } else {
                    optJSONObject.put(next, opt);
                }
            }
            jSONObject.putOpt("config", optJSONObject);
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (!TextUtils.equals(next2, "config")) {
                    jSONObject.put(next2, jSONObject2.opt(next2));
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject processPlayConfigContent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            JSONObject jSONObject2 = new JSONObject();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = optJSONObject.opt(next);
                if (!optJSONObject.isNull(next) && opt != null) {
                    jSONObject2.put(next, opt);
                }
            }
            jSONObject.putOpt("config", jSONObject2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private void writePlayConfigToFile(JSONObject jSONObject, File file) {
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
            String jSONObject2 = jSONObject.toString();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(jSONObject2.getBytes());
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public synchronized void loadPlayConfigFromFileIfNeeded() {
        FileInputStream fileInputStream;
        if (PlayConfigABManager.getIntSwitch(PlayConfigABManager.KEY_PLAY_CONFIG_SAVE_SDCARD, 1) == 0) {
            return;
        }
        if (this.isPlayConfigLoadedFromFile) {
            return;
        }
        Context appContext = PlayerPolicyRuntime.getAppContext();
        if (appContext == null) {
            return;
        }
        File makePlayConfigFile = makePlayConfigFile(appContext);
        if (!makePlayConfigFile.exists()) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(makePlayConfigFile);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            JSONObject jSONObject = new JSONObject(new String(bArr));
            this.mPlayConfigMerged = jSONObject;
            this.mHashTag = jSONObject.optString("hash_tag");
            fileInputStream.close();
        } catch (Exception unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            this.isPlayConfigLoadedFromFile = true;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
        this.isPlayConfigLoadedFromFile = true;
    }

    public synchronized void mergePlayConfigAndSave(String str) {
        Context appContext;
        try {
            appContext = PlayerPolicyRuntime.getAppContext();
        } catch (Exception unused) {
        }
        if (appContext == null) {
            return;
        }
        loadPlayConfigFromFileIfNeeded();
        File makePlayConfigFile = makePlayConfigFile(appContext);
        if (!makePlayConfigFile.exists()) {
            JSONObject processPlayConfigContent = processPlayConfigContent(str);
            this.mPlayConfigMerged = processPlayConfigContent;
            if (processPlayConfigContent == null) {
                this.mHashTag = null;
            } else {
                this.mHashTag = processPlayConfigContent.optString("hash_tag");
            }
            writePlayConfigToFile(this.mPlayConfigMerged, makePlayConfigFile);
        } else {
            FileInputStream fileInputStream = new FileInputStream(makePlayConfigFile);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            fileInputStream.close();
            JSONObject mergeCfg = mergeCfg(str2, str);
            this.mPlayConfigMerged = mergeCfg;
            if (mergeCfg == null) {
                this.mHashTag = null;
            } else {
                this.mHashTag = mergeCfg.optString("hash_tag");
            }
            if (this.mPlayConfigMerged != null) {
                writePlayConfigToFile(this.mPlayConfigMerged, makePlayConfigFile);
            }
        }
    }

    public int queryVideoType(Uri uri) {
        int i;
        boolean z;
        PlayerPolicyDetailConfig config;
        String query = uri.getQuery();
        if (query == null) {
            return -1;
        }
        String[] split = query.split("&");
        int i2 = 0;
        while (true) {
            if (i2 < split.length) {
                int indexOf = split[i2].indexOf("vt");
                if (indexOf != -1) {
                    try {
                        i = Integer.parseInt(split[i2].substring(indexOf + 3));
                    } catch (Exception unused) {
                        i = -1;
                    }
                    z = true;
                    break;
                }
                i2++;
            } else {
                i = -1;
                z = false;
                break;
            }
        }
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i != 10) {
                if (i == 11) {
                    return 3;
                }
                Log.i(TAG, "This URI is UNKNOWN video!!!");
                return -1;
            }
            return 2;
        }
        PlayerPolicyBandwidthConfig playerPolicyBandwidthConfig = this.mBandwidthConfig;
        if (playerPolicyBandwidthConfig == null || (config = playerPolicyBandwidthConfig.getConfig(4)) == null || !isMatchHost(uri.getHost(), config.hosts)) {
            return -1;
        }
        return 4;
    }

    public Uri rebuildUrlForPlay(Uri uri, String str, int i, int i2) {
        if (uri != null && i > 0 && i2 > 0) {
            PlayerPolicyBandwidthConfig pPBandwidthConfig = getPPBandwidthConfig(str);
            if (pPBandwidthConfig == null && (pPBandwidthConfig = getPlayerConfig()) == null) {
                PPLog.d(TAG, "rebuildUrl get container null!");
                return uri;
            }
            long currentTimeMillis = (System.currentTimeMillis() / 1000) - pPBandwidthConfig.mLastConfigUpdateTimeStamp;
            if (currentTimeMillis > pPBandwidthConfig.mUpdateInterval * 4) {
                PPLog.d(TAG, "config timeout!  delta: " + currentTimeMillis + " updateInterval: " + pPBandwidthConfig.mUpdateInterval);
                return uri;
            }
            int queryVideoType = queryVideoType(uri);
            if (queryVideoType == -1) {
                queryVideoType = 4;
                PlayerPolicyDetailConfig config = pPBandwidthConfig.getConfig(4);
                if (config == null || !isMatchHost(uri.getHost(), config.hosts)) {
                    return uri;
                }
            }
            PlayerPolicyDetailConfig config2 = pPBandwidthConfig.getConfig(queryVideoType);
            PPLog.d(TAG, "" + config2);
            if (!config2.isValidate()) {
                PPLog.i(TAG, "The player server config is invalidate, use old uri continue!");
                return uri;
            } else if (!isMatchHost(uri.getHost(), config2.hosts)) {
                PPLog.i(TAG, "host : " + uri.getHost() + " not match");
                return uri;
            } else {
                String query = uri.getQuery();
                if (TextUtils.isEmpty(query)) {
                    PPLog.i(TAG, "This host has no query!");
                    return uri;
                }
                String[] split = query.split("&");
                boolean z = false;
                int i3 = -1;
                boolean z2 = false;
                for (int i4 = 0; i4 < split.length; i4++) {
                    if (split[i4].indexOf(PP_CFG_KEY_SLE) != -1) {
                        split[i4] = "sle=" + config2.cdnConfig.sle;
                        z2 = true;
                    } else if (split[i4].indexOf("sl") != -1) {
                        split[i4] = "sl=" + ((int) ((config2.cdnConfig.slRate * i) / 8.0f));
                    } else if (split[i4].indexOf("split") != -1) {
                        split[i4] = "split=" + ((int) ((((config2.cdnConfig.splitRate * i) * 1024.0f) / 8.0f) + i2));
                    } else {
                        if (split[i4].indexOf("vt") != -1) {
                            try {
                                i3 = Integer.parseInt(split[i4].substring(split[i4].indexOf("vt") + 3));
                            } catch (Exception unused) {
                            }
                            z = true;
                        }
                    }
                }
                if (z && (i3 == 1 || i3 == 0)) {
                    try {
                        Uri.Builder buildUpon = uri.buildUpon();
                        buildUpon.clearQuery();
                        int length = split.length;
                        int i5 = 0;
                        while (i5 < length) {
                            String[] split2 = split[i5].split("=");
                            buildUpon.appendQueryParameter(split2[0], split2[1]);
                            i5++;
                            split = split;
                        }
                        if (!z2) {
                            buildUpon.appendQueryParameter(PP_CFG_KEY_SLE, "" + config2.cdnConfig.sle);
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            float f = (float) i;
                            sb.append((int) ((config2.cdnConfig.slRate * f) / 8.0f));
                            buildUpon.appendQueryParameter("sl", sb.toString());
                            buildUpon.appendQueryParameter("split", "" + ((int) ((((config2.cdnConfig.splitRate * f) * 1024.0f) / 8.0f) + i2)));
                        }
                        if (config2.cntlId != null && config2.cntlId.length() > 0) {
                            buildUpon.appendQueryParameter("ctid", config2.cntlId);
                        }
                        if (config2.cdnConfig.key != null) {
                            buildUpon.appendQueryParameter("ctl_lv", "" + pPBandwidthConfig.level + "_" + config2.cdnConfig.key + "." + config2.cdnConfig.level);
                        }
                        return buildUpon.build();
                    } catch (Exception unused2) {
                        return uri;
                    }
                }
                PPLog.i(TAG, "This URI is not shot video!!!");
                return uri;
            }
        }
        PPLog.i(TAG, "(URI == NULL, BPS == 0 MOOV_SIZE == 0) rebuild url fail!");
        return uri;
    }

    public AdjustInfo rebuildUrlForPrefetch(Uri uri, String str, int i, int i2) {
        if (uri != null && i > 0 && i2 > 0) {
            PlayerPolicyBandwidthConfig pPBandwidthConfig = getPPBandwidthConfig(str);
            if (pPBandwidthConfig == null && (pPBandwidthConfig = getPlayerConfig()) == null) {
                PPLog.d(TAG, "rebuildUrl get container null!");
                return null;
            }
            long currentTimeMillis = (System.currentTimeMillis() / 1000) - pPBandwidthConfig.mLastConfigUpdateTimeStamp;
            if (currentTimeMillis > pPBandwidthConfig.mUpdateInterval * 4) {
                PPLog.d(TAG, "config timeout! delta: " + currentTimeMillis + " updateInterval: " + pPBandwidthConfig.mUpdateInterval);
                return null;
            }
            int queryVideoType = queryVideoType(uri);
            if (queryVideoType == -1) {
                queryVideoType = 4;
                PlayerPolicyDetailConfig config = pPBandwidthConfig.getConfig(4);
                if (config == null || !isMatchHost(uri.getHost(), config.hosts)) {
                    return null;
                }
            }
            PlayerPolicyDetailConfig config2 = pPBandwidthConfig.getConfig(queryVideoType);
            PPLog.d(TAG, "" + config2);
            if (!config2.isValidate()) {
                PPLog.i(TAG, "The player server config is invalidate, use old uri continue!");
                return null;
            } else if (!isMatchHost(uri.getHost(), config2.hosts)) {
                PPLog.i(TAG, "host : " + uri.getHost() + " not match");
                return null;
            } else {
                String query = uri.getQuery();
                if (TextUtils.isEmpty(query)) {
                    PPLog.i(TAG, "This host has no query!");
                    return null;
                }
                String[] split = query.split("&");
                boolean z = false;
                int i3 = -1;
                boolean z2 = false;
                for (int i4 = 0; i4 < split.length; i4++) {
                    if (split[i4].indexOf(PP_CFG_KEY_SLE) != -1) {
                        split[i4] = "sle=" + config2.prefetchConfig.sle;
                        z2 = true;
                    } else if (split[i4].indexOf("sl") != -1) {
                        split[i4] = "sl=" + ((int) ((config2.prefetchConfig.slRate * i) / 8.0f));
                    } else if (split[i4].indexOf("split") != -1) {
                        split[i4] = "split=" + ((int) ((((config2.prefetchConfig.splitRate * i) * 1024.0f) / 8.0f) + i2));
                    } else {
                        if (split[i4].indexOf("vt") != -1) {
                            try {
                                i3 = Integer.parseInt(split[i4].substring(split[i4].indexOf("vt") + 3));
                            } catch (Exception unused) {
                            }
                            z = true;
                        }
                    }
                }
                if (z && (i3 == 1 || i3 == 0)) {
                    try {
                        Uri.Builder buildUpon = uri.buildUpon();
                        buildUpon.clearQuery();
                        int length = split.length;
                        int i5 = 0;
                        while (i5 < length) {
                            String[] split2 = split[i5].split("=");
                            buildUpon.appendQueryParameter(split2[0], split2[1]);
                            i5++;
                            split = split;
                        }
                        if (!z2) {
                            buildUpon.appendQueryParameter(PP_CFG_KEY_SLE, "" + config2.prefetchConfig.sle);
                            StringBuilder sb = new StringBuilder();
                            sb.append("");
                            float f = (float) i;
                            sb.append((int) ((config2.prefetchConfig.slRate * f) / 8.0f));
                            buildUpon.appendQueryParameter("sl", sb.toString());
                            buildUpon.appendQueryParameter("split", "" + ((int) ((((config2.prefetchConfig.splitRate * f) * 1024.0f) / 8.0f) + i2)));
                        }
                        if (config2.cntlId != null && config2.cntlId.length() > 0) {
                            buildUpon.appendQueryParameter("ctid", config2.cntlId);
                        }
                        if (config2.prefetchConfig.key != null) {
                            buildUpon.appendQueryParameter("ctl_lv", "" + pPBandwidthConfig.level + "_" + config2.prefetchConfig.key + "." + config2.prefetchConfig.level);
                        }
                        return new AdjustInfo(buildUpon.build().toString(), (((i * 1024) / 8) * config2.prefetchConfig.duration) + i2);
                    } catch (Exception unused2) {
                        return null;
                    }
                }
                PPLog.i(TAG, "This URI is not shot video!!!");
                return null;
            }
        }
        PPLog.i(TAG, "(URI == NULL, BPS == 0 MOOV_SIZE == 0) rebuild url fail!");
        return null;
    }

    public Uri rebuildUrlForPlay(String str, String str2, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            return rebuildUrlForPlay(Uri.parse(str), str2, i, i2);
        }
        return null;
    }

    public AdjustInfo rebuildUrlForPrefetch(String str, String str2, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            return rebuildUrlForPrefetch(Uri.parse(str), str2, i, i2);
        }
        return null;
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerConfig
    public void update(String str) {
        updatePlayerPolicyBandwidthConfig(str);
    }

    public void updatePlayerPolicyBandwidthConfig(@NonNull final String str) {
        if (!TextUtils.isEmpty(str)) {
            Handler handler = this.mWorkHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.searchbox.playerserver.PlayerPolicyCfgManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (PlayerPolicyCfgManager.class) {
                            Log.i(PlayerPolicyCfgManager.TAG, " bw_cfg  " + str);
                            PlayerPolicyCfgManager.this.mBandwidthConfig = PlayerPolicyCfgManager.this.getPPBandwidthConfig(str);
                        }
                    }
                });
                return;
            }
            synchronized (PlayerPolicyCfgManager.class) {
                this.mBandwidthConfig = getPPBandwidthConfig(str);
            }
        }
    }
}
