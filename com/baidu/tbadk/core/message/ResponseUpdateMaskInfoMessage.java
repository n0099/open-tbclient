package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import protobuf.UpdateMaskInfo.UpdateMaskInfoResIdl;
/* loaded from: classes2.dex */
public class ResponseUpdateMaskInfoMessage extends SocketResponsedMessage {
    public ResponseUpdateMaskInfoMessage() {
        super(CmdConfigSocket.CMD_UPDATE_MASK_INFO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UpdateMaskInfoResIdl updateMaskInfoResIdl = (UpdateMaskInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateMaskInfoResIdl.class);
        setError(updateMaskInfoResIdl.error.errorno.intValue());
        setErrorString(updateMaskInfoResIdl.error.usermsg);
    }
}
