package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int bQb;
    public String bQc;

    public b() {
        super("coverView", "viewId");
        this.bQc = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bQb = jSONObject.optInt("scrollTop");
            if (this.bPq != null) {
                this.bQc = this.bPq.optString("overflowY");
            }
            if (this.bPJ != null && this.bPq != null) {
                this.bPJ.er(this.bPq.optBoolean("fixed", false));
            }
        }
    }
}
