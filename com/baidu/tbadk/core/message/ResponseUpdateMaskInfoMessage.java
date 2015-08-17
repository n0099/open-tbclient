package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UpdateMaskInfo.UpdateMaskInfoResIdl;
/* loaded from: classes.dex */
public class ResponseUpdateMaskInfoMessage extends SocketResponsedMessage {
    public ResponseUpdateMaskInfoMessage() {
        super(104102);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        UpdateMaskInfoResIdl updateMaskInfoResIdl = (UpdateMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateMaskInfoResIdl.class);
        setError(updateMaskInfoResIdl.error.errorno.intValue());
        setErrorString(updateMaskInfoResIdl.error.usermsg);
    }
}
