package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class r {
    private o arC;
    private long threadId;
    private long arx = 0;
    private String ary = "";
    private long arz = 0;
    private String arA = "";
    private String imgUrl = "";
    private String arB = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.arx = forumHeadlineImgInfo.thread_user_id.longValue();
            this.ary = forumHeadlineImgInfo.thread_user_name;
            this.arz = forumHeadlineImgInfo.img_user_id.longValue();
            this.arA = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.arB = forumHeadlineImgInfo.headline_url;
            this.arC = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.arB == null ? "" : this.arB, null);
            qVar.aZ(true);
            arrayList.add(qVar);
            this.arC.j(arrayList);
        }
    }

    public String yF() {
        return this.imgUrl;
    }
}
