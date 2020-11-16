package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ALAGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean bke;
    private List<com.baidu.live.im.data.a> chatMsgs;
    private long mGroupId;

    public ALAGroupHttpResponseMessage() {
        super(1021012);
    }

    public boolean LY() {
        return this.bke;
    }

    public void cb(boolean z) {
        this.bke = z;
    }

    public List<com.baidu.live.im.data.a> LZ() {
        return this.chatMsgs;
    }

    public void W(List<com.baidu.live.im.data.a> list) {
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
