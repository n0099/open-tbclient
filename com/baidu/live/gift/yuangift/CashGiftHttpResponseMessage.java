package com.baidu.live.gift.yuangift;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.gift.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class CashGiftHttpResponseMessage extends JsonHttpResponsedMessage {
    public int aNs;
    public int aOm;
    public int aOn;
    public g bfh;
    public String bfi;
    public int bfj;
    public long dubi;
    public String iconId;
    public long nonMemberT;
    public int photoHeight;
    public String photoUrl;
    public int photoWidth;
    public int previewGiftId;
    public String productId;

    public CashGiftHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("gift_info");
            if (optJSONObject3 != null) {
                this.bfh = new g();
                this.bfh.parseJson(optJSONObject3);
            }
            this.previewGiftId = optJSONObject.optInt("preview_gift_id");
            this.photoUrl = optJSONObject.optString("photo_url");
            this.productId = optJSONObject.optString("product_id");
            this.iconId = optJSONObject.optString("icon_id");
            this.nonMemberT = optJSONObject.optLong("non_member_t");
            this.dubi = optJSONObject.optLong("dubi");
            this.photoWidth = optJSONObject.optInt("photo_width");
            this.photoHeight = optJSONObject.optInt("photo_height");
            this.bfi = optJSONObject.optString("back_ground");
            this.bfj = optJSONObject.optInt("premium_user");
            if (optJSONObject.has("cash_gift") && (optJSONObject2 = optJSONObject.optJSONObject("cash_gift")) != null) {
                this.aOm = optJSONObject2.optInt("show_times_daily");
                this.aOn = optJSONObject2.optInt("continue_show_times");
                this.aNs = optJSONObject2.optInt("condition");
            }
        }
    }
}
