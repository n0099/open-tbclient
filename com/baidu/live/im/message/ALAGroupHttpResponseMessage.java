package com.baidu.live.im.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ALAGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    private boolean aue;
    private List<com.baidu.live.im.data.a> auf;
    private long mGroupId;

    public ALAGroupHttpResponseMessage() {
        super(1021012);
    }

    public boolean xE() {
        return this.aue;
    }

    public void aW(boolean z) {
        this.aue = z;
    }

    public List<com.baidu.live.im.data.a> xF() {
        return this.auf;
    }

    public void F(List<com.baidu.live.im.data.a> list) {
        this.auf = list;
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
