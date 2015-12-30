package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.core.flow.a.a {
    private String VB;
    private String VC;
    private String VD;
    private boolean VE;
    private String mImageUrl;
    private String mTitle;

    public i(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.VB = str2;
        this.mTitle = str3;
    }

    public i() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String rt() {
        return this.VB;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ru */
    public i clone() {
        i iVar = new i();
        iVar.mImageUrl = this.mImageUrl;
        iVar.VB = this.VB;
        iVar.mTitle = this.mTitle;
        iVar.VC = this.VC;
        iVar.VD = this.VD;
        return iVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.VB = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.VC = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.VD = headImgs.btn_text.trim();
            }
        }
    }

    public boolean rv() {
        return this.VE;
    }

    public void ag(boolean z) {
        this.VE = z;
    }
}
