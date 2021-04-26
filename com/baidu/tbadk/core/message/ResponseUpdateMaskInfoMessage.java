package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UpdateMaskInfo.UpdateMaskInfoResIdl;
/* loaded from: classes3.dex */
public class ResponseUpdateMaskInfoMessage extends SocketResponsedMessage {
    public ResponseUpdateMaskInfoMessage() {
        super(104102);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        UpdateMaskInfoResIdl updateMaskInfoResIdl = (UpdateMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateMaskInfoResIdl.class);
        setError(updateMaskInfoResIdl.error.errorno.intValue());
        setErrorString(updateMaskInfoResIdl.error.usermsg);
    }
}
