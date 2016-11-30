package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private float PY;
    private String QO;
    private String QP;
    private boolean QR;
    private String mImageUrl;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;

    public s(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.QO = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.QO;
    }

    public String getLinkUrl() {
        return this.QO;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String pI() {
        return this.tagNameUrl;
    }

    public float pJ() {
        return this.PY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pK */
    public s clone() {
        s sVar = new s();
        sVar.mImageUrl = this.mImageUrl;
        sVar.QO = this.QO;
        sVar.mTitle = this.mTitle;
        sVar.mSubTitle = this.mSubTitle;
        sVar.QP = this.QP;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.PY = this.PY;
        return sVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.QO = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.PY = g / g2;
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
                this.QP = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pL() {
        return this.QR;
    }

    public void an(boolean z) {
        this.QR = z;
    }
}
