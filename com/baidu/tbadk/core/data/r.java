package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.flow.a.a {
    private String Xt;
    private String Xu;
    private String Xv;
    private String Xw;
    private boolean Xx;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public r(String str, String str2, String str3) {
        this.Xt = str;
        this.Xu = str2;
        this.mTitle = str3;
    }

    public r() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.Xt;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String qB() {
        return this.Xu;
    }

    public String getImageUrl() {
        return this.Xt;
    }

    public void setImageUrl(String str) {
        this.Xt = str;
    }

    public String getLinkUrl() {
        return this.Xu;
    }

    public void setLinkUrl(String str) {
        this.Xu = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String qC() {
        return this.tagNameUrl;
    }

    public float qD() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: qE */
    public r clone() {
        r rVar = new r();
        rVar.Xt = this.Xt;
        rVar.Xu = this.Xu;
        rVar.mTitle = this.mTitle;
        rVar.Xv = this.Xv;
        rVar.Xw = this.Xw;
        rVar.tagNameUrl = this.tagNameUrl;
        rVar.tagRatio = this.tagRatio;
        return rVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.Xt = headImgs.img_url;
            this.Xu = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.tagRatio = g / g2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.Xv = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Xw = headImgs.btn_text.trim();
            }
        }
    }

    public boolean qF() {
        return this.Xx;
    }

    public void an(boolean z) {
        this.Xx = z;
    }
}
