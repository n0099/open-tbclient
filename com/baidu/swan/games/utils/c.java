package com.baidu.swan.games.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c cRZ = new c();
    private static String cSa = "banner_ad_close_btn_show_key";
    private static String cSb = "banner_ad_close_duration_key";
    private long cSc;
    private long cSd;

    private c() {
    }

    public static c ayk() {
        return cRZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qY(String str) {
        h.any().putBoolean(cSa, "1".equals(str));
    }

    public boolean ayl() {
        return h.any().getBoolean(cSa, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qZ(String str) {
        h.any().putString(cSb, str);
    }

    private long aym() {
        String string = h.any().getString(cSb, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void cg(String str, String str2) {
        h.any().putString(str, str2);
    }

    private long ra(String str) {
        String string = h.any().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        h.any().putLong("banner_ad_start_show_key", j);
    }

    public long ayn() {
        return h.any().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(long j) {
        h.any().putLong("banner_ad_repeat_show_key", j);
    }

    public long ayo() {
        return h.any().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(long j) {
        h.any().putLong("banner_ad_close_key", j);
    }

    public long ayp() {
        return h.any().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void ayq() {
        this.cSc = System.currentTimeMillis();
    }

    public void ayr() {
        this.cSd = System.currentTimeMillis();
    }

    public boolean rb(String str) {
        return System.currentTimeMillis() - ra(str) <= aym();
    }

    public boolean ays() {
        return this.cSc != 0 && System.currentTimeMillis() - this.cSc <= ayn();
    }

    public boolean ayt() {
        return this.cSd != 0 && System.currentTimeMillis() - this.cSd <= ayo();
    }

    public void ayu() {
        e akM = e.akM();
        if (akM != null && com.baidu.swan.apps.w.a.abZ() != null && com.baidu.swan.apps.w.a.acl() != null) {
            akM.akZ().getRequest().cookieManager(com.baidu.swan.apps.w.a.acl().Qi()).url(com.baidu.swan.apps.w.a.abZ().Qd()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
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
