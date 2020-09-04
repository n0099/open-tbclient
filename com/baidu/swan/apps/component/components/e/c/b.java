package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cbt;
    public String cbu;

    public b() {
        super("coverView", "viewId");
        this.cbu = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cbt = jSONObject.optInt("scrollTop");
            if (this.caI != null) {
                this.cbu = this.caI.optString("overflowY");
            }
            if (this.cbb != null && this.caI != null) {
                this.cbb.eW(this.caI.optBoolean("fixed", false));
            }
        }
    }
}
