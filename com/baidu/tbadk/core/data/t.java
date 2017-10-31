package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.flow.a.a {
    private String VW;
    private String VX;
    private String VY;
    private String VZ;
    private boolean Wa;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public t(String str, String str2, String str3) {
        this.VW = str;
        this.VX = str2;
        this.mTitle = str3;
    }

    public t() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.VW;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pL() {
        return this.VX;
    }

    public String pM() {
        return this.tagNameUrl;
    }

    public float pN() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pO */
    public t clone() {
        t tVar = new t();
        tVar.VW = this.VW;
        tVar.VX = this.VX;
        tVar.mTitle = this.mTitle;
        tVar.VY = this.VY;
        tVar.VZ = this.VZ;
        tVar.tagNameUrl = this.tagNameUrl;
        tVar.tagRatio = this.tagRatio;
        return tVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.VW = headImgs.img_url;
            this.VX = headImgs.pc_url;
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
                this.VY = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.VZ = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pP() {
        return this.Wa;
    }

    public void ak(boolean z) {
        this.Wa = z;
    }
}
