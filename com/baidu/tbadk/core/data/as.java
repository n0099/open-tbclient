package com.baidu.tbadk.core.data;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class as {
    public String buttonText;
    public String cLO;
    public String cLP;
    public int cvj;
    public int position = 0;
    public String subtitle;
    public String summary;

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.cLO = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
            this.cvj = newsInfo.news_type.intValue();
            this.cLP = newsInfo.news_icon;
            this.subtitle = newsInfo.subtitle;
            this.buttonText = newsInfo.button_text;
        }
    }
}
