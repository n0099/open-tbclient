package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r Vq;
    private long threadId;
    private long Vl = 0;
    private String Vm = "";
    private long Vn = 0;
    private String Vo = "";
    private String imgUrl = "";
    private String Vp = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Vl = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Vm = forumHeadlineImgInfo.thread_user_name;
            this.Vn = forumHeadlineImgInfo.img_user_id.longValue();
            this.Vo = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.Vp = forumHeadlineImgInfo.headline_url;
            this.Vq = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.Vp == null ? "" : this.Vp, null);
            tVar.am(true);
            arrayList.add(tVar);
            this.Vq.f(arrayList);
        }
    }

    public boolean pY() {
        return pZ() && qa();
    }

    public boolean pZ() {
        return StringUtils.isNull(this.Vm, true) || this.Vl <= 0;
    }

    public boolean qa() {
        return StringUtils.isNull(this.Vo, true) || this.Vn <= 0;
    }

    public String qb() {
        return this.Vm;
    }

    public String qc() {
        return this.Vo;
    }

    public String qd() {
        return this.imgUrl;
    }

    public String qe() {
        return this.Vp;
    }

    public r qf() {
        return this.Vq;
    }
}
