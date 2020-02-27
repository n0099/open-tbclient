package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes8.dex */
public class u {
    private r cOH;
    private long threadId;
    private long cOC = 0;
    private String cOD = "";
    private long cOE = 0;
    private String cOF = "";
    private String imgUrl = "";
    private String cOG = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.cOC = forumHeadlineImgInfo.thread_user_id.longValue();
            this.cOD = forumHeadlineImgInfo.thread_user_name;
            this.cOE = forumHeadlineImgInfo.img_user_id.longValue();
            this.cOF = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.cOG = forumHeadlineImgInfo.headline_url;
            this.cOH = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.cOG == null ? "" : this.cOG, null);
            tVar.fx(true);
            arrayList.add(tVar);
            this.cOH.v(arrayList);
        }
    }

    public String aAE() {
        return this.imgUrl;
    }
}
