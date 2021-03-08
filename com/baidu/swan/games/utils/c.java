package com.baidu.swan.games.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private static c enf = new c();
    private static String eng = "banner_ad_close_btn_show_key";
    private static String enh = "banner_ad_close_duration_key";
    private static String enk = "gdt_banner_ad_app_id_key";
    private static String enl = "gdt_video_ad_app_id_key";
    private static String enm = "gdt_banner_ad_id_key";
    private static String enn = "gdt_video_ad_id_key";
    private static String eno = "gdt_video_ad_config_time";
    private static String enp = "video_interaction_optimization";
    private static String enq = "video_request_optimization";
    private static String enr = "first_request_optimization";
    private long eni;
    private long enj;

    private c() {
    }

    public static c aYH() {
        return enf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(String str) {
        h.aMk().putBoolean(eng, "1".equals(str));
    }

    public boolean aYI() {
        return h.aMk().getBoolean(eng, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC(String str) {
        h.aMk().putString(enh, str);
    }

    private long aYJ() {
        String string = h.aMk().getString(enh, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void dk(String str, String str2) {
        h.aMk().putString(str, str2);
    }

    private long xD(String str) {
        String string = h.aMk().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(long j) {
        h.aMk().putLong("banner_ad_start_show_key", j);
    }

    public long aYK() {
        return h.aMk().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(long j) {
        h.aMk().putLong("banner_ad_repeat_show_key", j);
    }

    public long aYL() {
        return h.aMk().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m30do(long j) {
        h.aMk().putLong("banner_ad_close_key", j);
    }

    public long aYM() {
        return h.aMk().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aYN() {
        this.eni = System.currentTimeMillis();
    }

    public void aYO() {
        this.enj = System.currentTimeMillis();
    }

    public boolean xE(String str) {
        return System.currentTimeMillis() - xD(str) <= aYJ();
    }

    public boolean aYP() {
        return this.eni != 0 && System.currentTimeMillis() - this.eni <= aYK();
    }

    public boolean aYQ() {
        return this.enj != 0 && System.currentTimeMillis() - this.enj <= aYL();
    }

    public void aYR() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null && com.baidu.swan.apps.t.a.axl() != null && com.baidu.swan.apps.t.a.axy() != null) {
            aIN.aJc().getRequest().cookieManager(com.baidu.swan.apps.t.a.axy().aiB()).url(com.baidu.swan.apps.t.a.axl().ahJ()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: V */
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.ag(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.xB(optJSONObject.optString("show", "1"));
                            c.this.xC(optJSONObject.optString("duration", "1"));
                            c.this.dm(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.dn(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.m30do(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aYS() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null && com.baidu.swan.apps.t.a.axl() != null && com.baidu.swan.apps.t.a.axy() != null) {
            aIN.aJc().getRequest().cookieManager(com.baidu.swan.apps.t.a.axy().aiB()).url(com.baidu.swan.apps.t.a.axl().ahP()).addUrlParam("app_key", aIN.getAppKey()).addUrlParam("host", aIN.getPackageName()).addUrlParam("os", HttpConstants.OS_TYPE_VALUE).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: V */
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    if (200 == i) {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                                    if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("ads_config")) == null) {
                                        c.this.xF("");
                                        c.this.xG("");
                                        c.this.xH("");
                                        c.this.xI("");
                                        c.this.dp(0L);
                                        c.this.ij(false);
                                        c.this.ik(false);
                                        c.this.il(false);
                                    } else {
                                        c.this.xF(optJSONObject.optString("banner"));
                                        c.this.xG(optJSONObject.optString("video"));
                                        c.this.xH(optJSONObject.optString("banner_app_id"));
                                        c.this.xI(optJSONObject.optString("video_app_id"));
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
    public void xF(String str) {
        h.aMk().putString(enm, str);
    }

    public String aYT() {
        return h.aMk().getString(enm, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG(String str) {
        h.aMk().putString(enn, str);
    }

    public String aYU() {
        return h.aMk().getString(enn, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xH(String str) {
        h.aMk().putString(enk, str);
    }

    public String aSu() {
        return h.aMk().getString(enk, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xI(String str) {
        h.aMk().putString(enl, str);
    }

    public String aSw() {
        return h.aMk().getString(enl, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(long j) {
        h.aMk().putLong(eno, j);
    }

    public Long aYV() {
        return Long.valueOf(h.aMk().getLong(eno, 0L));
    }

    public boolean aYW() {
        return h.aMk().getBoolean(enp, false);
    }

    public void ij(boolean z) {
        h.aMk().putBoolean(enp, z);
    }

    public boolean aYX() {
        return h.aMk().getBoolean(enq, false);
    }

    public void ik(boolean z) {
        h.aMk().putBoolean(enq, z);
    }

    public boolean aYY() {
        return h.aMk().getBoolean(enr, false);
    }

    public void il(boolean z) {
        h.aMk().putBoolean(enr, z);
    }
}
