package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class s {
    public String aSV;
    public int aSW;
    public long aUR;
    public String aUT;
    public long aUW;
    public String aUX;
    public int aUY;
    public String giftName;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        this.aUW = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
        this.aSV = jSONObject.optString("tying_tag");
        this.aSW = jSONObject.optInt("tying_tag_type");
        this.aUX = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aUY = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aUR = jSONObject.optLong("pay_userid");
        this.aUT = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
