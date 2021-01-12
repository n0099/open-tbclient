package com.baidu.live.ar;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i {
    private int aAL;
    private String aBl;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aBl = jSONObject.optString("bgurl");
            this.aAL = jSONObject.optInt(UbcStatConstant.ContentType.UBC_TYPE_ENTER_EFFECT);
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String yQ() {
        return this.mFile;
    }

    public String yP() {
        return this.aBl;
    }

    public int yT() {
        return this.aAL;
    }
}
