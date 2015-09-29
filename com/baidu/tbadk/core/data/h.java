package com.baidu.tbadk.core.data;

import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.flow.a.a {
    private String UH;
    private String UI;
    private String UJ;
    private boolean UK;
    private String mImageUrl;
    private String mTitle;

    public h(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.UH = str2;
        this.mTitle = str3;
    }

    public h() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ry() {
        return this.UH;
    }

    public String getTitle() {
        return this.mTitle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: rz */
    public h clone() {
        h hVar = new h();
        hVar.mImageUrl = this.mImageUrl;
        hVar.UH = this.UH;
        hVar.mTitle = this.mTitle;
        hVar.UI = this.UI;
        hVar.UJ = this.UJ;
        return hVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.UH = headImgs.pc_url;
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.UI = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.UJ = headImgs.btn_text.trim();
            }
        }
    }

    public boolean rA() {
        return this.UK;
    }

    public void ah(boolean z) {
        this.UK = z;
    }
}
