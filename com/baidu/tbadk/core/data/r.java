package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o aKY;
    private long threadId;
    private long aKT = 0;
    private String aKU = "";
    private long aKV = 0;
    private String aKW = "";
    private String imgUrl = "";
    private String aKX = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.aKT = forumHeadlineImgInfo.thread_user_id.longValue();
            this.aKU = forumHeadlineImgInfo.thread_user_name;
            this.aKV = forumHeadlineImgInfo.img_user_id.longValue();
            this.aKW = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.aKX = forumHeadlineImgInfo.headline_url;
            this.aKY = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.aKX == null ? "" : this.aKX, null);
            qVar.aS(true);
            arrayList.add(qVar);
            this.aKY.g(arrayList);
        }
    }

    public String xu() {
        return this.imgUrl;
    }
}
