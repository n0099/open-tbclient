package com.baidu.tbadk.core.feedManager;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class RecPersonalizeSocketResponse extends SocketResponsedMessage {
    private DataRes resultData;

    public RecPersonalizeSocketResponse() {
        super(CmdConfigSocket.CMD_RECOMMEND_PERSONALIZED);
    }

    public DataRes getResultData() {
        return this.resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PersonalizedResIdl personalizedResIdl = (PersonalizedResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalizedResIdl.class);
        if (personalizedResIdl != null) {
            if (personalizedResIdl.error != null) {
                if (personalizedResIdl.error.errorno != null) {
                    setError(personalizedResIdl.error.errorno.intValue());
                }
                setErrorString(personalizedResIdl.error.usermsg);
            }
            this.resultData = personalizedResIdl.data;
        }
    }
}
