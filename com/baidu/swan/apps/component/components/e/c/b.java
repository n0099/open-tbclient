package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cCw;
    public String cCx;

    public b() {
        super("coverView", "viewId");
        this.cCx = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cCw = jSONObject.optInt("scrollTop");
            if (this.cBL != null) {
                this.cCx = this.cBL.optString("overflowY");
            }
            if (this.cCe != null && this.cBL != null) {
                this.cCe.fP(this.cBL.optBoolean("fixed", false));
            }
        }
    }
}
