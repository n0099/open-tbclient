package com.baidu.ala.gift;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AlaGiftRefreshScoresHttpResponseMessage extends JsonHttpResponsedMessage {
    public String contentStr;
    public AlaUserScoreData data;

    public AlaGiftRefreshScoresHttpResponseMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_GIFT_REFRESH_SCORES);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (i2 != 1021019 || jSONObject == null) {
            return;
        }
        super.decodeLogicInBackGround(i2, jSONObject);
        this.data = new AlaUserScoreData();
        String optString = jSONObject.optString("scores_total");
        String optString2 = jSONObject.optString("petal_total");
        if (!TextUtils.isEmpty(optString)) {
            this.data.mTDouScores = Long.parseLong(optString);
        } else {
            setError(-1003);
            setErrorString("date error");
        }
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        this.data.mPetalTotal = Long.parseLong(optString2);
    }

    public String getContentStr() {
        return this.contentStr;
    }

    public AlaUserScoreData getScoresData() {
        return this.data;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public String parseToString(byte[] bArr) throws Exception {
        String parseToString = super.parseToString(bArr);
        this.contentStr = parseToString;
        return parseToString;
    }
}
