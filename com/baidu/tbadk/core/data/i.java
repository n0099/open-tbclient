package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private String UK;
    private String UL;
    private String UM;
    private boolean UN;
    private String mImageUrl;
    private String mTitle;

    public i(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.UK = str2;
        this.mTitle = str3;
    }

    public i() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rw() {
        return this.UK;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: rx */
    public i clone() {
        i iVar = new i();
        iVar.mImageUrl = this.mImageUrl;
        iVar.UK = this.UK;
        iVar.mTitle = this.mTitle;
        iVar.UL = this.UL;
        iVar.UM = this.UM;
        return iVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.UK = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.UL = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.UM = headImgs.btn_text.trim();
            }
        }
    }

    public boolean ry() {
        return this.UN;
    }

    public void ah(boolean z) {
        this.UN = z;
    }
}
