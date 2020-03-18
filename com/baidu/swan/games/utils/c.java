package com.baidu.swan.games.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c csZ = new c();
    private static String cta = "banner_ad_close_btn_show_key";
    private static String ctb = "banner_ad_close_duration_key";
    private long ctc;
    private long ctd;

    private c() {
    }

    public static c apY() {
        return csZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pL(String str) {
        h.afu().putBoolean(cta, "1".equals(str));
    }

    public boolean apZ() {
        return h.afu().getBoolean(cta, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(String str) {
        h.afu().putString(ctb, str);
    }

    private long aqa() {
        String string = h.afu().getString(ctb, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void bV(String str, String str2) {
        h.afu().putString(str, str2);
    }

    private long pN(String str) {
        String string = h.afu().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(long j) {
        h.afu().putLong("banner_ad_start_show_key", j);
    }

    public long aqb() {
        return h.afu().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(long j) {
        h.afu().putLong("banner_ad_repeat_show_key", j);
    }

    public long aqc() {
        return h.afu().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(long j) {
        h.afu().putLong("banner_ad_close_key", j);
    }

    public long aqd() {
        return h.afu().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aqe() {
        this.ctc = System.currentTimeMillis();
    }

    public void aqf() {
        this.ctd = System.currentTimeMillis();
    }

    public boolean pO(String str) {
        return System.currentTimeMillis() - pN(str) <= aqa();
    }

    public boolean aqg() {
        return this.ctc != 0 && System.currentTimeMillis() - this.ctc <= aqb();
    }

    public boolean aqh() {
        return this.ctd != 0 && System.currentTimeMillis() - this.ctd <= aqc();
    }

    public void aqi() {
        e acI = e.acI();
        if (acI != null && com.baidu.swan.apps.w.a.Ul() != null && com.baidu.swan.apps.w.a.Ux() != null) {
            acI.acV().getRequest().cookieManager(com.baidu.swan.apps.w.a.Ux().Ix()).url(com.baidu.swan.apps.w.a.Ul().Is()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.M(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.pL(optJSONObject.optString("show", "1"));
                            c.this.pM(optJSONObject.optString("duration", "1"));
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
