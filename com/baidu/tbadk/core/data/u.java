package com.baidu.tbadk.core.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class u implements k {
    protected String img_url = null;
    protected String link = null;

    @Override // com.baidu.tbadk.core.data.k
    public String mN() {
        return this.img_url;
    }

    public void bR(String str) {
        this.img_url = str;
    }

    @Override // com.baidu.tbadk.core.data.k
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
                bR(banner.pic_url);
                setLink(banner.link);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
