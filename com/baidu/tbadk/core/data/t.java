package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.flow.a.a {
    private String Vi;
    private String Vj;
    private boolean Vk;
    private String mImageUrl;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public t(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.Vi = str2;
        this.mTitle = str3;
    }

    public t() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pT() {
        return this.Vi;
    }

    public String getLinkUrl() {
        return this.Vi;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String pU() {
        return this.tagNameUrl;
    }

    public float pV() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pW */
    public t clone() {
        t tVar = new t();
        tVar.mImageUrl = this.mImageUrl;
        tVar.Vi = this.Vi;
        tVar.mTitle = this.mTitle;
        tVar.mSubTitle = this.mSubTitle;
        tVar.Vj = this.Vj;
        tVar.tagNameUrl = this.tagNameUrl;
        tVar.tagRatio = this.tagRatio;
        return tVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.Vi = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
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
                this.mSubTitle = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Vj = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pX() {
        return this.Vk;
    }

    public void am(boolean z) {
        this.Vk = z;
    }
}
