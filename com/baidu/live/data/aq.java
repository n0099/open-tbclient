package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class aq {
    public String aHq;
    public String aIu;
    public int aKc;
    public String aKd;
    public String aKe;
    public boolean aKf;
    public int duration;
    public String iconUrl;
    public int interval;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.interval = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aKc = optJSONObject.optInt("is_month_super_customer");
            this.aHq = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aKd = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aIu = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aKe = optJSONObject.optString("btn_url");
            this.aKf = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
