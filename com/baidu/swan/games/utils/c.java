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
    private long ejA;
    private long ejz;
    private static c ejw = new c();
    private static String ejx = "banner_ad_close_btn_show_key";
    private static String ejy = "banner_ad_close_duration_key";
    private static String ejB = "gdt_banner_ad_app_id_key";
    private static String ejC = "gdt_video_ad_app_id_key";
    private static String ejD = "gdt_banner_ad_id_key";
    private static String ejE = "gdt_video_ad_id_key";
    private static String ejF = "gdt_video_ad_config_time";
    private static String ejG = "video_interaction_optimization";
    private static String ejH = "video_request_optimization";
    private static String ejI = "first_request_optimization";

    private c() {
    }

    public static c aYs() {
        return ejw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xb(String str) {
        h.aLO().putBoolean(ejx, "1".equals(str));
    }

    public boolean aYt() {
        return h.aLO().getBoolean(ejx, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(String str) {
        h.aLO().putString(ejy, str);
    }

    private long aYu() {
        String string = h.aLO().getString(ejy, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void dq(String str, String str2) {
        h.aLO().putString(str, str2);
    }

    private long xd(String str) {
        String string = h.aLO().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(long j) {
        h.aLO().putLong("banner_ad_start_show_key", j);
    }

    public long aYv() {
        return h.aLO().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(long j) {
        h.aLO().putLong("banner_ad_repeat_show_key", j);
    }

    public long aYw() {
        return h.aLO().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(long j) {
        h.aLO().putLong("banner_ad_close_key", j);
    }

    public long aYx() {
        return h.aLO().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aYy() {
        this.ejz = System.currentTimeMillis();
    }

    public void aYz() {
        this.ejA = System.currentTimeMillis();
    }

    public boolean xe(String str) {
        return System.currentTimeMillis() - xd(str) <= aYu();
    }

    public boolean aYA() {
        return this.ejz != 0 && System.currentTimeMillis() - this.ejz <= aYv();
    }

    public boolean aYB() {
        return this.ejA != 0 && System.currentTimeMillis() - this.ejA <= aYw();
    }

    public void aYC() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null && com.baidu.swan.apps.t.a.awK() != null && com.baidu.swan.apps.t.a.awX() != null) {
            aIr.aIG().getRequest().cookieManager(com.baidu.swan.apps.t.a.awX().aia()).url(com.baidu.swan.apps.t.a.awK().ahi()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: S */
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.ad(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.xb(optJSONObject.optString("show", "1"));
                            c.this.xc(optJSONObject.optString("duration", "1"));
                            c.this.dg(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.dh(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.di(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void aYD() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null && com.baidu.swan.apps.t.a.awK() != null && com.baidu.swan.apps.t.a.awX() != null) {
            aIr.aIG().getRequest().cookieManager(com.baidu.swan.apps.t.a.awX().aia()).url(com.baidu.swan.apps.t.a.awK().aho()).addUrlParam("app_key", aIr.getAppKey()).addUrlParam("host", aIr.getPackageName()).addUrlParam("os", HttpConstants.OS_TYPE_VALUE).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: S */
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    if (200 == i) {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.optInt(BaseJsonData.TAG_ERRNO) == 0) {
                                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                                    if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("ads_config")) == null) {
                                        c.this.xf("");
                                        c.this.xg("");
                                        c.this.xh("");
                                        c.this.xi("");
                                        c.this.dj(0L);
                                        c.this.ih(false);
                                        c.this.ii(false);
                                        c.this.ij(false);
                                    } else {
                                        c.this.xf(optJSONObject.optString("banner"));
                                        c.this.xg(optJSONObject.optString("video"));
                                        c.this.xh(optJSONObject.optString("banner_app_id"));
                                        c.this.xi(optJSONObject.optString("video_app_id"));
                                        c.this.dj(System.currentTimeMillis());
                                        c.this.ih(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.ii(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.ij(optJSONObject.optBoolean("first_request_opt"));
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
    public void xf(String str) {
        h.aLO().putString(ejD, str);
    }

    public String aYE() {
        return h.aLO().getString(ejD, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg(String str) {
        h.aLO().putString(ejE, str);
    }

    public String aYF() {
        return h.aLO().getString(ejE, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(String str) {
        h.aLO().putString(ejB, str);
    }

    public String aSf() {
        return h.aLO().getString(ejB, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi(String str) {
        h.aLO().putString(ejC, str);
    }

    public String aSh() {
        return h.aLO().getString(ejC, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(long j) {
        h.aLO().putLong(ejF, j);
    }

    public Long aYG() {
        return Long.valueOf(h.aLO().getLong(ejF, 0L));
    }

    public boolean aYH() {
        return h.aLO().getBoolean(ejG, false);
    }

    public void ih(boolean z) {
        h.aLO().putBoolean(ejG, z);
    }

    public boolean aYI() {
        return h.aLO().getBoolean(ejH, false);
    }

    public void ii(boolean z) {
        h.aLO().putBoolean(ejH, z);
    }

    public boolean aYJ() {
        return h.aLO().getBoolean(ejI, false);
    }

    public void ij(boolean z) {
        h.aLO().putBoolean(ejI, z);
    }
}
