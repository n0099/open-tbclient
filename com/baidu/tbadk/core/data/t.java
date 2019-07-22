package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q bGJ;
    private long threadId;
    private long bGE = 0;
    private String bGF = "";
    private long bGG = 0;
    private String bGH = "";
    private String imgUrl = "";
    private String bGI = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.bGE = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bGF = forumHeadlineImgInfo.thread_user_name;
            this.bGG = forumHeadlineImgInfo.img_user_id.longValue();
            this.bGH = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.bGI = forumHeadlineImgInfo.headline_url;
            this.bGJ = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.bGI == null ? "" : this.bGI, null);
            sVar.dH(true);
            arrayList.add(sVar);
            this.bGJ.o(arrayList);
        }
    }

    public String acU() {
        return this.imgUrl;
    }
}
