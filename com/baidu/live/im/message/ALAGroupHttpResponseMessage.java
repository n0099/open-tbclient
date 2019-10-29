package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ALAGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean ahL;
    private List<com.baidu.live.im.data.a> ahM;
    private long mGroupId;

    public ALAGroupHttpResponseMessage() {
        super(1021012);
    }

    public boolean tp() {
        return this.ahL;
    }

    public void aA(boolean z) {
        this.ahL = z;
    }

    public List<com.baidu.live.im.data.a> tq() {
        return this.ahM;
    }

    public void I(List<com.baidu.live.im.data.a> list) {
        this.ahM = list;
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
