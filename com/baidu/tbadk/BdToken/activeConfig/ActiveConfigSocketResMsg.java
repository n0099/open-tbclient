package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.ActiveConfig.ActiveConfigResIdl;
/* loaded from: classes.dex */
public class ActiveConfigSocketResMsg extends SocketResponsedMessage {
    private a mData;

    public ActiveConfigSocketResMsg() {
        super(309637);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ActiveConfigResIdl activeConfigResIdl = (ActiveConfigResIdl) new Wire(new Class[0]).parseFrom(bArr, ActiveConfigResIdl.class);
        if (activeConfigResIdl != null) {
            if (activeConfigResIdl.error != null) {
                setError(activeConfigResIdl.error.errorno.intValue());
                setErrorString(activeConfigResIdl.error.usermsg);
            }
            if (activeConfigResIdl.data != null) {
                this.mData = new a();
                this.mData.a(activeConfigResIdl.data);
            }
        }
    }

    public a getData() {
        return this.mData;
    }
}
