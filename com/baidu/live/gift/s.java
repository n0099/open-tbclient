package com.baidu.live.gift;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class s {
    public String aSy;
    public int aSz;
    public long aUC;
    public String aUD;
    public int aUE;
    public long aUx;
    public String aUz;
    public String giftName;
    public String portrait;

    public void parserJson(JSONObject jSONObject) {
        this.aUC = jSONObject.optLong(LogConfig.LOG_GIFT_ID);
        this.aSy = jSONObject.optString("tying_tag");
        this.aSz = jSONObject.optInt("tying_tag_type");
        this.aUD = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aUE = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aUx = jSONObject.optLong("pay_userid");
        this.aUz = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }
}
