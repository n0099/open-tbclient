package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q byq;
    private long threadId;
    private long byl = 0;
    private String bym = "";
    private long byn = 0;
    private String byo = "";
    private String imgUrl = "";
    private String byp = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.byl = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bym = forumHeadlineImgInfo.thread_user_name;
            this.byn = forumHeadlineImgInfo.img_user_id.longValue();
            this.byo = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.byp = forumHeadlineImgInfo.headline_url;
            this.byq = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.byp == null ? "" : this.byp, null);
            sVar.di(true);
            arrayList.add(sVar);
            this.byq.l(arrayList);
        }
    }

    public String Xn() {
        return this.imgUrl;
    }
}
