package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class s {
    private p XD;
    private long threadId;
    private long Xy = 0;
    private String Xz = "";
    private long XA = 0;
    private String XB = "";
    private String imgUrl = "";
    private String XC = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Xy = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Xz = forumHeadlineImgInfo.thread_user_name;
            this.XA = forumHeadlineImgInfo.img_user_id.longValue();
            this.XB = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.XC = forumHeadlineImgInfo.headline_url;
            this.XD = new p();
            ArrayList<r> arrayList = new ArrayList<>();
            r rVar = new r(this.imgUrl == null ? "" : this.imgUrl, this.XC == null ? "" : this.XC, null);
            rVar.an(true);
            arrayList.add(rVar);
            this.XD.f(arrayList);
        }
    }

    public String qG() {
        return this.imgUrl;
    }
}
