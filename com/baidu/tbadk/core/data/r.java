package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class r {
    private o any;
    private long threadId;
    private long ant = 0;
    private String anu = "";
    private long anv = 0;
    private String anw = "";
    private String imgUrl = "";
    private String anx = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.ant = forumHeadlineImgInfo.thread_user_id.longValue();
            this.anu = forumHeadlineImgInfo.thread_user_name;
            this.anv = forumHeadlineImgInfo.img_user_id.longValue();
            this.anw = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.anx = forumHeadlineImgInfo.headline_url;
            this.any = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.anx == null ? "" : this.anx, null);
            qVar.aX(true);
            arrayList.add(qVar);
            this.any.j(arrayList);
        }
    }

    public String xn() {
        return this.imgUrl;
    }
}
