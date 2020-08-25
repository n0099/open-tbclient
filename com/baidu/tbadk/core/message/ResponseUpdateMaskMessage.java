package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.UpdateMask.UpdateMaskResIdl;
/* loaded from: classes2.dex */
public class ResponseUpdateMaskMessage extends SocketResponsedMessage {
    public ResponseUpdateMaskMessage() {
        super(CmdConfigSocket.CMD_UPDATE_MASK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UpdateMaskResIdl updateMaskResIdl = (UpdateMaskResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateMaskResIdl.class);
        setError(updateMaskResIdl.error.errorno.intValue());
        setErrorString(updateMaskResIdl.error.usermsg);
    }
}
