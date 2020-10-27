package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends e {
    public String dui = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e alC;
        if (this.dup == null) {
            this.dup = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dui) && (alC = com.baidu.swan.apps.v.f.axo().alC()) != null) {
            b.a ado = alC.ado();
            this.dui = ado != null ? ado.awd() : "";
        }
        try {
            this.dup.put("source", this.dui);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
