package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String ciC;
    public String eAe;
    public String eAj;
    public boolean eAl;
    public int eAm;
    public String fay;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.eAm = urlParserResIdl.data.url_type.intValue();
            this.ciC = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.eAj = urlParserResIdl.data.link_from;
            this.fay = urlParserResIdl.data.price_txt;
            this.eAl = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
