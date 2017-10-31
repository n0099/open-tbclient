package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r Wg;
    private long threadId;
    private long Wb = 0;
    private String Wc = "";
    private long Wd = 0;
    private String We = "";
    private String imgUrl = "";
    private String Wf = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Wb = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Wc = forumHeadlineImgInfo.thread_user_name;
            this.Wd = forumHeadlineImgInfo.img_user_id.longValue();
            this.We = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.Wf = forumHeadlineImgInfo.headline_url;
            this.Wg = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.Wf == null ? "" : this.Wf, null);
            tVar.ak(true);
            arrayList.add(tVar);
            this.Wg.f(arrayList);
        }
    }

    public String pQ() {
        return this.imgUrl;
    }
}
