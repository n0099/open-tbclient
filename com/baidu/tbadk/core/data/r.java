package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class r {
    private o arB;
    private long threadId;
    private long arw = 0;
    private String arx = "";
    private long ary = 0;
    private String arz = "";
    private String imgUrl = "";
    private String arA = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.arw = forumHeadlineImgInfo.thread_user_id.longValue();
            this.arx = forumHeadlineImgInfo.thread_user_name;
            this.ary = forumHeadlineImgInfo.img_user_id.longValue();
            this.arz = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.arA = forumHeadlineImgInfo.headline_url;
            this.arB = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.arA == null ? "" : this.arA, null);
            qVar.aZ(true);
            arrayList.add(qVar);
            this.arB.j(arrayList);
        }
    }

    public String yF() {
        return this.imgUrl;
    }
}
