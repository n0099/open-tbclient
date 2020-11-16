package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String bJJ;
    private String eya;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bJJ = bannerImage.img_url;
            this.eya = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bjy() {
        return this.bJJ;
    }

    public String bjz() {
        return this.eya;
    }

    public void Aj(String str) {
        this.eya = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bJJ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bjA() {
        return this.eya;
    }
}
