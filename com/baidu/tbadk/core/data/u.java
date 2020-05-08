package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r dog;
    private long threadId;
    private long doa = 0;
    private String dob = "";
    private long dod = 0;
    private String doe = "";
    private String imgUrl = "";
    private String dof = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.doa = forumHeadlineImgInfo.thread_user_id.longValue();
            this.dob = forumHeadlineImgInfo.thread_user_name;
            this.dod = forumHeadlineImgInfo.img_user_id.longValue();
            this.doe = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dof = forumHeadlineImgInfo.headline_url;
            this.dog = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.dof == null ? "" : this.dof, null);
            tVar.gv(true);
            arrayList.add(tVar);
            this.dog.v(arrayList);
        }
    }

    public String aIU() {
        return this.imgUrl;
    }
}
