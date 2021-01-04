package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class am {
    public String aJH;
    public String aKL;
    public int aMk;
    public int aMl;
    public String aMm;
    public String aMn;
    public boolean aMo;
    public int duration;
    public String iconUrl;
    public int limit;
    public String picUrl;

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aMk = optJSONObject.optInt("interval");
            this.picUrl = optJSONObject.optString("pic_url");
            this.aMl = optJSONObject.optInt("is_month_super_customer");
            this.aJH = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
            this.aMm = optJSONObject.optString("jump_url_audio");
            this.limit = optJSONObject.optInt(Constants.EXTRA_CONFIG_LIMIT);
            this.duration = optJSONObject.optInt("duration");
            this.aKL = optJSONObject.optString("toast_text");
            this.iconUrl = optJSONObject.optString("icon_url");
            this.aMn = optJSONObject.optString("btn_url");
            this.aMo = optJSONObject.optInt("audio_show_switch") == 1;
        }
    }
}
