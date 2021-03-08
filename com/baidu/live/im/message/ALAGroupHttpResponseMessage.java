package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ALAGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean brd;
    private List<com.baidu.live.im.data.b> chatMsgs;
    private long mGroupId;

    public ALAGroupHttpResponseMessage() {
        super(1021012);
    }

    public boolean Ly() {
        return this.brd;
    }

    public void cp(boolean z) {
        this.brd = z;
    }

    public List<com.baidu.live.im.data.b> Lz() {
        return this.chatMsgs;
    }

    public void Y(List<com.baidu.live.im.data.b> list) {
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
