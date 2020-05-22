package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aDI = null;
    public d aDJ = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aDJ = new d();
                this.aDJ.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aDI = new e();
                this.aDI.parseJson(optJSONObject2);
            }
        }
    }

    public boolean wR() {
        return (this.aDI == null || TextUtils.isEmpty(this.aDI.videoUrl) || TextUtils.isEmpty(this.aDI.videoMd5)) ? false : true;
    }

    public boolean wS() {
        return (this.aDI == null || TextUtils.isEmpty(this.aDI.zipDownloadUrl) || TextUtils.isEmpty(this.aDI.zipMD5)) ? false : true;
    }
}
