package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String bAT;
    private String dBY;
    private String dBZ;
    private boolean dCa;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.bAT = str;
        this.dBY = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bAT;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aOK() {
        return this.dBY;
    }

    public String getImageUrl() {
        return this.bAT;
    }

    public void setImageUrl(String str) {
        this.bAT = str;
    }

    public String getLinkUrl() {
        return this.dBY;
    }

    public void setLinkUrl(String str) {
        this.dBY = str;
    }

    public String aOL() {
        return this.tagNameUrl;
    }

    public float aOM() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aON */
    public s clone() {
        s sVar = new s();
        sVar.bAT = this.bAT;
        sVar.dBY = this.dBY;
        sVar.mTitle = this.mTitle;
        sVar.mSubTitle = this.mSubTitle;
        sVar.dBZ = this.dBZ;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bAT = headImgs.img_url;
            this.dBY = headImgs.pc_url;
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
                this.dBZ = headImgs.btn_text.trim();
            }
        }
    }

    public boolean aOO() {
        return this.dCa;
    }

    public void gN(boolean z) {
        this.dCa = z;
    }
}
