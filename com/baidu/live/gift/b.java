package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e ayq = null;
    public d ayr = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.ayr = new d();
                this.ayr.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.ayq = new e();
                this.ayq.parseJson(optJSONObject2);
            }
        }
    }

    public boolean vB() {
        return (this.ayq == null || TextUtils.isEmpty(this.ayq.videoUrl) || TextUtils.isEmpty(this.ayq.videoMd5)) ? false : true;
    }

    public boolean vC() {
        return (this.ayq == null || TextUtils.isEmpty(this.ayq.zipDownloadUrl) || TextUtils.isEmpty(this.ayq.zipMD5)) ? false : true;
    }
}
