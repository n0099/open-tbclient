package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private String UJ;
    private String UK;
    private String UL;
    private boolean UM;
    private String mImageUrl;
    private String mTitle;

    public i(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.UJ = str2;
        this.mTitle = str3;
    }

    public i() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ry() {
        return this.UJ;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: rz */
    public i clone() {
        i iVar = new i();
        iVar.mImageUrl = this.mImageUrl;
        iVar.UJ = this.UJ;
        iVar.mTitle = this.mTitle;
        iVar.UK = this.UK;
        iVar.UL = this.UL;
        return iVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.UJ = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.UK = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.UL = headImgs.btn_text.trim();
            }
        }
    }

    public boolean rA() {
        return this.UM;
    }

    public void ah(boolean z) {
        this.UM = z;
    }
}
