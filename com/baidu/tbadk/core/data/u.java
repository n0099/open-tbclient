package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r Vf;
    private long threadId;
    private long Va = 0;
    private String Vb = "";
    private long Vc = 0;
    private String Vd = "";
    private String imgUrl = "";
    private String Ve = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Va = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Vb = forumHeadlineImgInfo.thread_user_name;
            this.Vc = forumHeadlineImgInfo.img_user_id.longValue();
            this.Vd = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.Ve = forumHeadlineImgInfo.headline_url;
            this.Vf = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.Ve == null ? "" : this.Ve, null);
            tVar.am(true);
            arrayList.add(tVar);
            this.Vf.f(arrayList);
        }
    }

    public String pL() {
        return this.imgUrl;
    }
}
