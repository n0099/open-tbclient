package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes8.dex */
public class u {
    private r cOJ;
    private long threadId;
    private long cOE = 0;
    private String cOF = "";
    private long cOG = 0;
    private String cOH = "";
    private String imgUrl = "";
    private String cOI = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.cOE = forumHeadlineImgInfo.thread_user_id.longValue();
            this.cOF = forumHeadlineImgInfo.thread_user_name;
            this.cOG = forumHeadlineImgInfo.img_user_id.longValue();
            this.cOH = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.cOI = forumHeadlineImgInfo.headline_url;
            this.cOJ = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.cOI == null ? "" : this.cOI, null);
            tVar.fx(true);
            arrayList.add(tVar);
            this.cOJ.v(arrayList);
        }
    }

    public String aAG() {
        return this.imgUrl;
    }
}
