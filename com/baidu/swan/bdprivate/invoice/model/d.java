package com.baidu.swan.bdprivate.invoice.model;

import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d<DATA extends c> implements c {
    public String cdM;
    public String cdN;
    public DATA cdO;

    public d() {
    }

    public d(DATA data) {
        this.cdO = data;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cdM = jSONObject.optString("errno");
            this.cdN = jSONObject.optString("tipmsg");
            if (this.cdO != null) {
                this.cdO.bg(s.parseString(jSONObject.optString("data")));
            }
        }
    }
}
