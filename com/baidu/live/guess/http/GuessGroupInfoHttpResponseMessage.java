package com.baidu.live.guess.http;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GuessGroupInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private List<n> blp;
    private int blq;
    private String errorMsg;

    public GuessGroupInfoHttpResponseMessage() {
        super(1021237);
        this.blq = 0;
        this.errorMsg = "";
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            this.blq = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            this.errorMsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
            this.blp = new ArrayList();
            if (this.blq == 0 && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    n nVar = new n();
                    nVar.parserJson(optJSONArray.optJSONObject(i2));
                    this.blp.add(nVar);
                }
            }
        }
    }

    public List<n> getGroupList() {
        return this.blp;
    }
}
