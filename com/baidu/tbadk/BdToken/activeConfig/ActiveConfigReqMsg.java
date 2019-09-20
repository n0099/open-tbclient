package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.ActiveConfig.ActiveConfigReqIdl;
import tbclient.ActiveConfig.DataReq;
/* loaded from: classes.dex */
public class ActiveConfigReqMsg extends NetMessage {
    public ActiveConfigReqMsg() {
        super(CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            r.bindCommonParamsToProtobufData(builder, true, true, false);
            ActiveConfigReqIdl.Builder builder2 = new ActiveConfigReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
