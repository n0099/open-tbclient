package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes3.dex */
public class t {
    private q byw;
    private long threadId;
    private long byr = 0;
    private String bys = "";
    private long byt = 0;
    private String byu = "";
    private String imgUrl = "";
    private String byv = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.byr = forumHeadlineImgInfo.thread_user_id.longValue();
            this.bys = forumHeadlineImgInfo.thread_user_name;
            this.byt = forumHeadlineImgInfo.img_user_id.longValue();
            this.byu = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.byv = forumHeadlineImgInfo.headline_url;
            this.byw = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.byv == null ? "" : this.byv, null);
            sVar.di(true);
            arrayList.add(sVar);
            this.byw.l(arrayList);
        }
    }

    public String Xk() {
        return this.imgUrl;
    }
}
