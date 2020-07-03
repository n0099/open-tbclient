package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String bmW;
    private String dHI;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bmW = bannerImage.img_url;
            this.dHI = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String aQl() {
        return this.bmW;
    }

    public String aQm() {
        return this.dHI;
    }

    public void vE(String str) {
        this.dHI = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bmW;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aQn() {
        return this.dHI;
    }
}
