package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes5.dex */
public class u {
    private r cKt;
    private long threadId;
    private long cKo = 0;
    private String cKp = "";
    private long cKq = 0;
    private String cKr = "";
    private String imgUrl = "";
    private String cKs = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.cKo = forumHeadlineImgInfo.thread_user_id.longValue();
            this.cKp = forumHeadlineImgInfo.thread_user_name;
            this.cKq = forumHeadlineImgInfo.img_user_id.longValue();
            this.cKr = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.cKs = forumHeadlineImgInfo.headline_url;
            this.cKt = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.cKs == null ? "" : this.cKs, null);
            tVar.fl(true);
            arrayList.add(tVar);
            this.cKt.t(arrayList);
        }
    }

    public String axX() {
        return this.imgUrl;
    }
}
