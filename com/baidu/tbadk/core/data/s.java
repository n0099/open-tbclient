package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class s {
    private p XE;
    private long threadId;
    private long Xz = 0;
    private String XA = "";
    private long XB = 0;
    private String XC = "";
    private String imgUrl = "";
    private String XD = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Xz = forumHeadlineImgInfo.thread_user_id.longValue();
            this.XA = forumHeadlineImgInfo.thread_user_name;
            this.XB = forumHeadlineImgInfo.img_user_id.longValue();
            this.XC = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.XD = forumHeadlineImgInfo.headline_url;
            this.XE = new p();
            ArrayList<r> arrayList = new ArrayList<>();
            r rVar = new r(this.imgUrl == null ? "" : this.imgUrl, this.XD == null ? "" : this.XD, null);
            rVar.an(true);
            arrayList.add(rVar);
            this.XE.f(arrayList);
        }
    }

    public String qF() {
        return this.imgUrl;
    }
}
