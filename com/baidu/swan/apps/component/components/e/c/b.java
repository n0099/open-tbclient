package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cpM;
    public String cpN;

    public b() {
        super("coverView", "viewId");
        this.cpN = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cpM = jSONObject.optInt("scrollTop");
            if (this.cpa != null) {
                this.cpN = this.cpa.optString("overflowY");
            }
            if (this.cpt != null && this.cpa != null) {
                this.cpt.fq(this.cpa.optBoolean("fixed", false));
            }
        }
    }
}
