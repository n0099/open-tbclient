package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.DecryptCode.DataReq;
import tbclient.DecryptCode.DecryptCodeReqIdl;
/* loaded from: classes.dex */
public class DecryptCodeReqMsg extends NetMessage {
    private String code;

    public DecryptCodeReqMsg() {
        super(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.tieba_code = this.code;
            com.baidu.tbadk.util.r.a(builder, true, true, true);
            DecryptCodeReqIdl.Builder builder2 = new DecryptCodeReqIdl.Builder();
            builder2.data = builder.build(true);
            return builder2.build(true);
        } catch (Throwable th) {
            return null;
        }
    }

    public void setCode(String str) {
        this.code = str;
    }
}
