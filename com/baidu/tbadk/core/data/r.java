package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class r {
    private o amL;
    private long threadId;
    private long amG = 0;
    private String amH = "";
    private long amI = 0;
    private String amJ = "";
    private String imgUrl = "";
    private String amK = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.amG = forumHeadlineImgInfo.thread_user_id.longValue();
            this.amH = forumHeadlineImgInfo.thread_user_name;
            this.amI = forumHeadlineImgInfo.img_user_id.longValue();
            this.amJ = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.amK = forumHeadlineImgInfo.headline_url;
            this.amL = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.amK == null ? "" : this.amK, null);
            qVar.aH(true);
            arrayList.add(qVar);
            this.amL.j(arrayList);
        }
    }

    public String xf() {
        return this.imgUrl;
    }
}
