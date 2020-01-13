package com.baidu.swan.bdprivate.invoice.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements c {
    public List<InvoiceInfo> bZD;

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("list")) != null) {
            this.bZD = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                InvoiceInfo invoiceInfo = new InvoiceInfo();
                invoiceInfo.bg(optJSONObject);
                this.bZD.add(invoiceInfo);
            }
        }
    }
}
