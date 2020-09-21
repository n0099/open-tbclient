package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String bNJ;
    public String dZJ;
    public String dZO;
    public boolean dZQ;
    public int dZR;
    public String eAg;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.dZR = urlParserResIdl.data.url_type.intValue();
            this.bNJ = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.dZO = urlParserResIdl.data.link_from;
            this.eAg = urlParserResIdl.data.price_txt;
            this.dZQ = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
