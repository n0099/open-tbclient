package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {
    public int aqZ;
    public int ara;
    public String arb;
    public String arc;
    public String ard;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aqZ = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.ara = optJSONObject.optInt("is_super_customer");
            this.arb = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.arc = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.ard = optJSONObject.optString("btn_url");
        }
    }
}
