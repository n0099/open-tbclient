package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aMJ = null;
    public d aMK = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aMK = new d();
                this.aMK.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aMJ = new e();
                this.aMJ.parseJson(optJSONObject2);
            }
        }
    }

    public boolean Dx() {
        return (this.aMJ == null || TextUtils.isEmpty(this.aMJ.videoUrl) || TextUtils.isEmpty(this.aMJ.videoMd5)) ? false : true;
    }

    public boolean Dy() {
        return (this.aMJ == null || TextUtils.isEmpty(this.aMJ.zipDownloadUrl) || TextUtils.isEmpty(this.aMJ.zipMD5)) ? false : true;
    }
}
