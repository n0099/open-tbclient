package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean cdv;

    public c() {
        super("coverImage", "viewId");
        this.cdv = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cdv = jSONObject.optBoolean("loadState", false);
            if (this.cdd != null && this.ccK != null) {
                this.cdd.eU(this.ccK.optBoolean("fixed", false));
            }
        }
    }
}
