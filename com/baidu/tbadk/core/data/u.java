package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r UQ;
    private long threadId;
    private long UK = 0;
    private String UL = "";
    private long UM = 0;
    private String UN = "";
    private String imgUrl = "";
    private String UO = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.UK = forumHeadlineImgInfo.thread_user_id.longValue();
            this.UL = forumHeadlineImgInfo.thread_user_name;
            this.UM = forumHeadlineImgInfo.img_user_id.longValue();
            this.UN = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.UO = forumHeadlineImgInfo.headline_url;
            this.UQ = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.UO == null ? "" : this.UO, null);
            tVar.am(true);
            arrayList.add(tVar);
            this.UQ.f(arrayList);
        }
    }

    public String pL() {
        return this.imgUrl;
    }
}
