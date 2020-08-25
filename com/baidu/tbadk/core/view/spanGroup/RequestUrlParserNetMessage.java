package com.baidu.tbadk.core.view.spanGroup;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.UrlParser.DataReq;
import tbclient.UrlParser.UrlParserReqIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RequestUrlParserNetMessage extends NetMessage {
    private long mForumId;
    private int mLinkNum;
    private int mSpanGroupId;
    private String mUrl;

    public RequestUrlParserNetMessage() {
        super(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
        this.mSpanGroupId = 0;
    }

    public void setParams(long j, int i, String str, int i2) {
        this.mForumId = j;
        this.mLinkNum = i;
        this.mUrl = str;
        this.mSpanGroupId = i2;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.url = this.mUrl;
        builder.link_num = Integer.valueOf(this.mLinkNum);
        UrlParserReqIdl.Builder builder2 = new UrlParserReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getLinkNum() {
        return this.mLinkNum;
    }

    public int getSpanGroupId() {
        return this.mSpanGroupId;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String getUrl() {
        return this.mUrl;
    }
}
