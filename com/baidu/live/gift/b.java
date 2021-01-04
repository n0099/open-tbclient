package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    public int aXa;
    public String giftId = "";
    public String giftName = "";
    public e aWY = null;
    public d aWZ = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.aWZ = new d();
                this.aWZ.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.aWY = new e();
                this.aWY.parseJson(optJSONObject2);
            }
            this.aXa = jSONObject.optInt("branch", 0);
        }
    }

    public boolean Gb() {
        return (this.aWY == null || TextUtils.isEmpty(this.aWY.videoUrl) || TextUtils.isEmpty(this.aWY.videoMd5)) ? false : true;
    }

    public boolean Gc() {
        return this.aXa == 0 || (this.aXa & 1) != 0;
    }

    public boolean Gd() {
        return this.aXa == 0 || (this.aXa & 4) != 0;
    }
}
