package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o WA;
    private long threadId;
    private long Wv = 0;
    private String Ww = "";
    private long Wx = 0;
    private String Wy = "";
    private String imgUrl = "";
    private String Wz = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Wv = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Ww = forumHeadlineImgInfo.thread_user_name;
            this.Wx = forumHeadlineImgInfo.img_user_id.longValue();
            this.Wy = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.Wz = forumHeadlineImgInfo.headline_url;
            this.WA = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.Wz == null ? "" : this.Wz, null);
            qVar.ak(true);
            arrayList.add(qVar);
            this.WA.f(arrayList);
        }
    }

    public String pR() {
        return this.imgUrl;
    }
}
