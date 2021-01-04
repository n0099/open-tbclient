package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String cuF;
    public String ePk;
    public String ePp;
    public boolean ePr;
    public int ePs;
    public String fqN;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.ePs = urlParserResIdl.data.url_type.intValue();
            this.cuF = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.ePp = urlParserResIdl.data.link_from;
            this.fqN = urlParserResIdl.data.price_txt;
            this.ePr = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
