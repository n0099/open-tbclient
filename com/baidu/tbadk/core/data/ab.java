package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class ab {
    private x eOW;
    private long threadId;
    private long eOR = 0;
    private String eOS = "";
    private long eOT = 0;
    private String eOU = "";
    private String imgUrl = "";
    private String eOV = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.eOR = forumHeadlineImgInfo.thread_user_id.longValue();
            this.eOS = forumHeadlineImgInfo.thread_user_name;
            this.eOT = forumHeadlineImgInfo.img_user_id.longValue();
            this.eOU = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eOV = forumHeadlineImgInfo.headline_url;
            this.eOW = new x();
            ArrayList<aa> arrayList = new ArrayList<>();
            aa aaVar = new aa(this.imgUrl == null ? "" : this.imgUrl, this.eOV == null ? "" : this.eOV, null);
            aaVar.jt(true);
            arrayList.add(aaVar);
            this.eOW.x(arrayList);
        }
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
