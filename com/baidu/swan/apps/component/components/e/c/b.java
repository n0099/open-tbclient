package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cOm;
    public String cOn;

    public b() {
        super("coverView", "viewId");
        this.cOn = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cOm = jSONObject.optInt("scrollTop");
            if (this.cNz != null) {
                this.cOn = this.cNz.optString("overflowY");
            }
            if (this.cNS != null && this.cNz != null) {
                this.cNS.gn(this.cNz.optBoolean("fixed", false));
            }
        }
    }
}
