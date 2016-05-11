package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.flow.a.a {
    private String NI;
    private String NJ;
    private String NK;
    private boolean NL;
    private String mImageUrl;
    private String mTitle;

    public n(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.NI = str2;
        this.mTitle = str3;
    }

    public n() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String oU() {
        return this.NI;
    }

    public String getLinkUrl() {
        return this.NI;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: oV */
    public n clone() {
        n nVar = new n();
        nVar.mImageUrl = this.mImageUrl;
        nVar.NI = this.NI;
        nVar.mTitle = this.mTitle;
        nVar.NJ = this.NJ;
        nVar.NK = this.NK;
        return nVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.NI = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.NJ = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.NK = headImgs.btn_text.trim();
            }
        }
    }

    public boolean oW() {
        return this.NL;
    }

    public void aj(boolean z) {
        this.NL = z;
    }
}
