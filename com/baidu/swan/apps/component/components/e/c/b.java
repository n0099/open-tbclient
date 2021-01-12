package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cJA;
    public String cJB;

    public b() {
        super("coverView", "viewId");
        this.cJB = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cJA = jSONObject.optInt("scrollTop");
            if (this.cIN != null) {
                this.cJB = this.cIN.optString("overflowY");
            }
            if (this.cJg != null && this.cIN != null) {
                this.cJg.gj(this.cIN.optBoolean("fixed", false));
            }
        }
    }
}
