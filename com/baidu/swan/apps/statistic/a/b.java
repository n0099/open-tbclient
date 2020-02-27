package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends e {
    public String bVd = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e Oy;
        if (this.bVk == null) {
            this.bVk = new JSONObject();
        }
        if (TextUtils.isEmpty(this.bVd) && (Oy = com.baidu.swan.apps.y.f.WQ().Oy()) != null) {
            b.a GC = Oy.GC();
            this.bVd = GC != null ? GC.VH() : "";
        }
        try {
            this.bVk.put("source", this.bVd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
