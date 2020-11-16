package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aj {
    public String aGz;
    public String aHB;
    public int aIN;
    public int aIO;
    public String aIP;
    public String aIQ;
    public boolean aIR;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aIN = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aIO = optJSONObject.optInt("is_month_super_customer");
            this.aGz = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aIP = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aHB = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aIQ = optJSONObject.optString("btn_url");
            this.aIR = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
