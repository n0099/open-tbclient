package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cym;

    public c() {
        super("coverImage", "viewId");
        this.cym = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cym = jSONObject.optBoolean("loadState", false);
            if (this.cxV != null && this.cxC != null) {
                this.cxV.fD(this.cxC.optBoolean("fixed", false));
            }
        }
    }
}
