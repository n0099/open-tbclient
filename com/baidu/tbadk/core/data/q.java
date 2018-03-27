package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String aLY;
    private String aLZ;
    private String aMa;
    private String aMb;
    private boolean aMc;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.aLY = str;
        this.aLZ = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aLY;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xV() {
        return this.aLZ;
    }

    public String getImageUrl() {
        return this.aLY;
    }

    public void setImageUrl(String str) {
        this.aLY = str;
    }

    public String getLinkUrl() {
        return this.aLZ;
    }

    public void setLinkUrl(String str) {
        this.aLZ = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String xW() {
        return this.tagNameUrl;
    }

    public float xX() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: xY */
    public q clone() {
        q qVar = new q();
        qVar.aLY = this.aLY;
        qVar.aLZ = this.aLZ;
        qVar.mTitle = this.mTitle;
        qVar.aMa = this.aMa;
        qVar.aMb = this.aMb;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.aLY = headImgs.img_url;
            this.aLZ = headImgs.pc_url;
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
                this.aMa = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.aMb = headImgs.btn_text.trim();
            }
        }
    }

    public boolean xZ() {
        return this.aMc;
    }

    public void aV(boolean z) {
        this.aMc = z;
    }
}
