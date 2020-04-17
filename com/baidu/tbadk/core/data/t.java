package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.flow.a.a {
    private String btm;
    private String dnT;
    private String dnU;
    private boolean dnV;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public t(String str, String str2, String str3) {
        this.btm = str;
        this.dnT = str2;
        this.mTitle = str3;
    }

    public t() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.btm;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aIR() {
        return this.dnT;
    }

    public String getImageUrl() {
        return this.btm;
    }

    public void setImageUrl(String str) {
        this.btm = str;
    }

    public String getLinkUrl() {
        return this.dnT;
    }

    public void setLinkUrl(String str) {
        this.dnT = str;
    }

    public String aIS() {
        return this.tagNameUrl;
    }

    public float aIT() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aIU */
    public t clone() {
        t tVar = new t();
        tVar.btm = this.btm;
        tVar.dnT = this.dnT;
        tVar.mTitle = this.mTitle;
        tVar.mSubTitle = this.mSubTitle;
        tVar.dnU = this.dnU;
        tVar.tagNameUrl = this.tagNameUrl;
        tVar.tagRatio = this.tagRatio;
        return tVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.btm = headImgs.img_url;
            this.dnT = headImgs.pc_url;
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
                this.dnU = headImgs.btn_text.trim();
            }
        }
    }

    public boolean aIV() {
        return this.dnV;
    }

    public void gv(boolean z) {
        this.dnV = z;
    }
}
