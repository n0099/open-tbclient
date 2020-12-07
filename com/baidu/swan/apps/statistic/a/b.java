package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b extends e {
    public String dFs = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e aqC;
        if (this.dFz == null) {
            this.dFz = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dFs) && (aqC = com.baidu.swan.apps.v.f.aCp().aqC()) != null) {
            b.a aio = aqC.aio();
            this.dFs = aio != null ? aio.aBe() : "";
        }
        try {
            this.dFz.put("source", this.dFs);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
