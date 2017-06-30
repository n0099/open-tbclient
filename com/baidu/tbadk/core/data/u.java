package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.core.flow.a.a {
    private String UH;
    private boolean UI;
    private String mImageUrl;
    private String mLinkUrl;
    private String mSubTitle;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public u(String str, String str2, String str3) {
        this.mImageUrl = str;
        this.mLinkUrl = str2;
        this.mTitle = str3;
    }

    public u() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.mImageUrl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String pD() {
        return this.mLinkUrl;
    }

    public String pE() {
        return this.tagNameUrl;
    }

    public float pF() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: pG */
    public u clone() {
        u uVar = new u();
        uVar.mImageUrl = this.mImageUrl;
        uVar.mLinkUrl = this.mLinkUrl;
        uVar.mTitle = this.mTitle;
        uVar.mSubTitle = this.mSubTitle;
        uVar.UH = this.UH;
        uVar.tagNameUrl = this.tagNameUrl;
        uVar.tagRatio = this.tagRatio;
        return uVar;
    }

    public void a(HeadImgs headImgs) {
        if (headImgs != null) {
            this.mImageUrl = headImgs.img_url;
            this.mLinkUrl = headImgs.pc_url;
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
                this.mSubTitle = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.UH = headImgs.btn_text.trim();
            }
        }
    }

    public boolean pH() {
        return this.UI;
    }

    public void am(boolean z) {
        this.UI = z;
    }
}
