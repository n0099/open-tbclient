package com.baidu.live.ar;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private String aFY;
    private int aFy;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aFY = jSONObject.optString("bgurl");
            this.aFy = jSONObject.optInt(UbcStatConstant.ContentType.UBC_TYPE_ENTER_EFFECT);
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String CL() {
        return this.mFile;
    }

    public String CK() {
        return this.aFY;
    }

    public int CO() {
        return this.aFy;
    }
}
