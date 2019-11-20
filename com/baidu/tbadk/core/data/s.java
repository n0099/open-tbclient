package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String bXS;
    private String bXT;
    private String bXU;
    private String bXV;
    private boolean bXW;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.bXS = str;
        this.bXT = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bXS;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String agY() {
        return this.bXT;
    }

    public String getImageUrl() {
        return this.bXS;
    }

    public void setImageUrl(String str) {
        this.bXS = str;
    }

    public String getLinkUrl() {
        return this.bXT;
    }

    public void setLinkUrl(String str) {
        this.bXT = str;
    }

    public String agZ() {
        return this.tagNameUrl;
    }

    public float aha() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ahb */
    public s clone() {
        s sVar = new s();
        sVar.bXS = this.bXS;
        sVar.bXT = this.bXT;
        sVar.mTitle = this.mTitle;
        sVar.bXU = this.bXU;
        sVar.bXV = this.bXV;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bXS = headImgs.img_url;
            this.bXT = headImgs.pc_url;
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
                this.bXU = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.bXV = headImgs.btn_text.trim();
            }
        }
    }

    public boolean ahc() {
        return this.bXW;
    }

    public void dX(boolean z) {
        this.bXW = z;
    }
}
