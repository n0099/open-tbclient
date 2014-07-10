package com.baidu.tbadk.core.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateMaskInfo.DataReq;
import protobuf.UpdateMaskInfo.UpdateMaskInfoReqIdl;
/* loaded from: classes.dex */
public class RequestUpdateMaskInfoMessage extends TbSocketMessage {
    private static final int FALSE = 0;
    private static final int TRUE = 1;
    private int isMask;
    private String list;
    private int maskType;

    public RequestUpdateMaskInfoMessage() {
        super(104102);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = Integer.valueOf(this.maskType);
        builder.isMask = Integer.valueOf(this.isMask);
        builder.list = this.list;
        UpdateMaskInfoReqIdl.Builder builder2 = new UpdateMaskInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getMaskType() {
        return this.maskType;
    }

    public void setMaskType(int i) {
        this.maskType = i;
    }

    public int getIsMask() {
        return this.isMask;
    }

    public void setIsMask(int i) {
        this.isMask = i;
    }

    public void setMask(boolean z) {
        this.isMask = z ? 1 : 0;
    }

    public String getList() {
        return this.list;
    }

    public void setList(String str) {
        this.list = str;
    }
}
