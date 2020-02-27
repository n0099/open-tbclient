package com.baidu.swan.bdprivate.invoice.model;

import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d<DATA extends c> implements c {
    public String cdK;
    public String cdL;
    public DATA cdM;

    public d() {
    }

    public d(DATA data) {
        this.cdM = data;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cdK = jSONObject.optString("errno");
            this.cdL = jSONObject.optString("tipmsg");
            if (this.cdM != null) {
                this.cdM.bg(s.parseString(jSONObject.optString("data")));
            }
        }
    }
}
