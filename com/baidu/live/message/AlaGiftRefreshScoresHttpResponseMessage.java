package com.baidu.live.message;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.data.af;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGiftRefreshScoresHttpResponseMessage extends JsonHttpResponsedMessage {
    private af aZj;

    public AlaGiftRefreshScoresHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
    }

    public af FW() {
        return this.aZj;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (i == 1021019 && jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.aZj = new af();
            String optString = jSONObject.optString("scores_total");
            String optString2 = jSONObject.optString("petal_total");
            if (!TextUtils.isEmpty(optString)) {
                this.aZj.mTDouScores = Long.parseLong(optString);
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.aZj.mPetalTotal = Long.parseLong(optString2);
            }
        }
    }
}
