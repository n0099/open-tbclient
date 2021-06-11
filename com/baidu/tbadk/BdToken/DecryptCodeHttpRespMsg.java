package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import d.a.m0.a.i;
import tbclient.DecryptCode.DecryptCodeResIdl;
/* loaded from: classes3.dex */
public class DecryptCodeHttpRespMsg extends HttpResponsedMessage {
    public i decryptData;

    public DecryptCodeHttpRespMsg(int i2) {
        super(i2);
    }

    public i getDecryptData() {
        return this.decryptData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) {
        try {
            DecryptCodeResIdl decryptCodeResIdl = (DecryptCodeResIdl) new Wire(new Class[0]).parseFrom(bArr, DecryptCodeResIdl.class);
            if (decryptCodeResIdl != null) {
                i iVar = new i();
                this.decryptData = iVar;
                iVar.h(decryptCodeResIdl.data);
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
