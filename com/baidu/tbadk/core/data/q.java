package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String aMi;
    private String aMj;
    private String aMk;
    private String aMl;
    private boolean aMm;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.aMi = str;
        this.aMj = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aMi;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xV() {
        return this.aMj;
    }

    public String getImageUrl() {
        return this.aMi;
    }

    public String getLinkUrl() {
        return this.aMj;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String xW() {
        return this.tagNameUrl;
    }

    public float xX() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xY */
    public q clone() {
        q qVar = new q();
        qVar.aMi = this.aMi;
        qVar.aMj = this.aMj;
        qVar.mTitle = this.mTitle;
        qVar.aMk = this.aMk;
        qVar.aMl = this.aMl;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.aMi = headImgs.img_url;
            this.aMj = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int h = com.baidu.adp.lib.g.b.h(split[0], 1);
                    int h2 = com.baidu.adp.lib.g.b.h(split[1], 1);
                    if (h2 != 0) {
                        this.tagRatio = h / h2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.aMk = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.aMl = headImgs.btn_text.trim();
            }
        }
    }

    public boolean xZ() {
        return this.aMm;
    }

    public void aV(boolean z) {
        this.aMm = z;
    }
}
