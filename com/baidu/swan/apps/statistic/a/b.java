package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.u.c.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e {
    public String cZw = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e agX;
        if (this.cZD == null) {
            this.cZD = new JSONObject();
        }
        if (TextUtils.isEmpty(this.cZw) && (agX = com.baidu.swan.apps.v.f.asJ().agX()) != null) {
            b.a YI = agX.YI();
            this.cZw = YI != null ? YI.arx() : "";
        }
        try {
            this.cZD.put("source", this.cZw);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
