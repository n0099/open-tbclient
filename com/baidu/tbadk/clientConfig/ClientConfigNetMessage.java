package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.GetClientConfig.DataReq;
import tbclient.GetClientConfig.GetClientConfigReqIdl;
/* loaded from: classes3.dex */
public class ClientConfigNetMessage extends NetMessage {
    public String mType;

    public ClientConfigNetMessage() {
        super(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = this.mType;
        if (z) {
            w.a(builder, true);
        }
        GetClientConfigReqIdl.Builder builder2 = new GetClientConfigReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
