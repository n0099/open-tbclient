package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends e {
    public String dlG = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e ajI;
        if (this.dlN == null) {
            this.dlN = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dlG) && (ajI = com.baidu.swan.apps.v.f.avu().ajI()) != null) {
            b.a abu = ajI.abu();
            this.dlG = abu != null ? abu.auj() : "";
        }
        try {
            this.dlN.put("source", this.dlG);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
