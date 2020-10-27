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
    private boolean cPu;
    private boolean cPv;
    private JSONObject cPw;
    private String ccQ;

    public String getImageUrl() {
        return this.ccQ;
    }

    public b asN() {
        this.cPu = false;
        this.cPv = false;
        this.ccQ = null;
        this.cPw = asQ();
        if (this.cPw != null) {
            this.cPu = asP();
            if (!this.cPu) {
                this.cPv = asO();
            }
        }
        return this;
    }

    private boolean asO() {
        if (d.aEQ().ade() == 0) {
            return s(this.cPw, "bbasp_guide_");
        }
        if (d.aEQ().ade() == 1) {
            return s(this.cPw, "bbaspg_guide_");
        }
        return false;
    }

    private boolean asP() {
        JSONArray optJSONArray = this.cPw.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.aEW() == null || TextUtils.equals(e.aEW(), optString)) {
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
        b.a ado;
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
            if (e.aEU() != null && (ado = e.aEU().ado()) != null) {
                String awd = ado.awd();
                if (!TextUtils.isEmpty(awd) && !awd.startsWith("120")) {
                    z = false;
                    if (optInt < intValue && z3 && !z) {
                        z2 = true;
                    }
                    if (z2) {
                        int a2 = a(jSONObject, optInt2, str + TbConfig.IMAGE_CACHE_DIR_NAME);
                        try {
                            jSONObject.put(str + "shown_count", optInt + 1);
                            jSONObject.put(str + "image_index", a2 + 1);
                            jSONObject.put(str + "last_time", System.currentTimeMillis());
                            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.p.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.aIs().putString("swan_guide_toast", b.this.cPw.toString());
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
        this.ccQ = optJSONArray.optString(i);
        return i;
    }

    private JSONObject asQ() {
        String string = h.aIs().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.cPv || this.cPu;
    }

    public String asR() {
        if (this.cPu) {
            return "special";
        }
        if (this.cPv) {
            return "normal";
        }
        return null;
    }
}
