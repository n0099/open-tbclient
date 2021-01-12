package com.baidu.swan.apps.component.components.b;

import com.baidu.swan.apps.ao.ah;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c extends com.baidu.swan.apps.component.a.c.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        super("button", "buttonId");
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (this.cIN != null) {
                this.cIG = ah.O((float) this.cIN.optDouble("lineHeight", 0.0d));
            }
        }
    }
}
