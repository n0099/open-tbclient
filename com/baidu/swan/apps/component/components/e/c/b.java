package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int bes;
    public String beu;

    public b() {
        super("coverView", "viewId");
        this.beu = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.bes = jSONObject.optInt("scrollTop");
            if (this.bdG != null) {
                this.beu = this.bdG.optString("overflowY");
            }
            if (this.bdZ != null && this.bdG != null) {
                this.bdZ.cW(this.bdG.optBoolean("fixed", false));
            }
        }
    }
}
