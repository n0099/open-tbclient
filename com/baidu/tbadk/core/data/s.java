package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.xiaomi.mipush.sdk.Constants;
import tbclient.FrsPage.HeadImgs;
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.flow.a.a {
    private String byl;
    private String bym;
    private String byn;
    private String byo;
    private boolean byp;
    private String mTitle;
    private String tagNameUrl;
    private float tagRatio;

    public s(String str, String str2, String str3) {
        this.byl = str;
        this.bym = str2;
        this.mTitle = str3;
    }

    public s() {
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String getPicUrl() {
        return this.byl;
    }

    @Override // com.baidu.tbadk.core.flow.a.a
    public String Xf() {
        return this.bym;
    }

    public String getImageUrl() {
        return this.byl;
    }

    public void setImageUrl(String str) {
        this.byl = str;
    }

    public String getLinkUrl() {
        return this.bym;
    }

    public void setLinkUrl(String str) {
        this.bym = str;
    }

    public String Xg() {
        return this.tagNameUrl;
    }

    public float Xh() {
        return this.tagRatio;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Xi */
    public s clone() {
        s sVar = new s();
        sVar.byl = this.byl;
        sVar.bym = this.bym;
        sVar.mTitle = this.mTitle;
        sVar.byn = this.byn;
        sVar.byo = this.byo;
        sVar.tagNameUrl = this.tagNameUrl;
        sVar.tagRatio = this.tagRatio;
        return sVar;
    }

    public void b(HeadImgs headImgs) {
        if (headImgs != null) {
            this.byl = headImgs.img_url;
            this.bym = headImgs.pc_url;
            this.tagNameUrl = headImgs.tag_name_url;
            String str = headImgs.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int l = com.baidu.adp.lib.g.b.l(split[0], 1);
                    int l2 = com.baidu.adp.lib.g.b.l(split[1], 1);
                    if (l2 != 0) {
                        this.tagRatio = l / l2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            if (headImgs.title != null) {
                this.mTitle = headImgs.title.trim();
            }
            if (headImgs.subtitle != null) {
                this.byn = headImgs.subtitle.trim();
            }
            if (headImgs.btn_text != null) {
                this.byo = headImgs.btn_text.trim();
            }
        }
    }

    public boolean Xj() {
        return this.byp;
    }

    public void di(boolean z) {
        this.byp = z;
    }
}
