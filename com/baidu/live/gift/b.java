package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aUc = null;
    public d aUd = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aUd = new d();
                this.aUd.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aUc = new e();
                this.aUc.parseJson(optJSONObject2);
            }
        }
    }

    public boolean FB() {
        return (this.aUc == null || TextUtils.isEmpty(this.aUc.videoUrl) || TextUtils.isEmpty(this.aUc.videoMd5)) ? false : true;
    }
}
