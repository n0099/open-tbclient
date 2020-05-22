package com.baidu.swan.games.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c dcX = new c();
    private static String dcY = "banner_ad_close_btn_show_key";
    private static String dcZ = "banner_ad_close_duration_key";
    private long dda;
    private long ddb;

    private c() {
    }

    public static c aCc() {
        return dcX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sC(String str) {
        h.arO().putBoolean(dcY, "1".equals(str));
    }

    public boolean aCd() {
        return h.arO().getBoolean(dcY, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD(String str) {
        h.arO().putString(dcZ, str);
    }

    private long aCe() {
        String string = h.arO().getString(dcZ, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void cB(String str, String str2) {
        h.arO().putString(str, str2);
    }

    private long sE(String str) {
        String string = h.arO().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(long j) {
        h.arO().putLong("banner_ad_start_show_key", j);
    }

    public long aCf() {
        return h.arO().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(long j) {
        h.arO().putLong("banner_ad_repeat_show_key", j);
    }

    public long aCg() {
        return h.arO().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        h.arO().putLong("banner_ad_close_key", j);
    }

    public long aCh() {
        return h.arO().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aCi() {
        this.dda = System.currentTimeMillis();
    }

    public void aCj() {
        this.ddb = System.currentTimeMillis();
    }

    public boolean sF(String str) {
        return System.currentTimeMillis() - sE(str) <= aCe();
    }

    public boolean aCk() {
        return this.dda != 0 && System.currentTimeMillis() - this.dda <= aCf();
    }

    public boolean aCl() {
        return this.ddb != 0 && System.currentTimeMillis() - this.ddb <= aCg();
    }

    public void aCm() {
        e aoF = e.aoF();
        if (aoF != null && com.baidu.swan.apps.u.a.afd() != null && com.baidu.swan.apps.u.a.afo() != null) {
            aoF.aoU().getRequest().cookieManager(com.baidu.swan.apps.u.a.afo().SM()).url(com.baidu.swan.apps.u.a.afd().Sd()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.V(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.sC(optJSONObject.optString("show", "1"));
                            c.this.sD(optJSONObject.optString("duration", "1"));
                            c.this.bF(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.bG(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.bH(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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
