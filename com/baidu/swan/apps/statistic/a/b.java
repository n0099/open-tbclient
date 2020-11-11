package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends e {
    public String dAa = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e aoc;
        if (this.dAh == null) {
            this.dAh = new JSONObject();
        }
        if (TextUtils.isEmpty(this.dAa) && (aoc = com.baidu.swan.apps.v.f.azO().aoc()) != null) {
            b.a afO = aoc.afO();
            this.dAa = afO != null ? afO.ayD() : "";
        }
        try {
            this.dAh.put("source", this.dAa);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
