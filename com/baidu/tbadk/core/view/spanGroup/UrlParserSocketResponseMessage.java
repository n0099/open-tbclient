package com.baidu.tbadk.core.view.spanGroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class UrlParserSocketResponseMessage extends SocketResponsedMessage {
    public UrlParserResIdl mResponseData;

    public UrlParserSocketResponseMessage() {
        super(309686);
    }

    public UrlParserResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        UrlParserResIdl urlParserResIdl = (UrlParserResIdl) new Wire(new Class[0]).parseFrom(bArr, UrlParserResIdl.class);
        this.mResponseData = urlParserResIdl;
        Error error = urlParserResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
