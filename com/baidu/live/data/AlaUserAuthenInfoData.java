package com.baidu.live.data;

import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaUserAuthenInfoData implements Serializable {
    public String bank_card;
    public String card_portrait;
    public String card_portrait_back;
    public String id_card_number;
    public String phone_number;
    public String real_name;
    public String reason;
    public int verify_info_status;
    public int verify_video_status;

    public void paserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.real_name = jSONObject.optString("real_name");
            this.id_card_number = jSONObject.optString("id_card_number");
            this.bank_card = jSONObject.optString("bank_card");
            this.phone_number = jSONObject.optString(PayUtils.KEY_PHONE_NUMBER);
            this.card_portrait = jSONObject.optString("card_portrait");
            this.card_portrait_back = jSONObject.optString("card_portrait_back");
            this.reason = jSONObject.optString(TiebaInitialize.LogFields.REASON);
            this.verify_info_status = jSONObject.optInt("verify_info_status");
            this.verify_video_status = jSONObject.optInt("verify_video_status");
        }
    }
}
