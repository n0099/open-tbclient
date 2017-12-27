package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o aKX;
    private long threadId;
    private long aKS = 0;
    private String aKT = "";
    private long aKU = 0;
    private String aKV = "";
    private String imgUrl = "";
    private String aKW = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.aKS = forumHeadlineImgInfo.thread_user_id.longValue();
            this.aKT = forumHeadlineImgInfo.thread_user_name;
            this.aKU = forumHeadlineImgInfo.img_user_id.longValue();
            this.aKV = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.aKW = forumHeadlineImgInfo.headline_url;
            this.aKX = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.aKW == null ? "" : this.aKW, null);
            qVar.aR(true);
            arrayList.add(qVar);
            this.aKX.g(arrayList);
        }
    }

    public String xu() {
        return this.imgUrl;
    }
}
