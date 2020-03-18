package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends e {
    public String bVq = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e OD;
        if (this.bVx == null) {
            this.bVx = new JSONObject();
        }
        if (TextUtils.isEmpty(this.bVq) && (OD = com.baidu.swan.apps.y.f.WV().OD()) != null) {
            b.a GJ = OD.GJ();
            this.bVq = GJ != null ? GJ.VM() : "";
        }
        try {
            this.bVx.put("source", this.bVq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
