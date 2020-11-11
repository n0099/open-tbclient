package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class r {
    public String aUo;
    public int aUp;
    public long aWj;
    public String aWl;
    public long aWo;
    public String aWp;
    public int aWq;
    public String giftName;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        this.aWo = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
        this.aUo = jSONObject.optString("tying_tag");
        this.aUp = jSONObject.optInt("tying_tag_type");
        this.aWp = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aWq = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aWj = jSONObject.optLong("pay_userid");
        this.aWl = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
