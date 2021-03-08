package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aq {
    public String aIQ;
    public String aJU;
    public int aLC;
    public String aLD;
    public String aLE;
    public boolean aLF;
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
            this.aLC = optJSONObject.optInt("is_month_super_customer");
            this.aIQ = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aLD = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aJU = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aLE = optJSONObject.optString("btn_url");
            this.aLF = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
