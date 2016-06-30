package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.core.flow.a.a {
    private String NH;
    private String NI;
    private String NJ;
    private boolean NK;
    private String mImageUrl;
    private String mTitle;

    public p(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.NH = str2;
        this.mTitle = str3;
    }

    public p() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.NH;
    }

    public String getLinkUrl() {
        return this.NH;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: oM */
    public p clone() {
        p pVar = new p();
        pVar.mImageUrl = this.mImageUrl;
        pVar.NH = this.NH;
        pVar.mTitle = this.mTitle;
        pVar.NI = this.NI;
        pVar.NJ = this.NJ;
        return pVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.NH = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.NI = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.NJ = headImgs.btn_text.trim();
            }
        }
    }

    public boolean oN() {
        return this.NK;
    }

    public void ah(boolean z) {
        this.NK = z;
    }
}
