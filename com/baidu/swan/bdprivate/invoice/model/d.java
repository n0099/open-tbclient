package com.baidu.swan.bdprivate.invoice.model;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.bdprivate.invoice.model.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d<DATA extends c> implements c {
    public String cDb;
    public String cDc;
    public DATA cDd;

    public d() {
    }

    public d(DATA data) {
        this.cDd = data;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void br(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cDb = jSONObject.optString(BaseJsonData.TAG_ERRNO);
            this.cDc = jSONObject.optString("tipmsg");
            if (this.cDd != null) {
                this.cDd.br(s.parseString(jSONObject.optString("data")));
            }
        }
    }
}
