package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class s {
    public String aXl;
    public int aXm;
    public long aZk;
    public String aZm;
    public long aZp;
    public String aZq;
    public int aZr;
    public String giftName;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        this.aZp = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
        this.aXl = jSONObject.optString("tying_tag");
        this.aXm = jSONObject.optInt("tying_tag_type");
        this.aZq = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aZr = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aZk = jSONObject.optLong("pay_userid");
        this.aZm = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
