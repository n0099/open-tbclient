package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aVt = null;
    public d aVu = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aVu = new d();
                this.aVu.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aVt = new e();
                this.aVt.parseJson(optJSONObject2);
            }
        }
    }

    public boolean GD() {
        return (this.aVt == null || TextUtils.isEmpty(this.aVt.videoUrl) || TextUtils.isEmpty(this.aVt.videoMd5)) ? false : true;
    }
}
