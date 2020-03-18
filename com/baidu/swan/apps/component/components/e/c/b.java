package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int biW;
    public String biX;

    public b() {
        super("coverView", "viewId");
        this.biX = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.biW = jSONObject.optInt("scrollTop");
            if (this.bik != null) {
                this.biX = this.bik.optString("overflowY");
            }
            if (this.biE != null && this.bik != null) {
                this.biE.de(this.bik.optBoolean("fixed", false));
            }
        }
    }
}
