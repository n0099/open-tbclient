package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class x {
    private u dIB;
    private long threadId;
    private long dIw = 0;
    private String dIx = "";
    private long dIy = 0;
    private String dIz = "";
    private String imgUrl = "";
    private String dIA = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.dIw = forumHeadlineImgInfo.thread_user_id.longValue();
            this.dIx = forumHeadlineImgInfo.thread_user_name;
            this.dIy = forumHeadlineImgInfo.img_user_id.longValue();
            this.dIz = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dIA = forumHeadlineImgInfo.headline_url;
            this.dIB = new u();
            ArrayList<w> arrayList = new ArrayList<>();
            w wVar = new w(this.imgUrl == null ? "" : this.imgUrl, this.dIA == null ? "" : this.dIA, null);
            wVar.gU(true);
            arrayList.add(wVar);
            this.dIB.v(arrayList);
        }
    }

    public String aQl() {
        return this.imgUrl;
    }
}
