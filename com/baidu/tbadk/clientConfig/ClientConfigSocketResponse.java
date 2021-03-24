package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetClientConfig.DataRes;
import tbclient.GetClientConfig.GetClientConfigResIdl;
/* loaded from: classes3.dex */
public class ClientConfigSocketResponse extends SocketResponsedMessage {
    public DataRes mData;

    public ClientConfigSocketResponse() {
        super(303039);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetClientConfigResIdl getClientConfigResIdl = (GetClientConfigResIdl) new Wire(new Class[0]).parseFrom(bArr, GetClientConfigResIdl.class);
        if (getClientConfigResIdl == null) {
            return;
        }
        Error error = getClientConfigResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getClientConfigResIdl.error.errmsg);
        }
        DataRes dataRes = getClientConfigResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.mData = dataRes;
    }
}
