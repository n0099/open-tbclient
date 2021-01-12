package com.baidu.live.tieba.yuyinala.c;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private String bJF;
    private int bJG = 1;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bJF = jSONObject.optString("content");
            this.bJG = jSONObject.optInt("type", 1);
        }
    }

    public String Tu() {
        return this.bJF;
    }

    public int Tv() {
        return this.bJG;
    }

    public void hA(String str) {
        this.bJF = str;
    }

    public void eU(int i) {
        this.bJG = i;
    }
}
