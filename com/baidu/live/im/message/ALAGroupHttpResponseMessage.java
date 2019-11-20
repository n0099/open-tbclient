package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ALAGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean aht;
    private List<com.baidu.live.im.data.a> ahu;
    private long mGroupId;

    public ALAGroupHttpResponseMessage() {
        super(1021012);
    }

    public boolean tq() {
        return this.aht;
    }

    public void aA(boolean z) {
        this.aht = z;
    }

    public List<com.baidu.live.im.data.a> tr() {
        return this.ahu;
    }

    public void I(List<com.baidu.live.im.data.a> list) {
        this.ahu = list;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0) {
        }
    }
}
