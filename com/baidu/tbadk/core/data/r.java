package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.flow.a.a {
    private String afv;
    private String afw;
    private String afx;
    private String afy;
    private boolean afz;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public r(String str, String str2, String str3) {
        this.afv = str;
        this.afw = str2;
        this.mTitle = str3;
    }

    public r() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.afv;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String tW() {
        return this.afw;
    }

    public String getImageUrl() {
        return this.afv;
    }

    public void setImageUrl(String str) {
        this.afv = str;
    }

    public String getLinkUrl() {
        return this.afw;
    }

    public void setLinkUrl(String str) {
        this.afw = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String tX() {
        return this.tagNameUrl;
    }

    public float tY() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: tZ */
    public r clone() {
        r rVar = new r();
        rVar.afv = this.afv;
        rVar.afw = this.afw;
        rVar.mTitle = this.mTitle;
        rVar.afx = this.afx;
        rVar.afy = this.afy;
        rVar.tagNameUrl = this.tagNameUrl;
        rVar.tagRatio = this.tagRatio;
        return rVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.afv = headImgs.img_url;
            this.afw = headImgs.pc_url;
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
                this.afx = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.afy = headImgs.btn_text.trim();
            }
        }
    }

    public boolean ua() {
        return this.afz;
    }

    public void aq(boolean z) {
        this.afz = z;
    }
}
