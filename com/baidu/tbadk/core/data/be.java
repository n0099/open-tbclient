package com.baidu.tbadk.core.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class be {
    protected float tagNameRatio;
    protected String tagNameUrl;
    protected String img_url = null;
    protected String link = null;
    protected String XA = null;

    public String qd() {
        return this.img_url;
    }

    public void ck(String str) {
        this.img_url = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void cl(String str) {
        this.tagNameUrl = str;
    }

    public String pU() {
        return this.tagNameUrl;
    }

    public void cm(String str) {
        if (str != null) {
            try {
                String[] split = str.split(",");
                int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                if (g2 != 0) {
                    this.tagNameRatio = g / g2;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public float rp() {
        return this.tagNameRatio;
    }

    public void a(Banner banner) {
        if (banner != null) {
            a(banner, null);
        }
    }

    public void a(Banner banner, Context context) {
        if (banner != null) {
            try {
                ck(banner.pic_url);
                setLink(banner.link);
                cl(banner.tag_name_url);
                cm(banner.tag_name_wh);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String rq() {
        return this.XA;
    }

    public void cn(String str) {
        this.XA = str;
    }
}
