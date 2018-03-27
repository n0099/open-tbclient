package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o aMi;
    private long threadId;
    private long aMd = 0;
    private String aMe = "";
    private long aMf = 0;
    private String aMg = "";
    private String imgUrl = "";
    private String aMh = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.aMd = forumHeadlineImgInfo.thread_user_id.longValue();
            this.aMe = forumHeadlineImgInfo.thread_user_name;
            this.aMf = forumHeadlineImgInfo.img_user_id.longValue();
            this.aMg = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.aMh = forumHeadlineImgInfo.headline_url;
            this.aMi = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.aMh == null ? "" : this.aMh, null);
            qVar.aV(true);
            arrayList.add(qVar);
            this.aMi.g(arrayList);
        }
    }

    public String ya() {
        return this.imgUrl;
    }
}
