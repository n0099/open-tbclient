package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o aMh;
    private long threadId;
    private long aMc = 0;
    private String aMd = "";
    private long aMe = 0;
    private String aMf = "";
    private String imgUrl = "";
    private String aMg = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.aMc = forumHeadlineImgInfo.thread_user_id.longValue();
            this.aMd = forumHeadlineImgInfo.thread_user_name;
            this.aMe = forumHeadlineImgInfo.img_user_id.longValue();
            this.aMf = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.aMg = forumHeadlineImgInfo.headline_url;
            this.aMh = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.aMg == null ? "" : this.aMg, null);
            qVar.aV(true);
            arrayList.add(qVar);
            this.aMh.g(arrayList);
        }
    }

    public String ya() {
        return this.imgUrl;
    }
}
