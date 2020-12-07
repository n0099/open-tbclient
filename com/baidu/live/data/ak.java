package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ak {
    public String aJj;
    public String aKm;
    public int aLG;
    public int aLH;
    public String aLI;
    public String aLJ;
    public boolean aLK;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aLG = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aLH = optJSONObject.optInt("is_month_super_customer");
            this.aJj = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aLI = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aKm = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aLJ = optJSONObject.optString("btn_url");
            this.aLK = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
