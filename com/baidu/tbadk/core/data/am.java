package com.baidu.tbadk.core.data;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class am {
    public String HT;
    public String RV;
    public int RW;
    public String RX;
    public int position = 0;
    public String subtitle;
    public String summary;

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.RV = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
            this.RW = newsInfo.news_type.intValue();
            this.RX = newsInfo.news_icon;
            this.subtitle = newsInfo.subtitle;
            this.HT = newsInfo.button_text;
        }
    }
}
