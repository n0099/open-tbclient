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
    private boolean bwe;
    private boolean bwf;
    private JSONObject bwg;
    private String mImageUrl;

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public b Ti() {
        this.bwe = false;
        this.bwf = false;
        this.mImageUrl = null;
        this.bwg = Tl();
        if (this.bwg != null) {
            this.bwe = Tk();
            if (!this.bwe) {
                this.bwf = Tj();
            }
        }
        return this;
    }

    private boolean Tj() {
        if (com.baidu.swan.apps.runtime.d.acF().Gz() == 0) {
            return k(this.bwg, "swan_guide_");
        }
        if (com.baidu.swan.apps.runtime.d.acF().Gz() == 1) {
            return k(this.bwg, "swangame_guide_");
        }
        return false;
    }

    private boolean Tk() {
        JSONArray optJSONArray = this.bwg.optJSONArray("custom_guide_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("appid", "");
            if (e.acK() == null || TextUtils.equals(e.acK(), optString)) {
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
        b.a GJ;
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
            if (e.acI() != null && (GJ = e.acI().GJ()) != null) {
                String VM = GJ.VM();
                if (!TextUtils.isEmpty(VM) && !VM.startsWith("120")) {
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
                                    h.afu().putString("swan_guide_toast", b.this.bwg.toString());
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

    private JSONObject Tl() {
        String string = h.afu().getString("swan_guide_toast", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public boolean isShow() {
        return this.bwf || this.bwe;
    }

    public String Tm() {
        if (this.bwe) {
            return "special";
        }
        if (this.bwf) {
            return "normal";
        }
        return null;
    }
}
