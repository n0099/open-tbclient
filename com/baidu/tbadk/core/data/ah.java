package com.baidu.tbadk.core.data;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class ah {
    public String Fg;
    public String OV;
    public int OW;
    public String OX;
    public int position = 0;
    public String subtitle;
    public String summary;

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.OV = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
            this.OW = newsInfo.news_type.intValue();
            this.OX = newsInfo.news_icon;
            this.subtitle = newsInfo.subtitle;
            this.Fg = newsInfo.button_text;
        }
    }
}
