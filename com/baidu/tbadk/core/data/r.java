package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o aMs;
    private long threadId;
    private long aMn = 0;
    private String aMo = "";
    private long aMp = 0;
    private String aMq = "";
    private String imgUrl = "";
    private String aMr = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.aMn = forumHeadlineImgInfo.thread_user_id.longValue();
            this.aMo = forumHeadlineImgInfo.thread_user_name;
            this.aMp = forumHeadlineImgInfo.img_user_id.longValue();
            this.aMq = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.aMr = forumHeadlineImgInfo.headline_url;
            this.aMs = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.aMr == null ? "" : this.aMr, null);
            qVar.aV(true);
            arrayList.add(qVar);
            this.aMs.g(arrayList);
        }
    }

    public String ya() {
        return this.imgUrl;
    }
}
