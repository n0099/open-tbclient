package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String afe;
    private String aff;
    private String afg;
    private String afh;
    private boolean afi;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.afe = str;
        this.aff = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.afe;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String tO() {
        return this.aff;
    }

    public String getImageUrl() {
        return this.afe;
    }

    public void setImageUrl(String str) {
        this.afe = str;
    }

    public String getLinkUrl() {
        return this.aff;
    }

    public void setLinkUrl(String str) {
        this.aff = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String tP() {
        return this.tagNameUrl;
    }

    public float tQ() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: tR */
    public q clone() {
        q qVar = new q();
        qVar.afe = this.afe;
        qVar.aff = this.aff;
        qVar.mTitle = this.mTitle;
        qVar.afg = this.afg;
        qVar.afh = this.afh;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.afe = headImgs.img_url;
            this.aff = headImgs.pc_url;
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
                this.afg = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.afh = headImgs.btn_text.trim();
            }
        }
    }

    public boolean tS() {
        return this.afi;
    }

    public void ao(boolean z) {
        this.afi = z;
    }
}
