package com.baidu.tbadk.core.data;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class an {
    public String aso;
    public int asp;
    public String asq;
    public String buttonText;
    public int position = 0;
    public String subtitle;
    public String summary;

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.aso = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
            this.asp = newsInfo.news_type.intValue();
            this.asq = newsInfo.news_icon;
            this.subtitle = newsInfo.subtitle;
            this.buttonText = newsInfo.button_text;
        }
    }
}
