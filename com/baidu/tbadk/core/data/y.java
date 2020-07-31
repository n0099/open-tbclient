package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class y {
    private u dOM;
    private long threadId;
    private long dOH = 0;
    private String dOI = "";
    private long dOJ = 0;
    private String dOK = "";
    private String imgUrl = "";
    private String dOL = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.dOH = forumHeadlineImgInfo.thread_user_id.longValue();
            this.dOI = forumHeadlineImgInfo.thread_user_name;
            this.dOJ = forumHeadlineImgInfo.img_user_id.longValue();
            this.dOK = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dOL = forumHeadlineImgInfo.headline_url;
            this.dOM = new u();
            ArrayList<x> arrayList = new ArrayList<>();
            x xVar = new x(this.imgUrl == null ? "" : this.imgUrl, this.dOL == null ? "" : this.dOL, null);
            xVar.hy(true);
            arrayList.add(xVar);
            this.dOM.w(arrayList);
        }
    }

    public String aUh() {
        return this.imgUrl;
    }
}
