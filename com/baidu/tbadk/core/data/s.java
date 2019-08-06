package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String bGA;
    private String bGB;
    private String bGC;
    private String bGD;
    private boolean bGE;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.bGA = str;
        this.bGB = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bGA;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acQ() {
        return this.bGB;
    }

    public String getImageUrl() {
        return this.bGA;
    }

    public void setImageUrl(String str) {
        this.bGA = str;
    }

    public String getLinkUrl() {
        return this.bGB;
    }

    public void setLinkUrl(String str) {
        this.bGB = str;
    }

    public String acR() {
        return this.tagNameUrl;
    }

    public float acS() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: acT */
    public s clone() {
        s sVar = new s();
        sVar.bGA = this.bGA;
        sVar.bGB = this.bGB;
        sVar.mTitle = this.mTitle;
        sVar.bGC = this.bGC;
        sVar.bGD = this.bGD;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bGA = headImgs.img_url;
            this.bGB = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int f = com.baidu.adp.lib.g.b.f(split[0], 1);
                    int f2 = com.baidu.adp.lib.g.b.f(split[1], 1);
                    if (f2 != 0) {
                        this.tagRatio = f / f2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.bGC = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.bGD = headImgs.btn_text.trim();
            }
        }
    }

    public boolean acU() {
        return this.bGE;
    }

    public void dH(boolean z) {
        this.bGE = z;
    }
}
