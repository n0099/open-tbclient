package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String NP;
    private String NQ;
    private boolean NR;
    private String mImageUrl;
    private String mSubTitle;
    private String mTitle;

    public q(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.NP = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.NP;
    }

    public String getLinkUrl() {
        return this.NP;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: oB */
    public q clone() {
        q qVar = new q();
        qVar.mImageUrl = this.mImageUrl;
        qVar.NP = this.NP;
        qVar.mTitle = this.mTitle;
        qVar.mSubTitle = this.mSubTitle;
        qVar.NQ = this.NQ;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.NP = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.mSubTitle = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.NQ = headImgs.btn_text.trim();
            }
        }
    }

    public boolean oC() {
        return this.NR;
    }

    public void aj(boolean z) {
        this.NR = z;
    }
}
