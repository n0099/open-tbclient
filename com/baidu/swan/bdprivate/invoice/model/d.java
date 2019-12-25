package com.baidu.swan.bdprivate.invoice.model;

import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d<DATA extends c> implements c {
    public String bZs;
    public String bZt;
    public DATA bZu;

    public d() {
    }

    public d(DATA data) {
        this.bZu = data;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bZs = jSONObject.optString("errno");
            this.bZt = jSONObject.optString("tipmsg");
            if (this.bZu != null) {
                this.bZu.bg(s.parseString(jSONObject.optString("data")));
            }
        }
    }
}
