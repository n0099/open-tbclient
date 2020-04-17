package com.baidu.swan.games.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c cRU = new c();
    private static String cRV = "banner_ad_close_btn_show_key";
    private static String cRW = "banner_ad_close_duration_key";
    private long cRX;
    private long cRY;

    private c() {
    }

    public static c ayk() {
        return cRU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(String str) {
        h.anz().putBoolean(cRV, "1".equals(str));
    }

    public boolean ayl() {
        return h.anz().getBoolean(cRV, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qZ(String str) {
        h.anz().putString(cRW, str);
    }

    private long aym() {
        String string = h.anz().getString(cRW, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void cg(String str, String str2) {
        h.anz().putString(str, str2);
    }

    private long ra(String str) {
        String string = h.anz().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        h.anz().putLong("banner_ad_start_show_key", j);
    }

    public long ayn() {
        return h.anz().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(long j) {
        h.anz().putLong("banner_ad_repeat_show_key", j);
    }

    public long ayo() {
        return h.anz().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(long j) {
        h.anz().putLong("banner_ad_close_key", j);
    }

    public long ayp() {
        return h.anz().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void ayq() {
        this.cRX = System.currentTimeMillis();
    }

    public void ayr() {
        this.cRY = System.currentTimeMillis();
    }

    public boolean rb(String str) {
        return System.currentTimeMillis() - ra(str) <= aym();
    }

    public boolean ays() {
        return this.cRX != 0 && System.currentTimeMillis() - this.cRX <= ayn();
    }

    public boolean ayt() {
        return this.cRY != 0 && System.currentTimeMillis() - this.cRY <= ayo();
    }

    public void ayu() {
        e akN = e.akN();
        if (akN != null && com.baidu.swan.apps.w.a.aca() != null && com.baidu.swan.apps.w.a.acm() != null) {
            akN.ala().getRequest().cookieManager(com.baidu.swan.apps.w.a.acm().Qj()).url(com.baidu.swan.apps.w.a.aca().Qe()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.U(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.qY(optJSONObject.optString("show", "1"));
                            c.this.qZ(optJSONObject.optString("duration", "1"));
                            c.this.bH(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.bI(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.bJ(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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
