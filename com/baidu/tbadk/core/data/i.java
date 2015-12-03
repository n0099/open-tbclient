package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private String Vb;
    private String Vc;
    private String Vd;
    private boolean Ve;
    private String mImageUrl;
    private String mTitle;

    public i(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.Vb = str2;
        this.mTitle = str3;
    }

    public i() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rK() {
        return this.Vb;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: rL */
    public i clone() {
        i iVar = new i();
        iVar.mImageUrl = this.mImageUrl;
        iVar.Vb = this.Vb;
        iVar.mTitle = this.mTitle;
        iVar.Vc = this.Vc;
        iVar.Vd = this.Vd;
        return iVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.Vb = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.Vc = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Vd = headImgs.btn_text.trim();
            }
        }
    }

    public boolean rM() {
        return this.Ve;
    }

    public void aj(boolean z) {
        this.Ve = z;
    }
}
