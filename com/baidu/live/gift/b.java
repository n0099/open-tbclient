package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e aHz = null;
    public d aHA = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aHA = new d();
                this.aHA.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aHz = new e();
                this.aHz.parseJson(optJSONObject2);
            }
        }
    }

    public boolean xU() {
        return (this.aHz == null || TextUtils.isEmpty(this.aHz.videoUrl) || TextUtils.isEmpty(this.aHz.videoMd5)) ? false : true;
    }

    public boolean xV() {
        return (this.aHz == null || TextUtils.isEmpty(this.aHz.zipDownloadUrl) || TextUtils.isEmpty(this.aHz.zipMD5)) ? false : true;
    }
}
