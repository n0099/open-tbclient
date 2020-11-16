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
/* loaded from: classes7.dex */
public class b {
    private boolean cTD;
    private boolean cTE;
    private JSONObject cTF;
    private String cgQ;

    public String getImageUrl() {
        return this.cgQ;
    }

    public b auF() {
        this.cTD = false;
        this.cTE = false;
        this.cgQ = null;
        this.cTF = auI();
        if (this.cTF != null) {
            this.cTD = auH();
            if (!this.cTD) {
                this.cTE = auG();
            }
        }
        return this;
    }

    private boolean auG() {
        if (d.aGI().aeW() == 0) {
            return p(this.cTF, "bbasp_guide_");
        }
        if (d.aGI().aeW() == 1) {
            return p(this.cTF, "bbaspg_guide_");
        }
        return false;
    }

    private boolean auH() {
        JSONArray optJSONArray = this.cTF.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.aGO() == null || TextUtils.equals(e.aGO(), optString)) {
                return p(optJSONObject, "");
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean p(JSONObject jSONObject, String str) {
        boolean z;
        b.a afg;
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
            if (e.aGM() != null && (afg = e.aGM().afg()) != null) {
                String axV = afg.axV();
                if (!TextUtils.isEmpty(axV) && !axV.startsWith("120")) {
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
                                    h.aKk().putString("swan_guide_toast", b.this.cTF.toString());
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
        this.cgQ = optJSONArray.optString(i);
        return i;
    }

    private JSONObject auI() {
        String string = h.aKk().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.cTE || this.cTD;
    }

    public String auJ() {
        if (this.cTD) {
            return "special";
        }
        if (this.cTE) {
            return "normal";
        }
        return null;
    }
}
