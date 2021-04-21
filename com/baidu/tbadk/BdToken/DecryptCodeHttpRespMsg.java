package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import d.b.i0.a.g;
import tbclient.DecryptCode.DecryptCodeResIdl;
/* loaded from: classes3.dex */
public class DecryptCodeHttpRespMsg extends HttpResponsedMessage {
    public g decryptData;

    public DecryptCodeHttpRespMsg(int i) {
        super(i);
    }

    public g getDecryptData() {
        return this.decryptData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        try {
            DecryptCodeResIdl decryptCodeResIdl = (DecryptCodeResIdl) new Wire(new Class[0]).parseFrom(bArr, DecryptCodeResIdl.class);
            if (decryptCodeResIdl != null) {
                g gVar = new g();
                this.decryptData = gVar;
                gVar.h(decryptCodeResIdl.data);
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
