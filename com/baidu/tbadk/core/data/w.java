package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.core.flow.a.a {
    private String bFH;
    private String dIt;
    private String dIu;
    private boolean dIv;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public w(String str, String str2, String str3) {
        this.bFH = str;
        this.dIt = str2;
        this.mTitle = str3;
    }

    public w() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bFH;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String aQn() {
        return this.dIt;
    }

    public String getImageUrl() {
        return this.bFH;
    }

    public void setImageUrl(String str) {
        this.bFH = str;
    }

    public String getLinkUrl() {
        return this.dIt;
    }

    public void setLinkUrl(String str) {
        this.dIt = str;
    }

    public String aQx() {
        return this.tagNameUrl;
    }

    public float aQy() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: aQz */
    public w clone() {
        w wVar = new w();
        wVar.bFH = this.bFH;
        wVar.dIt = this.dIt;
        wVar.mTitle = this.mTitle;
        wVar.mSubTitle = this.mSubTitle;
        wVar.dIu = this.dIu;
        wVar.tagNameUrl = this.tagNameUrl;
        wVar.tagRatio = this.tagRatio;
        return wVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bFH = headImgs.img_url;
            this.dIt = headImgs.pc_url;
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
                this.dIu = headImgs.btn_text.trim();
            }
        }
    }

    public boolean aQA() {
        return this.dIv;
    }

    public void gU(boolean z) {
        this.dIv = z;
    }
}
