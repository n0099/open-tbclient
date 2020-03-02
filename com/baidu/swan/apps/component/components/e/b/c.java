package com.baidu.swan.apps.component.components.e.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c extends com.baidu.swan.apps.component.a.b.b {
    public boolean biH;

    public c() {
        super("coverImage", "viewId");
        this.biH = false;
    }

    @Override // com.baidu.swan.apps.component.a.b.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            this.biH = jSONObject.optBoolean("loadState", false);
            if (this.biq != null && this.bhU != null) {
                this.biq.dd(this.bhU.optBoolean("fixed", false));
            }
        }
    }
}
