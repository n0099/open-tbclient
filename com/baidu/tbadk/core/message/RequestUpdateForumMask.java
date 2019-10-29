package com.baidu.tbadk.core.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateForumMask.DataReq;
import protobuf.UpdateForumMask.UpdateForumMaskReqIdl;
/* loaded from: classes.dex */
public class RequestUpdateForumMask extends TbSocketMessage {
    public static final int TYPE_FORUM_BROADCAST = 1;
    private boolean flag;
    private int type;

    public RequestUpdateForumMask() {
        super(CmdConfigSocket.CMD_UPDATE_FORUM_MAST_STAT);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public boolean getFlag() {
        return this.flag;
    }

    public void setFlag(boolean z) {
        this.flag = z;
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
}
