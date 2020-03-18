package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean biV;

    public c() {
        super("coverImage", "viewId");
        this.biV = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.biV = jSONObject.optBoolean("loadState", false);
            if (this.biE != null && this.bik != null) {
                this.biE.de(this.bik.optBoolean("fixed", false));
            }
        }
    }
}
