package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String ano;
    private String anp;
    private String anq;
    private String anr;
    private boolean ans;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.ano = str;
        this.anp = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.ano;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xi() {
        return this.anp;
    }

    public String getImageUrl() {
        return this.ano;
    }

    public void setImageUrl(String str) {
        this.ano = str;
    }

    public String getLinkUrl() {
        return this.anp;
    }

    public void setLinkUrl(String str) {
        this.anp = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String xj() {
        return this.tagNameUrl;
    }

    public float xk() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xl */
    public q clone() {
        q qVar = new q();
        qVar.ano = this.ano;
        qVar.anp = this.anp;
        qVar.mTitle = this.mTitle;
        qVar.anq = this.anq;
        qVar.anr = this.anr;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.ano = headImgs.img_url;
            this.anp = headImgs.pc_url;
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
                this.anq = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.anr = headImgs.btn_text.trim();
            }
        }
    }

    public boolean xm() {
        return this.ans;
    }

    public void aX(boolean z) {
        this.ans = z;
    }
}
