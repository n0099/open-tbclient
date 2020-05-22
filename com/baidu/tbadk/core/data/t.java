package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class t {
    private q dCg;
    private long threadId;
    private long dCb = 0;
    private String dCc = "";
    private long dCd = 0;
    private String dCe = "";
    private String imgUrl = "";
    private String dCf = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.dCb = forumHeadlineImgInfo.thread_user_id.longValue();
            this.dCc = forumHeadlineImgInfo.thread_user_name;
            this.dCd = forumHeadlineImgInfo.img_user_id.longValue();
            this.dCe = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dCf = forumHeadlineImgInfo.headline_url;
            this.dCg = new q();
            ArrayList<s> arrayList = new ArrayList<>();
            s sVar = new s(this.imgUrl == null ? "" : this.imgUrl, this.dCf == null ? "" : this.dCf, null);
            sVar.gN(true);
            arrayList.add(sVar);
            this.dCg.v(arrayList);
        }
    }

    public String aOP() {
        return this.imgUrl;
    }
}
