package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int bHe;
    public String bHf;

    public b() {
        super("coverView", "viewId");
        this.bHf = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bHe = jSONObject.optInt("scrollTop");
            if (this.bGt != null) {
                this.bHf = this.bGt.optString("overflowY");
            }
            if (this.bGM != null && this.bGt != null) {
                this.bGM.ea(this.bGt.optBoolean("fixed", false));
            }
        }
    }
}
