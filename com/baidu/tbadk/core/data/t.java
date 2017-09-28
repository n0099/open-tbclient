package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.flow.a.a {
    private String VQ;
    private String VR;
    private String VS;
    private String VT;
    private boolean VU;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public t(String str, String str2, String str3) {
        this.VQ = str;
        this.VR = str2;
        this.mTitle = str3;
    }

    public t() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.VQ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pN() {
        return this.VR;
    }

    public String pO() {
        return this.tagNameUrl;
    }

    public float pP() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pQ */
    public t clone() {
        t tVar = new t();
        tVar.VQ = this.VQ;
        tVar.VR = this.VR;
        tVar.mTitle = this.mTitle;
        tVar.VS = this.VS;
        tVar.VT = this.VT;
        tVar.tagNameUrl = this.tagNameUrl;
        tVar.tagRatio = this.tagRatio;
        return tVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.VQ = headImgs.img_url;
            this.VR = headImgs.pc_url;
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
                this.VS = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.VT = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pR() {
        return this.VU;
    }

    public void an(boolean z) {
        this.VU = z;
    }
}
