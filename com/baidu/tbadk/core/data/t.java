package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.flow.a.a {
    private String btq;
    private String dnX;
    private String dnY;
    private boolean dnZ;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public t(String str, String str2, String str3) {
        this.btq = str;
        this.dnX = str2;
        this.mTitle = str3;
    }

    public t() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.btq;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aIP() {
        return this.dnX;
    }

    public String getImageUrl() {
        return this.btq;
    }

    public void setImageUrl(String str) {
        this.btq = str;
    }

    public String getLinkUrl() {
        return this.dnX;
    }

    public void setLinkUrl(String str) {
        this.dnX = str;
    }

    public String aIQ() {
        return this.tagNameUrl;
    }

    public float aIR() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aIS */
    public t clone() {
        t tVar = new t();
        tVar.btq = this.btq;
        tVar.dnX = this.dnX;
        tVar.mTitle = this.mTitle;
        tVar.mSubTitle = this.mSubTitle;
        tVar.dnY = this.dnY;
        tVar.tagNameUrl = this.tagNameUrl;
        tVar.tagRatio = this.tagRatio;
        return tVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.btq = headImgs.img_url;
            this.dnX = headImgs.pc_url;
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
                this.dnY = headImgs.btn_text.trim();
            }
        }
    }

    public boolean aIT() {
        return this.dnZ;
    }

    public void gv(boolean z) {
        this.dnZ = z;
    }
}
