package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.core.flow.a.a {
    private String dcS;
    private String eNn;
    private String eNo;
    private boolean eNp;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public aa(String str, String str2, String str3) {
        this.dcS = str;
        this.eNn = str2;
        this.mTitle = str3;
    }

    public aa() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.dcS;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String blL() {
        return this.eNn;
    }

    public String getImageUrl() {
        return this.dcS;
    }

    public void setImageUrl(String str) {
        this.dcS = str;
    }

    public String getLinkUrl() {
        return this.eNn;
    }

    public void setLinkUrl(String str) {
        this.eNn = str;
    }

    public String blV() {
        return this.tagNameUrl;
    }

    public float blW() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: blX */
    public aa clone() {
        aa aaVar = new aa();
        aaVar.dcS = this.dcS;
        aaVar.eNn = this.eNn;
        aaVar.mTitle = this.mTitle;
        aaVar.mSubTitle = this.mSubTitle;
        aaVar.eNo = this.eNo;
        aaVar.tagNameUrl = this.tagNameUrl;
        aaVar.tagRatio = this.tagRatio;
        return aaVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.dcS = headImgs.img_url;
            this.eNn = headImgs.pc_url;
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
                this.eNo = headImgs.btn_text.trim();
            }
        }
    }

    public boolean blY() {
        return this.eNp;
    }

    public void jt(boolean z) {
        this.eNp = z;
    }
}
