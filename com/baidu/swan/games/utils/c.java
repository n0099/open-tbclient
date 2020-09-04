package com.baidu.swan.games.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private static c dxB = new c();
    private static String dxC = "banner_ad_close_btn_show_key";
    private static String dxD = "banner_ad_close_duration_key";
    private static String dxG = "gdt_banner_ad_app_id_key";
    private static String dxH = "gdt_video_ad_app_id_key";
    private static String dxI = "gdt_banner_ad_id_key";
    private static String dxJ = "gdt_video_ad_id_key";
    private static String dxK = "gdt_video_ad_config_time";
    private static String dxL = "video_interaction_optimization";
    private static String dxM = "video_request_optimization";
    private static String dxN = "first_request_optimization";
    private long dxE;
    private long dxF;

    private c() {
    }

    public static c aPG() {
        return dxB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ(String str) {
        h.aDf().putBoolean(dxC, "1".equals(str));
    }

    public boolean aPH() {
        return h.aDf().getBoolean(dxC, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(String str) {
        h.aDf().putString(dxD, str);
    }

    private long aPI() {
        String string = h.aDf().getString(dxD, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void da(String str, String str2) {
        h.aDf().putString(str, str2);
    }

    private long wb(String str) {
        String string = h.aDf().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(long j) {
        h.aDf().putLong("banner_ad_start_show_key", j);
    }

    public long aPJ() {
        return h.aDf().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(long j) {
        h.aDf().putLong("banner_ad_repeat_show_key", j);
    }

    public long aPK() {
        return h.aDf().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(long j) {
        h.aDf().putLong("banner_ad_close_key", j);
    }

    public long aPL() {
        return h.aDf().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aPM() {
        this.dxE = System.currentTimeMillis();
    }

    public void aPN() {
        this.dxF = System.currentTimeMillis();
    }

    public boolean wc(String str) {
        return System.currentTimeMillis() - wb(str) <= aPI();
    }

    public boolean aPO() {
        return this.dxE != 0 && System.currentTimeMillis() - this.dxE <= aPJ();
    }

    public boolean aPP() {
        return this.dxF != 0 && System.currentTimeMillis() - this.dxF <= aPK();
    }

    public void aPQ() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null && com.baidu.swan.apps.t.a.aoV() != null && com.baidu.swan.apps.t.a.apj() != null) {
            azI.azX().getRequest().cookieManager(com.baidu.swan.apps.t.a.apj().aau()).url(com.baidu.swan.apps.t.a.aoV().ZE()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.X(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.vZ(optJSONObject.optString("show", "1"));
                            c.this.wa(optJSONObject.optString("duration", "1"));
                            c.this.bZ(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.ca(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.cb(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aPR() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null && com.baidu.swan.apps.t.a.aoV() != null && com.baidu.swan.apps.t.a.apj() != null) {
            azI.azX().getRequest().cookieManager(com.baidu.swan.apps.t.a.apj().aau()).url(com.baidu.swan.apps.t.a.aoV().ZK()).addUrlParam("app_key", azI.getAppKey()).addUrlParam("host", azI.getPackageName()).addUrlParam("os", "android").build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
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
                                        c.this.wd("");
                                        c.this.we("");
                                        c.this.wf("");
                                        c.this.wg("");
                                        c.this.cc(0L);
                                        c.this.gL(false);
                                        c.this.gM(false);
                                        c.this.gN(false);
                                    } else {
                                        c.this.wd(optJSONObject.optString("banner"));
                                        c.this.we(optJSONObject.optString("video"));
                                        c.this.wf(optJSONObject.optString("banner_app_id"));
                                        c.this.wg(optJSONObject.optString("video_app_id"));
                                        c.this.cc(System.currentTimeMillis());
                                        c.this.gL(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.gM(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.gN(optJSONObject.optBoolean("first_request_opt"));
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
    public void wd(String str) {
        h.aDf().putString(dxI, str);
    }

    public String aPS() {
        return h.aDf().getString(dxI, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(String str) {
        h.aDf().putString(dxJ, str);
    }

    public String aPT() {
        return h.aDf().getString(dxJ, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf(String str) {
        h.aDf().putString(dxG, str);
    }

    public String aJt() {
        return h.aDf().getString(dxG, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(String str) {
        h.aDf().putString(dxH, str);
    }

    public String aJv() {
        return h.aDf().getString(dxH, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(long j) {
        h.aDf().putLong(dxK, j);
    }

    public Long aPU() {
        return Long.valueOf(h.aDf().getLong(dxK, 0L));
    }

    public boolean aPV() {
        return h.aDf().getBoolean(dxL, false);
    }

    public void gL(boolean z) {
        h.aDf().putBoolean(dxL, z);
    }

    public boolean aPW() {
        return h.aDf().getBoolean(dxM, false);
    }

    public void gM(boolean z) {
        h.aDf().putBoolean(dxM, z);
    }

    public boolean aPX() {
        return h.aDf().getBoolean(dxN, false);
    }

    public void gN(boolean z) {
        h.aDf().putBoolean(dxN, z);
    }
}
