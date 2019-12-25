package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int bdD;
    public String bdE;

    public b() {
        super("coverView", "viewId");
        this.bdE = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bdD = jSONObject.optInt("scrollTop");
            if (this.bcR != null) {
                this.bdE = this.bcR.optString("overflowY");
            }
            if (this.bdl != null && this.bcR != null) {
                this.bdl.cR(this.bcR.optBoolean("fixed", false));
            }
        }
    }
}
