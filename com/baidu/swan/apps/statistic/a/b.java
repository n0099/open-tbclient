package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends e {
    public String bVe = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e OA;
        if (this.bVl == null) {
            this.bVl = new JSONObject();
        }
        if (TextUtils.isEmpty(this.bVe) && (OA = com.baidu.swan.apps.y.f.WS().OA()) != null) {
            b.a GE = OA.GE();
            this.bVe = GE != null ? GE.VJ() : "";
        }
        try {
            this.bVl.put("source", this.bVe);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
