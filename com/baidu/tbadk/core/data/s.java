package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String bFA;
    private String bFB;
    private boolean bFC;
    private String bFy;
    private String bFz;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.bFy = str;
        this.bFz = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bFy;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String abN() {
        return this.bFz;
    }

    public String getImageUrl() {
        return this.bFy;
    }

    public void setImageUrl(String str) {
        this.bFy = str;
    }

    public String getLinkUrl() {
        return this.bFz;
    }

    public void setLinkUrl(String str) {
        this.bFz = str;
    }

    public String abO() {
        return this.tagNameUrl;
    }

    public float abP() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: abQ */
    public s clone() {
        s sVar = new s();
        sVar.bFy = this.bFy;
        sVar.bFz = this.bFz;
        sVar.mTitle = this.mTitle;
        sVar.bFA = this.bFA;
        sVar.bFB = this.bFB;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bFy = headImgs.img_url;
            this.bFz = headImgs.pc_url;
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
                this.bFA = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.bFB = headImgs.btn_text.trim();
            }
        }
    }

    public boolean abR() {
        return this.bFC;
    }

    public void dD(boolean z) {
        this.bFC = z;
    }
}
