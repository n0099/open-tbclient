package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.UpdateMaskInfo.UpdateMaskInfoRes;
/* loaded from: classes.dex */
public class ResponseUpdateMaskInfoMessage extends SocketResponsedMessage {
    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        UpdateMaskInfoRes.UpdateMaskInfoResIdl parseFrom = UpdateMaskInfoRes.UpdateMaskInfoResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        d(parseFrom.getError().getUsermsg());
    }

    public ResponseUpdateMaskInfoMessage() {
        super(104102);
    }
}
