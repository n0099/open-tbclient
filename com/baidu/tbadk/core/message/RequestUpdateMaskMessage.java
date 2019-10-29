package com.baidu.tbadk.core.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateMask.DataReq;
import protobuf.UpdateMask.UpdateMaskReqIdl;
/* loaded from: classes.dex */
public class RequestUpdateMaskMessage extends TbSocketMessage {
    private static final int FALSE = 0;
    private static final int TRUE = 1;
    private String gids;
    private int isAdd;
    private int isMask;

    public RequestUpdateMaskMessage() {
        super(CmdConfigSocket.CMD_UPDATE_MASK);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.gids = this.gids;
        builder.isAdd = Integer.valueOf(this.isAdd);
        builder.maskRemind = Integer.valueOf(this.isMask);
        UpdateMaskReqIdl.Builder builder2 = new UpdateMaskReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setSettingMask(boolean z) {
        this.isMask = !z ? 1 : 0;
    }

    public boolean isSettingMask() {
        return this.isMask != 1;
    }

    public void setGids(String str) {
        this.gids = str;
    }

    public void setIsAdd(boolean z) {
        this.isAdd = !z ? 1 : 0;
    }

    public boolean isAdd() {
        return this.isAdd == 0;
    }
}
