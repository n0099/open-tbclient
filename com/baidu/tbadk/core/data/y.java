package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.flow.a.a {
    private String bUs;
    private String emn;
    private String emo;
    private boolean emp;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public y(String str, String str2, String str3) {
        this.bUs = str;
        this.emn = str2;
        this.mTitle = str3;
    }

    public y() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bUs;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bgf() {
        return this.emn;
    }

    public String getImageUrl() {
        return this.bUs;
    }

    public void setImageUrl(String str) {
        this.bUs = str;
    }

    public String getLinkUrl() {
        return this.emn;
    }

    public void setLinkUrl(String str) {
        this.emn = str;
    }

    public String bgp() {
        return this.tagNameUrl;
    }

    public float bgq() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bgr */
    public y clone() {
        y yVar = new y();
        yVar.bUs = this.bUs;
        yVar.emn = this.emn;
        yVar.mTitle = this.mTitle;
        yVar.mSubTitle = this.mSubTitle;
        yVar.emo = this.emo;
        yVar.tagNameUrl = this.tagNameUrl;
        yVar.tagRatio = this.tagRatio;
        return yVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bUs = headImgs.img_url;
            this.emn = headImgs.pc_url;
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
                this.emo = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bgs() {
        return this.emp;
    }

    public void io(boolean z) {
        this.emp = z;
    }
}
