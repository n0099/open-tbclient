package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetToken.GetTokenResIdl;
/* loaded from: classes.dex */
public class GetTokenSocketResponsedMessage extends SocketResponsedMessage {
    private q mData;

    public GetTokenSocketResponsedMessage() {
        super(309608);
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
                this.mData = new q();
                this.mData.a(getTokenResIdl.data);
            }
        }
    }

    public q getData() {
        return this.mData;
    }
}
