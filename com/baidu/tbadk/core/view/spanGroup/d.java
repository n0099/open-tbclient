package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String dev;
    public String eOm;
    public String eOr;
    public boolean eOt;
    public int eOu;
    public String fpW;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.eOu = urlParserResIdl.data.url_type.intValue();
            this.dev = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.eOr = urlParserResIdl.data.link_from;
            this.fpW = urlParserResIdl.data.price_txt;
            this.eOt = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
