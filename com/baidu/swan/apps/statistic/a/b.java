package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends e {
    public String bQo = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e LO;
        if (this.bQv == null) {
            this.bQv = new JSONObject();
        }
        if (TextUtils.isEmpty(this.bQo) && (LO = com.baidu.swan.apps.y.f.Uf().LO()) != null) {
            b.a DR = LO.DR();
            this.bQo = DR != null ? DR.SW() : "";
        }
        try {
            this.bQv.put("source", this.bQo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
