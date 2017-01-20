package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String PV;
    private String PW;
    private boolean PX;
    private String mImageUrl;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.PV = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pB() {
        return this.PV;
    }

    public String getLinkUrl() {
        return this.PV;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String pC() {
        return this.tagNameUrl;
    }

    public float pD() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pE */
    public s clone() {
        s sVar = new s();
        sVar.mImageUrl = this.mImageUrl;
        sVar.PV = this.PV;
        sVar.mTitle = this.mTitle;
        sVar.mSubTitle = this.mSubTitle;
        sVar.PW = this.PW;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.PV = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.tagRatio = g / g2;
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
                this.PW = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pF() {
        return this.PX;
    }

    public void an(boolean z) {
        this.PX = z;
    }
}
