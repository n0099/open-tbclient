package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q bYc;
    private long threadId;
    private long bXX = 0;
    private String bXY = "";
    private long bXZ = 0;
    private String bYa = "";
    private String imgUrl = "";
    private String bYb = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.bXX = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bXY = forumHeadlineImgInfo.thread_user_name;
            this.bXZ = forumHeadlineImgInfo.img_user_id.longValue();
            this.bYa = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.bYb = forumHeadlineImgInfo.headline_url;
            this.bYc = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.bYb == null ? "" : this.bYb, null);
            sVar.dX(true);
            arrayList.add(sVar);
            this.bYc.r(arrayList);
        }
    }

    public String ahd() {
        return this.imgUrl;
    }
}
