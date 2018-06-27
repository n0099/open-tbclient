package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class s {
    private p afU;
    private long threadId;
    private long afP = 0;
    private String afQ = "";
    private long afR = 0;
    private String afS = "";
    private String imgUrl = "";
    private String afT = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.afP = forumHeadlineImgInfo.thread_user_id.longValue();
            this.afQ = forumHeadlineImgInfo.thread_user_name;
            this.afR = forumHeadlineImgInfo.img_user_id.longValue();
            this.afS = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.afT = forumHeadlineImgInfo.headline_url;
            this.afU = new p();
            ArrayList<r> arrayList = new ArrayList<>();
            r rVar = new r(this.imgUrl == null ? "" : this.imgUrl, this.afT == null ? "" : this.afT, null);
            rVar.ar(true);
            arrayList.add(rVar);
            this.afU.j(arrayList);
        }
    }

    public String uh() {
        return this.imgUrl;
    }
}
