package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private String name;
    private int number;

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
