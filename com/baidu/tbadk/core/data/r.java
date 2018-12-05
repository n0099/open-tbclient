package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class r {
    private o aqZ;
    private long threadId;
    private long aqU = 0;
    private String aqV = "";
    private long aqW = 0;
    private String aqX = "";
    private String imgUrl = "";
    private String aqY = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.aqU = forumHeadlineImgInfo.thread_user_id.longValue();
            this.aqV = forumHeadlineImgInfo.thread_user_name;
            this.aqW = forumHeadlineImgInfo.img_user_id.longValue();
            this.aqX = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.aqY = forumHeadlineImgInfo.headline_url;
            this.aqZ = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.aqY == null ? "" : this.aqY, null);
            qVar.aY(true);
            arrayList.add(qVar);
            this.aqZ.j(arrayList);
        }
    }

    public String ys() {
        return this.imgUrl;
    }
}
