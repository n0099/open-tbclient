package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class z {
    private v euV;
    private long threadId;
    private long euQ = 0;
    private String euR = "";
    private long euS = 0;
    private String euT = "";
    private String imgUrl = "";
    private String euU = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.euQ = forumHeadlineImgInfo.thread_user_id.longValue();
            this.euR = forumHeadlineImgInfo.thread_user_name;
            this.euS = forumHeadlineImgInfo.img_user_id.longValue();
            this.euT = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.euU = forumHeadlineImgInfo.headline_url;
            this.euV = new v();
            ArrayList<y> arrayList = new ArrayList<>();
            y yVar = new y(this.imgUrl == null ? "" : this.imgUrl, this.euU == null ? "" : this.euU, null);
            yVar.iB(true);
            arrayList.add(yVar);
            this.euV.C(arrayList);
        }
    }

    public String bhW() {
        return this.imgUrl;
    }
}
