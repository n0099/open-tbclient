package com.baidu.swan.apps.component.components.e.c;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.c.b {
    public int biI;
    public String biJ;

    public b() {
        super("coverView", "viewId");
        this.biJ = "";
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.biI = jSONObject.optInt("scrollTop");
            if (this.bhU != null) {
                this.biJ = this.bhU.optString("overflowY");
            }
            if (this.biq != null && this.bhU != null) {
                this.biq.dd(this.bhU.optBoolean("fixed", false));
            }
        }
    }
}
