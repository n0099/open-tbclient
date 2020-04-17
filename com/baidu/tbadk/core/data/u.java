package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class u {
    private r dob;
    private long threadId;
    private long dnW = 0;
    private String dnX = "";
    private long dnY = 0;
    private String dnZ = "";
    private String imgUrl = "";
    private String doa = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.dnW = forumHeadlineImgInfo.thread_user_id.longValue();
            this.dnX = forumHeadlineImgInfo.thread_user_name;
            this.dnY = forumHeadlineImgInfo.img_user_id.longValue();
            this.dnZ = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.doa = forumHeadlineImgInfo.headline_url;
            this.dob = new r();
            ArrayList<t> arrayList = new ArrayList<>();
            t tVar = new t(this.imgUrl == null ? "" : this.imgUrl, this.doa == null ? "" : this.doa, null);
            tVar.gv(true);
            arrayList.add(tVar);
            this.dob.v(arrayList);
        }
    }

    public String aIW() {
        return this.imgUrl;
    }
}
