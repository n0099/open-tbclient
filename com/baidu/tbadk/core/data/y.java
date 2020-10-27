package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.flow.a.a {
    private String ccQ;
    private String euN;
    private String euO;
    private boolean euP;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public y(String str, String str2, String str3) {
        this.ccQ = str;
        this.euN = str2;
        this.mTitle = str3;
    }

    public y() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.ccQ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bhY() {
        return this.euN;
    }

    public String getImageUrl() {
        return this.ccQ;
    }

    public void setImageUrl(String str) {
        this.ccQ = str;
    }

    public String getLinkUrl() {
        return this.euN;
    }

    public void setLinkUrl(String str) {
        this.euN = str;
    }

    public String bii() {
        return this.tagNameUrl;
    }

    public float bij() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bik */
    public y clone() {
        y yVar = new y();
        yVar.ccQ = this.ccQ;
        yVar.euN = this.euN;
        yVar.mTitle = this.mTitle;
        yVar.mSubTitle = this.mSubTitle;
        yVar.euO = this.euO;
        yVar.tagNameUrl = this.tagNameUrl;
        yVar.tagRatio = this.tagRatio;
        return yVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.ccQ = headImgs.img_url;
            this.euN = headImgs.pc_url;
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
                this.euO = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bil() {
        return this.euP;
    }

    public void iB(boolean z) {
        this.euP = z;
    }
}
