package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.flow.a.a {
    private String dev;
    private String eOO;
    private String eOP;
    private boolean eOQ;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public aa(String str, String str2, String str3) {
        this.dev = str;
        this.eOO = str2;
        this.mTitle = str3;
    }

    public aa() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.dev;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blN() {
        return this.eOO;
    }

    public String getImageUrl() {
        return this.dev;
    }

    public void setImageUrl(String str) {
        this.dev = str;
    }

    public String getLinkUrl() {
        return this.eOO;
    }

    public void setLinkUrl(String str) {
        this.eOO = str;
    }

    public String blX() {
        return this.tagNameUrl;
    }

    public float blY() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: blZ */
    public aa clone() {
        aa aaVar = new aa();
        aaVar.dev = this.dev;
        aaVar.eOO = this.eOO;
        aaVar.mTitle = this.mTitle;
        aaVar.mSubTitle = this.mSubTitle;
        aaVar.eOP = this.eOP;
        aaVar.tagNameUrl = this.tagNameUrl;
        aaVar.tagRatio = this.tagRatio;
        return aaVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.dev = headImgs.img_url;
            this.eOO = headImgs.pc_url;
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
                this.eOP = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bma() {
        return this.eOQ;
    }

    public void jt(boolean z) {
        this.eOQ = z;
    }
}
