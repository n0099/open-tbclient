package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String cgQ;
    public String eZG;
    public String eyA;
    public boolean eyC;
    public int eyD;
    public String eyv;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.eyD = urlParserResIdl.data.url_type.intValue();
            this.cgQ = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.eyA = urlParserResIdl.data.link_from;
            this.eZG = urlParserResIdl.data.price_txt;
            this.eyC = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
