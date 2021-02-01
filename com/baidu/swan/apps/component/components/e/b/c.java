package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cLN;

    public c() {
        super("coverImage", "viewId");
        this.cLN = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cLN = jSONObject.optBoolean("loadState", false);
            if (this.cLu != null && this.cLb != null) {
                this.cLu.gl(this.cLb.optBoolean("fixed", false));
            }
        }
    }
}
