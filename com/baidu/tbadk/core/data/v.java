package com.baidu.tbadk.core.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class v implements l {
    protected String img_url = null;
    protected String link = null;

    @Override // com.baidu.tbadk.core.data.l
    public String mI() {
        return this.img_url;
    }

    public void bM(String str) {
        this.img_url = str;
    }

    @Override // com.baidu.tbadk.core.data.l
    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void a(Banner banner) {
        if (banner != null) {
            a(banner, null);
        }
    }

    public void a(Banner banner, Context context) {
        if (banner != null) {
            try {
                bM(banner.pic_url);
                setLink(banner.link);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
