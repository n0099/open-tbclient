package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int id = 0;
    public String name;
    public int number;

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.number = jSONObject.optInt("num");
            this.name = jSONObject.optString("name");
        }
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }
}
