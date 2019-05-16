package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.GetToken.DataReq;
import tbclient.GetToken.GetTokenReqIdl;
/* loaded from: classes.dex */
public class GetTokenRequestMessage extends NetMessage {
    private String mBaiduCuid;
    private String mToken;

    public GetTokenRequestMessage() {
        super(CmdConfigHttp.CMD_GET_TOKEN, 309608);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.token = this.mToken;
        builder.shoubaicuid = this.mBaiduCuid;
        if (z) {
            com.baidu.tbadk.util.s.bindCommonParamsToProtobufData(builder, true);
        }
        GetTokenReqIdl.Builder builder2 = new GetTokenReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setBaiduCuid(String str) {
        this.mBaiduCuid = str;
    }
}
