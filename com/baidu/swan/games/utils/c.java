package com.baidu.swan.games.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c {
    private static c efj = new c();
    private static String efk = "banner_ad_close_btn_show_key";
    private static String efl = "banner_ad_close_duration_key";
    private static String efo = "gdt_banner_ad_app_id_key";
    private static String efp = "gdt_video_ad_app_id_key";
    private static String efq = "gdt_banner_ad_id_key";
    private static String efr = "gdt_video_ad_id_key";
    private static String efs = "gdt_video_ad_config_time";
    private static String eft = "video_interaction_optimization";
    private static String efu = "video_request_optimization";
    private static String efv = "first_request_optimization";
    private long efm;
    private long efn;

    private c() {
    }

    public static c aZR() {
        return efj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn(String str) {
        h.aNr().putBoolean(efk, "1".equals(str));
    }

    public boolean aZS() {
        return h.aNr().getBoolean(efk, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(String str) {
        h.aNr().putString(efl, str);
    }

    private long aZT() {
        String string = h.aNr().getString(efl, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void ds(String str, String str2) {
        h.aNr().putString(str, str2);
    }

    private long yp(String str) {
        String string = h.aNr().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void df(long j) {
        h.aNr().putLong("banner_ad_start_show_key", j);
    }

    public long aZU() {
        return h.aNr().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(long j) {
        h.aNr().putLong("banner_ad_repeat_show_key", j);
    }

    public long aZV() {
        return h.aNr().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(long j) {
        h.aNr().putLong("banner_ad_close_key", j);
    }

    public long aZW() {
        return h.aNr().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aZX() {
        this.efm = System.currentTimeMillis();
    }

    public void aZY() {
        this.efn = System.currentTimeMillis();
    }

    public boolean yq(String str) {
        return System.currentTimeMillis() - yp(str) <= aZT();
    }

    public boolean aZZ() {
        return this.efm != 0 && System.currentTimeMillis() - this.efm <= aZU();
    }

    public boolean baa() {
        return this.efn != 0 && System.currentTimeMillis() - this.efn <= aZV();
    }

    public void bab() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null && com.baidu.swan.apps.t.a.azm() != null && com.baidu.swan.apps.t.a.azz() != null) {
            aJU.aKj().getRequest().cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).url(com.baidu.swan.apps.t.a.azm().ajT()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.ab(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.yn(optJSONObject.optString("show", "1"));
                            c.this.yo(optJSONObject.optString("duration", "1"));
                            c.this.df(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.dg(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.dh(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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

    public void bac() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null && com.baidu.swan.apps.t.a.azm() != null && com.baidu.swan.apps.t.a.azz() != null) {
            aJU.aKj().getRequest().cookieManager(com.baidu.swan.apps.t.a.azz().akJ()).url(com.baidu.swan.apps.t.a.azm().ajZ()).addUrlParam("app_key", aJU.getAppKey()).addUrlParam("host", aJU.getPackageName()).addUrlParam("os", "android").build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.2
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
                                        c.this.yr("");
                                        c.this.ys("");
                                        c.this.yt("");
                                        c.this.yu("");
                                        c.this.di(0L);
                                        c.this.hT(false);
                                        c.this.hU(false);
                                        c.this.hV(false);
                                    } else {
                                        c.this.yr(optJSONObject.optString("banner"));
                                        c.this.ys(optJSONObject.optString("video"));
                                        c.this.yt(optJSONObject.optString("banner_app_id"));
                                        c.this.yu(optJSONObject.optString("video_app_id"));
                                        c.this.di(System.currentTimeMillis());
                                        c.this.hT(optJSONObject.optBoolean("video_ui_opt"));
                                        c.this.hU(optJSONObject.optBoolean("video_request_opt"));
                                        c.this.hV(optJSONObject.optBoolean("first_request_opt"));
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
    public void yr(String str) {
        h.aNr().putString(efq, str);
    }

    public String bad() {
        return h.aNr().getString(efq, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys(String str) {
        h.aNr().putString(efr, str);
    }

    public String bae() {
        return h.aNr().getString(efr, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(String str) {
        h.aNr().putString(efo, str);
    }

    public String aTE() {
        return h.aNr().getString(efo, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu(String str) {
        h.aNr().putString(efp, str);
    }

    public String aTG() {
        return h.aNr().getString(efp, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(long j) {
        h.aNr().putLong(efs, j);
    }

    public Long baf() {
        return Long.valueOf(h.aNr().getLong(efs, 0L));
    }

    public boolean bag() {
        return h.aNr().getBoolean(eft, false);
    }

    public void hT(boolean z) {
        h.aNr().putBoolean(eft, z);
    }

    public boolean bah() {
        return h.aNr().getBoolean(efu, false);
    }

    public void hU(boolean z) {
        h.aNr().putBoolean(efu, z);
    }

    public boolean bai() {
        return h.aNr().getBoolean(efv, false);
    }

    public void hV(boolean z) {
        h.aNr().putBoolean(efv, z);
    }
}
