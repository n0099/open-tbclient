package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q bHi;
    private long threadId;
    private long bHd = 0;
    private String bHe = "";
    private long bHf = 0;
    private String bHg = "";
    private String imgUrl = "";
    private String bHh = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.bHd = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bHe = forumHeadlineImgInfo.thread_user_name;
            this.bHf = forumHeadlineImgInfo.img_user_id.longValue();
            this.bHg = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.bHh = forumHeadlineImgInfo.headline_url;
            this.bHi = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.bHh == null ? "" : this.bHh, null);
            sVar.dH(true);
            arrayList.add(sVar);
            this.bHi.o(arrayList);
        }
    }

    public String acZ() {
        return this.imgUrl;
    }
}
