package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public int aSn;
    public String giftId = "";
    public String giftName = "";
    public e aSl = null;
    public d aSm = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aSm = new d();
                this.aSm.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aSl = new e();
                this.aSl.parseJson(optJSONObject2);
            }
            this.aSn = jSONObject.optInt("branch", 0);
        }
    }

    public boolean Cg() {
        return (this.aSl == null || TextUtils.isEmpty(this.aSl.videoUrl) || TextUtils.isEmpty(this.aSl.videoMd5)) ? false : true;
    }

    public boolean Ch() {
        return this.aSn == 0 || (this.aSn & 1) != 0;
    }

    public boolean Ci() {
        return this.aSn == 0 || (this.aSn & 4) != 0;
    }
}
