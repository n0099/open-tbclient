package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ALAGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean aXj;
    private List<com.baidu.live.im.data.a> chatMsgs;
    private long mGroupId;

    public ALAGroupHttpResponseMessage() {
        super(1021012);
    }

    public boolean Ew() {
        return this.aXj;
    }

    public void bL(boolean z) {
        this.aXj = z;
    }

    public List<com.baidu.live.im.data.a> Ex() {
        return this.chatMsgs;
    }

    public void P(List<com.baidu.live.im.data.a> list) {
        this.chatMsgs = list;
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
        if (jSONObject == null) {
        }
    }
}
