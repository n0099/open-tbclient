package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cbo;

    public c() {
        super("coverImage", "viewId");
        this.cbo = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cbo = jSONObject.optBoolean("loadState", false);
            if (this.caX != null && this.caE != null) {
                this.caX.eV(this.caE.optBoolean("fixed", false));
            }
        }
    }
}
