package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean bHi;

    public c() {
        super("coverImage", "viewId");
        this.bHi = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bHi = jSONObject.optBoolean("loadState", false);
            if (this.bGR != null && this.bGy != null) {
                this.bGR.ea(this.bGy.optBoolean("fixed", false));
            }
        }
    }
}
