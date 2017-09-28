package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r Wa;
    private long threadId;
    private long VV = 0;
    private String VW = "";
    private long VX = 0;
    private String VY = "";
    private String imgUrl = "";
    private String VZ = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.VV = forumHeadlineImgInfo.thread_user_id.longValue();
            this.VW = forumHeadlineImgInfo.thread_user_name;
            this.VX = forumHeadlineImgInfo.img_user_id.longValue();
            this.VY = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.VZ = forumHeadlineImgInfo.headline_url;
            this.Wa = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.VZ == null ? "" : this.VZ, null);
            tVar.an(true);
            arrayList.add(tVar);
            this.Wa.f(arrayList);
        }
    }

    public String pS() {
        return this.imgUrl;
    }
}
