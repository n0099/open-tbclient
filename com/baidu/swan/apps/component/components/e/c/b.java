package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int bVH;
    public String bVI;

    public b() {
        super("coverView", "viewId");
        this.bVI = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bVH = jSONObject.optInt("scrollTop");
            if (this.bUW != null) {
                this.bVI = this.bUW.optString("overflowY");
            }
            if (this.bVp != null && this.bUW != null) {
                this.bVp.eE(this.bUW.optBoolean("fixed", false));
            }
        }
    }
}
