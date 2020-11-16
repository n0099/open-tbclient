package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    public String aSD;
    public int aSE;
    public String aUA;
    public long aUD;
    public String aUE;
    public int aUF;
    public long aUy;
    public String giftName;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        this.aUD = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
        this.aSD = jSONObject.optString("tying_tag");
        this.aSE = jSONObject.optInt("tying_tag_type");
        this.aUE = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aUF = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aUy = jSONObject.optLong("pay_userid");
        this.aUA = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
