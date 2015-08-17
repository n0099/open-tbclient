package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private String US;
    private String UT;
    private String UU;
    private boolean UV;
    private String mImageUrl;
    private String mTitle;

    public i(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.US = str2;
        this.mTitle = str3;
    }

    public i() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rE() {
        return this.US;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: rF */
    public i clone() {
        i iVar = new i();
        iVar.mImageUrl = this.mImageUrl;
        iVar.US = this.US;
        iVar.mTitle = this.mTitle;
        iVar.UT = this.UT;
        iVar.UU = this.UU;
        return iVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.US = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.UT = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.UU = headImgs.btn_text.trim();
            }
        }
    }

    public boolean rG() {
        return this.UV;
    }

    public void ah(boolean z) {
        this.UV = z;
    }
}
