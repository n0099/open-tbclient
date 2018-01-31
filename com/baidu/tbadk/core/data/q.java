package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String aKO;
    private String aKP;
    private String aKQ;
    private String aKR;
    private boolean aKS;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.aKO = str;
        this.aKP = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aKO;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xp() {
        return this.aKP;
    }

    public String xq() {
        return this.tagNameUrl;
    }

    public float xr() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xs */
    public q clone() {
        q qVar = new q();
        qVar.aKO = this.aKO;
        qVar.aKP = this.aKP;
        qVar.mTitle = this.mTitle;
        qVar.aKQ = this.aKQ;
        qVar.aKR = this.aKR;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.aKO = headImgs.img_url;
            this.aKP = headImgs.pc_url;
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
                this.aKQ = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.aKR = headImgs.btn_text.trim();
            }
        }
    }

    public boolean xt() {
        return this.aKS;
    }

    public void aS(boolean z) {
        this.aKS = z;
    }
}
