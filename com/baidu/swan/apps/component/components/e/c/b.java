package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cbp;
    public String cbq;

    public b() {
        super("coverView", "viewId");
        this.cbq = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cbp = jSONObject.optInt("scrollTop");
            if (this.caE != null) {
                this.cbq = this.caE.optString("overflowY");
            }
            if (this.caX != null && this.caE != null) {
                this.caX.eV(this.caE.optBoolean("fixed", false));
            }
        }
    }
}
