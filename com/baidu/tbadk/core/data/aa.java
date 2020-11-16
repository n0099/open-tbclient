package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class aa {
    private w ezf;
    private long threadId;
    private long eza = 0;
    private String ezb = "";
    private long ezc = 0;
    private String ezd = "";
    private String imgUrl = "";
    private String eze = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.eza = forumHeadlineImgInfo.thread_user_id.longValue();
            this.ezb = forumHeadlineImgInfo.thread_user_name;
            this.ezc = forumHeadlineImgInfo.img_user_id.longValue();
            this.ezd = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eze = forumHeadlineImgInfo.headline_url;
            this.ezf = new w();
            ArrayList<z> arrayList = new ArrayList<>();
            z zVar = new z(this.imgUrl == null ? "" : this.imgUrl, this.eze == null ? "" : this.eze, null);
            zVar.iL(true);
            arrayList.add(zVar);
            this.ezf.C(arrayList);
        }
    }

    public String bjy() {
        return this.imgUrl;
    }
}
