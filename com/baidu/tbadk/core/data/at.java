package com.baidu.tbadk.core.data;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class at {
    public String Xo;
    public int Xp;
    public String Xq;
    public String buttonText;
    public int position = 0;
    public String subtitle;
    public String summary;

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.Xo = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
            this.Xp = newsInfo.news_type.intValue();
            this.Xq = newsInfo.news_icon;
            this.subtitle = newsInfo.subtitle;
            this.buttonText = newsInfo.button_text;
        }
    }
}
