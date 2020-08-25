package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.ai;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGiftRefreshScoresHttpResponseMessage extends JsonHttpResponsedMessage {
    private ai beB;

    public AlaGiftRefreshScoresHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
    }

    public ai LE() {
        return this.beB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (i == 1021019 && jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.beB = new ai();
            String optString = jSONObject.optString("scores_total");
            String optString2 = jSONObject.optString("petal_total");
            if (!TextUtils.isEmpty(optString)) {
                this.beB.mTDouScores = Long.parseLong(optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.beB.mPetalTotal = Long.parseLong(optString2);
            }
        }
    }
}
