package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q byv;
    private long threadId;
    private long byq = 0;
    private String byr = "";
    private long bys = 0;
    private String byt = "";
    private String imgUrl = "";
    private String byu = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.byq = forumHeadlineImgInfo.thread_user_id.longValue();
            this.byr = forumHeadlineImgInfo.thread_user_name;
            this.bys = forumHeadlineImgInfo.img_user_id.longValue();
            this.byt = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.byu = forumHeadlineImgInfo.headline_url;
            this.byv = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.byu == null ? "" : this.byu, null);
            sVar.di(true);
            arrayList.add(sVar);
            this.byv.l(arrayList);
        }
    }

    public String Xk() {
        return this.imgUrl;
    }
}
