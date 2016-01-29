package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.flow.a.a {
    private String Vm;
    private String Vn;
    private String Vo;
    private boolean Vp;
    private String mImageUrl;
    private String mTitle;

    public k(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.Vm = str2;
        this.mTitle = str3;
    }

    public k() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rX() {
        return this.Vm;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: rY */
    public k clone() {
        k kVar = new k();
        kVar.mImageUrl = this.mImageUrl;
        kVar.Vm = this.Vm;
        kVar.mTitle = this.mTitle;
        kVar.Vn = this.Vn;
        kVar.Vo = this.Vo;
        return kVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.Vm = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.Vn = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Vo = headImgs.btn_text.trim();
            }
        }
    }

    public boolean rZ() {
        return this.Vp;
    }

    public void ah(boolean z) {
        this.Vp = z;
    }
}
