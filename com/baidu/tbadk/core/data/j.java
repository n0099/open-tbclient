package com.baidu.tbadk.core.data;

import tbclient.BannerImage;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.core.flow.a.a {
    private String bFP;
    private String etS;
    private String mTitle;

    public void a(BannerImage bannerImage) {
        if (bannerImage != null) {
            this.bFP = bannerImage.img_url;
            this.etS = bannerImage.ahead_url;
            this.mTitle = bannerImage.title;
        }
    }

    public String bhW() {
        return this.bFP;
    }

    public String bhX() {
        return this.etS;
    }

    public void AA(String str) {
        this.etS = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bFP;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bhY() {
        return this.etS;
    }
}
