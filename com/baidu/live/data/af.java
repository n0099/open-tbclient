package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class af {
    public String aEQ;
    public String aEb;
    public int aFS;
    public int aFT;
    public String aFU;
    public String aFV;
    public boolean aFW;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aFS = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aFT = optJSONObject.optInt("is_month_super_customer");
            this.aEb = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aFU = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aEQ = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aFV = optJSONObject.optString("btn_url");
            this.aFW = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
