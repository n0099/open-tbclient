package com.baidu.swan.games.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private long coB;
    private long coC;
    private static c coy = new c();
    private static String coz = "banner_ad_close_btn_show_key";
    private static String coA = "banner_ad_close_duration_key";

    private c() {
    }

    public static c anm() {
        return coy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(String str) {
        h.acE().putBoolean(coz, "1".equals(str));
    }

    public boolean ann() {
        return h.acE().getBoolean(coz, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv(String str) {
        h.acE().putString(coA, str);
    }

    private long ano() {
        String string = h.acE().getString(coA, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void bM(String str, String str2) {
        h.acE().putString(str, str2);
    }

    private long pw(String str) {
        String string = h.acE().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(long j) {
        h.acE().putLong("banner_ad_start_show_key", j);
    }

    public long anp() {
        return h.acE().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(long j) {
        h.acE().putLong("banner_ad_repeat_show_key", j);
    }

    public long anq() {
        return h.acE().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(long j) {
        h.acE().putLong("banner_ad_close_key", j);
    }

    public long anr() {
        return h.acE().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void ans() {
        this.coB = System.currentTimeMillis();
    }

    public void ant() {
        this.coC = System.currentTimeMillis();
    }

    public boolean px(String str) {
        return System.currentTimeMillis() - pw(str) <= ano();
    }

    public boolean anu() {
        return this.coB != 0 && System.currentTimeMillis() - this.coB <= anp();
    }

    public boolean anv() {
        return this.coC != 0 && System.currentTimeMillis() - this.coC <= anq();
    }

    public void anw() {
        e ZS = e.ZS();
        if (ZS != null && com.baidu.swan.apps.w.a.Rw() != null && com.baidu.swan.apps.w.a.RI() != null) {
            ZS.aaf().getRequest().cookieManager(com.baidu.swan.apps.w.a.RI().FH()).url(com.baidu.swan.apps.w.a.Rw().FC()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.O(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.pu(optJSONObject.optString("show", "1"));
                            c.this.pv(optJSONObject.optString("duration", "1"));
                            c.this.aV(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.aW(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.aX(optJSONObject.optLong("preventBannerADShowingGap", 60L));
                        }
                    } catch (JSONException e) {
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                }
            });
        }
    }
}
