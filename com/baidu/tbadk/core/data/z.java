package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class z {
    private v dYf;
    private long threadId;
    private long dYa = 0;
    private String dYb = "";
    private long dYc = 0;
    private String dYd = "";
    private String imgUrl = "";
    private String dYe = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.dYa = forumHeadlineImgInfo.thread_user_id.longValue();
            this.dYb = forumHeadlineImgInfo.thread_user_name;
            this.dYc = forumHeadlineImgInfo.img_user_id.longValue();
            this.dYd = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.dYe = forumHeadlineImgInfo.headline_url;
            this.dYf = new v();
            ArrayList<y> arrayList = new ArrayList<>();
            y yVar = new y(this.imgUrl == null ? "" : this.imgUrl, this.dYe == null ? "" : this.dYe, null);
            yVar.hU(true);
            arrayList.add(yVar);
            this.dYf.C(arrayList);
        }
    }

    public String bcA() {
        return this.imgUrl;
    }
}
