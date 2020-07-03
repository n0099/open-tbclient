package com.baidu.tbadk.core.data;

import tbclient.PbPage.NewsInfo;
/* loaded from: classes.dex */
public class aw {
    public String buttonText;
    public String dJK;
    public String dJL;
    public int dom;
    public int position = 0;
    public String subtitle;
    public String summary;

    public void a(NewsInfo newsInfo) {
        if (newsInfo != null) {
            this.dJK = newsInfo.news_link;
            this.summary = newsInfo.summary;
            this.position = newsInfo.position.intValue();
            this.dom = newsInfo.news_type.intValue();
            this.dJL = newsInfo.news_icon;
            this.subtitle = newsInfo.subtitle;
            this.buttonText = newsInfo.button_text;
        }
    }
}
