package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String bLu;
    private String ezL;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bLu = bannerImage.img_url;
            this.ezL = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bkw() {
        return this.bLu;
    }

    public String bkx() {
        return this.ezL;
    }

    public void AO(String str) {
        this.ezL = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bLu;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bky() {
        return this.ezL;
    }
}
