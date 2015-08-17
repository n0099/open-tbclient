package com.baidu.tbadk.core.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.CheckMaskUser.CheckMaskUserIdl;
import protobuf.CheckMaskUser.DataReq;
/* loaded from: classes.dex */
public class RequestCheckUserMaskMessage extends TbSocketMessage {
    private long userId;

    public RequestCheckUserMaskMessage() {
        super(104104);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.uid = Long.valueOf(getUserId());
        CheckMaskUserIdl.Builder builder2 = new CheckMaskUserIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
