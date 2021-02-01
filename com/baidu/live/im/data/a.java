package com.baidu.live.im.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String aWQ;
    public int bot;
    public String bpc;
    public long bpd;
    public int giftId;
    public String giftName;

    public static a T(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        aVar.bot = jSONObject.optInt("prize_num");
        aVar.giftName = jSONObject.optString("gift_name");
        aVar.aWQ = jSONObject.optString("gift_url");
        aVar.bpc = jSONObject.optString("prize_type");
        aVar.bpd = jSONObject.optInt("prize_value");
        return aVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("prize_type", this.bpc);
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.giftId);
            jSONObject.put("prize_num", this.bot);
            jSONObject.put("gift_name", this.giftName);
            jSONObject.put("gift_url", this.aWQ);
            jSONObject.put("prize_value", this.bpd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
