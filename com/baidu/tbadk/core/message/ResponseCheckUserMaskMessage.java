package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.CheckMaskUser.CheckMaskUserResIdl;
/* loaded from: classes3.dex */
public class ResponseCheckUserMaskMessage extends SocketResponsedMessage {
    public boolean isMasked;

    public ResponseCheckUserMaskMessage() {
        super(104104);
        this.isMasked = false;
    }

    public boolean isMasked() {
        return this.isMasked;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CheckMaskUserResIdl checkMaskUserResIdl = (CheckMaskUserResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckMaskUserResIdl.class);
        setError(checkMaskUserResIdl.error.errorno.intValue());
        setErrorString(checkMaskUserResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.isMasked = checkMaskUserResIdl.data.isMask.intValue() == 1;
    }
}
