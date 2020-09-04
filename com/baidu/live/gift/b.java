package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aML = null;
    public d aMM = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aMM = new d();
                this.aMM.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aML = new e();
                this.aML.parseJson(optJSONObject2);
            }
        }
    }

    public boolean Dx() {
        return (this.aML == null || TextUtils.isEmpty(this.aML.videoUrl) || TextUtils.isEmpty(this.aML.videoMd5)) ? false : true;
    }

    public boolean Dy() {
        return (this.aML == null || TextUtils.isEmpty(this.aML.zipDownloadUrl) || TextUtils.isEmpty(this.aML.zipMD5)) ? false : true;
    }
}
