package com.baidu.swan.games.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c csO = new c();
    private static String csP = "banner_ad_close_btn_show_key";
    private static String csQ = "banner_ad_close_duration_key";
    private long csR;
    private long csS;

    private c() {
    }

    public static c apV() {
        return csO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(String str) {
        h.afr().putBoolean(csP, "1".equals(str));
    }

    public boolean apW() {
        return h.afr().getBoolean(csP, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pN(String str) {
        h.afr().putString(csQ, str);
    }

    private long apX() {
        String string = h.afr().getString(csQ, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void bW(String str, String str2) {
        h.afr().putString(str, str2);
    }

    private long pO(String str) {
        String string = h.afr().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(long j) {
        h.afr().putLong("banner_ad_start_show_key", j);
    }

    public long apY() {
        return h.afr().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(long j) {
        h.afr().putLong("banner_ad_repeat_show_key", j);
    }

    public long apZ() {
        return h.afr().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(long j) {
        h.afr().putLong("banner_ad_close_key", j);
    }

    public long aqa() {
        return h.afr().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aqb() {
        this.csR = System.currentTimeMillis();
    }

    public void aqc() {
        this.csS = System.currentTimeMillis();
    }

    public boolean pP(String str) {
        return System.currentTimeMillis() - pO(str) <= apX();
    }

    public boolean aqd() {
        return this.csR != 0 && System.currentTimeMillis() - this.csR <= apY();
    }

    public boolean aqe() {
        return this.csS != 0 && System.currentTimeMillis() - this.csS <= apZ();
    }

    public void aqf() {
        e acF = e.acF();
        if (acF != null && com.baidu.swan.apps.w.a.Ui() != null && com.baidu.swan.apps.w.a.Uu() != null) {
            acF.acS().getRequest().cookieManager(com.baidu.swan.apps.w.a.Uu().Iu()).url(com.baidu.swan.apps.w.a.Ui().Ip()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.M(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.pM(optJSONObject.optString("show", "1"));
                            c.this.pN(optJSONObject.optString("duration", "1"));
                            c.this.bc(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.bd(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.be(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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
