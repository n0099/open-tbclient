package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.flow.a.a {
    private String cpN;
    private String eLb;
    private String eLc;
    private boolean eLd;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public z(String str, String str2, String str3) {
        this.cpN = str;
        this.eLb = str2;
        this.mTitle = str3;
    }

    public z() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cpN;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blt() {
        return this.eLb;
    }

    public String getImageUrl() {
        return this.cpN;
    }

    public void setImageUrl(String str) {
        this.cpN = str;
    }

    public String getLinkUrl() {
        return this.eLb;
    }

    public void setLinkUrl(String str) {
        this.eLb = str;
    }

    public String blD() {
        return this.tagNameUrl;
    }

    public float blE() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: blF */
    public z clone() {
        z zVar = new z();
        zVar.cpN = this.cpN;
        zVar.eLb = this.eLb;
        zVar.mTitle = this.mTitle;
        zVar.mSubTitle = this.mSubTitle;
        zVar.eLc = this.eLc;
        zVar.tagNameUrl = this.tagNameUrl;
        zVar.tagRatio = this.tagRatio;
        return zVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.cpN = headImgs.img_url;
            this.eLb = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.tagRatio = i / i2;
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
                this.eLc = headImgs.btn_text.trim();
            }
        }
    }

    public boolean blG() {
        return this.eLd;
    }

    public void jr(boolean z) {
        this.eLd = z;
    }
}
