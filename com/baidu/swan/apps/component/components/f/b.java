package com.baidu.swan.apps.component.components.f;

import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class b extends com.baidu.swan.apps.component.a.a.b {
    boolean biV;
    boolean biW;
    public String type;

    public b() {
        super(Config.INPUT_PART, "viewId");
    }

    @Override // com.baidu.swan.apps.component.a.a.b, com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (this.biq == null) {
                this.biq = new com.baidu.swan.apps.model.a.a.a();
            }
            this.text = jSONObject.optString("value");
            this.type = jSONObject.optString("type");
            this.biV = jSONObject.optInt("confirmHold") == 1;
            this.biW = jSONObject.optInt("adjustPosition", 1) == 1;
        }
    }
}
