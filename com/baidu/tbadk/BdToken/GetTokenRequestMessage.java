package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.p;
import tbclient.GetToken.DataReq;
import tbclient.GetToken.GetTokenReqIdl;
/* loaded from: classes.dex */
public class GetTokenRequestMessage extends NetMessage {
    private String mToken;

    public GetTokenRequestMessage() {
        super(CmdConfigHttp.CMD_GET_TOKEN, 309608);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.token = this.mToken;
        if (z) {
            p.bindCommonParamsToProtobufData(builder, true);
        }
        GetTokenReqIdl.Builder builder2 = new GetTokenReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
