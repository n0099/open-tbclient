package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e adH = null;
    public d adI = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.adI = new d();
                this.adI.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.adH = new e();
                this.adH.parseJson(optJSONObject2);
            }
        }
    }
}
