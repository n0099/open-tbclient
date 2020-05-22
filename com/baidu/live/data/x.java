package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class x {
    public String auL;
    public int avZ;
    public int awa;
    public String awb;
    public String awc;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.avZ = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.awa = optJSONObject.optInt("is_super_customer");
            this.auL = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.awb = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.awc = optJSONObject.optString("btn_url");
        }
    }
}
