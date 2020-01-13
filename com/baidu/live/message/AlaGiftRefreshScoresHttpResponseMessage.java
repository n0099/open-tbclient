package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGiftRefreshScoresHttpResponseMessage extends JsonHttpResponsedMessage {
    private x asm;

    public AlaGiftRefreshScoresHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
    }

    public x wy() {
        return this.asm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (i == 1021019 && jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.asm = new x();
            String optString = jSONObject.optString("scores_total");
            String optString2 = jSONObject.optString("petal_total");
            if (!TextUtils.isEmpty(optString)) {
                this.asm.mTDouScores = Long.parseLong(optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.asm.mPetalTotal = Long.parseLong(optString2);
            }
        }
    }
}
