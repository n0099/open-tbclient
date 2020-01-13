package com.baidu.swan.bdprivate.invoice.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements c {
    public long mId;

    public b() {
    }

    public b(long j) {
        this.mId = j;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.mId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optLong("id");
        }
    }
}
