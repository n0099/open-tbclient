package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String bLJ;
    public String dXE;
    public boolean dXG;
    public int dXH;
    public String dXz;
    public String eya;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.dXH = urlParserResIdl.data.url_type.intValue();
            this.bLJ = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.dXE = urlParserResIdl.data.link_from;
            this.eya = urlParserResIdl.data.price_txt;
            this.dXG = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
