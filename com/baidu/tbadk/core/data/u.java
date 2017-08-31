package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r VM;
    private long threadId;
    private long VH = 0;
    private String VI = "";
    private long VJ = 0;
    private String VK = "";
    private String imgUrl = "";
    private String VL = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.VH = forumHeadlineImgInfo.thread_user_id.longValue();
            this.VI = forumHeadlineImgInfo.thread_user_name;
            this.VJ = forumHeadlineImgInfo.img_user_id.longValue();
            this.VK = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.VL = forumHeadlineImgInfo.headline_url;
            this.VM = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.VL == null ? "" : this.VL, null);
            tVar.am(true);
            arrayList.add(tVar);
            this.VM.f(arrayList);
        }
    }

    public String pR() {
        return this.imgUrl;
    }
}
