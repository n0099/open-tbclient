package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.flow.a.a {
    private float PT;
    private String QL;
    private String QM;
    private boolean QN;
    private String mImageUrl;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;

    public r(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.QL = str2;
        this.mTitle = str3;
    }

    public r() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pI() {
        return this.QL;
    }

    public String getLinkUrl() {
        return this.QL;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String pJ() {
        return this.tagNameUrl;
    }

    public float pK() {
        return this.PT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pL */
    public r clone() {
        r rVar = new r();
        rVar.mImageUrl = this.mImageUrl;
        rVar.QL = this.QL;
        rVar.mTitle = this.mTitle;
        rVar.mSubTitle = this.mSubTitle;
        rVar.QM = this.QM;
        rVar.tagNameUrl = this.tagNameUrl;
        rVar.PT = this.PT;
        return rVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.QL = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.PT = g / g2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.mSubTitle = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.QM = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pM() {
        return this.QN;
    }

    public void an(boolean z) {
        this.QN = z;
    }
}
