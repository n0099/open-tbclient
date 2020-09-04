package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.flow.a.a {
    private String bLJ;
    private String dYb;
    private String dYc;
    private boolean dYd;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public y(String str, String str2, String str3) {
        this.bLJ = str;
        this.dYb = str2;
        this.mTitle = str3;
    }

    public y() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bLJ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        return this.dYb;
    }

    public String getImageUrl() {
        return this.bLJ;
    }

    public void setImageUrl(String str) {
        this.bLJ = str;
    }

    public String getLinkUrl() {
        return this.dYb;
    }

    public void setLinkUrl(String str) {
        this.dYb = str;
    }

    public String bcM() {
        return this.tagNameUrl;
    }

    public float bcN() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bcO */
    public y clone() {
        y yVar = new y();
        yVar.bLJ = this.bLJ;
        yVar.dYb = this.dYb;
        yVar.mTitle = this.mTitle;
        yVar.mSubTitle = this.mSubTitle;
        yVar.dYc = this.dYc;
        yVar.tagNameUrl = this.tagNameUrl;
        yVar.tagRatio = this.tagRatio;
        return yVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bLJ = headImgs.img_url;
            this.dYb = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                this.dYc = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bcP() {
        return this.dYd;
    }

    public void hV(boolean z) {
        this.dYd = z;
    }
}
