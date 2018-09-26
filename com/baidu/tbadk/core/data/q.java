package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String ahF;
    private String ahG;
    private String ahH;
    private String ahI;
    private boolean ahJ;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.ahF = str;
        this.ahG = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.ahF;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String uR() {
        return this.ahG;
    }

    public String getImageUrl() {
        return this.ahF;
    }

    public void setImageUrl(String str) {
        this.ahF = str;
    }

    public String getLinkUrl() {
        return this.ahG;
    }

    public void setLinkUrl(String str) {
        this.ahG = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String uS() {
        return this.tagNameUrl;
    }

    public float uT() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: uU */
    public q clone() {
        q qVar = new q();
        qVar.ahF = this.ahF;
        qVar.ahG = this.ahG;
        qVar.mTitle = this.mTitle;
        qVar.ahH = this.ahH;
        qVar.ahI = this.ahI;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.ahF = headImgs.img_url;
            this.ahG = headImgs.pc_url;
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
                this.ahH = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.ahI = headImgs.btn_text.trim();
            }
        }
    }

    public boolean uV() {
        return this.ahJ;
    }

    public void ax(boolean z) {
        this.ahJ = z;
    }
}
