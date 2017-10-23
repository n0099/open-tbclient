package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.flow.a.a {
    private String VE;
    private String VF;
    private String VG;
    private String VH;
    private boolean VI;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public t(String str, String str2, String str3) {
        this.VE = str;
        this.VF = str2;
        this.mTitle = str3;
    }

    public t() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.VE;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pG() {
        return this.VF;
    }

    public String pH() {
        return this.tagNameUrl;
    }

    public float pI() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pJ */
    public t clone() {
        t tVar = new t();
        tVar.VE = this.VE;
        tVar.VF = this.VF;
        tVar.mTitle = this.mTitle;
        tVar.VG = this.VG;
        tVar.VH = this.VH;
        tVar.tagNameUrl = this.tagNameUrl;
        tVar.tagRatio = this.tagRatio;
        return tVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.VE = headImgs.img_url;
            this.VF = headImgs.pc_url;
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
                this.VG = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.VH = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pK() {
        return this.VI;
    }

    public void am(boolean z) {
        this.VI = z;
    }
}
