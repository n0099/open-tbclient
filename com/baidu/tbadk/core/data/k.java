package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String bOR;
    private String eFb;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bOR = bannerImage.img_url;
            this.eFb = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bmL() {
        return this.bOR;
    }

    public String bmM() {
        return this.eFb;
    }

    public void AQ(String str) {
        this.eFb = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bOR;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bmN() {
        return this.eFb;
    }
}
