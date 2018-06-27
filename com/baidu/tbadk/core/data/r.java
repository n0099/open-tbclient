package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class r implements com.baidu.tbadk.core.flow.a.a {
    private String afK;
    private String afL;
    private String afM;
    private String afN;
    private boolean afO;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public r(String str, String str2, String str3) {
        this.afK = str;
        this.afL = str2;
        this.mTitle = str3;
    }

    public r() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.afK;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String uc() {
        return this.afL;
    }

    public String getImageUrl() {
        return this.afK;
    }

    public void setImageUrl(String str) {
        this.afK = str;
    }

    public String getLinkUrl() {
        return this.afL;
    }

    public void setLinkUrl(String str) {
        this.afL = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String ud() {
        return this.tagNameUrl;
    }

    public float ue() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: uf */
    public r clone() {
        r rVar = new r();
        rVar.afK = this.afK;
        rVar.afL = this.afL;
        rVar.mTitle = this.mTitle;
        rVar.afM = this.afM;
        rVar.afN = this.afN;
        rVar.tagNameUrl = this.tagNameUrl;
        rVar.tagRatio = this.tagRatio;
        return rVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.afK = headImgs.img_url;
            this.afL = headImgs.pc_url;
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
                this.afM = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.afN = headImgs.btn_text.trim();
            }
        }
    }

    public boolean ug() {
        return this.afO;
    }

    public void ar(boolean z) {
        this.afO = z;
    }
}
