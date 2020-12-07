package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cJr;
    public String cJs;

    public b() {
        super("coverView", "viewId");
        this.cJs = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cJr = jSONObject.optInt("scrollTop");
            if (this.cIG != null) {
                this.cJs = this.cIG.optString("overflowY");
            }
            if (this.cIZ != null && this.cIG != null) {
                this.cIZ.ge(this.cIG.optBoolean("fixed", false));
            }
        }
    }
}
