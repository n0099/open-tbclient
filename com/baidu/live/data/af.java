package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class af {
    public String aHU;
    public String aHf;
    public int aIW;
    public int aIX;
    public String aIY;
    public String aIZ;
    public boolean aJa;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aIW = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aIX = optJSONObject.optInt("is_month_super_customer");
            this.aHf = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aIY = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aHU = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aIZ = optJSONObject.optString("btn_url");
            this.aJa = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
