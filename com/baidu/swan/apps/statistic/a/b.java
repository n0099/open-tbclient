package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b extends e {
    public String dLo = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e aos;
        if (this.dLv == null) {
            this.dLv = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dLo) && (aos = com.baidu.swan.apps.v.f.aAl().aos()) != null) {
            b.a afZ = aos.afZ();
            this.dLo = afZ != null ? afZ.aza() : "";
        }
        try {
            this.dLv.put("source", this.dLo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
