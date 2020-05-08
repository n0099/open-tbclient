package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int bHj;
    public String bHk;

    public b() {
        super("coverView", "viewId");
        this.bHk = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bHj = jSONObject.optInt("scrollTop");
            if (this.bGy != null) {
                this.bHk = this.bGy.optString("overflowY");
            }
            if (this.bGR != null && this.bGy != null) {
                this.bGR.ea(this.bGy.optBoolean("fixed", false));
            }
        }
    }
}
