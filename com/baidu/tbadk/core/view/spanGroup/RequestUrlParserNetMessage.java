package com.baidu.tbadk.core.view.spanGroup;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.UrlParser.DataReq;
import tbclient.UrlParser.UrlParserReqIdl;
/* loaded from: classes3.dex */
public class RequestUrlParserNetMessage extends NetMessage {
    public long mForumId;
    public int mLinkNum;
    public int mSpanGroupId;
    public String mUrl;

    public RequestUrlParserNetMessage() {
        super(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
        this.mSpanGroupId = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.url = this.mUrl;
        builder.link_num = Integer.valueOf(this.mLinkNum);
        UrlParserReqIdl.Builder builder2 = new UrlParserReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getForumId() {
        return this.mForumId;
    }

    public int getLinkNum() {
        return this.mLinkNum;
    }

    public int getSpanGroupId() {
        return this.mSpanGroupId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setParams(long j, int i2, String str, int i3) {
        this.mForumId = j;
        this.mLinkNum = i2;
        this.mUrl = str;
        this.mSpanGroupId = i3;
    }
}
