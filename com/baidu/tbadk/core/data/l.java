package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.flow.a.a {
    private String bUz;
    private String eNT;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bUz = bannerImage.img_url;
            this.eNT = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String getImgUrl() {
        return this.bUz;
    }

    public String blM() {
        return this.eNT;
    }

    public void Aa(String str) {
        this.eNT = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bUz;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blN() {
        return this.eNT;
    }
}
