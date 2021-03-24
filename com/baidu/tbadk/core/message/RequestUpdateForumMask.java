package com.baidu.tbadk.core.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateForumMask.DataReq;
import protobuf.UpdateForumMask.UpdateForumMaskReqIdl;
/* loaded from: classes3.dex */
public class RequestUpdateForumMask extends TbSocketMessage {
    public static final int TYPE_FORUM_BROADCAST = 1;
    public boolean flag;
    public int type;

    public RequestUpdateForumMask() {
        super(104106);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = Integer.valueOf(getType());
        builder.flag = Boolean.valueOf(getFlag());
        UpdateForumMaskReqIdl.Builder builder2 = new UpdateForumMaskReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public boolean getFlag() {
        return this.flag;
    }

    public int getType() {
        return this.type;
    }

    public void setFlag(boolean z) {
        this.flag = z;
    }

    public void setType(int i) {
        this.type = i;
    }
}
