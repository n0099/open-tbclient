package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes8.dex */
public class u {
    private r cOI;
    private long threadId;
    private long cOD = 0;
    private String cOE = "";
    private long cOF = 0;
    private String cOG = "";
    private String imgUrl = "";
    private String cOH = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.cOD = forumHeadlineImgInfo.thread_user_id.longValue();
            this.cOE = forumHeadlineImgInfo.thread_user_name;
            this.cOF = forumHeadlineImgInfo.img_user_id.longValue();
            this.cOG = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.cOH = forumHeadlineImgInfo.headline_url;
            this.cOI = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.cOH == null ? "" : this.cOH, null);
            tVar.fx(true);
            arrayList.add(tVar);
            this.cOI.v(arrayList);
        }
    }

    public String aAG() {
        return this.imgUrl;
    }
}
