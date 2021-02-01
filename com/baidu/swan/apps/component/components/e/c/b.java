package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cLO;
    public String cLP;

    public b() {
        super("coverView", "viewId");
        this.cLP = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cLO = jSONObject.optInt("scrollTop");
            if (this.cLb != null) {
                this.cLP = this.cLb.optString("overflowY");
            }
            if (this.cLu != null && this.cLb != null) {
                this.cLu.gl(this.cLb.optBoolean("fixed", false));
            }
        }
    }
}
