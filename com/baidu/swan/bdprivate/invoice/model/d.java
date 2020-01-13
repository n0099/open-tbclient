package com.baidu.swan.bdprivate.invoice.model;

import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d<DATA extends c> implements c {
    public String bZE;
    public String bZF;
    public DATA bZG;

    public d() {
    }

    public d(DATA data) {
        this.bZG = data;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bZE = jSONObject.optString("errno");
            this.bZF = jSONObject.optString("tipmsg");
            if (this.bZG != null) {
                this.bZG.bg(s.parseString(jSONObject.optString("data")));
            }
        }
    }
}
