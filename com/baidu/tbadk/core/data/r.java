package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.flow.a.a {
    private boolean QA;
    private String Qy;
    private String Qz;
    private String mImageUrl;
    private String mSubTitle;
    private String mTitle;

    public r(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.Qy = str2;
        this.mTitle = str3;
    }

    public r() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.Qy;
    }

    public String getLinkUrl() {
        return this.Qy;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pE */
    public r clone() {
        r rVar = new r();
        rVar.mImageUrl = this.mImageUrl;
        rVar.Qy = this.Qy;
        rVar.mTitle = this.mTitle;
        rVar.mSubTitle = this.mSubTitle;
        rVar.Qz = this.Qz;
        return rVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.Qy = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.mSubTitle = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Qz = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pF() {
        return this.QA;
    }

    public void al(boolean z) {
        this.QA = z;
    }
}
