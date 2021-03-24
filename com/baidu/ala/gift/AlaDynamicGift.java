package com.baidu.ala.gift;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaDynamicGift implements Serializable {
    public String giftId = "";
    public String giftName = "";
    public AlaDynamicGiftZip giftZip = null;
    public AlaDynamicGiftConfigInfo configInfo = null;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.giftId = jSONObject.optString("gift_id");
        this.giftName = jSONObject.optString("gift_name");
        JSONObject optJSONObject = jSONObject.optJSONObject("config_info");
        if (optJSONObject != null) {
            AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo = new AlaDynamicGiftConfigInfo();
            this.configInfo = alaDynamicGiftConfigInfo;
            alaDynamicGiftConfigInfo.parseJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("gift_zip");
        if (optJSONObject2 != null) {
            AlaDynamicGiftZip alaDynamicGiftZip = new AlaDynamicGiftZip();
            this.giftZip = alaDynamicGiftZip;
            alaDynamicGiftZip.parseJson(optJSONObject2);
        }
    }
}
