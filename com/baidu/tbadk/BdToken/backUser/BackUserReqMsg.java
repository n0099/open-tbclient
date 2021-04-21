package com.baidu.tbadk.BdToken.backUser;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.BackUser.BackUserReqIdl;
import tbclient.BackUser.DataReq;
/* loaded from: classes3.dex */
public class BackUserReqMsg extends NetMessage {
    public BackUserReqMsg() {
        super(CmdConfigHttp.CMD_BACK_USER, 309689);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            w.c(builder, true, true, false);
            BackUserReqIdl.Builder builder2 = new BackUserReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }
}
