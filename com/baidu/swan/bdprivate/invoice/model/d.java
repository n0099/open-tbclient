package com.baidu.swan.bdprivate.invoice.model;

import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d<DATA extends c> implements c {
    public String cdL;
    public String cdM;
    public DATA cdN;

    public d() {
    }

    public d(DATA data) {
        this.cdN = data;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cdL = jSONObject.optString("errno");
            this.cdM = jSONObject.optString("tipmsg");
            if (this.cdN != null) {
                this.cdN.bg(s.parseString(jSONObject.optString("data")));
            }
        }
    }
}
