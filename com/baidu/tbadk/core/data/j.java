package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String bnr;
    private String dNT;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bnr = bannerImage.img_url;
            this.dNT = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String aUh() {
        return this.bnr;
    }

    public String aUi() {
        return this.dNT;
    }

    public void wL(String str) {
        this.dNT = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bnr;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aUj() {
        return this.dNT;
    }
}
