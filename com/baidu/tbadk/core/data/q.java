package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String amB;
    private String amC;
    private String amD;
    private String amE;
    private boolean amF;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.amB = str;
        this.amC = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.amB;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xa() {
        return this.amC;
    }

    public String getImageUrl() {
        return this.amB;
    }

    public void setImageUrl(String str) {
        this.amB = str;
    }

    public String getLinkUrl() {
        return this.amC;
    }

    public void setLinkUrl(String str) {
        this.amC = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String xb() {
        return this.tagNameUrl;
    }

    public float xc() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xd */
    public q clone() {
        q qVar = new q();
        qVar.amB = this.amB;
        qVar.amC = this.amC;
        qVar.mTitle = this.mTitle;
        qVar.amD = this.amD;
        qVar.amE = this.amE;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.amB = headImgs.img_url;
            this.amC = headImgs.pc_url;
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
                this.amD = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.amE = headImgs.btn_text.trim();
            }
        }
    }

    public boolean xe() {
        return this.amF;
    }

    public void aH(boolean z) {
        this.amF = z;
    }
}
