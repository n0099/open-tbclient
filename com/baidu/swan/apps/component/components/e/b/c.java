package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cEf;

    public c() {
        super("coverImage", "viewId");
        this.cEf = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cEf = jSONObject.optBoolean("loadState", false);
            if (this.cDO != null && this.cDv != null) {
                this.cDO.fM(this.cDv.optBoolean("fixed", false));
            }
        }
    }
}
