package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.CheckMaskUser.CheckMaskUserResIdl;
/* loaded from: classes.dex */
public class ResponseCheckUserMaskMessage extends SocketResponsedMessage {
    private boolean isMasked;

    public ResponseCheckUserMaskMessage() {
        super(104104);
        this.isMasked = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        CheckMaskUserResIdl checkMaskUserResIdl = (CheckMaskUserResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckMaskUserResIdl.class);
        setError(checkMaskUserResIdl.error.errorno.intValue());
        setErrorString(checkMaskUserResIdl.error.usermsg);
        if (getError() == 0) {
            this.isMasked = checkMaskUserResIdl.data.isMask.intValue() == 1;
        }
    }

    public boolean isMasked() {
        return this.isMasked;
    }
}
