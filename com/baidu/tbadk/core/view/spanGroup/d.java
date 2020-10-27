package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String ccQ;
    public String eUJ;
    public String eul;
    public String euq;
    public boolean eus;
    public int eut;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.eut = urlParserResIdl.data.url_type.intValue();
            this.ccQ = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.euq = urlParserResIdl.data.link_from;
            this.eUJ = urlParserResIdl.data.price_txt;
            this.eus = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
