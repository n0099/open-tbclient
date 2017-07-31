package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r WB;
    private long threadId;
    private long Ww = 0;
    private String Wx = "";
    private long Wy = 0;
    private String Wz = "";
    private String imgUrl = "";
    private String WA = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Ww = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Wx = forumHeadlineImgInfo.thread_user_name;
            this.Wy = forumHeadlineImgInfo.img_user_id.longValue();
            this.Wz = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.WA = forumHeadlineImgInfo.headline_url;
            this.WB = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.WA == null ? "" : this.WA, null);
            tVar.am(true);
            arrayList.add(tVar);
            this.WB.f(arrayList);
        }
    }

    public String pV() {
        return this.imgUrl;
    }
}
