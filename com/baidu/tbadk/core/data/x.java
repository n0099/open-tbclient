package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.core.flow.a.a {
    private String bGf;
    private String dOE;
    private String dOF;
    private boolean dOG;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public x(String str, String str2, String str3) {
        this.bGf = str;
        this.dOE = str2;
        this.mTitle = str3;
    }

    public x() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bGf;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aUj() {
        return this.dOE;
    }

    public String getImageUrl() {
        return this.bGf;
    }

    public void setImageUrl(String str) {
        this.bGf = str;
    }

    public String getLinkUrl() {
        return this.dOE;
    }

    public void setLinkUrl(String str) {
        this.dOE = str;
    }

    public String aUt() {
        return this.tagNameUrl;
    }

    public float aUu() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aUv */
    public x clone() {
        x xVar = new x();
        xVar.bGf = this.bGf;
        xVar.dOE = this.dOE;
        xVar.mTitle = this.mTitle;
        xVar.mSubTitle = this.mSubTitle;
        xVar.dOF = this.dOF;
        xVar.tagNameUrl = this.tagNameUrl;
        xVar.tagRatio = this.tagRatio;
        return xVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bGf = headImgs.img_url;
            this.dOE = headImgs.pc_url;
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
                this.dOF = headImgs.btn_text.trim();
            }
        }
    }

    public boolean aUw() {
        return this.dOG;
    }

    public void hy(boolean z) {
        this.dOG = z;
    }
}
