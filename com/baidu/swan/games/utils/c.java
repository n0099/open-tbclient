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
    private static c eol = new c();
    private static String eom = "banner_ad_close_btn_show_key";
    private static String eon = "banner_ad_close_duration_key";
    private static String eoq = "gdt_banner_ad_app_id_key";
    private static String eor = "gdt_video_ad_app_id_key";
    private static String eos = "gdt_banner_ad_id_key";
    private static String eot = "gdt_video_ad_id_key";
    private static String eou = "gdt_video_ad_config_time";
    private static String eov = "video_interaction_optimization";
    private static String eow = "video_request_optimization";
    private static String eox = "first_request_optimization";
    private long eoo;
    private long eop;

    private c() {
    }

    public static c bcl() {
        return eol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym(String str) {
        h.aPH().putBoolean(eom, "1".equals(str));
    }

    public boolean bcm() {
        return h.aPH().getBoolean(eom, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn(String str) {
        h.aPH().putString(eon, str);
    }

    private long bcn() {
        String string = h.aPH().getString(eon, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void dr(String str, String str2) {
        h.aPH().putString(str, str2);
    }

    private long yo(String str) {
        String string = h.aPH().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(long j) {
        h.aPH().putLong("banner_ad_start_show_key", j);
    }

    public long bco() {
        return h.aPH().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(long j) {
        h.aPH().putLong("banner_ad_repeat_show_key", j);
    }

    public long bcp() {
        return h.aPH().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(long j) {
        h.aPH().putLong("banner_ad_close_key", j);
    }

    public long bcq() {
        return h.aPH().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void bcr() {
        this.eoo = System.currentTimeMillis();
    }

    public void bcs() {
        this.eop = System.currentTimeMillis();
    }

    public boolean yp(String str) {
        return System.currentTimeMillis() - yo(str) <= bcn();
    }

    public boolean bct() {
        return this.eoo != 0 && System.currentTimeMillis() - this.eoo <= bco();
    }

    public boolean bcu() {
        return this.eop != 0 && System.currentTimeMillis() - this.eop <= bcp();
    }

    public void bcv() {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk != null && com.baidu.swan.apps.t.a.aAD() != null && com.baidu.swan.apps.t.a.aAQ() != null) {
            aMk.aMz().getRequest().cookieManager(com.baidu.swan.apps.t.a.aAQ().alT()).url(com.baidu.swan.apps.t.a.aAD().alb()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                /* renamed from: S */
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.ad(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.ym(optJSONObject.optString("show", "1"));
                            c.this.yn(optJSONObject.optString("duration", "1"));
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

    public void bcw() {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk != null && com.baidu.swan.apps.t.a.aAD() != null && com.baidu.swan.apps.t.a.aAQ() != null) {
            aMk.aMz().getRequest().cookieManager(com.baidu.swan.apps.t.a.aAQ().alT()).url(com.baidu.swan.apps.t.a.aAD().alh()).addUrlParam("app_key", aMk.getAppKey()).addUrlParam("host", aMk.getPackageName()).addUrlParam("os", HttpConstants.OS_TYPE_VALUE).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
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
                                        c.this.yq("");
                                        c.this.yr("");
                                        c.this.ys("");
                                        c.this.yt("");
                                        c.this.dj(0L);
                                        c.this.il(false);
                                        c.this.im(false);
                                        c.this.in(false);
                                    } else {
                                        c.this.yq(optJSONObject.optString("banner"));
                                        c.this.yr(optJSONObject.optString("video"));
                                        c.this.ys(optJSONObject.optString("banner_app_id"));
                                        c.this.yt(optJSONObject.optString("video_app_id"));
                                        c.this.dj(System.currentTimeMillis());
                                        c.this.il(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.im(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.in(optJSONObject.optBoolean("first_request_opt"));
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
    public void yq(String str) {
        h.aPH().putString(eos, str);
    }

    public String bcx() {
        return h.aPH().getString(eos, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yr(String str) {
        h.aPH().putString(eot, str);
    }

    public String bcy() {
        return h.aPH().getString(eot, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys(String str) {
        h.aPH().putString(eoq, str);
    }

    public String aVY() {
        return h.aPH().getString(eoq, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(String str) {
        h.aPH().putString(eor, str);
    }

    public String aWa() {
        return h.aPH().getString(eor, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(long j) {
        h.aPH().putLong(eou, j);
    }

    public Long bcz() {
        return Long.valueOf(h.aPH().getLong(eou, 0L));
    }

    public boolean bcA() {
        return h.aPH().getBoolean(eov, false);
    }

    public void il(boolean z) {
        h.aPH().putBoolean(eov, z);
    }

    public boolean bcB() {
        return h.aPH().getBoolean(eow, false);
    }

    public void im(boolean z) {
        h.aPH().putBoolean(eow, z);
    }

    public boolean bcC() {
        return h.aPH().getBoolean(eox, false);
    }

    public void in(boolean z) {
        h.aPH().putBoolean(eox, z);
    }
}
