package com.baidu.live.im.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aWS;
    public String boL;
    public long boM;
    public int boe;
    public int giftId;
    public String giftName;

    public static a L(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        aVar.boe = jSONObject.optInt("prize_num");
        aVar.giftName = jSONObject.optString("gift_name");
        aVar.aWS = jSONObject.optString("gift_url");
        aVar.boL = jSONObject.optString("prize_type");
        aVar.boM = jSONObject.optInt("prize_value");
        return aVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("prize_type", this.boL);
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.giftId);
            jSONObject.put("prize_num", this.boe);
            jSONObject.put("gift_name", this.giftName);
            jSONObject.put("gift_url", this.aWS);
            jSONObject.put("prize_value", this.boM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
