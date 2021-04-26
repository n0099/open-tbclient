package com.baidu.tbadk.core.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.GetMaskInfo.DataReq;
import protobuf.GetMaskInfo.GetMaskInfoReqIdl;
/* loaded from: classes3.dex */
public class RequestGetMaskInfoMessage extends TbSocketMessage {
    public int maskType;

    public RequestGetMaskInfoMessage() {
        super(104103);
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

    public void setMaskType(int i2) {
        this.maskType = i2;
    }
}
