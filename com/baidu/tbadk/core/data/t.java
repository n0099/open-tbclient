package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q bFI;
    private long threadId;
    private long bFD = 0;
    private String bFE = "";
    private long bFF = 0;
    private String bFG = "";
    private String imgUrl = "";
    private String bFH = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.bFD = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bFE = forumHeadlineImgInfo.thread_user_name;
            this.bFF = forumHeadlineImgInfo.img_user_id.longValue();
            this.bFG = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.bFH = forumHeadlineImgInfo.headline_url;
            this.bFI = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.bFH == null ? "" : this.bFH, null);
            sVar.dD(true);
            arrayList.add(sVar);
            this.bFI.o(arrayList);
        }
    }

    public String abS() {
        return this.imgUrl;
    }
}
