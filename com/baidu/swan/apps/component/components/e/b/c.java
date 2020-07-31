package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean bVG;

    public c() {
        super("coverImage", "viewId");
        this.bVG = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bVG = jSONObject.optBoolean("loadState", false);
            if (this.bVp != null && this.bUW != null) {
                this.bVp.eE(this.bUW.optBoolean("fixed", false));
            }
        }
    }
}
