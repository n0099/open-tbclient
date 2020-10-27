package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    private int aDE;
    private String aDV;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aDV = jSONObject.optString("bgurl");
            this.aDE = jSONObject.optInt("effect");
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String Cc() {
        return this.mFile;
    }

    public String Cb() {
        return this.aDV;
    }

    public int Cf() {
        return this.aDE;
    }
}
