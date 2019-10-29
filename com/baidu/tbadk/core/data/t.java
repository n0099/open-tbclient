package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q bYT;
    private long threadId;
    private long bYO = 0;
    private String bYP = "";
    private long bYQ = 0;
    private String bYR = "";
    private String imgUrl = "";
    private String bYS = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.bYO = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bYP = forumHeadlineImgInfo.thread_user_name;
            this.bYQ = forumHeadlineImgInfo.img_user_id.longValue();
            this.bYR = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.bYS = forumHeadlineImgInfo.headline_url;
            this.bYT = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.bYS == null ? "" : this.bYS, null);
            sVar.dX(true);
            arrayList.add(sVar);
            this.bYT.r(arrayList);
        }
    }

    public String ahf() {
        return this.imgUrl;
    }
}
