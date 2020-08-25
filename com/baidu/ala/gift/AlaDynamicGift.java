package com.baidu.ala.gift;

import com.baidu.live.tbadk.log.LogConfig;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaDynamicGift implements Serializable {
    public String giftId = "";
    public String giftName = "";
    public AlaDynamicGiftZip giftZip = null;
    public AlaDynamicGiftConfigInfo configInfo = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            this.giftName = jSONObject.optString("gift_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
            if (optJSONObject != null) {
                this.configInfo = new AlaDynamicGiftConfigInfo();
                this.configInfo.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
            if (optJSONObject2 != null) {
                this.giftZip = new AlaDynamicGiftZip();
                this.giftZip.parseJson(optJSONObject2);
            }
        }
    }
}
