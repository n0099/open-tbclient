package com.baidu.tbadk.core.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class an {
    protected String img_url = null;
    protected String link = null;
    protected String UK = null;

    public String sW() {
        return this.img_url;
    }

    public void cs(String str) {
        this.img_url = str;
    }

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
                cs(banner.pic_url);
                setLink(banner.link);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String sX() {
        return this.UK;
    }

    public void ct(String str) {
        this.UK = str;
    }
}
