package com.baidu.tbadk.core.view.spanGroup;

import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes2.dex */
public class d {
    public static int i = 1;
    public String bLF;
    public String dXA;
    public boolean dXC;
    public int dXD;
    public String dXv;
    public String exW;
    public String mDescription;
    public int mStatus;
    public String mTitle;

    public void a(UrlParserResIdl urlParserResIdl) {
        if (urlParserResIdl != null && urlParserResIdl.data != null) {
            this.mStatus = urlParserResIdl.data.status.intValue();
            this.dXD = urlParserResIdl.data.url_type.intValue();
            this.bLF = urlParserResIdl.data.image;
            this.mTitle = urlParserResIdl.data.title;
            this.dXA = urlParserResIdl.data.link_from;
            this.exW = urlParserResIdl.data.price_txt;
            this.dXC = urlParserResIdl.data.is_recognize.intValue() == 1;
            this.mDescription = urlParserResIdl.data.description;
        }
    }
}
