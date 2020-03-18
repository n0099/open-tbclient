package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e afT = null;
    public d afU = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.afU = new d();
                this.afU.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.afT = new e();
                this.afT.parseJson(optJSONObject2);
            }
        }
    }

    public boolean rk() {
        return (this.afT == null || TextUtils.isEmpty(this.afT.videoUrl) || TextUtils.isEmpty(this.afT.videoMd5)) ? false : true;
    }

    public boolean rl() {
        return (this.afT == null || TextUtils.isEmpty(this.afT.zipDownloadUrl) || TextUtils.isEmpty(this.afT.zipMD5)) ? false : true;
    }
}
