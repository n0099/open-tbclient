package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    private int asT;
    private String atd;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.atd = jSONObject.optString("bgurl");
            this.asT = jSONObject.optInt("effect");
        }
    }

    public String getName() {
        return this.mName;
    }

    public String uX() {
        return this.mFile;
    }

    public String uY() {
        return this.atd;
    }

    public int uZ() {
        return this.asT;
    }
}
