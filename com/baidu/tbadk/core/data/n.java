package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.flow.a.a {
    private String SW;
    private String SX;
    private String SY;
    private boolean SZ;
    private String mImageUrl;
    private String mTitle;

    public n(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.SW = str2;
        this.mTitle = str3;
    }

    public n() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rA() {
        return this.SW;
    }

    public String getLinkUrl() {
        return this.SW;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: rB */
    public n clone() {
        n nVar = new n();
        nVar.mImageUrl = this.mImageUrl;
        nVar.SW = this.SW;
        nVar.mTitle = this.mTitle;
        nVar.SX = this.SX;
        nVar.SY = this.SY;
        return nVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.SW = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.SX = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.SY = headImgs.btn_text.trim();
            }
        }
    }

    public boolean rC() {
        return this.SZ;
    }

    public void ag(boolean z) {
        this.SZ = z;
    }
}
