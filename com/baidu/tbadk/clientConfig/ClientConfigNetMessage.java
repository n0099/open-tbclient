package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.h;
import tbclient.GetClientConfig.DataReq;
import tbclient.GetClientConfig.GetClientConfigReqIdl;
/* loaded from: classes.dex */
public class ClientConfigNetMessage extends NetMessage {
    private String mType;

    public ClientConfigNetMessage() {
        super(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.type = this.mType;
        if (z) {
            h.a(builder, true);
        }
        GetClientConfigReqIdl.Builder builder2 = new GetClientConfigReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
