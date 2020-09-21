package com.baidu.tbadk.BdToken.backUser;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.BackUser.BackUserResIdl;
/* loaded from: classes.dex */
public class BackUserSocketResMsg extends SocketResponsedMessage {
    private a mData;

    public BackUserSocketResMsg() {
        super(309689);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        BackUserResIdl backUserResIdl = (BackUserResIdl) new Wire(new Class[0]).parseFrom(bArr, BackUserResIdl.class);
        if (backUserResIdl != null) {
            if (backUserResIdl.error != null) {
                setError(backUserResIdl.error.errorno.intValue());
                setErrorString(backUserResIdl.error.usermsg);
            }
            if (backUserResIdl.data != null) {
                this.mData = new a();
                this.mData.a(backUserResIdl.data);
            }
        }
    }

    public a getData() {
        return this.mData;
    }
}
