package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cEg;
    public String cEh;

    public b() {
        super("coverView", "viewId");
        this.cEh = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cEg = jSONObject.optInt("scrollTop");
            if (this.cDv != null) {
                this.cEh = this.cDv.optString("overflowY");
            }
            if (this.cDO != null && this.cDv != null) {
                this.cDO.fM(this.cDv.optBoolean("fixed", false));
            }
        }
    }
}
