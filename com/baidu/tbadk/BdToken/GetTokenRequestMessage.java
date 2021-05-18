package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.GetToken.DataReq;
import tbclient.GetToken.GetTokenReqIdl;
/* loaded from: classes3.dex */
public class GetTokenRequestMessage extends NetMessage {
    public String mBaiduCuid;
    public String mToken;

    public GetTokenRequestMessage() {
        super(CmdConfigHttp.CMD_GET_TOKEN, 309608);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.token = this.mToken;
        builder.shoubaicuid = this.mBaiduCuid;
        if (z) {
            w.a(builder, true);
        }
        GetTokenReqIdl.Builder builder2 = new GetTokenReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setBaiduCuid(String str) {
        this.mBaiduCuid = str;
    }

    public void setToken(String str) {
        this.mToken = str;
    }
}
