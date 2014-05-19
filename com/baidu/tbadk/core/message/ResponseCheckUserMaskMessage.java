package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.squareup.wire.Wire;
import protobuf.CheckMaskUser.CheckMaskUserResIdl;
/* loaded from: classes.dex */
public class ResponseCheckUserMaskMessage extends SocketResponsedMessage {
    private boolean isMasked;

    public ResponseCheckUserMaskMessage() {
        super(MessageTypes.CMD_CHECK_USER_MASK);
        this.isMasked = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        CheckMaskUserResIdl checkMaskUserResIdl = (CheckMaskUserResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckMaskUserResIdl.class);
        setError(checkMaskUserResIdl.error.errorno.intValue());
        setErrorString(checkMaskUserResIdl.error.usermsg);
        if (getError() == 0) {
            setMasked(checkMaskUserResIdl.data.isMask.intValue() == 1);
        }
    }

    public boolean isMasked() {
        return this.isMasked;
    }

    public void setMasked(boolean z) {
        this.isMasked = z;
    }
}
