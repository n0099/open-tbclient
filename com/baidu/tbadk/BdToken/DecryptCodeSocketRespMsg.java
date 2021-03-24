package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import d.b.h0.a.g;
import tbclient.DecryptCode.DecryptCodeResIdl;
/* loaded from: classes3.dex */
public class DecryptCodeSocketRespMsg extends SocketResponsedMessage {
    public g decryptData;

    public DecryptCodeSocketRespMsg(int i) {
        super(i);
    }

    public g getDecryptData() {
        return this.decryptData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
