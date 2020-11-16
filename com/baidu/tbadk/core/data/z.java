package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.flow.a.a {
    private String cgQ;
    private String eyX;
    private String eyY;
    private boolean eyZ;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public z(String str, String str2, String str3) {
        this.cgQ = str;
        this.eyX = str2;
        this.mTitle = str3;
    }

    public z() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.cgQ;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String bjA() {
        return this.eyX;
    }

    public String getImageUrl() {
        return this.cgQ;
    }

    public void setImageUrl(String str) {
        this.cgQ = str;
    }

    public String getLinkUrl() {
        return this.eyX;
    }

    public void setLinkUrl(String str) {
        this.eyX = str;
    }

    public String bjK() {
        return this.tagNameUrl;
    }

    public float bjL() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: bjM */
    public z clone() {
        z zVar = new z();
        zVar.cgQ = this.cgQ;
        zVar.eyX = this.eyX;
        zVar.mTitle = this.mTitle;
        zVar.mSubTitle = this.mSubTitle;
        zVar.eyY = this.eyY;
        zVar.tagNameUrl = this.tagNameUrl;
        zVar.tagRatio = this.tagRatio;
        return zVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.cgQ = headImgs.img_url;
            this.eyX = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                this.eyY = headImgs.btn_text.trim();
            }
        }
    }

    public boolean bjN() {
        return this.eyZ;
    }

    public void iL(boolean z) {
        this.eyZ = z;
    }
}
