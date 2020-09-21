package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aOD = null;
    public d aOE = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aOE = new d();
                this.aOE.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aOD = new e();
                this.aOD.parseJson(optJSONObject2);
            }
        }
    }

    public boolean DO() {
        return (this.aOD == null || TextUtils.isEmpty(this.aOD.videoUrl) || TextUtils.isEmpty(this.aOD.videoMd5)) ? false : true;
    }

    public boolean DP() {
        return (this.aOD == null || TextUtils.isEmpty(this.aOD.zipDownloadUrl) || TextUtils.isEmpty(this.aOD.zipMD5)) ? false : true;
    }
}
