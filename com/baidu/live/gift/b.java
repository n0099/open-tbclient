package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aSJ = null;
    public d aSK = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aSK = new d();
                this.aSK.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aSJ = new e();
                this.aSJ.parseJson(optJSONObject2);
            }
        }
    }

    public boolean Fa() {
        return (this.aSJ == null || TextUtils.isEmpty(this.aSJ.videoUrl) || TextUtils.isEmpty(this.aSJ.videoMd5)) ? false : true;
    }
}
