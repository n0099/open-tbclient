package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetClientConfig.DataRes;
import tbclient.GetClientConfig.GetClientConfigResIdl;
/* loaded from: classes.dex */
public class ClientConfigSocketResponse extends SocketResponsedMessage {
    private DataRes mData;

    public ClientConfigSocketResponse() {
        super(303039);
    }

    public DataRes getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) {
        GetClientConfigResIdl getClientConfigResIdl = (GetClientConfigResIdl) new Wire(new Class[0]).parseFrom(bArr, GetClientConfigResIdl.class);
        if (getClientConfigResIdl != null) {
            if (getClientConfigResIdl.error != null) {
                setError(getClientConfigResIdl.error.errorno.intValue());
                setErrorString(getClientConfigResIdl.error.errmsg);
            }
            if (getClientConfigResIdl.data != null) {
                this.mData = getClientConfigResIdl.data;
            }
        }
    }
}
