package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cyn;
    public String cyo;

    public b() {
        super("coverView", "viewId");
        this.cyo = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cyn = jSONObject.optInt("scrollTop");
            if (this.cxC != null) {
                this.cyo = this.cxC.optString("overflowY");
            }
            if (this.cxV != null && this.cxC != null) {
                this.cxV.fD(this.cxC.optBoolean("fixed", false));
            }
        }
    }
}
