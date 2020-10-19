package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String bCT;
    private String els;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bCT = bannerImage.img_url;
            this.els = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bgd() {
        return this.bCT;
    }

    public String bge() {
        return this.els;
    }

    public void Ah(String str) {
        this.els = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bCT;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bgf() {
        return this.els;
    }
}
