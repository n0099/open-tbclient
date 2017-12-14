package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o Wx;
    private long threadId;
    private long Ws = 0;
    private String Wt = "";
    private long Wu = 0;
    private String Wv = "";
    private String imgUrl = "";
    private String Ww = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.Ws = forumHeadlineImgInfo.thread_user_id.longValue();
            this.Wt = forumHeadlineImgInfo.thread_user_name;
            this.Wu = forumHeadlineImgInfo.img_user_id.longValue();
            this.Wv = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.Ww = forumHeadlineImgInfo.headline_url;
            this.Wx = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.Ww == null ? "" : this.Ww, null);
            qVar.ak(true);
            arrayList.add(qVar);
            this.Wx.f(arrayList);
        }
    }

    public String pR() {
        return this.imgUrl;
    }
}
