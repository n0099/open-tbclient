package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String Wt;
    private String Wu;
    private String Wv;
    private String Ww;
    private boolean Wx;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.Wt = str;
        this.Wu = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.Wt;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pO() {
        return this.Wu;
    }

    public String pP() {
        return this.tagNameUrl;
    }

    public float pQ() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pR */
    public q clone() {
        q qVar = new q();
        qVar.Wt = this.Wt;
        qVar.Wu = this.Wu;
        qVar.mTitle = this.mTitle;
        qVar.Wv = this.Wv;
        qVar.Ww = this.Ww;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.Wt = headImgs.img_url;
            this.Wu = headImgs.pc_url;
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
                this.Wv = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.Ww = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pS() {
        return this.Wx;
    }

    public void ak(boolean z) {
        this.Wx = z;
    }
}
