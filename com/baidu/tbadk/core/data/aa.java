package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import tbclient.FrsPage.ForumHeadlineImgInfo;
/* loaded from: classes.dex */
public class aa {
    private w eGe;
    private long threadId;
    private long eFZ = 0;
    private String eGa = "";
    private long eGb = 0;
    private String eGc = "";
    private String imgUrl = "";
    private String eGd = "";

    public void a(ForumHeadlineImgInfo forumHeadlineImgInfo) {
        if (forumHeadlineImgInfo != null) {
            this.threadId = forumHeadlineImgInfo.thread_id.longValue();
            this.eFZ = forumHeadlineImgInfo.thread_user_id.longValue();
            this.eGa = forumHeadlineImgInfo.thread_user_name;
            this.eGb = forumHeadlineImgInfo.img_user_id.longValue();
            this.eGc = forumHeadlineImgInfo.img_user_name;
            this.imgUrl = forumHeadlineImgInfo.img_url;
            this.eGd = forumHeadlineImgInfo.headline_url;
            this.eGe = new w();
            ArrayList<z> arrayList = new ArrayList<>();
            z zVar = new z(this.imgUrl == null ? "" : this.imgUrl, this.eGd == null ? "" : this.eGd, null);
            zVar.ja(true);
            arrayList.add(zVar);
            this.eGe.C(arrayList);
        }
    }

    public String bmL() {
        return this.imgUrl;
    }
}
