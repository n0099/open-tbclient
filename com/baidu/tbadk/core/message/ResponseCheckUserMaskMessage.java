package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.CheckMaskUser.CheckMaskUserRes;
/* loaded from: classes.dex */
public class ResponseCheckUserMaskMessage extends SocketResponsedMessage {
    private boolean a;

    @Override // com.baidu.adp.framework.message.c
    public final /* synthetic */ void a(int i, Object obj) {
        CheckMaskUserRes.CheckMaskUserResIdl parseFrom = CheckMaskUserRes.CheckMaskUserResIdl.parseFrom((byte[]) obj);
        a(parseFrom.getError().getErrorno());
        e(parseFrom.getError().getUsermsg());
        if (e() == 0) {
            this.a = parseFrom.getData().getIsMask() == 1;
        }
    }

    public ResponseCheckUserMaskMessage() {
        super(104104);
        this.a = false;
    }

    public final boolean d() {
        return this.a;
    }
}
