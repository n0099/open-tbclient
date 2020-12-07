package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String cny;
    public boolean eFB;
    public int eFC;
    public String eFu;
    public String eFz;
    public String fhd;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.eFC = urlParserResIdl.data.url_type.intValue();
            this.cny = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.eFz = urlParserResIdl.data.link_from;
            this.fhd = urlParserResIdl.data.price_txt;
            this.eFB = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
