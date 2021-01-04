package com.baidu.live.im.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String aYy;
    public int bpN;
    public String bqu;
    public long bqv;
    public int giftId;
    public String giftName;

    public static a T(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        aVar.bpN = jSONObject.optInt("prize_num");
        aVar.giftName = jSONObject.optString("gift_name");
        aVar.aYy = jSONObject.optString("gift_url");
        aVar.bqu = jSONObject.optString("prize_type");
        aVar.bqv = jSONObject.optInt("prize_value");
        return aVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("prize_type", this.bqu);
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.giftId);
            jSONObject.put("prize_num", this.bpN);
            jSONObject.put("gift_name", this.giftName);
            jSONObject.put("gift_url", this.aYy);
            jSONObject.put("prize_value", this.bqv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
