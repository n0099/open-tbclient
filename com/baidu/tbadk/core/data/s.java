package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String byg;
    private String byh;
    private String byi;
    private String byj;
    private boolean byk;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.byg = str;
        this.byh = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.byg;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xi() {
        return this.byh;
    }

    public String getImageUrl() {
        return this.byg;
    }

    public void setImageUrl(String str) {
        this.byg = str;
    }

    public String getLinkUrl() {
        return this.byh;
    }

    public void setLinkUrl(String str) {
        this.byh = str;
    }

    public String Xj() {
        return this.tagNameUrl;
    }

    public float Xk() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Xl */
    public s clone() {
        s sVar = new s();
        sVar.byg = this.byg;
        sVar.byh = this.byh;
        sVar.mTitle = this.mTitle;
        sVar.byi = this.byi;
        sVar.byj = this.byj;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.byg = headImgs.img_url;
            this.byh = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                    int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                    if (l2 != 0) {
                        this.tagRatio = l / l2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.byi = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.byj = headImgs.btn_text.trim();
            }
        }
    }

    public boolean Xm() {
        return this.byk;
    }

    public void di(boolean z) {
        this.byk = z;
    }
}
