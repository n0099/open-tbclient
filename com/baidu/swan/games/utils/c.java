package com.baidu.swan.games.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private static c dUa = new c();
    private static String dUb = "banner_ad_close_btn_show_key";
    private static String dUc = "banner_ad_close_duration_key";
    private static String dUf = "gdt_banner_ad_app_id_key";
    private static String dUg = "gdt_video_ad_app_id_key";
    private static String dUh = "gdt_banner_ad_id_key";
    private static String dUi = "gdt_video_ad_id_key";
    private static String dUj = "gdt_video_ad_config_time";
    private static String dUk = "video_interaction_optimization";
    private static String dUl = "video_request_optimization";
    private static String dUm = "first_request_optimization";
    private long dUd;
    private long dUe;

    private c() {
    }

    public static c aUU() {
        return dUa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xx(String str) {
        h.aIs().putBoolean(dUb, "1".equals(str));
    }

    public boolean aUV() {
        return h.aIs().getBoolean(dUb, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(String str) {
        h.aIs().putString(dUc, str);
    }

    private long aUW() {
        String string = h.aIs().getString(dUc, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void dm(String str, String str2) {
        h.aIs().putString(str, str2);
    }

    private long xz(String str) {
        String string = h.aIs().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(long j) {
        h.aIs().putLong("banner_ad_start_show_key", j);
    }

    public long aUX() {
        return h.aIs().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(long j) {
        h.aIs().putLong("banner_ad_repeat_show_key", j);
    }

    public long aUY() {
        return h.aIs().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(long j) {
        h.aIs().putLong("banner_ad_close_key", j);
    }

    public long aUZ() {
        return h.aIs().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aVa() {
        this.dUd = System.currentTimeMillis();
    }

    public void aVb() {
        this.dUe = System.currentTimeMillis();
    }

    public boolean xA(String str) {
        return System.currentTimeMillis() - xz(str) <= aUW();
    }

    public boolean aVc() {
        return this.dUd != 0 && System.currentTimeMillis() - this.dUd <= aUX();
    }

    public boolean aVd() {
        return this.dUe != 0 && System.currentTimeMillis() - this.dUe <= aUY();
    }

    public void aVe() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null && com.baidu.swan.apps.t.a.aum() != null && com.baidu.swan.apps.t.a.auz() != null) {
            aEU.aFj().getRequest().cookieManager(com.baidu.swan.apps.t.a.auz().afJ()).url(com.baidu.swan.apps.t.a.aum().aeT()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.Y(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.xx(optJSONObject.optString("show", "1"));
                            c.this.xy(optJSONObject.optString("duration", "1"));
                            c.this.ck(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.cl(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.cm(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aVf() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null && com.baidu.swan.apps.t.a.aum() != null && com.baidu.swan.apps.t.a.auz() != null) {
            aEU.aFj().getRequest().cookieManager(com.baidu.swan.apps.t.a.auz().afJ()).url(com.baidu.swan.apps.t.a.aum().aeZ()).addUrlParam("app_key", aEU.getAppKey()).addUrlParam("host", aEU.getPackageName()).addUrlParam("os", "android").build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    if (200 == i) {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                                    if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("ads_config")) == null) {
                                        c.this.xB("");
                                        c.this.xC("");
                                        c.this.xD("");
                                        c.this.xE("");
                                        c.this.cn(0L);
                                        c.this.hs(false);
                                        c.this.ht(false);
                                        c.this.hu(false);
                                    } else {
                                        c.this.xB(optJSONObject.optString("banner"));
                                        c.this.xC(optJSONObject.optString("video"));
                                        c.this.xD(optJSONObject.optString("banner_app_id"));
                                        c.this.xE(optJSONObject.optString("video_app_id"));
                                        c.this.cn(System.currentTimeMillis());
                                        c.this.hs(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.ht(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.hu(optJSONObject.optBoolean("first_request_opt"));
                                    }
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(String str) {
        h.aIs().putString(dUh, str);
    }

    public String aVg() {
        return h.aIs().getString(dUh, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC(String str) {
        h.aIs().putString(dUi, str);
    }

    public String aVh() {
        return h.aIs().getString(dUi, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD(String str) {
        h.aIs().putString(dUf, str);
    }

    public String aOH() {
        return h.aIs().getString(dUf, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE(String str) {
        h.aIs().putString(dUg, str);
    }

    public String aOJ() {
        return h.aIs().getString(dUg, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(long j) {
        h.aIs().putLong(dUj, j);
    }

    public Long aVi() {
        return Long.valueOf(h.aIs().getLong(dUj, 0L));
    }

    public boolean aVj() {
        return h.aIs().getBoolean(dUk, false);
    }

    public void hs(boolean z) {
        h.aIs().putBoolean(dUk, z);
    }

    public boolean aVk() {
        return h.aIs().getBoolean(dUl, false);
    }

    public void ht(boolean z) {
        h.aIs().putBoolean(dUl, z);
    }

    public boolean aVl() {
        return h.aIs().getBoolean(dUm, false);
    }

    public void hu(boolean z) {
        h.aIs().putBoolean(dUm, z);
    }
}
