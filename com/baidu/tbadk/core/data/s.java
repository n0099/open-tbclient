package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String bYJ;
    private String bYK;
    private String bYL;
    private String bYM;
    private boolean bYN;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.bYJ = str;
        this.bYK = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bYJ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aha() {
        return this.bYK;
    }

    public String getImageUrl() {
        return this.bYJ;
    }

    public void setImageUrl(String str) {
        this.bYJ = str;
    }

    public String getLinkUrl() {
        return this.bYK;
    }

    public void setLinkUrl(String str) {
        this.bYK = str;
    }

    public String ahb() {
        return this.tagNameUrl;
    }

    public float ahc() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ahd */
    public s clone() {
        s sVar = new s();
        sVar.bYJ = this.bYJ;
        sVar.bYK = this.bYK;
        sVar.mTitle = this.mTitle;
        sVar.bYL = this.bYL;
        sVar.bYM = this.bYM;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bYJ = headImgs.img_url;
            this.bYK = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int i = com.baidu.adp.lib.g.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.g.b.toInt(split[1], 1);
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
                this.bYL = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.bYM = headImgs.btn_text.trim();
            }
        }
    }

    public boolean ahe() {
        return this.bYN;
    }

    public void dX(boolean z) {
        this.bYN = z;
    }
}
