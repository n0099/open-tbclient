package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.flow.a.a {
    private String bNJ;
    private String eal;
    private String eam;
    private boolean ean;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public y(String str, String str2, String str3) {
        this.bNJ = str;
        this.eal = str2;
        this.mTitle = str3;
    }

    public y() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bNJ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bdw() {
        return this.eal;
    }

    public String getImageUrl() {
        return this.bNJ;
    }

    public void setImageUrl(String str) {
        this.bNJ = str;
    }

    public String getLinkUrl() {
        return this.eal;
    }

    public void setLinkUrl(String str) {
        this.eal = str;
    }

    public String bdG() {
        return this.tagNameUrl;
    }

    public float bdH() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bdI */
    public y clone() {
        y yVar = new y();
        yVar.bNJ = this.bNJ;
        yVar.eal = this.eal;
        yVar.mTitle = this.mTitle;
        yVar.mSubTitle = this.mSubTitle;
        yVar.eam = this.eam;
        yVar.tagNameUrl = this.tagNameUrl;
        yVar.tagRatio = this.tagRatio;
        return yVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bNJ = headImgs.img_url;
            this.eal = headImgs.pc_url;
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
                this.eam = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bdJ() {
        return this.ean;
    }

    public void hS(boolean z) {
        this.ean = z;
    }
}
