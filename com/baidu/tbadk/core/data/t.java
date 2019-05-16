package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q bFH;
    private long threadId;
    private long bFC = 0;
    private String bFD = "";
    private long bFE = 0;
    private String bFF = "";
    private String imgUrl = "";
    private String bFG = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.bFC = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bFD = forumHeadlineImgInfo.thread_user_name;
            this.bFE = forumHeadlineImgInfo.img_user_id.longValue();
            this.bFF = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.bFG = forumHeadlineImgInfo.headline_url;
            this.bFH = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.bFG == null ? "" : this.bFG, null);
            sVar.dD(true);
            arrayList.add(sVar);
            this.bFH.o(arrayList);
        }
    }

    public String abS() {
        return this.imgUrl;
    }
}
