package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class aa {
    private w ePU;
    private long threadId;
    private long ePP = 0;
    private String ePQ = "";
    private long ePR = 0;
    private String ePS = "";
    private String imgUrl = "";
    private String ePT = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.ePP = forumHeadlineImgInfo.thread_user_id.longValue();
            this.ePQ = forumHeadlineImgInfo.thread_user_name;
            this.ePR = forumHeadlineImgInfo.img_user_id.longValue();
            this.ePS = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.ePT = forumHeadlineImgInfo.headline_url;
            this.ePU = new w();
            ArrayList<z> arrayList = new ArrayList<>();
            z zVar = new z(this.imgUrl == null ? "" : this.imgUrl, this.ePT == null ? "" : this.ePT, null);
            zVar.jv(true);
            arrayList.add(zVar);
            this.ePU.C(arrayList);
        }
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
