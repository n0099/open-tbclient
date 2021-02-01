package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String dcS;
    public String eML;
    public String eMQ;
    public boolean eMS;
    public int eMT;
    public String fow;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.eMT = urlParserResIdl.data.url_type.intValue();
            this.dcS = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.eMQ = urlParserResIdl.data.link_from;
            this.fow = urlParserResIdl.data.price_txt;
            this.eMS = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
