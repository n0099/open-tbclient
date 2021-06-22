package com.baidu.tbadk.BdToken.backUser;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.a.n0.a.d0.a;
import tbclient.BackUser.BackUserResIdl;
import tbclient.Error;
/* loaded from: classes3.dex */
public class BackUserHTTPResMsg extends HttpResponsedMessage {
    public a mData;

    public BackUserHTTPResMsg() {
        super(CmdConfigHttp.CMD_BACK_USER);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        BackUserResIdl backUserResIdl = (BackUserResIdl) new Wire(new Class[0]).parseFrom(bArr, BackUserResIdl.class);
        if (backUserResIdl != null) {
            Error error = backUserResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(backUserResIdl.error.usermsg);
            }
            if (backUserResIdl.data != null) {
                a aVar = new a();
                this.mData = aVar;
                aVar.a(backUserResIdl.data);
            }
        }
    }
}
