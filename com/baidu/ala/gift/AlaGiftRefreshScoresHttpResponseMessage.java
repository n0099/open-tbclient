package com.baidu.ala.gift;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AlaGiftRefreshScoresHttpResponseMessage extends JsonHttpResponsedMessage {
    private String contentStr;
    private AlaUserScoreData data;

    public AlaGiftRefreshScoresHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
    }

    public AlaUserScoreData getScoresData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public String parseToString(byte[] bArr) throws Exception {
        this.contentStr = super.parseToString(bArr);
        return this.contentStr;
    }

    public String getContentStr() {
        return this.contentStr;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (i == 1021019 && jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            this.data = new AlaUserScoreData();
            String optString = jSONObject.optString("scores_total");
            String optString2 = jSONObject.optString("petal_total");
            if (!TextUtils.isEmpty(optString)) {
                this.data.mTDouScores = Long.parseLong(optString);
            } else {
                setError(-1003);
                setErrorString("date error");
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.data.mPetalTotal = Long.parseLong(optString2);
            }
        }
    }
}
