package com.baidu.swan.apps.o;

import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.tbadk.TbConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private String bGf;
    private boolean clu;
    private boolean clv;
    private JSONObject clw;

    public String getImageUrl() {
        return this.bGf;
    }

    public b ago() {
        this.clu = false;
        this.clv = false;
        this.bGf = null;
        this.clw = agr();
        if (this.clw != null) {
            this.clu = agq();
            if (!this.clu) {
                this.clv = agp();
            }
        }
        return this;
    }

    private boolean agp() {
        if (com.baidu.swan.apps.runtime.d.arr().RU() == 0) {
            return s(this.clw, "bbasp_guide_");
        }
        if (com.baidu.swan.apps.runtime.d.arr().RU() == 1) {
            return s(this.clw, "bbaspg_guide_");
        }
        return false;
    }

    private boolean agq() {
        JSONArray optJSONArray = this.clw.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.arx() == null || TextUtils.equals(e.arx(), optString)) {
                return s(optJSONObject, "");
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean s(JSONObject jSONObject, String str) {
        boolean z;
        b.a Se;
        boolean z2 = false;
        if (jSONObject != null) {
            String optString = jSONObject.optString(str + "count", "3");
            int intValue = !TextUtils.isEmpty(optString) ? Integer.valueOf(optString).intValue() : 0;
            String optString2 = jSONObject.optString(str + "interval", "72");
            long longValue = !TextUtils.isEmpty(optString2) ? Long.valueOf(optString2).longValue() : 0L;
            long optLong = jSONObject.optLong(str + "last_time", 0L);
            int optInt = jSONObject.optInt(str + "shown_count", 0);
            int optInt2 = jSONObject.optInt(str + "image_index", 0);
            boolean z3 = System.currentTimeMillis() - optLong > longValue * BdKVCache.MILLS_1Hour;
            if (e.arv() != null && (Se = e.arv().Se()) != null) {
                String ajg = Se.ajg();
                if (!TextUtils.isEmpty(ajg) && !ajg.startsWith("120")) {
                    z = false;
                    if (optInt < intValue && z3 && !z) {
                        z2 = true;
                    }
                    if (z2) {
                        int a = a(jSONObject, optInt2, str + TbConfig.IMAGE_CACHE_DIR_NAME);
                        try {
                            jSONObject.put(str + "shown_count", optInt + 1);
                            jSONObject.put(str + "image_index", a + 1);
                            jSONObject.put(str + "last_time", System.currentTimeMillis());
                            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.o.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.auW().putString("swan_guide_toast", b.this.clw.toString());
                                }
                            }, "swanCloseGuideRunnable");
                        } catch (JSONException e) {
                        }
                    }
                }
            }
            z = true;
            if (optInt < intValue) {
                z2 = true;
            }
            if (z2) {
            }
        }
        return z2;
    }

    private int a(JSONObject jSONObject, int i, String str) {
        JSONArray optJSONArray;
        if (jSONObject == null || i < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
            return 0;
        }
        if (i >= optJSONArray.length()) {
            i = 0;
        }
        this.bGf = optJSONArray.optString(i);
        return i;
    }

    private JSONObject agr() {
        String string = h.auW().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.clv || this.clu;
    }

    public String ags() {
        if (this.clu) {
            return "special";
        }
        if (this.clv) {
            return "normal";
        }
        return null;
    }
}
