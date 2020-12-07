package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class s {
    public String aVF;
    public int aVG;
    public long aXF;
    public String aXH;
    public long aXK;
    public String aXL;
    public int aXM;
    public String giftName;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        this.aXK = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
        this.aVF = jSONObject.optString("tying_tag");
        this.aVG = jSONObject.optInt("tying_tag_type");
        this.aXL = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aXM = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aXF = jSONObject.optLong("pay_userid");
        this.aXH = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
