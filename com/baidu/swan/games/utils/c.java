package com.baidu.swan.games.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static c coL = new c();
    private static String coM = "banner_ad_close_btn_show_key";
    private static String coN = "banner_ad_close_duration_key";
    private long coO;
    private long coP;

    private c() {
    }

    public static c anF() {
        return coL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void px(String str) {
        h.adb().putBoolean(coM, "1".equals(str));
    }

    public boolean anG() {
        return h.adb().getBoolean(coM, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py(String str) {
        h.adb().putString(coN, str);
    }

    private long anH() {
        String string = h.adb().getString(coN, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void bN(String str, String str2) {
        h.adb().putString(str, str2);
    }

    private long pz(String str) {
        String string = h.adb().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(long j) {
        h.adb().putLong("banner_ad_start_show_key", j);
    }

    public long anI() {
        return h.adb().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(long j) {
        h.adb().putLong("banner_ad_repeat_show_key", j);
    }

    public long anJ() {
        return h.adb().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(long j) {
        h.adb().putLong("banner_ad_close_key", j);
    }

    public long anK() {
        return h.adb().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void anL() {
        this.coO = System.currentTimeMillis();
    }

    public void anM() {
        this.coP = System.currentTimeMillis();
    }

    public boolean pA(String str) {
        return System.currentTimeMillis() - pz(str) <= anH();
    }

    public boolean anN() {
        return this.coO != 0 && System.currentTimeMillis() - this.coO <= anI();
    }

    public boolean anO() {
        return this.coP != 0 && System.currentTimeMillis() - this.coP <= anJ();
    }

    public void anP() {
        e aap = e.aap();
        if (aap != null && com.baidu.swan.apps.w.a.RS() != null && com.baidu.swan.apps.w.a.Se() != null) {
            aap.aaC().getRequest().cookieManager(com.baidu.swan.apps.w.a.Se().Gd()).url(com.baidu.swan.apps.w.a.RS().FY()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.O(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.px(optJSONObject.optString("show", "1"));
                            c.this.py(optJSONObject.optString("duration", "1"));
                            c.this.aY(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.aZ(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.ba(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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
