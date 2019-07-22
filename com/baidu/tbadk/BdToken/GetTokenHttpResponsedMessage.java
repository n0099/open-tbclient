package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.GetToken.GetTokenResIdl;
/* loaded from: classes.dex */
public class GetTokenHttpResponsedMessage extends HttpResponsedMessage {
    private v mData;

    public GetTokenHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_GET_TOKEN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetTokenResIdl getTokenResIdl = (GetTokenResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTokenResIdl.class);
        if (getTokenResIdl != null) {
            if (getTokenResIdl.error != null) {
                setError(getTokenResIdl.error.errorno.intValue());
                setErrorString(getTokenResIdl.error.usermsg);
            }
            if (getTokenResIdl.data != null) {
                this.mData = new v();
                this.mData.a(getTokenResIdl.data);
            }
        }
    }

    public v getData() {
        return this.mData;
    }
}
