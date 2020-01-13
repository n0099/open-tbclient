package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean ber;

    public c() {
        super("coverImage", "viewId");
        this.ber = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.ber = jSONObject.optBoolean("loadState", false);
            if (this.bdZ != null && this.bdG != null) {
                this.bdZ.cW(this.bdG.optBoolean("fixed", false));
            }
        }
    }
}
