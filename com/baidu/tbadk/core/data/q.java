package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String Wn;
    private String Wo;
    private String Wp;
    private String Wq;
    private boolean Wr;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.Wn = str;
        this.Wo = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.Wn;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pM() {
        return this.Wo;
    }

    public String pN() {
        return this.tagNameUrl;
    }

    public float pO() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pP */
    public q clone() {
        q qVar = new q();
        qVar.Wn = this.Wn;
        qVar.Wo = this.Wo;
        qVar.mTitle = this.mTitle;
        qVar.Wp = this.Wp;
        qVar.Wq = this.Wq;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.Wn = headImgs.img_url;
            this.Wo = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                this.Wp = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Wq = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pQ() {
        return this.Wr;
    }

    public void ak(boolean z) {
        this.Wr = z;
    }
}
