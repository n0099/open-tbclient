package com.baidu.tbadk.core.view.spanGroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class UrlParserSocketResponseMessage extends SocketResponsedMessage {
    private UrlParserResIdl mResponseData;

    public UrlParserSocketResponseMessage() {
        super(309686);
    }

    public UrlParserResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.mResponseData = (UrlParserResIdl) new Wire(new Class[0]).parseFrom(bArr, UrlParserResIdl.class);
        if (this.mResponseData.error != null) {
            setError(this.mResponseData.error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
