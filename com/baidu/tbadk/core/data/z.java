package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.flow.a.a {
    private String cny;
    private String eFW;
    private String eFX;
    private boolean eFY;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public z(String str, String str2, String str3) {
        this.cny = str;
        this.eFW = str2;
        this.mTitle = str3;
    }

    public z() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cny;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bmN() {
        return this.eFW;
    }

    public String getImageUrl() {
        return this.cny;
    }

    public void setImageUrl(String str) {
        this.cny = str;
    }

    public String getLinkUrl() {
        return this.eFW;
    }

    public void setLinkUrl(String str) {
        this.eFW = str;
    }

    public String bmX() {
        return this.tagNameUrl;
    }

    public float bmY() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bmZ */
    public z clone() {
        z zVar = new z();
        zVar.cny = this.cny;
        zVar.eFW = this.eFW;
        zVar.mTitle = this.mTitle;
        zVar.mSubTitle = this.mSubTitle;
        zVar.eFX = this.eFX;
        zVar.tagNameUrl = this.tagNameUrl;
        zVar.tagRatio = this.tagRatio;
        return zVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.cny = headImgs.img_url;
            this.eFW = headImgs.pc_url;
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
                this.eFX = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bna() {
        return this.eFY;
    }

    public void ja(boolean z) {
        this.eFY = z;
    }
}
