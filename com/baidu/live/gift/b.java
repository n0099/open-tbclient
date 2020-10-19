package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aRO = null;
    public d aRP = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aRP = new d();
                this.aRP.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aRO = new e();
                this.aRO.parseJson(optJSONObject2);
            }
        }
    }

    public boolean EL() {
        return (this.aRO == null || TextUtils.isEmpty(this.aRO.videoUrl) || TextUtils.isEmpty(this.aRO.videoMd5)) ? false : true;
    }
}
