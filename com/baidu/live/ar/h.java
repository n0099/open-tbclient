package com.baidu.live.ar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    private int aCA;
    private String aDa;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aDa = jSONObject.optString("bgurl");
            this.aCA = jSONObject.optInt("effect");
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String BL() {
        return this.mFile;
    }

    public String BK() {
        return this.aDa;
    }

    public int BO() {
        return this.aCA;
    }
}
