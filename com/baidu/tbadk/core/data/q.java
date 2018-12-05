package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String aqP;
    private String aqQ;
    private String aqR;
    private String aqS;
    private boolean aqT;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.aqP = str;
        this.aqQ = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aqP;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String yn() {
        return this.aqQ;
    }

    public String getImageUrl() {
        return this.aqP;
    }

    public void setImageUrl(String str) {
        this.aqP = str;
    }

    public String getLinkUrl() {
        return this.aqQ;
    }

    public void setLinkUrl(String str) {
        this.aqQ = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String yo() {
        return this.tagNameUrl;
    }

    public float yp() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: yq */
    public q clone() {
        q qVar = new q();
        qVar.aqP = this.aqP;
        qVar.aqQ = this.aqQ;
        qVar.mTitle = this.mTitle;
        qVar.aqR = this.aqR;
        qVar.aqS = this.aqS;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.aqP = headImgs.img_url;
            this.aqQ = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
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
                this.aqR = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.aqS = headImgs.btn_text.trim();
            }
        }
    }

    public boolean yr() {
        return this.aqT;
    }

    public void aY(boolean z) {
        this.aqT = z;
    }
}
