package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.x.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends e {
    public String cug = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e Wr;
        if (this.cun == null) {
            this.cun = new JSONObject();
        }
        if (TextUtils.isEmpty(this.cug) && (Wr = com.baidu.swan.apps.y.f.aeK().Wr()) != null) {
            b.a Ow = Wr.Ow();
            this.cug = Ow != null ? Ow.adB() : "";
        }
        try {
            this.cun.put("source", this.cug);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
