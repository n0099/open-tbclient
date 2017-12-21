package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String Wq;
    private String Wr;
    private String Ws;
    private String Wt;
    private boolean Wu;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.Wq = str;
        this.Wr = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.Wq;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pM() {
        return this.Wr;
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
        qVar.Wq = this.Wq;
        qVar.Wr = this.Wr;
        qVar.mTitle = this.mTitle;
        qVar.Ws = this.Ws;
        qVar.Wt = this.Wt;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.Wq = headImgs.img_url;
            this.Wr = headImgs.pc_url;
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
                this.Ws = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Wt = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pQ() {
        return this.Wu;
    }

    public void ak(boolean z) {
        this.Wu = z;
    }
}
