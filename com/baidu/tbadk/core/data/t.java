package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.flow.a.a {
    private String cKw;
    private String cKx;
    private boolean cKy;
    private String mImageUrl;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public t(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.cKw = str2;
        this.mTitle = str3;
    }

    public t() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String ayl() {
        return this.cKw;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getLinkUrl() {
        return this.cKw;
    }

    public void setLinkUrl(String str) {
        this.cKw = str;
    }

    public String aym() {
        return this.tagNameUrl;
    }

    public float ayn() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: ayo */
    public t clone() {
        t tVar = new t();
        tVar.mImageUrl = this.mImageUrl;
        tVar.cKw = this.cKw;
        tVar.mTitle = this.mTitle;
        tVar.mSubTitle = this.mSubTitle;
        tVar.cKx = this.cKx;
        tVar.tagNameUrl = this.tagNameUrl;
        tVar.tagRatio = this.tagRatio;
        return tVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.cKw = headImgs.pc_url;
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
                this.cKx = headImgs.btn_text.trim();
            }
        }
    }

    public boolean ayp() {
        return this.cKy;
    }

    public void fq(boolean z) {
        this.cKy = z;
    }
}
