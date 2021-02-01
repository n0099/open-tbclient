package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class ab {
    private x eNv;
    private long threadId;
    private long eNq = 0;
    private String eNr = "";
    private long eNs = 0;
    private String eNt = "";
    private String imgUrl = "";
    private String eNu = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.eNq = forumHeadlineImgInfo.thread_user_id.longValue();
            this.eNr = forumHeadlineImgInfo.thread_user_name;
            this.eNs = forumHeadlineImgInfo.img_user_id.longValue();
            this.eNt = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eNu = forumHeadlineImgInfo.headline_url;
            this.eNv = new x();
            ArrayList<aa> arrayList = new ArrayList<>();
            aa aaVar = new aa(this.imgUrl == null ? "" : this.imgUrl, this.eNu == null ? "" : this.eNu, null);
            aaVar.jt(true);
            arrayList.add(aaVar);
            this.eNv.x(arrayList);
        }
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
