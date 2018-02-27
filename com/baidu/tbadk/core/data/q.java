package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class q implements com.baidu.tbadk.core.flow.a.a {
    private String aLX;
    private String aLY;
    private String aLZ;
    private String aMa;
    private boolean aMb;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public q(String str, String str2, String str3) {
        this.aLX = str;
        this.aLY = str2;
        this.mTitle = str3;
    }

    public q() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.aLX;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String xV() {
        return this.aLY;
    }

    public String getImageUrl() {
        return this.aLX;
    }

    public String getLinkUrl() {
        return this.aLY;
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
        qVar.aLX = this.aLX;
        qVar.aLY = this.aLY;
        qVar.mTitle = this.mTitle;
        qVar.aLZ = this.aLZ;
        qVar.aMa = this.aMa;
        qVar.tagNameUrl = this.tagNameUrl;
        qVar.tagRatio = this.tagRatio;
        return qVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.aLX = headImgs.img_url;
            this.aLY = headImgs.pc_url;
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
                this.aLZ = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.aMa = headImgs.btn_text.trim();
            }
        }
    }

    public boolean xZ() {
        return this.aMb;
    }

    public void aV(boolean z) {
        this.aMb = z;
    }
}
