package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.flow.a.a {
    private String cuF;
    private String ePM;
    private String ePN;
    private boolean ePO;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public z(String str, String str2, String str3) {
        this.cuF = str;
        this.ePM = str2;
        this.mTitle = str3;
    }

    public z() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cuF;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bpn() {
        return this.ePM;
    }

    public String getImageUrl() {
        return this.cuF;
    }

    public void setImageUrl(String str) {
        this.cuF = str;
    }

    public String getLinkUrl() {
        return this.ePM;
    }

    public void setLinkUrl(String str) {
        this.ePM = str;
    }

    public String bpx() {
        return this.tagNameUrl;
    }

    public float bpy() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bpz */
    public z clone() {
        z zVar = new z();
        zVar.cuF = this.cuF;
        zVar.ePM = this.ePM;
        zVar.mTitle = this.mTitle;
        zVar.mSubTitle = this.mSubTitle;
        zVar.ePN = this.ePN;
        zVar.tagNameUrl = this.tagNameUrl;
        zVar.tagRatio = this.tagRatio;
        return zVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.cuF = headImgs.img_url;
            this.ePM = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int i = com.baidu.adp.lib.f.b.toInt(split[0], 1);
                    int i2 = com.baidu.adp.lib.f.b.toInt(split[1], 1);
                    if (i2 != 0) {
                        this.tagRatio = i / i2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.mSubTitle = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.ePN = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bpA() {
        return this.ePO;
    }

    public void jv(boolean z) {
        this.ePO = z;
    }
}
