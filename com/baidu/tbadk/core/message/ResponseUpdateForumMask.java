package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import protobuf.UpdateForumMask.UpdateForumMaskResIdl;
/* loaded from: classes.dex */
public class ResponseUpdateForumMask extends SocketResponsedMessage {
    public ResponseUpdateForumMask() {
        super(104106);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UpdateForumMaskResIdl updateForumMaskResIdl = (UpdateForumMaskResIdl) new Wire(new Class[0]).parseFrom(bArr, UpdateForumMaskResIdl.class);
        setError(updateForumMaskResIdl.error.errorno.intValue());
        setErrorString(updateForumMaskResIdl.error.usermsg);
    }
}
