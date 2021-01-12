package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class d {
    public static int i = 1;
    public String cpN;
    public String eKE;
    public boolean eKG;
    public int eKH;
    public String eKz;
    public String fmd;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.eKH = urlParserResIdl.data.url_type.intValue();
            this.cpN = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.eKE = urlParserResIdl.data.link_from;
            this.fmd = urlParserResIdl.data.price_txt;
            this.eKG = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
