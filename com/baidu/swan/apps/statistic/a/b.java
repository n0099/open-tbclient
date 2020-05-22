package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import com.baidu.swan.apps.v.b.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends e {
    public String cGn = "";

    @Override // com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        com.baidu.swan.apps.runtime.e Zc;
        if (this.cGu == null) {
            this.cGu = new JSONObject();
        }
        if (TextUtils.isEmpty(this.cGn) && (Zc = com.baidu.swan.apps.w.f.ahV().Zc()) != null) {
            b.a QJ = Zc.QJ();
            this.cGn = QJ != null ? QJ.agK() : "";
        }
        try {
            this.cGu.put("source", this.cGn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return super.toJSONObject();
    }
}
