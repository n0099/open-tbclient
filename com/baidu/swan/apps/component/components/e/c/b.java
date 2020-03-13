package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int biJ;
    public String biK;

    public b() {
        super("coverView", "viewId");
        this.biK = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.biJ = jSONObject.optInt("scrollTop");
            if (this.bhV != null) {
                this.biK = this.bhV.optString("overflowY");
            }
            if (this.bir != null && this.bhV != null) {
                this.bir.dd(this.bhV.optBoolean("fixed", false));
            }
        }
    }
}
