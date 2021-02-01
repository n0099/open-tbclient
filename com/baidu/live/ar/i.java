package com.baidu.live.ar;

import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i {
    private String aCQ;
    private int aCq;
    private String mFile;
    private String mId;
    private String mName;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optString("id");
            this.mName = jSONObject.optString("name");
            this.mFile = jSONObject.optString("file");
            this.aCQ = jSONObject.optString("bgurl");
            this.aCq = jSONObject.optInt(UbcStatConstant.ContentType.UBC_TYPE_ENTER_EFFECT);
        }
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String zx() {
        return this.mFile;
    }

    public String zw() {
        return this.aCQ;
    }

    public int zA() {
        return this.aCq;
    }
}
