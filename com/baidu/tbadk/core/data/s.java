package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String bGY;
    private String bGZ;
    private String bHa;
    private String bHb;
    private boolean bHc;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.bGY = str;
        this.bGZ = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.bGY;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String acU() {
        return this.bGZ;
    }

    public String getImageUrl() {
        return this.bGY;
    }

    public void setImageUrl(String str) {
        this.bGY = str;
    }

    public String getLinkUrl() {
        return this.bGZ;
    }

    public void setLinkUrl(String str) {
        this.bGZ = str;
    }

    public String acV() {
        return this.tagNameUrl;
    }

    public float acW() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: acX */
    public s clone() {
        s sVar = new s();
        sVar.bGY = this.bGY;
        sVar.bGZ = this.bGZ;
        sVar.mTitle = this.mTitle;
        sVar.bHa = this.bHa;
        sVar.bHb = this.bHb;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.bGY = headImgs.img_url;
            this.bGZ = headImgs.pc_url;
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
                this.bHa = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.bHb = headImgs.btn_text.trim();
            }
        }
    }

    public boolean acY() {
        return this.bHc;
    }

    public void dH(boolean z) {
        this.bHc = z;
    }
}
