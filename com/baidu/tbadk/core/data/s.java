package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class s {
    private p afF;
    private long threadId;
    private long afA = 0;
    private String afB = "";
    private long afC = 0;
    private String afD = "";
    private String imgUrl = "";
    private String afE = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.afA = forumHeadlineImgInfo.thread_user_id.longValue();
            this.afB = forumHeadlineImgInfo.thread_user_name;
            this.afC = forumHeadlineImgInfo.img_user_id.longValue();
            this.afD = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.afE = forumHeadlineImgInfo.headline_url;
            this.afF = new p();
            ArrayList<r> arrayList = new ArrayList<>();
            r rVar = new r(this.imgUrl == null ? "" : this.imgUrl, this.afE == null ? "" : this.afE, null);
            rVar.aq(true);
            arrayList.add(rVar);
            this.afF.f(arrayList);
        }
    }

    public String ub() {
        return this.imgUrl;
    }
}
