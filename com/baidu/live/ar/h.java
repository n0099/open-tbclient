package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private String aEL;
    private int aEl;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aEL = jSONObject.optString("bgurl");
            this.aEl = jSONObject.optInt("effect");
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String Cu() {
        return this.mFile;
    }

    public String Ct() {
        return this.aEL;
    }

    public int Cx() {
        return this.aEl;
    }
}
