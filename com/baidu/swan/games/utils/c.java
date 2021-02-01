package com.baidu.swan.games.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private static c elD = new c();
    private static String elE = "banner_ad_close_btn_show_key";
    private static String elF = "banner_ad_close_duration_key";
    private static String elI = "gdt_banner_ad_app_id_key";
    private static String elJ = "gdt_video_ad_app_id_key";
    private static String elK = "gdt_banner_ad_id_key";
    private static String elL = "gdt_video_ad_id_key";
    private static String elM = "gdt_video_ad_config_time";
    private static String elN = "video_interaction_optimization";
    private static String elO = "video_request_optimization";
    private static String elP = "first_request_optimization";
    private long elG;
    private long elH;

    private c() {
    }

    public static c aYE() {
        return elD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu(String str) {
        h.aMh().putBoolean(elE, "1".equals(str));
    }

    public boolean aYF() {
        return h.aMh().getBoolean(elE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(String str) {
        h.aMh().putString(elF, str);
    }

    private long aYG() {
        String string = h.aMh().getString(elF, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void dk(String str, String str2) {
        h.aMh().putString(str, str2);
    }

    private long xw(String str) {
        String string = h.aMh().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(long j) {
        h.aMh().putLong("banner_ad_start_show_key", j);
    }

    public long aYH() {
        return h.aMh().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(long j) {
        h.aMh().putLong("banner_ad_repeat_show_key", j);
    }

    public long aYI() {
        return h.aMh().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m29do(long j) {
        h.aMh().putLong("banner_ad_close_key", j);
    }

    public long aYJ() {
        return h.aMh().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aYK() {
        this.elG = System.currentTimeMillis();
    }

    public void aYL() {
        this.elH = System.currentTimeMillis();
    }

    public boolean xx(String str) {
        return System.currentTimeMillis() - xw(str) <= aYG();
    }

    public boolean aYM() {
        return this.elG != 0 && System.currentTimeMillis() - this.elG <= aYH();
    }

    public boolean aYN() {
        return this.elH != 0 && System.currentTimeMillis() - this.elH <= aYI();
    }

    public void aYO() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null && com.baidu.swan.apps.t.a.axi() != null && com.baidu.swan.apps.t.a.axv() != null) {
            aIK.aIZ().getRequest().cookieManager(com.baidu.swan.apps.t.a.axv().aiy()).url(com.baidu.swan.apps.t.a.axi().ahG()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: U */
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.af(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.xu(optJSONObject.optString("show", "1"));
                            c.this.xv(optJSONObject.optString("duration", "1"));
                            c.this.dm(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.dn(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.m29do(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aYP() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null && com.baidu.swan.apps.t.a.axi() != null && com.baidu.swan.apps.t.a.axv() != null) {
            aIK.aIZ().getRequest().cookieManager(com.baidu.swan.apps.t.a.axv().aiy()).url(com.baidu.swan.apps.t.a.axi().ahM()).addUrlParam("app_key", aIK.getAppKey()).addUrlParam("host", aIK.getPackageName()).addUrlParam("os", HttpConstants.OS_TYPE_VALUE).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: U */
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    if (200 == i) {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                                    if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("ads_config")) == null) {
                                        c.this.xy("");
                                        c.this.xz("");
                                        c.this.xA("");
                                        c.this.xB("");
                                        c.this.dp(0L);
                                        c.this.ij(false);
                                        c.this.ik(false);
                                        c.this.il(false);
                                    } else {
                                        c.this.xy(optJSONObject.optString("banner"));
                                        c.this.xz(optJSONObject.optString("video"));
                                        c.this.xA(optJSONObject.optString("banner_app_id"));
                                        c.this.xB(optJSONObject.optString("video_app_id"));
                                        c.this.dp(System.currentTimeMillis());
                                        c.this.ij(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.ik(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.il(optJSONObject.optBoolean("first_request_opt"));
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
    public void xy(String str) {
        h.aMh().putString(elK, str);
    }

    public String aYQ() {
        return h.aMh().getString(elK, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz(String str) {
        h.aMh().putString(elL, str);
    }

    public String aYR() {
        return h.aMh().getString(elL, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xA(String str) {
        h.aMh().putString(elI, str);
    }

    public String aSr() {
        return h.aMh().getString(elI, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(String str) {
        h.aMh().putString(elJ, str);
    }

    public String aSt() {
        return h.aMh().getString(elJ, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(long j) {
        h.aMh().putLong(elM, j);
    }

    public Long aYS() {
        return Long.valueOf(h.aMh().getLong(elM, 0L));
    }

    public boolean aYT() {
        return h.aMh().getBoolean(elN, false);
    }

    public void ij(boolean z) {
        h.aMh().putBoolean(elN, z);
    }

    public boolean aYU() {
        return h.aMh().getBoolean(elO, false);
    }

    public void ik(boolean z) {
        h.aMh().putBoolean(elO, z);
    }

    public boolean aYV() {
        return h.aMh().getBoolean(elP, false);
    }

    public void il(boolean z) {
        h.aMh().putBoolean(elP, z);
    }
}
