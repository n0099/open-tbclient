package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes2.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String bsW;
    private String dXc;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bsW = bannerImage.img_url;
            this.dXc = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bcA() {
        return this.bsW;
    }

    public String bcB() {
        return this.dXc;
    }

    public void yZ(String str) {
        this.dXc = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bsW;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        return this.dXc;
    }
}
