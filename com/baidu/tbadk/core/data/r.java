package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.flow.a.a {
    private String Xu;
    private String Xv;
    private String Xw;
    private String Xx;
    private boolean Xy;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public r(String str, String str2, String str3) {
        this.Xu = str;
        this.Xv = str2;
        this.mTitle = str3;
    }

    public r() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.Xu;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String qA() {
        return this.Xv;
    }

    public String getImageUrl() {
        return this.Xu;
    }

    public void setImageUrl(String str) {
        this.Xu = str;
    }

    public String getLinkUrl() {
        return this.Xv;
    }

    public void setLinkUrl(String str) {
        this.Xv = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String qB() {
        return this.tagNameUrl;
    }

    public float qC() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: qD */
    public r clone() {
        r rVar = new r();
        rVar.Xu = this.Xu;
        rVar.Xv = this.Xv;
        rVar.mTitle = this.mTitle;
        rVar.Xw = this.Xw;
        rVar.Xx = this.Xx;
        rVar.tagNameUrl = this.tagNameUrl;
        rVar.tagRatio = this.tagRatio;
        return rVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.Xu = headImgs.img_url;
            this.Xv = headImgs.pc_url;
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
                this.Xw = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Xx = headImgs.btn_text.trim();
            }
        }
    }

    public boolean qE() {
        return this.Xy;
    }

    public void an(boolean z) {
        this.Xy = z;
    }
}
