package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ALAGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean apx;
    private List<com.baidu.live.im.data.a> apy;
    private long mGroupId;

    public ALAGroupHttpResponseMessage() {
        super(1021012);
    }

    public boolean vk() {
        return this.apx;
    }

    public void aR(boolean z) {
        this.apx = z;
    }

    public List<com.baidu.live.im.data.a> vl() {
        return this.apy;
    }

    public void G(List<com.baidu.live.im.data.a> list) {
        this.apy = list;
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
