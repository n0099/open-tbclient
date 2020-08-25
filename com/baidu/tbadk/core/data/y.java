package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes2.dex */
public class y implements com.baidu.tbadk.core.flow.a.a {
    private String bLF;
    private String dXX;
    private String dXY;
    private boolean dXZ;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public y(String str, String str2, String str3) {
        this.bLF = str;
        this.dXX = str2;
        this.mTitle = str3;
    }

    public y() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bLF;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bcC() {
        return this.dXX;
    }

    public String getImageUrl() {
        return this.bLF;
    }

    public void setImageUrl(String str) {
        this.bLF = str;
    }

    public String getLinkUrl() {
        return this.dXX;
    }

    public void setLinkUrl(String str) {
        this.dXX = str;
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
        yVar.bLF = this.bLF;
        yVar.dXX = this.dXX;
        yVar.mTitle = this.mTitle;
        yVar.mSubTitle = this.mSubTitle;
        yVar.dXY = this.dXY;
        yVar.tagNameUrl = this.tagNameUrl;
        yVar.tagRatio = this.tagRatio;
        return yVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bLF = headImgs.img_url;
            this.dXX = headImgs.pc_url;
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
                this.dXY = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bcP() {
        return this.dXZ;
    }

    public void hU(boolean z) {
        this.dXZ = z;
    }
}
