package com.baidu.tbadk.core.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.GetMaskInfo.DataReq;
import protobuf.GetMaskInfo.GetMaskInfoReqIdl;
/* loaded from: classes.dex */
public class RequestGetMaskInfoMessage extends TbSocketMessage {
    private int maskType;

    public RequestGetMaskInfoMessage() {
        super(CmdConfigSocket.CMD_GET_MASK_INFO);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = Integer.valueOf(getMaskType());
        GetMaskInfoReqIdl.Builder builder2 = new GetMaskInfoReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getMaskType() {
        return this.maskType;
    }

    public void setMaskType(int i) {
        this.maskType = i;
    }
}
