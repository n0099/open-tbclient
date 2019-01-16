package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String arr;
    private String ars;
    private String art;
    private String aru;
    private boolean arv;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.arr = str;
        this.ars = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.arr;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String yA() {
        return this.ars;
    }

    public String getImageUrl() {
        return this.arr;
    }

    public void setImageUrl(String str) {
        this.arr = str;
    }

    public String getLinkUrl() {
        return this.ars;
    }

    public void setLinkUrl(String str) {
        this.ars = str;
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
        qVar.arr = this.arr;
        qVar.ars = this.ars;
        qVar.mTitle = this.mTitle;
        qVar.art = this.art;
        qVar.aru = this.aru;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.arr = headImgs.img_url;
            this.ars = headImgs.pc_url;
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
                this.art = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.aru = headImgs.btn_text.trim();
            }
        }
    }

    public boolean yE() {
        return this.arv;
    }

    public void aZ(boolean z) {
        this.arv = z;
    }
}
