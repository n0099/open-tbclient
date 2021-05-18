package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import d.a.j0.a.a0;
import tbclient.Error;
import tbclient.GetToken.GetTokenResIdl;
/* loaded from: classes3.dex */
public class GetTokenSocketResponsedMessage extends SocketResponsedMessage {
    public a0 mData;

    public GetTokenSocketResponsedMessage() {
        super(309608);
    }

    public a0 getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
            a0 a0Var = new a0();
            this.mData = a0Var;
            a0Var.d(getTokenResIdl.data);
        }
    }
}
