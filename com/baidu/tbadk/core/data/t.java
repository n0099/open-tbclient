package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q bys;
    private long threadId;
    private long byn = 0;
    private String byo = "";
    private long byp = 0;
    private String byq = "";
    private String imgUrl = "";
    private String byr = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.byn = forumHeadlineImgInfo.thread_user_id.longValue();
            this.byo = forumHeadlineImgInfo.thread_user_name;
            this.byp = forumHeadlineImgInfo.img_user_id.longValue();
            this.byq = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.byr = forumHeadlineImgInfo.headline_url;
            this.bys = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.byr == null ? "" : this.byr, null);
            sVar.di(true);
            arrayList.add(sVar);
            this.bys.l(arrayList);
        }
    }

    public String Xn() {
        return this.imgUrl;
    }
}
