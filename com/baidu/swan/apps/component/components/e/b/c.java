package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cOl;

    public c() {
        super("coverImage", "viewId");
        this.cOl = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cOl = jSONObject.optBoolean("loadState", false);
            if (this.cNS != null && this.cNz != null) {
                this.cNS.gn(this.cNz.optBoolean("fixed", false));
            }
        }
    }
}
