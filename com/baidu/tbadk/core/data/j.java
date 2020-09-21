package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String bwq;
    private String dZq;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bwq = bannerImage.img_url;
            this.dZq = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bdu() {
        return this.bwq;
    }

    public String bdv() {
        return this.dZq;
    }

    public void zv(String str) {
        this.dZq = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bwq;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bdw() {
        return this.dZq;
    }
}
