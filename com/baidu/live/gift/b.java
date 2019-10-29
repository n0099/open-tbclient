package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e Wk = null;
    public d Wl = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.Wl = new d();
                this.Wl.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.Wk = new e();
                this.Wk.parseJson(optJSONObject2);
            }
        }
    }
}
