package com.baidu.swan.apps.p;

import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.tbadk.TbConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private boolean cVn;
    private boolean cVo;
    private JSONObject cVp;
    private String ciC;

    public String getImageUrl() {
        return this.ciC;
    }

    public b avn() {
        this.cVn = false;
        this.cVo = false;
        this.ciC = null;
        this.cVp = avq();
        if (this.cVp != null) {
            this.cVn = avp();
            if (!this.cVn) {
                this.cVo = avo();
            }
        }
        return this;
    }

    private boolean avo() {
        if (d.aHq().afE() == 0) {
            return s(this.cVp, "bbasp_guide_");
        }
        if (d.aHq().afE() == 1) {
            return s(this.cVp, "bbaspg_guide_");
        }
        return false;
    }

    private boolean avp() {
        JSONArray optJSONArray = this.cVp.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.aHw() == null || TextUtils.equals(e.aHw(), optString)) {
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
        b.a afO;
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
            if (e.aHu() != null && (afO = e.aHu().afO()) != null) {
                String ayD = afO.ayD();
                if (!TextUtils.isEmpty(ayD) && !ayD.startsWith("120")) {
                    z = false;
                    if (optInt < intValue && z3 && !z) {
                        z2 = true;
                    }
                    if (z2) {
                        int b = b(jSONObject, optInt2, str + TbConfig.IMAGE_CACHE_DIR_NAME);
                        try {
                            jSONObject.put(str + "shown_count", optInt + 1);
                            jSONObject.put(str + "image_index", b + 1);
                            jSONObject.put(str + "last_time", System.currentTimeMillis());
                            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.p.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.aKS().putString("swan_guide_toast", b.this.cVp.toString());
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

    private int b(JSONObject jSONObject, int i, String str) {
        JSONArray optJSONArray;
        if (jSONObject == null || i < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
            return 0;
        }
        if (i >= optJSONArray.length()) {
            i = 0;
        }
        this.ciC = optJSONArray.optString(i);
        return i;
    }

    private JSONObject avq() {
        String string = h.aKS().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.cVo || this.cVn;
    }

    public String avr() {
        if (this.cVn) {
            return "special";
        }
        if (this.cVo) {
            return "normal";
        }
        return null;
    }
}
