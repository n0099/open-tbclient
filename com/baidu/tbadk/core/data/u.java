package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes6.dex */
public class u {
    private r cKE;
    private long threadId;
    private long cKz = 0;
    private String cKA = "";
    private long cKB = 0;
    private String cKC = "";
    private String imgUrl = "";
    private String cKD = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.cKz = forumHeadlineImgInfo.thread_user_id.longValue();
            this.cKA = forumHeadlineImgInfo.thread_user_name;
            this.cKB = forumHeadlineImgInfo.img_user_id.longValue();
            this.cKC = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.cKD = forumHeadlineImgInfo.headline_url;
            this.cKE = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.cKD == null ? "" : this.cKD, null);
            tVar.fq(true);
            arrayList.add(tVar);
            this.cKE.t(arrayList);
        }
    }

    public String ayq() {
        return this.imgUrl;
    }
}
