package com.baidu.tbadk.core.data;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes2.dex */
public class ay {
    public String buttonText;
    public int dEg;
    public String dZp;
    public String dZq;
    public int position = 0;
    public String subtitle;
    public String summary;

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.dZp = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
            this.dEg = newsInfo.news_type.intValue();
            this.dZq = newsInfo.news_icon;
            this.subtitle = newsInfo.subtitle;
            this.buttonText = newsInfo.button_text;
        }
    }
}
