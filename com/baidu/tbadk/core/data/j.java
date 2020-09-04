package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String bsZ;
    private String dXg;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bsZ = bannerImage.img_url;
            this.dXg = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bcA() {
        return this.bsZ;
    }

    public String bcB() {
        return this.dXg;
    }

    public void za(String str) {
        this.dXg = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bsZ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        return this.dXg;
    }
}
