package com.baidu.swan.games.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private static c dzC = new c();
    private static String dzD = "banner_ad_close_btn_show_key";
    private static String dzE = "banner_ad_close_duration_key";
    private static String dzH = "gdt_banner_ad_app_id_key";
    private static String dzI = "gdt_video_ad_app_id_key";
    private static String dzJ = "gdt_banner_ad_id_key";
    private static String dzK = "gdt_video_ad_id_key";
    private static String dzL = "gdt_video_ad_config_time";
    private static String dzM = "video_interaction_optimization";
    private static String dzN = "video_request_optimization";
    private static String dzO = "first_request_optimization";
    private long dzF;
    private long dzG;

    private c() {
    }

    public static c aQr() {
        return dzC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws(String str) {
        h.aDP().putBoolean(dzD, "1".equals(str));
    }

    public boolean aQs() {
        return h.aDP().getBoolean(dzD, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wt(String str) {
        h.aDP().putString(dzE, str);
    }

    private long aQt() {
        String string = h.aDP().getString(dzE, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void da(String str, String str2) {
        h.aDP().putString(str, str2);
    }

    private long wu(String str) {
        String string = h.aDP().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(long j) {
        h.aDP().putLong("banner_ad_start_show_key", j);
    }

    public long aQu() {
        return h.aDP().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(long j) {
        h.aDP().putLong("banner_ad_repeat_show_key", j);
    }

    public long aQv() {
        return h.aDP().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(long j) {
        h.aDP().putLong("banner_ad_close_key", j);
    }

    public long aQw() {
        return h.aDP().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aQx() {
        this.dzF = System.currentTimeMillis();
    }

    public void aQy() {
        this.dzG = System.currentTimeMillis();
    }

    public boolean wv(String str) {
        return System.currentTimeMillis() - wu(str) <= aQt();
    }

    public boolean aQz() {
        return this.dzF != 0 && System.currentTimeMillis() - this.dzF <= aQu();
    }

    public boolean aQA() {
        return this.dzG != 0 && System.currentTimeMillis() - this.dzG <= aQv();
    }

    public void aQB() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null && com.baidu.swan.apps.t.a.apG() != null && com.baidu.swan.apps.t.a.apT() != null) {
            aAr.aAG().getRequest().cookieManager(com.baidu.swan.apps.t.a.apT().abd()).url(com.baidu.swan.apps.t.a.apG().aan()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.X(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.ws(optJSONObject.optString("show", "1"));
                            c.this.wt(optJSONObject.optString("duration", "1"));
                            c.this.ca(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.cb(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.cc(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aQC() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null && com.baidu.swan.apps.t.a.apG() != null && com.baidu.swan.apps.t.a.apT() != null) {
            aAr.aAG().getRequest().cookieManager(com.baidu.swan.apps.t.a.apT().abd()).url(com.baidu.swan.apps.t.a.apG().aat()).addUrlParam("app_key", aAr.getAppKey()).addUrlParam("host", aAr.getPackageName()).addUrlParam("os", "android").build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
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
                                        c.this.ww("");
                                        c.this.wx("");
                                        c.this.wy("");
                                        c.this.wz("");
                                        c.this.cd(0L);
                                        c.this.gJ(false);
                                        c.this.gK(false);
                                        c.this.gL(false);
                                    } else {
                                        c.this.ww(optJSONObject.optString("banner"));
                                        c.this.wx(optJSONObject.optString("video"));
                                        c.this.wy(optJSONObject.optString("banner_app_id"));
                                        c.this.wz(optJSONObject.optString("video_app_id"));
                                        c.this.cd(System.currentTimeMillis());
                                        c.this.gJ(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.gK(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.gL(optJSONObject.optBoolean("first_request_opt"));
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
    public void ww(String str) {
        h.aDP().putString(dzJ, str);
    }

    public String aQD() {
        return h.aDP().getString(dzJ, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(String str) {
        h.aDP().putString(dzK, str);
    }

    public String aQE() {
        return h.aDP().getString(dzK, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wy(String str) {
        h.aDP().putString(dzH, str);
    }

    public String aKe() {
        return h.aDP().getString(dzH, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(String str) {
        h.aDP().putString(dzI, str);
    }

    public String aKg() {
        return h.aDP().getString(dzI, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(long j) {
        h.aDP().putLong(dzL, j);
    }

    public Long aQF() {
        return Long.valueOf(h.aDP().getLong(dzL, 0L));
    }

    public boolean aQG() {
        return h.aDP().getBoolean(dzM, false);
    }

    public void gJ(boolean z) {
        h.aDP().putBoolean(dzM, z);
    }

    public boolean aQH() {
        return h.aDP().getBoolean(dzN, false);
    }

    public void gK(boolean z) {
        h.aDP().putBoolean(dzN, z);
    }

    public boolean aQI() {
        return h.aDP().getBoolean(dzO, false);
    }

    public void gL(boolean z) {
        h.aDP().putBoolean(dzO, z);
    }
}
