package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cJq;

    public c() {
        super("coverImage", "viewId");
        this.cJq = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cJq = jSONObject.optBoolean("loadState", false);
            if (this.cIZ != null && this.cIG != null) {
                this.cIZ.ge(this.cIG.optBoolean("fixed", false));
            }
        }
    }
}
