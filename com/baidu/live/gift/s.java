package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class s {
    public String aVD;
    public int aVE;
    public long aXC;
    public String aXE;
    public long aXH;
    public String aXI;
    public int aXJ;
    public String giftName;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        this.aXH = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
        this.aVD = jSONObject.optString("tying_tag");
        this.aVE = jSONObject.optInt("tying_tag_type");
        this.aXI = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aXJ = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aXC = jSONObject.optLong("pay_userid");
        this.aXE = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
