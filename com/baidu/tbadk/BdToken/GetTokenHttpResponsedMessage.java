package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.b.h0.a.y;
import tbclient.Error;
import tbclient.GetToken.GetTokenResIdl;
/* loaded from: classes3.dex */
public class GetTokenHttpResponsedMessage extends HttpResponsedMessage {
    public y mData;

    public GetTokenHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_GET_TOKEN);
    }

    public y getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetTokenResIdl getTokenResIdl = (GetTokenResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTokenResIdl.class);
        if (getTokenResIdl == null) {
            return;
        }
        Error error = getTokenResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getTokenResIdl.error.usermsg);
        }
        if (getTokenResIdl.data != null) {
            y yVar = new y();
            this.mData = yVar;
            yVar.d(getTokenResIdl.data);
        }
    }
}
