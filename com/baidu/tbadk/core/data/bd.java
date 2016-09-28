package com.baidu.tbadk.core.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import tbclient.ForumRecommend.Banner;
/* loaded from: classes.dex */
public class bd {
    protected float tagNameRatio;
    protected String tagNameUrl;
    protected String img_url = null;
    protected String link = null;
    protected String Th = null;

    public String pO() {
        return this.img_url;
    }

    public void cq(String str) {
        this.img_url = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void cr(String str) {
        this.tagNameUrl = str;
    }

    public String pF() {
        return this.tagNameUrl;
    }

    public void cs(String str) {
        if (str != null) {
            try {
                String[] split = str.split(",");
                int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                if (g2 != 0) {
                    this.tagNameRatio = g / g2;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public float rn() {
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
                cq(banner.pic_url);
                setLink(banner.link);
                cr(banner.tag_name_url);
                cs(banner.tag_name_wh);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String ro() {
        return this.Th;
    }

    public void ct(String str) {
        this.Th = str;
    }
}
