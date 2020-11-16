package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aSr = null;
    public d aSs = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aSs = new d();
                this.aSs.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aSr = new e();
                this.aSr.parseJson(optJSONObject2);
            }
        }
    }

    public boolean ES() {
        return (this.aSr == null || TextUtils.isEmpty(this.aSr.videoUrl) || TextUtils.isEmpty(this.aSr.videoMd5)) ? false : true;
    }
}
