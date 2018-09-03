package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class r {
    private o afo;
    private long threadId;
    private long afj = 0;
    private String afk = "";
    private long afl = 0;
    private String afm = "";
    private String imgUrl = "";
    private String afn = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.afj = forumHeadlineImgInfo.thread_user_id.longValue();
            this.afk = forumHeadlineImgInfo.thread_user_name;
            this.afl = forumHeadlineImgInfo.img_user_id.longValue();
            this.afm = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.afn = forumHeadlineImgInfo.headline_url;
            this.afo = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.afn == null ? "" : this.afn, null);
            qVar.ao(true);
            arrayList.add(qVar);
            this.afo.j(arrayList);
        }
    }

    public String tT() {
        return this.imgUrl;
    }
}
