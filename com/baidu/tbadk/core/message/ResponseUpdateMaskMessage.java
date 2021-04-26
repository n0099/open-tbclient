package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UpdateMask.UpdateMaskResIdl;
/* loaded from: classes3.dex */
public class ResponseUpdateMaskMessage extends SocketResponsedMessage {
    public ResponseUpdateMaskMessage() {
        super(104101);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        UpdateMaskResIdl updateMaskResIdl = (UpdateMaskResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateMaskResIdl.class);
        setError(updateMaskResIdl.error.errorno.intValue());
        setErrorString(updateMaskResIdl.error.usermsg);
    }
}
