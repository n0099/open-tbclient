package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ALAGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean bpi;
    private List<com.baidu.live.im.data.b> chatMsgs;
    private long mGroupId;

    public ALAGroupHttpResponseMessage() {
        super(1021012);
    }

    public boolean On() {
        return this.bpi;
    }

    public void cl(boolean z) {
        this.bpi = z;
    }

    public List<com.baidu.live.im.data.b> Oo() {
        return this.chatMsgs;
    }

    public void X(List<com.baidu.live.im.data.b> list) {
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
