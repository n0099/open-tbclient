package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r Vd;
    private long threadId;
    private long UY = 0;
    private String UZ = "";
    private long Va = 0;
    private String Vb = "";
    private String imgUrl = "";
    private String Vc = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.UY = forumHeadlineImgInfo.thread_user_id.longValue();
            this.UZ = forumHeadlineImgInfo.thread_user_name;
            this.Va = forumHeadlineImgInfo.img_user_id.longValue();
            this.Vb = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.Vc = forumHeadlineImgInfo.headline_url;
            this.Vd = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.Vc == null ? "" : this.Vc, null);
            tVar.an(true);
            arrayList.add(tVar);
            this.Vd.f(arrayList);
        }
    }

    public String pT() {
        return this.imgUrl;
    }
}
