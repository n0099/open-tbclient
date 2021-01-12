package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends e {
    public String dJk = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e anU;
        if (this.dJr == null) {
            this.dJr = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dJk) && (anU = com.baidu.swan.apps.v.f.azN().anU()) != null) {
            b.a afB = anU.afB();
            this.dJk = afB != null ? afB.ayC() : "";
        }
        try {
            this.dJr.put("source", this.dJk);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
