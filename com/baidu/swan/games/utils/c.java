package com.baidu.swan.games.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    private static c dYk = new c();
    private static String dYl = "banner_ad_close_btn_show_key";
    private static String dYm = "banner_ad_close_duration_key";
    private static String dYp = "gdt_banner_ad_app_id_key";
    private static String dYq = "gdt_video_ad_app_id_key";
    private static String dYr = "gdt_banner_ad_id_key";
    private static String dYs = "gdt_video_ad_id_key";
    private static String dYt = "gdt_video_ad_config_time";
    private static String dYu = "video_interaction_optimization";
    private static String dYv = "video_request_optimization";
    private static String dYw = "first_request_optimization";
    private long dYn;
    private long dYo;

    private c() {
    }

    public static c aWM() {
        return dYk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG(String str) {
        h.aKk().putBoolean(dYl, "1".equals(str));
    }

    public boolean aWN() {
        return h.aKk().getBoolean(dYl, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xH(String str) {
        h.aKk().putString(dYm, str);
    }

    private long aWO() {
        String string = h.aKk().getString(dYm, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void dl(String str, String str2) {
        h.aKk().putString(str, str2);
    }

    private long xI(String str) {
        String string = h.aKk().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(long j) {
        h.aKk().putLong("banner_ad_start_show_key", j);
    }

    public long aWP() {
        return h.aKk().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(long j) {
        h.aKk().putLong("banner_ad_repeat_show_key", j);
    }

    public long aWQ() {
        return h.aKk().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(long j) {
        h.aKk().putLong("banner_ad_close_key", j);
    }

    public long aWR() {
        return h.aKk().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aWS() {
        this.dYn = System.currentTimeMillis();
    }

    public void aWT() {
        this.dYo = System.currentTimeMillis();
    }

    public boolean xJ(String str) {
        return System.currentTimeMillis() - xI(str) <= aWO();
    }

    public boolean aWU() {
        return this.dYn != 0 && System.currentTimeMillis() - this.dYn <= aWP();
    }

    public boolean aWV() {
        return this.dYo != 0 && System.currentTimeMillis() - this.dYo <= aWQ();
    }

    public void aWW() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null && com.baidu.swan.apps.t.a.awe() != null && com.baidu.swan.apps.t.a.awr() != null) {
            aGM.aHb().getRequest().cookieManager(com.baidu.swan.apps.t.a.awr().ahB()).url(com.baidu.swan.apps.t.a.awe().agL()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.aa(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.xG(optJSONObject.optString("show", "1"));
                            c.this.xH(optJSONObject.optString("duration", "1"));
                            c.this.cG(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.cH(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.cI(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aWX() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null && com.baidu.swan.apps.t.a.awe() != null && com.baidu.swan.apps.t.a.awr() != null) {
            aGM.aHb().getRequest().cookieManager(com.baidu.swan.apps.t.a.awr().ahB()).url(com.baidu.swan.apps.t.a.awe().agR()).addUrlParam("app_key", aGM.getAppKey()).addUrlParam("host", aGM.getPackageName()).addUrlParam("os", "android").build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
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
                                        c.this.xK("");
                                        c.this.xL("");
                                        c.this.xM("");
                                        c.this.xN("");
                                        c.this.cJ(0L);
                                        c.this.hE(false);
                                        c.this.hF(false);
                                        c.this.hG(false);
                                    } else {
                                        c.this.xK(optJSONObject.optString("banner"));
                                        c.this.xL(optJSONObject.optString("video"));
                                        c.this.xM(optJSONObject.optString("banner_app_id"));
                                        c.this.xN(optJSONObject.optString("video_app_id"));
                                        c.this.cJ(System.currentTimeMillis());
                                        c.this.hE(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.hF(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.hG(optJSONObject.optBoolean("first_request_opt"));
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
    public void xK(String str) {
        h.aKk().putString(dYr, str);
    }

    public String aWY() {
        return h.aKk().getString(dYr, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(String str) {
        h.aKk().putString(dYs, str);
    }

    public String aWZ() {
        return h.aKk().getString(dYs, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(String str) {
        h.aKk().putString(dYp, str);
    }

    public String aQz() {
        return h.aKk().getString(dYp, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(String str) {
        h.aKk().putString(dYq, str);
    }

    public String aQB() {
        return h.aKk().getString(dYq, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(long j) {
        h.aKk().putLong(dYt, j);
    }

    public Long aXa() {
        return Long.valueOf(h.aKk().getLong(dYt, 0L));
    }

    public boolean aXb() {
        return h.aKk().getBoolean(dYu, false);
    }

    public void hE(boolean z) {
        h.aKk().putBoolean(dYu, z);
    }

    public boolean aXc() {
        return h.aKk().getBoolean(dYv, false);
    }

    public void hF(boolean z) {
        h.aKk().putBoolean(dYv, z);
    }

    public boolean aXd() {
        return h.aKk().getBoolean(dYw, false);
    }

    public void hG(boolean z) {
        h.aKk().putBoolean(dYw, z);
    }
}
