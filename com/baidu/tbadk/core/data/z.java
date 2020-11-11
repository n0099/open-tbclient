package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class z {
    private v eAO;
    private long threadId;
    private long eAJ = 0;
    private String eAK = "";
    private long eAL = 0;
    private String eAM = "";
    private String imgUrl = "";
    private String eAN = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.eAJ = forumHeadlineImgInfo.thread_user_id.longValue();
            this.eAK = forumHeadlineImgInfo.thread_user_name;
            this.eAL = forumHeadlineImgInfo.img_user_id.longValue();
            this.eAM = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eAN = forumHeadlineImgInfo.headline_url;
            this.eAO = new v();
            ArrayList<y> arrayList = new ArrayList<>();
            y yVar = new y(this.imgUrl == null ? "" : this.imgUrl, this.eAN == null ? "" : this.eAN, null);
            yVar.iK(true);
            arrayList.add(yVar);
            this.eAO.C(arrayList);
        }
    }

    public String bkw() {
        return this.imgUrl;
    }
}
