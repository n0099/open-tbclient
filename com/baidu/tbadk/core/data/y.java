package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.flow.a.a {
    private String ciC;
    private String eAG;
    private String eAH;
    private boolean eAI;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public y(String str, String str2, String str3) {
        this.ciC = str;
        this.eAG = str2;
        this.mTitle = str3;
    }

    public y() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.ciC;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bky() {
        return this.eAG;
    }

    public String getImageUrl() {
        return this.ciC;
    }

    public void setImageUrl(String str) {
        this.ciC = str;
    }

    public String getLinkUrl() {
        return this.eAG;
    }

    public void setLinkUrl(String str) {
        this.eAG = str;
    }

    public String bkI() {
        return this.tagNameUrl;
    }

    public float bkJ() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bkK */
    public y clone() {
        y yVar = new y();
        yVar.ciC = this.ciC;
        yVar.eAG = this.eAG;
        yVar.mTitle = this.mTitle;
        yVar.mSubTitle = this.mSubTitle;
        yVar.eAH = this.eAH;
        yVar.tagNameUrl = this.tagNameUrl;
        yVar.tagRatio = this.tagRatio;
        return yVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.ciC = headImgs.img_url;
            this.eAG = headImgs.pc_url;
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
                this.eAH = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bkL() {
        return this.eAI;
    }

    public void iK(boolean z) {
        this.eAI = z;
    }
}
