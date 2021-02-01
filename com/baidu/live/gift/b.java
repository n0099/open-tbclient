package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public int aVr;
    public String giftId = "";
    public String giftName = "";
    public e aVp = null;
    public d aVq = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aVq = new d();
                this.aVq.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aVp = new e();
                this.aVp.parseJson(optJSONObject2);
            }
            this.aVr = jSONObject.optInt("branch", 0);
        }
    }

    public boolean Dv() {
        return (this.aVp == null || TextUtils.isEmpty(this.aVp.videoUrl) || TextUtils.isEmpty(this.aVp.videoMd5)) ? false : true;
    }

    public boolean Dw() {
        return this.aVr == 0 || (this.aVr & 1) != 0;
    }

    public boolean Dx() {
        return this.aVr == 0 || (this.aVr & 4) != 0;
    }
}
