package com.baidu.live.talentshow.model;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveBCVideoCancelChatResponse extends JsonHttpResponsedMessage {
    public LiveBCVideoCancelChatResponse() {
        super(1021223);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && BdLog.isDebugMode()) {
            BdLog.e("LiveBCVideoCancelChatResponse:  " + jSONObject.toString());
        }
    }
}
