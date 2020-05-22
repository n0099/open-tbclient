package com.baidu.swan.apps.o;

import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.tbadk.TbConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private String bAT;
    private boolean ceG;
    private boolean ceH;
    private JSONObject ceI;

    public String getImageUrl() {
        return this.bAT;
    }

    public b adX() {
        this.ceG = false;
        this.ceH = false;
        this.bAT = null;
        this.ceI = aea();
        if (this.ceI != null) {
            this.ceG = adZ();
            if (!this.ceG) {
                this.ceH = adY();
            }
        }
        return this;
    }

    private boolean adY() {
        if (com.baidu.swan.apps.runtime.d.aoB().Qz() == 0) {
            return s(this.ceI, "bbasp_guide_");
        }
        if (com.baidu.swan.apps.runtime.d.aoB().Qz() == 1) {
            return s(this.ceI, "bbaspg_guide_");
        }
        return false;
    }

    private boolean adZ() {
        JSONArray optJSONArray = this.ceI.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.aoH() == null || TextUtils.equals(e.aoH(), optString)) {
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
        b.a QJ;
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
            if (e.aoF() != null && (QJ = e.aoF().QJ()) != null) {
                String agK = QJ.agK();
                if (!TextUtils.isEmpty(agK) && !agK.startsWith("120")) {
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
                            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.o.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.arO().putString("swan_guide_toast", b.this.ceI.toString());
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
        this.bAT = optJSONArray.optString(i);
        return i;
    }

    private JSONObject aea() {
        String string = h.arO().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.ceH || this.ceG;
    }

    public String aeb() {
        if (this.ceG) {
            return "special";
        }
        if (this.ceH) {
            return "normal";
        }
        return null;
    }
}
