package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cpL;

    public c() {
        super("coverImage", "viewId");
        this.cpL = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cpL = jSONObject.optBoolean("loadState", false);
            if (this.cpt != null && this.cpa != null) {
                this.cpt.fq(this.cpa.optBoolean("fixed", false));
            }
        }
    }
}
