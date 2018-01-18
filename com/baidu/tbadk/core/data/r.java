package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class r {
    private o aKV;
    private long threadId;
    private long aKQ = 0;
    private String aKR = "";
    private long aKS = 0;
    private String aKT = "";
    private String imgUrl = "";
    private String aKU = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.aKQ = forumHeadlineImgInfo.thread_user_id.longValue();
            this.aKR = forumHeadlineImgInfo.thread_user_name;
            this.aKS = forumHeadlineImgInfo.img_user_id.longValue();
            this.aKT = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.aKU = forumHeadlineImgInfo.headline_url;
            this.aKV = new o();
            ArrayList<q> arrayList = new ArrayList<>();
            q qVar = new q(this.imgUrl == null ? "" : this.imgUrl, this.aKU == null ? "" : this.aKU, null);
            qVar.aR(true);
            arrayList.add(qVar);
            this.aKV.g(arrayList);
        }
    }

    public String xt() {
        return this.imgUrl;
    }
}
