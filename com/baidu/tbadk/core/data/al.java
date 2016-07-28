package com.baidu.tbadk.core.data;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class al {
    public String FG;
    public String Pj;
    public int Pk;
    public String Pl;
    public int position = 0;
    public String subtitle;
    public String summary;

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.Pj = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
            this.Pk = newsInfo.news_type.intValue();
            this.Pl = newsInfo.news_icon;
            this.subtitle = newsInfo.subtitle;
            this.FG = newsInfo.button_text;
        }
    }
}
