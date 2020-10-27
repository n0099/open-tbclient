package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ai {
    public String aHs;
    public String aIv;
    public String aJA;
    public String aJB;
    public boolean aJC;
    public int aJy;
    public int aJz;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aJy = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aJz = optJSONObject.optInt("is_month_super_customer");
            this.aHs = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aJA = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aIv = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aJB = optJSONObject.optString("btn_url");
            this.aJC = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
