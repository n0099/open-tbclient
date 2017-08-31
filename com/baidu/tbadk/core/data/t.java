package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.flow.a.a {
    private String VC;
    private String VD;
    private String VE;
    private String VF;
    private boolean VG;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public t(String str, String str2, String str3) {
        this.VC = str;
        this.VD = str2;
        this.mTitle = str3;
    }

    public t() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.VC;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pM() {
        return this.VD;
    }

    public String pN() {
        return this.tagNameUrl;
    }

    public float pO() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pP */
    public t clone() {
        t tVar = new t();
        tVar.VC = this.VC;
        tVar.VD = this.VD;
        tVar.mTitle = this.mTitle;
        tVar.VE = this.VE;
        tVar.VF = this.VF;
        tVar.tagNameUrl = this.tagNameUrl;
        tVar.tagRatio = this.tagRatio;
        return tVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.VC = headImgs.img_url;
            this.VD = headImgs.pc_url;
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
                this.VE = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.VF = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pQ() {
        return this.VG;
    }

    public void am(boolean z) {
        this.VG = z;
    }
}
