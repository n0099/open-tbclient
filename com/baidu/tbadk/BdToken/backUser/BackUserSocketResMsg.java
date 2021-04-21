package com.baidu.tbadk.BdToken.backUser;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.a.a0.a;
import tbclient.BackUser.BackUserResIdl;
import tbclient.Error;
/* loaded from: classes3.dex */
public class BackUserSocketResMsg extends SocketResponsedMessage {
    public a mData;

    public BackUserSocketResMsg() {
        super(309689);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        BackUserResIdl backUserResIdl = (BackUserResIdl) new Wire(new Class[0]).parseFrom(bArr, BackUserResIdl.class);
        if (backUserResIdl != null) {
            Error error = backUserResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(backUserResIdl.error.usermsg);
            }
            if (backUserResIdl.data != null) {
                a aVar = new a();
                this.mData = aVar;
                aVar.a(backUserResIdl.data);
            }
        }
    }
}
