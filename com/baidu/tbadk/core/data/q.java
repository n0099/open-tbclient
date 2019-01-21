package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String ars;
    private String art;
    private String aru;
    private String arv;
    private boolean arw;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.ars = str;
        this.art = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.ars;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String yA() {
        return this.art;
    }

    public String getImageUrl() {
        return this.ars;
    }

    public void setImageUrl(String str) {
        this.ars = str;
    }

    public String getLinkUrl() {
        return this.art;
    }

    public void setLinkUrl(String str) {
        this.art = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String yB() {
        return this.tagNameUrl;
    }

    public float yC() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: yD */
    public q clone() {
        q qVar = new q();
        qVar.ars = this.ars;
        qVar.art = this.art;
        qVar.mTitle = this.mTitle;
        qVar.aru = this.aru;
        qVar.arv = this.arv;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.ars = headImgs.img_url;
            this.art = headImgs.pc_url;
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
                this.aru = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.arv = headImgs.btn_text.trim();
            }
        }
    }

    public boolean yE() {
        return this.arw;
    }

    public void aZ(boolean z) {
        this.arw = z;
    }
}
