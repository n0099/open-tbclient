package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String bPj;
    private String eKg;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bPj = bannerImage.img_url;
            this.eKg = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String getImgUrl() {
        return this.bPj;
    }

    public String bls() {
        return this.eKg;
    }

    public void zC(String str) {
        this.eKg = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bPj;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blt() {
        return this.eKg;
    }
}
