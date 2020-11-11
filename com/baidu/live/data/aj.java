package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aj {
    public String aIk;
    public String aJm;
    public String aKA;
    public String aKB;
    public boolean aKC;
    public int aKy;
    public int aKz;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aKy = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aKz = optJSONObject.optInt("is_month_super_customer");
            this.aIk = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aKA = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aJm = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aKB = optJSONObject.optString("btn_url");
            this.aKC = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
