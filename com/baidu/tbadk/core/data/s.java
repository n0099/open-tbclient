package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String byi;
    private String byj;
    private String byk;
    private String byl;
    private boolean bym;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.byi = str;
        this.byj = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.byi;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xi() {
        return this.byj;
    }

    public String getImageUrl() {
        return this.byi;
    }

    public void setImageUrl(String str) {
        this.byi = str;
    }

    public String getLinkUrl() {
        return this.byj;
    }

    public void setLinkUrl(String str) {
        this.byj = str;
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
        sVar.byi = this.byi;
        sVar.byj = this.byj;
        sVar.mTitle = this.mTitle;
        sVar.byk = this.byk;
        sVar.byl = this.byl;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.byi = headImgs.img_url;
            this.byj = headImgs.pc_url;
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
                this.byk = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.byl = headImgs.btn_text.trim();
            }
        }
    }

    public boolean Xm() {
        return this.bym;
    }

    public void di(boolean z) {
        this.bym = z;
    }
}
