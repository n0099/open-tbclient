package com.baidu.live.im.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String aTL;
    public String blH;
    public long blI;
    public int bla;
    public int giftId;
    public String giftName;

    public static a T(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        aVar.bla = jSONObject.optInt("prize_num");
        aVar.giftName = jSONObject.optString("gift_name");
        aVar.aTL = jSONObject.optString("gift_url");
        aVar.blH = jSONObject.optString("prize_type");
        aVar.blI = jSONObject.optInt("prize_value");
        return aVar;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("prize_type", this.blH);
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.giftId);
            jSONObject.put("prize_num", this.bla);
            jSONObject.put("gift_name", this.giftName);
            jSONObject.put("gift_url", this.aTL);
            jSONObject.put("prize_value", this.blI);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
