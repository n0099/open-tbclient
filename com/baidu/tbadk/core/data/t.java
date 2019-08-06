package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q bGK;
    private long threadId;
    private long bGF = 0;
    private String bGG = "";
    private long bGH = 0;
    private String bGI = "";
    private String imgUrl = "";
    private String bGJ = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.bGF = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bGG = forumHeadlineImgInfo.thread_user_name;
            this.bGH = forumHeadlineImgInfo.img_user_id.longValue();
            this.bGI = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.bGJ = forumHeadlineImgInfo.headline_url;
            this.bGK = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.bGJ == null ? "" : this.bGJ, null);
            sVar.dH(true);
            arrayList.add(sVar);
            this.bGK.o(arrayList);
        }
    }

    public String acV() {
        return this.imgUrl;
    }
}
