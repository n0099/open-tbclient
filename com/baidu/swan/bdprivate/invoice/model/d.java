package com.baidu.swan.bdprivate.invoice.model;

import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d<DATA extends c> implements c {
    public String cdX;
    public String cdY;
    public DATA cdZ;

    public d() {
    }

    public d(DATA data) {
        this.cdZ = data;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cdX = jSONObject.optString("errno");
            this.cdY = jSONObject.optString("tipmsg");
            if (this.cdZ != null) {
                this.cdZ.bg(s.parseString(jSONObject.optString("data")));
            }
        }
    }
}
