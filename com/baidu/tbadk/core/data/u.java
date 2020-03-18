package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r cOW;
    private long threadId;
    private long cOR = 0;
    private String cOS = "";
    private long cOT = 0;
    private String cOU = "";
    private String imgUrl = "";
    private String cOV = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.cOR = forumHeadlineImgInfo.thread_user_id.longValue();
            this.cOS = forumHeadlineImgInfo.thread_user_name;
            this.cOT = forumHeadlineImgInfo.img_user_id.longValue();
            this.cOU = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.cOV = forumHeadlineImgInfo.headline_url;
            this.cOW = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.cOV == null ? "" : this.cOV, null);
            tVar.fy(true);
            arrayList.add(tVar);
            this.cOW.v(arrayList);
        }
    }

    public String aAJ() {
        return this.imgUrl;
    }
}
