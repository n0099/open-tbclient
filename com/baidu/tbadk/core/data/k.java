package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String bTV;
    private String eOR;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bTV = bannerImage.img_url;
            this.eOR = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String getImgUrl() {
        return this.bTV;
    }

    public String bpl() {
        return this.eOR;
    }

    public void AO(String str) {
        this.eOR = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bTV;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bpm() {
        return this.eOR;
    }
}
