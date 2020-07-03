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
    private String bFH;
    private boolean cju;
    private boolean cjv;
    private JSONObject cjw;

    public String getImageUrl() {
        return this.bFH;
    }

    public b afd() {
        this.cju = false;
        this.cjv = false;
        this.bFH = null;
        this.cjw = afg();
        if (this.cjw != null) {
            this.cju = aff();
            if (!this.cju) {
                this.cjv = afe();
            }
        }
        return this;
    }

    private boolean afe() {
        if (com.baidu.swan.apps.runtime.d.apI().RF() == 0) {
            return s(this.cjw, "bbasp_guide_");
        }
        if (com.baidu.swan.apps.runtime.d.apI().RF() == 1) {
            return s(this.cjw, "bbaspg_guide_");
        }
        return false;
    }

    private boolean aff() {
        JSONArray optJSONArray = this.cjw.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.apO() == null || TextUtils.equals(e.apO(), optString)) {
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
        b.a RP;
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
            if (e.apM() != null && (RP = e.apM().RP()) != null) {
                String ahQ = RP.ahQ();
                if (!TextUtils.isEmpty(ahQ) && !ahQ.startsWith("120")) {
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
                                    h.asV().putString("swan_guide_toast", b.this.cjw.toString());
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
        this.bFH = optJSONArray.optString(i);
        return i;
    }

    private JSONObject afg() {
        String string = h.asV().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.cjv || this.cju;
    }

    public String afh() {
        if (this.cju) {
            return "special";
        }
        if (this.cjv) {
            return "normal";
        }
        return null;
    }
}
