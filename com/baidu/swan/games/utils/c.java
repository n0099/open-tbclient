package com.baidu.swan.games.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private long dnw;
    private long dnx;
    private static c dnt = new c();
    private static String dnu = "banner_ad_close_btn_show_key";
    private static String dnv = "banner_ad_close_duration_key";
    private static String dny = "gdt_banner_ad_app_id_key";
    private static String dnz = "gdt_video_ad_app_id_key";
    private static String dnA = "gdt_banner_ad_id_key";
    private static String dnB = "gdt_video_ad_id_key";
    private static String dnC = "gdt_video_ad_config_time";
    private static String dnD = "video_interaction_optimization";
    private static String dnE = "video_request_optimization";
    private static String dnF = "first_request_optimization";

    private c() {
    }

    public static c aGP() {
        return dnt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(String str) {
        h.auW().putBoolean(dnu, "1".equals(str));
    }

    public boolean aGQ() {
        return h.auW().getBoolean(dnu, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(String str) {
        h.auW().putString(dnv, str);
    }

    private long aGR() {
        String string = h.auW().getString(dnv, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void cG(String str, String str2) {
        h.auW().putString(str, str2);
    }

    private long tK(String str) {
        String string = h.auW().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(long j) {
        h.auW().putLong("banner_ad_start_show_key", j);
    }

    public long aGS() {
        return h.auW().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(long j) {
        h.auW().putLong("banner_ad_repeat_show_key", j);
    }

    public long aGT() {
        return h.auW().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(long j) {
        h.auW().putLong("banner_ad_close_key", j);
    }

    public long aGU() {
        return h.auW().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aGV() {
        this.dnw = System.currentTimeMillis();
    }

    public void aGW() {
        this.dnx = System.currentTimeMillis();
    }

    public boolean tL(String str) {
        return System.currentTimeMillis() - tK(str) <= aGR();
    }

    public boolean aGX() {
        return this.dnw != 0 && System.currentTimeMillis() - this.dnw <= aGS();
    }

    public boolean aGY() {
        return this.dnx != 0 && System.currentTimeMillis() - this.dnx <= aGT();
    }

    public void aGZ() {
        e arv = e.arv();
        if (arv != null && com.baidu.swan.apps.t.a.ahv() != null && com.baidu.swan.apps.t.a.ahH() != null) {
            arv.arK().getRequest().cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).url(com.baidu.swan.apps.t.a.ahv().TE()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.V(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.tI(optJSONObject.optString("show", "1"));
                            c.this.tJ(optJSONObject.optString("duration", "1"));
                            c.this.bS(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.bT(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.bU(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aHa() {
        e arv = e.arv();
        if (arv != null && com.baidu.swan.apps.t.a.ahv() != null && com.baidu.swan.apps.t.a.ahH() != null) {
            arv.arK().getRequest().cookieManager(com.baidu.swan.apps.t.a.ahH().Us()).url(com.baidu.swan.apps.t.a.ahv().TJ()).addUrlParam("app_key", arv.getAppKey()).addUrlParam("host", arv.getPackageName()).addUrlParam("os", "android").build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
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
                                        c.this.tM("");
                                        c.this.tN("");
                                        c.this.tO("");
                                        c.this.tP("");
                                        c.this.bV(0L);
                                        c.this.go(false);
                                        c.this.gp(false);
                                        c.this.gq(false);
                                    } else {
                                        c.this.tM(optJSONObject.optString("banner"));
                                        c.this.tN(optJSONObject.optString("video"));
                                        c.this.tO(optJSONObject.optString("banner_app_id"));
                                        c.this.tP(optJSONObject.optString("video_app_id"));
                                        c.this.bV(System.currentTimeMillis());
                                        c.this.go(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.gp(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.gq(optJSONObject.optBoolean("first_request_opt"));
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
    public void tM(String str) {
        h.auW().putString(dnA, str);
    }

    public String aHb() {
        return h.auW().getString(dnA, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tN(String str) {
        h.auW().putString(dnB, str);
    }

    public String aHc() {
        return h.auW().getString(dnB, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(String str) {
        h.auW().putString(dny, str);
    }

    public String aAK() {
        return h.auW().getString(dny, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(String str) {
        h.auW().putString(dnz, str);
    }

    public String aAM() {
        return h.auW().getString(dnz, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(long j) {
        h.auW().putLong(dnC, j);
    }

    public Long aHd() {
        return Long.valueOf(h.auW().getLong(dnC, 0L));
    }

    public boolean aHe() {
        return h.auW().getBoolean(dnD, false);
    }

    public void go(boolean z) {
        h.auW().putBoolean(dnD, z);
    }

    public boolean aHf() {
        return h.auW().getBoolean(dnE, false);
    }

    public void gp(boolean z) {
        h.auW().putBoolean(dnE, z);
    }

    public boolean aHg() {
        return h.auW().getBoolean(dnF, false);
    }

    public void gq(boolean z) {
        h.auW().putBoolean(dnF, z);
    }
}
