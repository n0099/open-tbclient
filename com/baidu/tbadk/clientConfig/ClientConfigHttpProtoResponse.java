package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetClientConfig.DataRes;
import tbclient.GetClientConfig.GetClientConfigResIdl;
/* loaded from: classes3.dex */
public class ClientConfigHttpProtoResponse extends HttpResponsedMessage {
    public DataRes mData;

    public ClientConfigHttpProtoResponse() {
        super(CmdConfigHttp.CMD_CLIENT_CONFIG);
    }

    public DataRes getData() {
        return this.mData;
    }

    public ClientConfigHttpProtoResponse(int i2) {
        super(CmdConfigHttp.CMD_CLIENT_CONFIG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
