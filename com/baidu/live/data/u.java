package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class u {
    public int aqT;
    public int aqU;
    public String aqV;
    public String aqW;
    public String aqX;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aqT = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aqU = optJSONObject.optInt("is_super_customer");
            this.aqV = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aqW = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aqX = optJSONObject.optString("btn_url");
        }
    }
}
