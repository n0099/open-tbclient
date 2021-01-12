package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.au;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGiftRefreshScoresHttpResponseMessage extends JsonHttpResponsedMessage {
    private au brn;

    public AlaGiftRefreshScoresHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
    }

    public au MR() {
        return this.brn;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (i == 1021019 && jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.brn = new au();
            String optString = jSONObject.optString("scores_total");
            String optString2 = jSONObject.optString("petal_total");
            if (!TextUtils.isEmpty(optString)) {
                this.brn.mTDouScores = Long.parseLong(optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.brn.mPetalTotal = Long.parseLong(optString2);
            }
        }
    }
}
