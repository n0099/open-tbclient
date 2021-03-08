package com.baidu.swan.apps.p;

import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.tbadk.TbConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private boolean det;
    private boolean deu;
    private String dev;
    private JSONObject dew;

    public String getImageUrl() {
        return this.dev;
    }

    public b avM() {
        this.det = false;
        this.deu = false;
        this.dev = null;
        this.dew = avP();
        if (this.dew != null) {
            this.det = avO();
            if (!this.det) {
                this.deu = avN();
            }
        }
        return this;
    }

    private boolean avN() {
        if (d.aIJ().getFrameType() == 0) {
            return o(this.dew, "bbasp_guide_");
        }
        if (d.aIJ().getFrameType() == 1) {
            return o(this.dew, "bbaspg_guide_");
        }
        return false;
    }

    private boolean avO() {
        JSONArray optJSONArray = this.dew.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.aIP() == null || TextUtils.equals(e.aIP(), optString)) {
                return o(optJSONObject, "");
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean o(JSONObject jSONObject, String str) {
        boolean z;
        b.a agc;
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
            if (e.aIN() != null && (agc = e.aIN().agc()) != null) {
                String azd = agc.azd();
                if (!TextUtils.isEmpty(azd) && !azd.startsWith("120")) {
                    z = false;
                    if (optInt < intValue && z3 && !z) {
                        z2 = true;
                    }
                    if (z2) {
                        int c = c(jSONObject, optInt2, str + TbConfig.IMAGE_CACHE_DIR_NAME);
                        try {
                            jSONObject.put(str + "shown_count", optInt + 1);
                            jSONObject.put(str + "image_index", c + 1);
                            jSONObject.put(str + "last_time", System.currentTimeMillis());
                            p.a(new Runnable() { // from class: com.baidu.swan.apps.p.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.aMk().putString("swan_guide_toast", b.this.dew.toString());
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

    private int c(JSONObject jSONObject, int i, String str) {
        JSONArray optJSONArray;
        if (jSONObject == null || i < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
            return 0;
        }
        if (i >= optJSONArray.length()) {
            i = 0;
        }
        this.dev = optJSONArray.optString(i);
        return i;
    }

    private JSONObject avP() {
        String string = h.aMk().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.deu || this.det;
    }

    public String avQ() {
        if (this.det) {
            return "special";
        }
        if (this.deu) {
            return "normal";
        }
        return null;
    }
}
