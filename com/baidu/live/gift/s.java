package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class s {
    public String aXd;
    public int aXe;
    public long aZc;
    public String aZe;
    public long aZh;
    public String aZi;
    public int aZj;
    public String giftName;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        this.aZh = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
        this.aXd = jSONObject.optString("tying_tag");
        this.aXe = jSONObject.optInt("tying_tag_type");
        this.aZi = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aZj = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aZc = jSONObject.optLong("pay_userid");
        this.aZe = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
