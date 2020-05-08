package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends e {
    public String cum = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e Wq;
        if (this.cuv == null) {
            this.cuv = new JSONObject();
        }
        if (TextUtils.isEmpty(this.cum) && (Wq = com.baidu.swan.apps.y.f.aeJ().Wq()) != null) {
            b.a Ov = Wq.Ov();
            this.cum = Ov != null ? Ov.adA() : "";
        }
        try {
            this.cuv.put("source", this.cum);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
