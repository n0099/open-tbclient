package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int bUP;
    public String bUQ;

    public b() {
        super("coverView", "viewId");
        this.bUQ = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bUP = jSONObject.optInt("scrollTop");
            if (this.bUe != null) {
                this.bUQ = this.bUe.optString("overflowY");
            }
            if (this.bUx != null && this.bUe != null) {
                this.bUx.ew(this.bUe.optBoolean("fixed", false));
            }
        }
    }
}
