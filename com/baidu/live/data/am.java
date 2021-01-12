package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class am {
    public String aEU;
    public String aFY;
    public String aHA;
    public boolean aHB;
    public int aHx;
    public int aHy;
    public String aHz;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aHx = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aHy = optJSONObject.optInt("is_month_super_customer");
            this.aEU = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aHz = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aFY = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aHA = optJSONObject.optString("btn_url");
            this.aHB = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
