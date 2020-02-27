package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public String giftId = "";
    public String giftName = "";
    public e afJ = null;
    public d afK = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.afK = new d();
                this.afK.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.afJ = new e();
                this.afJ.parseJson(optJSONObject2);
            }
        }
    }

    public boolean rf() {
        return (this.afJ == null || TextUtils.isEmpty(this.afJ.videoUrl) || TextUtils.isEmpty(this.afJ.videoMd5)) ? false : true;
    }

    public boolean rg() {
        return (this.afJ == null || TextUtils.isEmpty(this.afJ.zipDownloadUrl) || TextUtils.isEmpty(this.afJ.zipMD5)) ? false : true;
    }
}
