package com.baidu.swan.bdprivate.invoice.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements c {
    public List<InvoiceInfo> cCU;

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void br(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("list")) != null) {
            this.cCU = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                InvoiceInfo invoiceInfo = new InvoiceInfo();
                invoiceInfo.br(optJSONObject);
                this.cCU.add(invoiceInfo);
            }
        }
    }
}
