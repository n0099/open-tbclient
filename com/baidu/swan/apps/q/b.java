package com.baidu.swan.apps.q;

import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.x.b.b;
import com.baidu.tbadk.TbConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private boolean bvS;
    private boolean bvT;
    private JSONObject bvU;
    private String mImageUrl;

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public b Tf() {
        this.bvS = false;
        this.bvT = false;
        this.mImageUrl = null;
        this.bvU = Ti();
        if (this.bvU != null) {
            this.bvS = Th();
            if (!this.bvS) {
                this.bvT = Tg();
            }
        }
        return this;
    }

    private boolean Tg() {
        if (com.baidu.swan.apps.runtime.d.acC().Gu() == 0) {
            return k(this.bvU, "swan_guide_");
        }
        if (com.baidu.swan.apps.runtime.d.acC().Gu() == 1) {
            return k(this.bvU, "swangame_guide_");
        }
        return false;
    }

    private boolean Th() {
        JSONArray optJSONArray = this.bvU.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.acH() == null || TextUtils.equals(e.acH(), optString)) {
                return k(optJSONObject, "");
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean k(JSONObject jSONObject, String str) {
        boolean z;
        b.a GE;
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
            if (e.acF() != null && (GE = e.acF().GE()) != null) {
                String VJ = GE.VJ();
                if (!TextUtils.isEmpty(VJ) && !VJ.startsWith("120")) {
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
                            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.q.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.afr().putString("swan_guide_toast", b.this.bvU.toString());
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
        this.mImageUrl = optJSONArray.optString(i);
        return i;
    }

    private JSONObject Ti() {
        String string = h.afr().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.bvT || this.bvS;
    }

    public String Tj() {
        if (this.bvS) {
            return "special";
        }
        if (this.bvT) {
            return "normal";
        }
        return null;
    }
}
