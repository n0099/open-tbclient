package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cCv;

    public c() {
        super("coverImage", "viewId");
        this.cCv = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cCv = jSONObject.optBoolean("loadState", false);
            if (this.cCe != null && this.cBL != null) {
                this.cCe.fP(this.cBL.optBoolean("fixed", false));
            }
        }
    }
}
