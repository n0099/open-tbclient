package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class aa {
    private w eLj;
    private long threadId;
    private long eLe = 0;
    private String eLf = "";
    private long eLg = 0;
    private String eLh = "";
    private String imgUrl = "";
    private String eLi = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.eLe = forumHeadlineImgInfo.thread_user_id.longValue();
            this.eLf = forumHeadlineImgInfo.thread_user_name;
            this.eLg = forumHeadlineImgInfo.img_user_id.longValue();
            this.eLh = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eLi = forumHeadlineImgInfo.headline_url;
            this.eLj = new w();
            ArrayList<z> arrayList = new ArrayList<>();
            z zVar = new z(this.imgUrl == null ? "" : this.imgUrl, this.eLi == null ? "" : this.eLi, null);
            zVar.jr(true);
            arrayList.add(zVar);
            this.eLj.x(arrayList);
        }
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
