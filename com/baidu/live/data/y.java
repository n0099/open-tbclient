package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class y {
    public String aye;
    public int azu;
    public int azv;
    public String azw;
    public String azx;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.azu = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.azv = optJSONObject.optInt("is_month_super_customer");
            this.aye = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.azw = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.azx = optJSONObject.optString("btn_url");
        }
    }
}
