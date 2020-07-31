package com.baidu.swan.apps.component.components.b;

import com.baidu.swan.apps.aq.ai;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c extends com.baidu.swan.apps.component.a.c.b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        super("button", "buttonId");
    }

    @Override // com.baidu.swan.apps.component.a.c.b, com.baidu.swan.apps.component.a.d.b, com.baidu.swan.apps.component.b.b, com.baidu.swan.apps.model.a
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (this.bUW != null) {
                this.lineSpace = ai.D((float) this.bUW.optDouble("lineHeight", 0.0d));
            }
        }
    }
}
