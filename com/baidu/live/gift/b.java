package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public int aWR;
    public String giftId = "";
    public String giftName = "";
    public e aWP = null;
    public d aWQ = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aWQ = new d();
                this.aWQ.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aWP = new e();
                this.aWP.parseJson(optJSONObject2);
            }
            this.aWR = jSONObject.optInt("branch", 0);
        }
    }

    public boolean Dy() {
        return (this.aWP == null || TextUtils.isEmpty(this.aWP.videoUrl) || TextUtils.isEmpty(this.aWP.videoMd5)) ? false : true;
    }

    public boolean Dz() {
        return this.aWR == 0 || (this.aWR & 1) != 0;
    }

    public boolean DA() {
        return this.aWR == 0 || (this.aWR & 4) != 0;
    }
}
