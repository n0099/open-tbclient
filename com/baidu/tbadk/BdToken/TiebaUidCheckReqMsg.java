package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.a.d;
import d.a.j0.z0.w;
import tbclient.GetUserByTiebaUid.DataReq;
import tbclient.GetUserByTiebaUid.GetUserByTiebaUidReqIdl;
/* loaded from: classes3.dex */
public class TiebaUidCheckReqMsg extends NetMessage {
    public d.l mTiebaUidData;

    public TiebaUidCheckReqMsg() {
        super(CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, 309702);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            if (this.mTiebaUidData.b() != null) {
                builder.tieba_uid = this.mTiebaUidData.b();
            }
            w.c(builder, true, true, true);
            GetUserByTiebaUidReqIdl.Builder builder2 = new GetUserByTiebaUidReqIdl.Builder();
            builder2.data = builder.build(true);
            return builder2.build(true);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void setTiebaUid(d.l lVar) {
        this.mTiebaUidData = lVar;
    }
}
