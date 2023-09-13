package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.utils.NumberUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CyberRuntimeInfo {
    public static final String DP_RUNTIME_DISK_CACHE_SIZE = "disk_cache_size";
    public static final String DP_RUNTIME_DOWNLOAD_BY_CDN = "download_by_cdn";
    public static final String DP_RUNTIME_DOWNLOAD_BY_P2P = "download_by_p2p";
    public static final String DP_RUNTIME_DOWNLOAD_BY_XCDN = "download_by_xcdn";
    public static final String DP_RUNTIME_DOWNLOAD_SPEED = "download_speed";
    public static final String DP_RUNTIME_DOWNLOAD_SPEED_CDN = "download_speed_cdn";
    public static final String DP_RUNTIME_DOWNLOAD_SPEED_P2P = "download_speed_p2p";
    public static final String DP_RUNTIME_DROP_FRAME_COUNT = "drop_frame_count";
    public static final String DP_RUNTIME_MEM_CACHE_SIZE = "mem_cache_size";
    public static final int UNKNOWN_VALUE = -1;
    public int mDownloadSpeed = -1;
    public int mDownloadSpeedP2P = -1;
    public int mDownloadSpeedCdn = -1;
    public int mDropFrameCount = -1;
    public int mMemCacheSize = -1;
    public int mDiskCacheSize = -1;
    public long mDownloadCacheByCDN = -1;
    public long mDownloadCacheByP2P = -1;
    public long mDownloadCacheByXCDN = -1;

    @Keep
    public int getDiskCacheSize() {
        return this.mDiskCacheSize;
    }

    @Keep
    public long getDownloadCacheByCDN() {
        return this.mDownloadCacheByCDN;
    }

    @Keep
    public long getDownloadCacheByP2P() {
        return this.mDownloadCacheByP2P;
    }

    @Keep
    public long getDownloadCacheByXCDN() {
        return this.mDownloadCacheByXCDN;
    }

    @Keep
    public int getDownloadSpeed() {
        return this.mDownloadSpeed;
    }

    @Keep
    public int getDownloadSpeedCdn() {
        return this.mDownloadSpeedCdn;
    }

    @Keep
    public int getDownloadSpeedP2P() {
        return this.mDownloadSpeedP2P;
    }

    @Keep
    public int getDropFrameCount() {
        return this.mDropFrameCount;
    }

    @Keep
    public int getMemCacheSize() {
        return this.mMemCacheSize;
    }

    @Keep
    /* loaded from: classes3.dex */
    public static abstract class OnMediaRuntimeInfoDefault implements CyberPlayerManager.OnMediaRuntimeInfoListener {
        public abstract void onInfo(CyberRuntimeInfo cyberRuntimeInfo);

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaRuntimeInfoListener
        public void onRuntimeInfo(String str) {
            onInfo(new CyberRuntimeInfo().parseRuntimeInfo(str));
        }
    }

    public CyberRuntimeInfo parseRuntimeInfo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mDownloadSpeed = NumberUtils.parseIntSafely(jSONObject.optString(DP_RUNTIME_DOWNLOAD_SPEED), -1);
            this.mDownloadSpeedP2P = NumberUtils.parseIntSafely(jSONObject.optString(DP_RUNTIME_DOWNLOAD_SPEED_P2P), -1);
            this.mDownloadSpeedCdn = NumberUtils.parseIntSafely(jSONObject.optString(DP_RUNTIME_DOWNLOAD_SPEED_CDN), -1);
            this.mDropFrameCount = NumberUtils.parseIntSafely(jSONObject.optString(DP_RUNTIME_DROP_FRAME_COUNT), -1);
            this.mMemCacheSize = NumberUtils.parseIntSafely(jSONObject.optString(DP_RUNTIME_MEM_CACHE_SIZE), -1);
            this.mDiskCacheSize = NumberUtils.parseIntSafely(jSONObject.optString(DP_RUNTIME_DISK_CACHE_SIZE), -1);
            this.mDownloadCacheByCDN = NumberUtils.parseLongSafely(jSONObject.optString(DP_RUNTIME_DOWNLOAD_BY_CDN), -1L);
            this.mDownloadCacheByP2P = NumberUtils.parseLongSafely(jSONObject.optString(DP_RUNTIME_DOWNLOAD_BY_P2P), -1L);
            this.mDownloadCacheByXCDN = NumberUtils.parseLongSafely(jSONObject.optString(DP_RUNTIME_DOWNLOAD_BY_XCDN), -1L);
        } catch (Exception unused) {
        }
        return this;
    }
}
