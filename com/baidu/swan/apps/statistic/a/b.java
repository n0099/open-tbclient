package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends e {
    public String bQY = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e Mk;
        if (this.bRf == null) {
            this.bRf = new JSONObject();
        }
        if (TextUtils.isEmpty(this.bQY) && (Mk = com.baidu.swan.apps.y.f.UC().Mk()) != null) {
            b.a En = Mk.En();
            this.bQY = En != null ? En.Tt() : "";
        }
        try {
            this.bRf.put("source", this.bQY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
