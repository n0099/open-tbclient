package com.baidu.live.yuyingift.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YuyinAlaComboEndHttpResponseMessage extends JsonHttpResponsedMessage {
    public YuyinAlaComboEndHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject == null || i != 1031088) {
        }
    }
}
