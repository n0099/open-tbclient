package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String aKN;
    private String aKO;
    private String aKP;
    private String aKQ;
    private boolean aKR;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.aKN = str;
        this.aKO = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aKN;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xp() {
        return this.aKO;
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
        qVar.aKN = this.aKN;
        qVar.aKO = this.aKO;
        qVar.mTitle = this.mTitle;
        qVar.aKP = this.aKP;
        qVar.aKQ = this.aKQ;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.aKN = headImgs.img_url;
            this.aKO = headImgs.pc_url;
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
                this.aKP = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.aKQ = headImgs.btn_text.trim();
            }
        }
    }

    public boolean xt() {
        return this.aKR;
    }

    public void aR(boolean z) {
        this.aKR = z;
    }
}
