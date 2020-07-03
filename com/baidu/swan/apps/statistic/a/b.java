package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.v.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends e {
    public String cKX = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e aai;
        if (this.cLe == null) {
            this.cLe = new JSONObject();
        }
        if (TextUtils.isEmpty(this.cKX) && (aai = com.baidu.swan.apps.w.f.ajb().aai()) != null) {
            b.a RP = aai.RP();
            this.cKX = RP != null ? RP.ahQ() : "";
        }
        try {
            this.cLe.put("source", this.cKX);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
