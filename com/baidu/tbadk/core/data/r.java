package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o WD;
    private long threadId;
    private long Wy = 0;
    private String Wz = "";
    private long WA = 0;
    private String WB = "";
    private String imgUrl = "";
    private String WC = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Wy = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Wz = forumHeadlineImgInfo.thread_user_name;
            this.WA = forumHeadlineImgInfo.img_user_id.longValue();
            this.WB = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.WC = forumHeadlineImgInfo.headline_url;
            this.WD = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.WC == null ? "" : this.WC, null);
            qVar.ak(true);
            arrayList.add(qVar);
            this.WD.f(arrayList);
        }
    }

    public String pT() {
        return this.imgUrl;
    }
}
