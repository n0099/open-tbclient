package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r WE;
    private long threadId;
    private long Wz = 0;
    private String WA = "";
    private long WB = 0;
    private String WC = "";
    private String imgUrl = "";
    private String WD = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Wz = forumHeadlineImgInfo.thread_user_id.longValue();
            this.WA = forumHeadlineImgInfo.thread_user_name;
            this.WB = forumHeadlineImgInfo.img_user_id.longValue();
            this.WC = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.WD = forumHeadlineImgInfo.headline_url;
            this.WE = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.WD == null ? "" : this.WD, null);
            tVar.am(true);
            arrayList.add(tVar);
            this.WE.f(arrayList);
        }
    }

    public String pW() {
        return this.imgUrl;
    }
}
