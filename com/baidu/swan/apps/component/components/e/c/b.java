package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int cdw;
    public String cdx;

    public b() {
        super("coverView", "viewId");
        this.cdx = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.cdw = jSONObject.optInt("scrollTop");
            if (this.ccK != null) {
                this.cdx = this.ccK.optString("overflowY");
            }
            if (this.cdd != null && this.ccK != null) {
                this.cdd.eU(this.ccK.optBoolean("fixed", false));
            }
        }
    }
}
