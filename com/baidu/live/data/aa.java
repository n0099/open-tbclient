package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class aa {
    public String aDU;
    public String aDi;
    public int aEH;
    public int aEI;
    public String aEJ;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aEH = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aEI = optJSONObject.optInt("is_month_super_customer");
            this.aDi = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aDU = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aEJ = optJSONObject.optString("btn_url");
        }
    }
}
