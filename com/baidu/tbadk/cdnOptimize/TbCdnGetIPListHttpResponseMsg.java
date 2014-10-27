package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbCdnGetIPListHttpResponseMsg extends JsonHttpResponsedMessage {
    public f ipListData;

    public TbCdnGetIPListHttpResponseMsg(int i) {
        super(i);
        this.ipListData = new f();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            try {
                this.ipListData.parseJson(jSONObject);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
