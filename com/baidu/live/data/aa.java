package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class aa {
    public String aDS;
    public String aDg;
    public int aEF;
    public int aEG;
    public String aEH;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aEF = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aEG = optJSONObject.optInt("is_month_super_customer");
            this.aDg = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aDS = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aEH = optJSONObject.optString("btn_url");
        }
    }
}
