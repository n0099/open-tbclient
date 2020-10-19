package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String bUs;
    public String eMn;
    public String elL;
    public String elQ;
    public boolean elS;
    public int elT;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.elT = urlParserResIdl.data.url_type.intValue();
            this.bUs = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.elQ = urlParserResIdl.data.link_from;
            this.eMn = urlParserResIdl.data.price_txt;
            this.elS = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
