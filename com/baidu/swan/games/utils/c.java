package com.baidu.swan.games.utils;

import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static c dhJ = new c();
    private static String dhK = "banner_ad_close_btn_show_key";
    private static String dhL = "banner_ad_close_duration_key";
    private long dhM;
    private long dhN;

    private c() {
    }

    public static c aDi() {
        return dhJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sK(String str) {
        h.asV().putBoolean(dhK, "1".equals(str));
    }

    public boolean aDj() {
        return h.asV().getBoolean(dhK, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL(String str) {
        h.asV().putString(dhL, str);
    }

    private long aDk() {
        String string = h.asV().getString(dhL, "1");
        return string != null ? Long.valueOf(string).longValue() * 60 * 60 * 1000 : BdKVCache.MILLS_1Hour;
    }

    public void cD(String str, String str2) {
        h.asV().putString(str, str2);
    }

    private long sM(String str) {
        String string = h.asV().getString(str, "0");
        if (string != null) {
            return Long.valueOf(string).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(long j) {
        h.asV().putLong("banner_ad_start_show_key", j);
    }

    public long aDl() {
        return h.asV().getLong("banner_ad_start_show_key", 5L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(long j) {
        h.asV().putLong("banner_ad_repeat_show_key", j);
    }

    public long aDm() {
        return h.asV().getLong("banner_ad_repeat_show_key", 120L) * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(long j) {
        h.asV().putLong("banner_ad_close_key", j);
    }

    public long aDn() {
        return h.asV().getLong("banner_ad_close_key", 60L) * 1000;
    }

    public void aDo() {
        this.dhM = System.currentTimeMillis();
    }

    public void aDp() {
        this.dhN = System.currentTimeMillis();
    }

    public boolean sN(String str) {
        return System.currentTimeMillis() - sM(str) <= aDk();
    }

    public boolean aDq() {
        return this.dhM != 0 && System.currentTimeMillis() - this.dhM <= aDl();
    }

    public boolean aDr() {
        return this.dhN != 0 && System.currentTimeMillis() - this.dhN <= aDm();
    }

    public void aDs() {
        e apM = e.apM();
        if (apM != null && com.baidu.swan.apps.u.a.agj() != null && com.baidu.swan.apps.u.a.agu() != null) {
            apM.aqb().getRequest().cookieManager(com.baidu.swan.apps.u.a.agu().TS()).url(com.baidu.swan.apps.u.a.agj().Tj()).build().executeAsync(new StringResponseCallback() { // from class: com.baidu.swan.games.utils.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(String str, int i) {
                    JSONObject optJSONObject;
                    try {
                        if (com.baidu.swan.games.network.c.V(str, i) && (optJSONObject = new JSONObject(str).optJSONObject("data")) != null) {
                            c.this.sK(optJSONObject.optString("show", "1"));
                            c.this.sL(optJSONObject.optString("duration", "1"));
                            c.this.bF(optJSONObject.optLong("startNoBannerADGap", 5L));
                            c.this.bG(optJSONObject.optLong("bannerShowSuccGap", 120L));
                            c.this.bH(optJSONObject.optLong("preventBannerADShowingGap", 60L));
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
}
