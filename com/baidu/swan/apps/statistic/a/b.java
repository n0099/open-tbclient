package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends e {
    public String dyt = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e anu;
        if (this.dyA == null) {
            this.dyA = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dyt) && (anu = com.baidu.swan.apps.v.f.azg().anu()) != null) {
            b.a afg = anu.afg();
            this.dyt = afg != null ? afg.axV() : "";
        }
        try {
            this.dyA.put("source", this.dyt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
