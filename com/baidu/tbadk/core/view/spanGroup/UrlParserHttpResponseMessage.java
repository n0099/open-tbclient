package com.baidu.tbadk.core.view.spanGroup;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class UrlParserHttpResponseMessage extends TbHttpResponsedMessage {
    public UrlParserResIdl mResponseData;

    public UrlParserHttpResponseMessage(int i) {
        super(CmdConfigHttp.CMD_URL_PARSER_MESSAGE);
    }

    public UrlParserResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        UrlParserResIdl urlParserResIdl = (UrlParserResIdl) new Wire(new Class[0]).parseFrom(bArr, UrlParserResIdl.class);
        this.mResponseData = urlParserResIdl;
        Error error = urlParserResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(this.mResponseData.error.errmsg);
        }
    }
}
