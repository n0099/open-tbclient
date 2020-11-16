package com.baidu.live.tieba.yuyinala.c;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private String bEv;
    private int bEw = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bEv = jSONObject.optString("content");
            this.bEw = jSONObject.optInt("type", 1);
        }
    }

    public String TK() {
        return this.bEv;
    }

    public int TL() {
        return this.bEw;
    }

    public void is(String str) {
        this.bEv = str;
    }

    public void gb(int i) {
        this.bEw = i;
    }
}
