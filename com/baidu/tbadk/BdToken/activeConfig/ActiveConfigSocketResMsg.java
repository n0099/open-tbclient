package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.n0.a.c0.b;
import tbclient.ActiveConfig.ActiveConfigResIdl;
import tbclient.Error;
/* loaded from: classes3.dex */
public class ActiveConfigSocketResMsg extends SocketResponsedMessage {
    public b mData;

    public ActiveConfigSocketResMsg() {
        super(309637);
    }

    public b getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        ActiveConfigResIdl activeConfigResIdl = (ActiveConfigResIdl) new Wire(new Class[0]).parseFrom(bArr, ActiveConfigResIdl.class);
        if (activeConfigResIdl != null) {
            Error error = activeConfigResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(activeConfigResIdl.error.usermsg);
            }
            if (activeConfigResIdl.data != null) {
                b bVar = new b();
                this.mData = bVar;
                bVar.c(activeConfigResIdl.data);
            }
        }
    }
}
