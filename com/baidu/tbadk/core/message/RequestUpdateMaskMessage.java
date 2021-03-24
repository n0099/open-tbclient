package com.baidu.tbadk.core.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateMask.DataReq;
import protobuf.UpdateMask.UpdateMaskReqIdl;
/* loaded from: classes3.dex */
public class RequestUpdateMaskMessage extends TbSocketMessage {
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    public String gids;
    public int isAdd;
    public int isMask;

    public RequestUpdateMaskMessage() {
        super(104101);
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

    public boolean isAdd() {
        return this.isAdd == 0;
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

    public void setSettingMask(boolean z) {
        this.isMask = !z ? 1 : 0;
    }
}
