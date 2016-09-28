package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.flow.a.a {
    private float PE;
    private String Qw;
    private String Qx;
    private boolean Qy;
    private String mImageUrl;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;

    public r(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.Qw = str2;
        this.mTitle = str3;
    }

    public r() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicLinkUrl() {
        return this.Qw;
    }

    public String getLinkUrl() {
        return this.Qw;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String pF() {
        return this.tagNameUrl;
    }

    public float pG() {
        return this.PE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pH */
    public r clone() {
        r rVar = new r();
        rVar.mImageUrl = this.mImageUrl;
        rVar.Qw = this.Qw;
        rVar.mTitle = this.mTitle;
        rVar.mSubTitle = this.mSubTitle;
        rVar.Qx = this.Qx;
        rVar.tagNameUrl = this.tagNameUrl;
        rVar.PE = this.PE;
        return rVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.Qw = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.PE = g / g2;
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
                this.Qx = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pI() {
        return this.Qy;
    }

    public void al(boolean z) {
        this.Qy = z;
    }
}
