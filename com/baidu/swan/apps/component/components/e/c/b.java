package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cNo;
    public String cNp;

    public b() {
        super("coverView", "viewId");
        this.cNp = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cNo = jSONObject.optInt("scrollTop");
            if (this.cMB != null) {
                this.cNp = this.cMB.optString("overflowY");
            }
            if (this.cMU != null && this.cMB != null) {
                this.cMU.gl(this.cMB.optBoolean("fixed", false));
            }
        }
    }
}
