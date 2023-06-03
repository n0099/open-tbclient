package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CyberRuntimeInfo {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public int e = -1;
    public int f = -1;
    public long g = -1;
    public long h = -1;
    public long i = -1;

    @Keep
    public int getDiskCacheSize() {
        return this.f;
    }

    @Keep
    public long getDownloadCacheByCDN() {
        return this.g;
    }

    @Keep
    public long getDownloadCacheByP2P() {
        return this.h;
    }

    @Keep
    public long getDownloadCacheByXCDN() {
        return this.i;
    }

    @Keep
    public int getDownloadSpeed() {
        return this.a;
    }

    @Keep
    public int getDownloadSpeedCdn() {
        return this.c;
    }

    @Keep
    public int getDownloadSpeedP2P() {
        return this.b;
    }

    @Keep
    public int getDropFrameCount() {
        return this.d;
    }

    @Keep
    public int getMemCacheSize() {
        return this.e;
    }

    @Keep
    /* loaded from: classes3.dex */
    public static abstract class OnMediaRuntimeInfoDefault implements CyberPlayerManager.OnMediaRuntimeInfoListener {
        public abstract void onInfo(CyberRuntimeInfo cyberRuntimeInfo);

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaRuntimeInfoListener
        public void onRuntimeInfo(String str) {
            onInfo(new CyberRuntimeInfo().a(str));
        }
    }

    public CyberRuntimeInfo a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("download_speed"), -1);
            this.b = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("download_speed_p2p"), -1);
            this.c = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("download_speed_cdn"), -1);
            this.d = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("drop_frame_count"), -1);
            this.e = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("mem_cache_size"), -1);
            this.f = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("disk_cache_size"), -1);
            this.g = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("download_by_cdn"), -1L);
            this.h = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("download_by_p2p"), -1L);
            this.i = com.baidu.cyberplayer.sdk.utils.c.a(jSONObject.optString("download_by_xcdn"), -1L);
        } catch (Exception unused) {
        }
        return this;
    }
}
