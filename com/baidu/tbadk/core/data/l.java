package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.flow.a.a {
    private String bSZ;
    private String eMs;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bSZ = bannerImage.img_url;
            this.eMs = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String getImgUrl() {
        return this.bSZ;
    }

    public String blK() {
        return this.eMs;
    }

    public void zT(String str) {
        this.eMs = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bSZ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blL() {
        return this.eMs;
    }
}
