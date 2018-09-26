package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes2.dex */
public class r {
    private o ahP;
    private long threadId;
    private long ahK = 0;
    private String ahL = "";
    private long ahM = 0;
    private String ahN = "";
    private String imgUrl = "";
    private String ahO = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.ahK = forumHeadlineImgInfo.thread_user_id.longValue();
            this.ahL = forumHeadlineImgInfo.thread_user_name;
            this.ahM = forumHeadlineImgInfo.img_user_id.longValue();
            this.ahN = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.ahO = forumHeadlineImgInfo.headline_url;
            this.ahP = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.ahO == null ? "" : this.ahO, null);
            qVar.ax(true);
            arrayList.add(qVar);
            this.ahP.j(arrayList);
        }
    }

    public String uW() {
        return this.imgUrl;
    }
}
