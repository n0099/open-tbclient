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
    private static c dZS = new c();
    private static String dZT = "banner_ad_close_btn_show_key";
    private static String dZU = "banner_ad_close_duration_key";
    private static String dZX = "gdt_banner_ad_app_id_key";
    private static String dZY = "gdt_video_ad_app_id_key";
    private static String dZZ = "gdt_banner_ad_id_key";
    private static String eaa = "gdt_video_ad_id_key";
    private static String eab = "gdt_video_ad_config_time";
    private static String eac = "video_interaction_optimization";
    private static String ead = "video_request_optimization";
    private static String eae = "first_request_optimization";
    private long dZV;
    private long dZW;

    private c() {
    }

    public static c aXu() {
        return dZS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(String str) {
        h.aKS().putBoolean(dZT, "1".equals(str));
    }

    public boolean aXv() {
        return h.aKS().getBoolean(dZT, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(String str) {
        h.aKS().putString(dZU, str);
    }

    private long aXw() {
        String string = h.aKS().getString(dZU, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void dm(String str, String str2) {
        h.aKS().putString(str, str2);
    }

    private long xN(String str) {
        String string = h.aKS().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(long j) {
        h.aKS().putLong("banner_ad_start_show_key", j);
    }

    public long aXx() {
        return h.aKS().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(long j) {
        h.aKS().putLong("banner_ad_repeat_show_key", j);
    }

    public long aXy() {
        return h.aKS().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(long j) {
        h.aKS().putLong("banner_ad_close_key", j);
    }

    public long aXz() {
        return h.aKS().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aXA() {
        this.dZV = System.currentTimeMillis();
    }

    public void aXB() {
        this.dZW = System.currentTimeMillis();
    }

    public boolean xO(String str) {
        return System.currentTimeMillis() - xN(str) <= aXw();
    }

    public boolean aXC() {
        return this.dZV != 0 && System.currentTimeMillis() - this.dZV <= aXx();
    }

    public boolean aXD() {
        return this.dZW != 0 && System.currentTimeMillis() - this.dZW <= aXy();
    }

    public void aXE() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null && com.baidu.swan.apps.t.a.awM() != null && com.baidu.swan.apps.t.a.awZ() != null) {
            aHu.aHJ().getRequest().cookieManager(com.baidu.swan.apps.t.a.awZ().aij()).url(com.baidu.swan.apps.t.a.awM().aht()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.aa(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.xL(optJSONObject.optString("show", "1"));
                            c.this.xM(optJSONObject.optString("duration", "1"));
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

    public void aXF() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null && com.baidu.swan.apps.t.a.awM() != null && com.baidu.swan.apps.t.a.awZ() != null) {
            aHu.aHJ().getRequest().cookieManager(com.baidu.swan.apps.t.a.awZ().aij()).url(com.baidu.swan.apps.t.a.awM().ahz()).addUrlParam("app_key", aHu.getAppKey()).addUrlParam("host", aHu.getPackageName()).addUrlParam("os", "android").build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
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
                                        c.this.xP("");
                                        c.this.xQ("");
                                        c.this.xR("");
                                        c.this.xS("");
                                        c.this.cJ(0L);
                                        c.this.hB(false);
                                        c.this.hC(false);
                                        c.this.hD(false);
                                    } else {
                                        c.this.xP(optJSONObject.optString("banner"));
                                        c.this.xQ(optJSONObject.optString("video"));
                                        c.this.xR(optJSONObject.optString("banner_app_id"));
                                        c.this.xS(optJSONObject.optString("video_app_id"));
                                        c.this.cJ(System.currentTimeMillis());
                                        c.this.hB(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.hC(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.hD(optJSONObject.optBoolean("first_request_opt"));
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
    public void xP(String str) {
        h.aKS().putString(dZZ, str);
    }

    public String aXG() {
        return h.aKS().getString(dZZ, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xQ(String str) {
        h.aKS().putString(eaa, str);
    }

    public String aXH() {
        return h.aKS().getString(eaa, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xR(String str) {
        h.aKS().putString(dZX, str);
    }

    public String aRh() {
        return h.aKS().getString(dZX, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xS(String str) {
        h.aKS().putString(dZY, str);
    }

    public String aRj() {
        return h.aKS().getString(dZY, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(long j) {
        h.aKS().putLong(eab, j);
    }

    public Long aXI() {
        return Long.valueOf(h.aKS().getLong(eab, 0L));
    }

    public boolean aXJ() {
        return h.aKS().getBoolean(eac, false);
    }

    public void hB(boolean z) {
        h.aKS().putBoolean(eac, z);
    }

    public boolean aXK() {
        return h.aKS().getBoolean(ead, false);
    }

    public void hC(boolean z) {
        h.aKS().putBoolean(ead, z);
    }

    public boolean aXL() {
        return h.aKS().getBoolean(eae, false);
    }

    public void hD(boolean z) {
        h.aKS().putBoolean(eae, z);
    }
}
