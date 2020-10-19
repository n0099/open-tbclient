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
    private static c dLD = new c();
    private static String dLE = "banner_ad_close_btn_show_key";
    private static String dLF = "banner_ad_close_duration_key";
    private static String dLI = "gdt_banner_ad_app_id_key";
    private static String dLJ = "gdt_video_ad_app_id_key";
    private static String dLK = "gdt_banner_ad_id_key";
    private static String dLL = "gdt_video_ad_id_key";
    private static String dLM = "gdt_video_ad_config_time";
    private static String dLN = "video_interaction_optimization";
    private static String dLO = "video_request_optimization";
    private static String dLP = "first_request_optimization";
    private long dLG;
    private long dLH;

    private c() {
    }

    public static c aTa() {
        return dLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe(String str) {
        h.aGy().putBoolean(dLE, "1".equals(str));
    }

    public boolean aTb() {
        return h.aGy().getBoolean(dLE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xf(String str) {
        h.aGy().putString(dLF, str);
    }

    private long aTc() {
        String string = h.aGy().getString(dLF, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void df(String str, String str2) {
        h.aGy().putString(str, str2);
    }

    private long xg(String str) {
        String string = h.aGy().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(long j) {
        h.aGy().putLong("banner_ad_start_show_key", j);
    }

    public long aTd() {
        return h.aGy().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(long j) {
        h.aGy().putLong("banner_ad_repeat_show_key", j);
    }

    public long aTe() {
        return h.aGy().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(long j) {
        h.aGy().putLong("banner_ad_close_key", j);
    }

    public long aTf() {
        return h.aGy().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aTg() {
        this.dLG = System.currentTimeMillis();
    }

    public void aTh() {
        this.dLH = System.currentTimeMillis();
    }

    public boolean xh(String str) {
        return System.currentTimeMillis() - xg(str) <= aTc();
    }

    public boolean aTi() {
        return this.dLG != 0 && System.currentTimeMillis() - this.dLG <= aTd();
    }

    public boolean aTj() {
        return this.dLH != 0 && System.currentTimeMillis() - this.dLH <= aTe();
    }

    public void aTk() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null && com.baidu.swan.apps.t.a.ass() != null && com.baidu.swan.apps.t.a.asF() != null) {
            aDa.aDp().getRequest().cookieManager(com.baidu.swan.apps.t.a.asF().adP()).url(com.baidu.swan.apps.t.a.ass().acZ()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.Y(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.xe(optJSONObject.optString("show", "1"));
                            c.this.xf(optJSONObject.optString("duration", "1"));
                            c.this.ci(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.cj(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.ck(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aTl() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null && com.baidu.swan.apps.t.a.ass() != null && com.baidu.swan.apps.t.a.asF() != null) {
            aDa.aDp().getRequest().cookieManager(com.baidu.swan.apps.t.a.asF().adP()).url(com.baidu.swan.apps.t.a.ass().adf()).addUrlParam("app_key", aDa.getAppKey()).addUrlParam("host", aDa.getPackageName()).addUrlParam("os", "android").build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
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
                                        c.this.xi("");
                                        c.this.xj("");
                                        c.this.xk("");
                                        c.this.xl("");
                                        c.this.cl(0L);
                                        c.this.hf(false);
                                        c.this.hg(false);
                                        c.this.hh(false);
                                    } else {
                                        c.this.xi(optJSONObject.optString("banner"));
                                        c.this.xj(optJSONObject.optString("video"));
                                        c.this.xk(optJSONObject.optString("banner_app_id"));
                                        c.this.xl(optJSONObject.optString("video_app_id"));
                                        c.this.cl(System.currentTimeMillis());
                                        c.this.hf(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.hg(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.hh(optJSONObject.optBoolean("first_request_opt"));
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
    public void xi(String str) {
        h.aGy().putString(dLK, str);
    }

    public String aTm() {
        return h.aGy().getString(dLK, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str) {
        h.aGy().putString(dLL, str);
    }

    public String aTn() {
        return h.aGy().getString(dLL, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk(String str) {
        h.aGy().putString(dLI, str);
    }

    public String aMN() {
        return h.aGy().getString(dLI, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl(String str) {
        h.aGy().putString(dLJ, str);
    }

    public String aMP() {
        return h.aGy().getString(dLJ, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(long j) {
        h.aGy().putLong(dLM, j);
    }

    public Long aTo() {
        return Long.valueOf(h.aGy().getLong(dLM, 0L));
    }

    public boolean aTp() {
        return h.aGy().getBoolean(dLN, false);
    }

    public void hf(boolean z) {
        h.aGy().putBoolean(dLN, z);
    }

    public boolean aTq() {
        return h.aGy().getBoolean(dLO, false);
    }

    public void hg(boolean z) {
        h.aGy().putBoolean(dLO, z);
    }

    public boolean aTr() {
        return h.aGy().getBoolean(dLP, false);
    }

    public void hh(boolean z) {
        h.aGy().putBoolean(dLP, z);
    }
}
