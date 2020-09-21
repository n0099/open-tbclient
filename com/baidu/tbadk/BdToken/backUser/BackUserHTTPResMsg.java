package com.baidu.tbadk.BdToken.backUser;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.BackUser.BackUserResIdl;
/* loaded from: classes.dex */
public class BackUserHTTPResMsg extends HttpResponsedMessage {
    private a mData;

    public BackUserHTTPResMsg() {
        super(CmdConfigHttp.CMD_BACK_USER);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        BackUserResIdl backUserResIdl = (BackUserResIdl) new Wire(new Class[0]).parseFrom(bArr, BackUserResIdl.class);
        if (backUserResIdl != null) {
            if (backUserResIdl.error != null) {
                setError(backUserResIdl.error.errorno.intValue());
                setErrorString(backUserResIdl.error.usermsg);
            }
            if (backUserResIdl.data != null) {
                this.mData = new a();
                this.mData.a(backUserResIdl.data);
            }
        }
    }

    public a getData() {
        return this.mData;
    }
}
