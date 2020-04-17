package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e ayk = null;
    public d ayl = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.ayl = new d();
                this.ayl.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.ayk = new e();
                this.ayk.parseJson(optJSONObject2);
            }
        }
    }

    public boolean vC() {
        return (this.ayk == null || TextUtils.isEmpty(this.ayk.videoUrl) || TextUtils.isEmpty(this.ayk.videoMd5)) ? false : true;
    }

    public boolean vD() {
        return (this.ayk == null || TextUtils.isEmpty(this.ayk.zipDownloadUrl) || TextUtils.isEmpty(this.ayk.zipMD5)) ? false : true;
    }
}
